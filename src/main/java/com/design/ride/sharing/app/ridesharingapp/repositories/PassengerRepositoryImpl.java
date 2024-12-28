package com.design.ride.sharing.app.ridesharingapp.repositories;

import com.design.ride.sharing.app.ridesharingapp.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepositoryImpl extends JpaRepository<Passenger, Long> {
}
