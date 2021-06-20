package com.kiran.corona.models;

import org.springframework.context.annotation.Bean;


public class LocationStats {

    private String Province_State;
    private String Country_Region;
    private long Confirmed;
    private long Deaths;
    private long Recovered;

    public String getProvince_State() {
        return Province_State;
    }

    public void setProvince_State(String province_State) {
        Province_State = province_State;
    }

    public String getCountry_Region() {
        return Country_Region;
    }

    public void setCountry_Region(String country_Region) {
        Country_Region = country_Region;
    }

    public long getConfirmed() {
        return Confirmed;
    }

    public void setConfirmed(long confirmed) {
        Confirmed = confirmed;
    }

    public long getDeaths() {
        return Deaths;
    }

    public void setDeaths(long deaths) {
        Deaths = deaths;
    }

    public long getRecovered() {
        return Recovered;
    }

    public void setRecovered(long recovered) {
        Recovered = recovered;
    }

    @Override
    public String toString() {
        return "LocationStats{" +
                "Province_State='" + Province_State + '\'' +
                ", Country_Region='" + Country_Region + '\'' +
                ", Confirmed=" + Confirmed +
                ", Deaths=" + Deaths +
//                ", Recovered=" + Recovered +
                '}';
    }
}
