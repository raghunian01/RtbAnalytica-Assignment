package com.example.demo.service;

import com.example.demo.model.Launcher;
import com.example.demo.repository.LauncherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class LauncherServiceTest {

    @InjectMocks
    private LauncherService launcherService;

    @Mock
    private LauncherRepository launcherRepository;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFetchAndSaveLaunchers() {
        Map<String, List<Map<String, String>>> responseMap = Map.of("launchers", List.of(
                Map.of("id", "SLV-3E1"),
                Map.of("id", "SLV-3E2")
        ));
        ResponseEntity<Map<String, List<Map<String, String>>>> responseEntity = ResponseEntity.ok(responseMap);
        when(restTemplate.exchange(
                eq("https://isro.vercel.app/api/launchers"),
                eq(HttpMethod.GET),
                any(),
                any(ParameterizedTypeReference.class)
        )).thenReturn(responseEntity);

        launcherService.fetchAndSaveLaunchers();
        verify(launcherRepository, times(1)).saveAll(any());
    }
}
