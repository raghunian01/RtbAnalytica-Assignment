package com.example.demo.service;

import com.example.demo.model.CustomerSatellite;
import com.example.demo.repository.CustomerSatelliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class CustomerSatelliteService {

    @Autowired
    private CustomerSatelliteRepository customerSatelliteRepository;

    private final String satelliteUrl = "https://isro.vercel.app/api/customer_satellites";

    public List<CustomerSatellite> getAllSatellites() {
        return customerSatelliteRepository.findAll();
    }

    public CustomerSatellite getCustomerSatelliteById(Long id) {
        return customerSatelliteRepository.findById(id).orElse(null);
    }

    public CustomerSatellite saveCustomerSatellite(CustomerSatellite customerSatellite) {
        return customerSatelliteRepository.save(customerSatellite);
    }

    public CustomerSatellite updateCustomerSatellite(Long id, CustomerSatellite customerSatellite) {
        customerSatellite.setId(id);
        return customerSatelliteRepository.save(customerSatellite);
    }

    public void deleteCustomerSatellite(Long id) {
        customerSatelliteRepository.deleteById(id);
    }

    public void fetchAndSaveSatellites() {
        RestTemplate restTemplate = new RestTemplate();
        CustomerSatellite[] satellites = restTemplate.getForObject(satelliteUrl, CustomerSatellite[].class);
        if (satellites != null) {
            for (CustomerSatellite satellite : satellites) {
                customerSatelliteRepository.save(satellite);
            }
        }
    }

    // Add this method to search satellites
    public List<CustomerSatellite> searchSatellites(Long id, Date launchDate, String country, String launcherId, Double mass) {
        return customerSatelliteRepository.findByCriteria(id, launchDate, country, launcherId, mass);
    }
}
