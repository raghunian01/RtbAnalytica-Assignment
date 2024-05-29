package com.example.demo.controller;

import com.example.demo.model.CustomerSatellite;
import com.example.demo.service.CustomerSatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/satellite_search")
public class SatelliteSearchController {

    @Autowired
    private CustomerSatelliteService customerSatelliteService;

    @GetMapping("/search")
    public List<CustomerSatellite> searchSatellites(@RequestParam(required = false) Long id,
                                                    @RequestParam(required = false) Date launchDate,
                                                    @RequestParam(required = false) String country,
                                                    @RequestParam(required = false) String launcherId,
                                                    @RequestParam(required = false) Double mass) {
        return customerSatelliteService.searchSatellites(id, launchDate, country, launcherId, mass);
    }
}
