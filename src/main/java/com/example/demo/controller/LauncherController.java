package com.example.demo.controller;

import com.example.demo.model.Launcher;
import com.example.demo.service.LauncherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/launchers")
public class LauncherController {

    @Autowired
    private LauncherService launcherService;

    @GetMapping
    public ResponseEntity<List<Launcher>> getAllLaunchers() {
        return ResponseEntity.ok(launcherService.getAllLaunchers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Launcher> getLauncherById(@PathVariable String id) {
        return ResponseEntity.ok(launcherService.getLauncherById(id));
    }

    @PostMapping
    public ResponseEntity<Launcher> createLauncher(@RequestBody Launcher launcher) {
        return ResponseEntity.ok(launcherService.createLauncher(launcher));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Launcher> updateLauncher(@PathVariable String id, @RequestBody Launcher launcher) {
        return ResponseEntity.ok(launcherService.updateLauncher(id, launcher));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLauncher(@PathVariable String id) {
        launcherService.deleteLauncher(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/fetch-and-save")
    public ResponseEntity<Void> fetchAndSaveLaunchers() {
        launcherService.fetchAndSaveLaunchers();
        return ResponseEntity.ok().build();
    }
}
