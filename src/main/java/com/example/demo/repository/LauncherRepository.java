package com.example.demo.repository;

import com.example.demo.model.Launcher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LauncherRepository extends JpaRepository<Launcher, String> {
}
