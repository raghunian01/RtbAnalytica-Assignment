package com.example.demo.repository;

import com.example.demo.model.CustomerSatellite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CustomerSatelliteRepository extends JpaRepository<CustomerSatellite, Long> {

    @Query("SELECT s FROM CustomerSatellite s WHERE " +
            "(:id IS NULL OR s.id = :id) " +
            "AND (:launchDate IS NULL OR s.launchDate = :launchDate) " +
            "AND (:country IS NULL OR s.country = :country) " +
            "AND (:launcherId IS NULL OR s.launcherId = :launcherId) " +
            "AND (:mass IS NULL OR s.mass = :mass)")
    List<CustomerSatellite> findByCriteria(@Param("id") Long id,
                                           @Param("launchDate") Date launchDate,
                                           @Param("country") String country,
                                           @Param("launcherId") String launcherId,
                                           @Param("mass") Double mass);
}
