package com.example.demo.controller;

import com.example.demo.model.CustomerSatellite;
import com.example.demo.service.CustomerSatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer_satellites")
public class CustomerSatelliteController {

    @Autowired
    private CustomerSatelliteService customerSatelliteService;

    @GetMapping
    public List<CustomerSatellite> getAllCustomerSatellites() {
        return customerSatelliteService.getAllSatellites();
    }

    @GetMapping("/{id}")
    public CustomerSatellite getCustomerSatelliteById(@PathVariable Long id) {
        return customerSatelliteService.getCustomerSatelliteById(id);
    }

    @PostMapping
    public CustomerSatellite createCustomerSatellite(@RequestBody CustomerSatellite customerSatellite) {
        return customerSatelliteService.saveCustomerSatellite(customerSatellite);
    }

    @PutMapping("/{id}")
    public CustomerSatellite updateCustomerSatellite(@PathVariable Long id, @RequestBody CustomerSatellite customerSatellite) {
        return customerSatelliteService.updateCustomerSatellite(id, customerSatellite);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerSatellite(@PathVariable Long id) {
        customerSatelliteService.deleteCustomerSatellite(id);
    }

    @PostMapping("/fetch")
    public void fetchAndSaveCustomerSatellites() {
        customerSatelliteService.fetchAndSaveSatellites();
    }
}
