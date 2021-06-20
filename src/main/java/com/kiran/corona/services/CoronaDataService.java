package com.kiran.corona.services;


import com.kiran.corona.models.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

//Creates instance of the CLass.
@Service
public class CoronaDataService {

    private static String DATA_SOURCE_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/06-17-2021.csv";

    List<LocationStats> allStats = new ArrayList<>();
    public List<LocationStats> getAllStats() {
        return allStats;
    }


    //Starts this method when service started.
    //When the service is constructed, execute it(post/after)
    @PostConstruct

    //Runs Method as scheduled. sec, min, hour, day, month, year
    @Scheduled(cron = " * * 1 * * *")
    public void fetchVirusData() throws IOException, InterruptedException {

        List<LocationStats> newStats = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();

        //URI = Uniform Resource Identifier
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(DATA_SOURCE_URL))
                .build();

        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        //Common CSV. CSV Parser
        StringReader csvBodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
        for (CSVRecord record : records) {

            LocationStats locationStats = new LocationStats();

            locationStats.setCountry_Region(record.get("Country_Region"));
            locationStats.setProvince_State(record.get("Province_State"));
            locationStats.setConfirmed(Long.parseLong(record.get("Confirmed")));
            locationStats.setDeaths(Long.parseLong(record.get("Deaths")));
//            locationStats.setRecovered(Long.parseLong(record.get("Recovered")));

            System.out.println(locationStats);
            newStats.add(locationStats);
        }
        this.allStats = newStats;
    }

    }
