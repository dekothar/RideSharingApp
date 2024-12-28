package com.design.ride.sharing.app.ridesharingapp.repositories;

import com.design.ride.sharing.app.ridesharingapp.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepositoryImpl extends JpaRepository<Driver, Long> {
}
