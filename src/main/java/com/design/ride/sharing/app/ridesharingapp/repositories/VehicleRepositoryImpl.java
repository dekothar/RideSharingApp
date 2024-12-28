package com.design.ride.sharing.app.ridesharingapp.repositories;

import com.design.ride.sharing.app.ridesharingapp.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepositoryImpl extends JpaRepository<Vehicle,Long> {
}
