package com.example.demo.controller;

import com.example.demo.model.Launcher;
import com.example.demo.service.LauncherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class LauncherControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private LauncherService launcherService;

    @InjectMocks
    private LauncherController launcherController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(launcherController).build();
    }

    @Test
    public void testCreateLauncher() throws Exception {
        Launcher launcher = new Launcher("GSLV-F10");
        when(launcherService.createLauncher(any(Launcher.class))).thenReturn(launcher);

        mockMvc.perform(post("/api/launchers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"GSLV-F10\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("GSLV-F10"));
    }

    @Test
    public void testUpdateLauncher() throws Exception {
        Launcher launcher = new Launcher("GSLV-F10");
        when(launcherService.updateLauncher(any(String.class), any(Launcher.class))).thenReturn(launcher);

        mockMvc.perform(put("/api/launchers/GSLV-F10")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"GSLV-F10\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("GSLV-F10"));
    }
}
