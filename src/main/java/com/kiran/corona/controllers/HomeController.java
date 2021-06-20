package com.kiran.corona.controllers;

import com.kiran.corona.models.LocationStats;
import com.kiran.corona.services.CoronaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaDataService coronaDataService;

    @GetMapping("/")
    public String HomeModel(Model model){
        model.addAttribute("data" , coronaDataService.getAllStats());
        return "home";
    }


}
