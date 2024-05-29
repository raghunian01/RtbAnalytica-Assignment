package com.example.demo.service;

import com.example.demo.model.Launcher;
import com.example.demo.repository.LauncherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LauncherService {

    @Autowired
    private LauncherRepository launcherRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Launcher> getAllLaunchers() {
        return launcherRepository.findAll();
    }

    public Launcher getLauncherById(String id) {
        return launcherRepository.findById(id).orElse(null);
    }

    public Launcher createLauncher(Launcher launcher) {
        return launcherRepository.save(launcher);
    }

    public Launcher updateLauncher(String id, Launcher launcher) {
        launcher.setId(id);
        return launcherRepository.save(launcher);
    }

    public void deleteLauncher(String id) {
        launcherRepository.deleteById(id);
    }

    public void fetchAndSaveLaunchers() {
        String url = "https://isro.vercel.app/api/launchers";
        ResponseEntity<Map<String, List<Map<String, String>>>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map<String, List<Map<String, String>>>>() {}
        );

        List<Map<String, String>> launchersData = response.getBody().get("launchers");
        List<Launcher> launchers = launchersData.stream()
                .map(data -> new Launcher(data.get("id")))
                .collect(Collectors.toList());

        launcherRepository.saveAll(launchers);
    }
}
