package com.example.demo.service;

import com.example.demo.model.CustomerSatellite;
import com.example.demo.repository.CustomerSatelliteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class CustomerSatelliteServiceTest {

    @Mock
    private CustomerSatelliteRepository customerSatelliteRepository;

    @InjectMocks
    private CustomerSatelliteService customerSatelliteService;

    private CustomerSatellite customerSatellite;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        customerSatellite = new CustomerSatellite();
        customerSatellite.setId(1L);
        customerSatellite.setName("Test Satellite");
        customerSatellite.setCountry("Test Country");
        customerSatellite.setLauncherId("Test Launcher");
        customerSatellite.setMass(100.0);
        customerSatellite.setLaunchDate(new java.util.Date());
    }

    @Test
    public void testGetCustomerSatelliteById() {
        when(customerSatelliteRepository.findById(anyLong())).thenReturn(Optional.of(customerSatellite));
        CustomerSatellite result = customerSatelliteService.getCustomerSatelliteById(1L);
        assertNotNull(result);
        assertEquals("Test Satellite", result.getName());
    }

    @Test
    public void testSaveCustomerSatellite() {
        when(customerSatelliteRepository.save(any(CustomerSatellite.class))).thenReturn(customerSatellite);
        CustomerSatellite result = customerSatelliteService.saveCustomerSatellite(customerSatellite);
        assertNotNull(result);
        assertEquals("Test Satellite", result.getName());
    }

    @Test
    public void testUpdateCustomerSatellite() {
        when(customerSatelliteRepository.save(any(CustomerSatellite.class))).thenReturn(customerSatellite);
        CustomerSatellite result = customerSatelliteService.updateCustomerSatellite(1L, customerSatellite);
        assertNotNull(result);
        assertEquals("Test Satellite", result.getName());
    }

    @Test
    public void testDeleteCustomerSatellite() {
        doNothing().when(customerSatelliteRepository).deleteById(anyLong());
        customerSatelliteService.deleteCustomerSatellite(1L);
        verify(customerSatelliteRepository, times(1)).deleteById(anyLong());
    }
}
