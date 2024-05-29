package com.example.demo.controller;

import com.example.demo.model.CustomerSatellite;
import com.example.demo.service.CustomerSatelliteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerSatelliteController.class)
public class CustomerSatelliteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerSatelliteService customerSatelliteService;

    @InjectMocks
    private CustomerSatelliteController customerSatelliteController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCustomerSatelliteById() throws Exception {
        CustomerSatellite satellite = new CustomerSatellite();
        satellite.setId(1L);
        when(customerSatelliteService.getCustomerSatelliteById(anyLong())).thenReturn(satellite);

        mockMvc.perform(get("/api/customer_satellites/1"))
                .andExpect(status().isOk());
    }
}
