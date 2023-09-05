package com.reservation.reservation.dao;

import com.reservation.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationDao extends JpaRepository<Reservation,Integer> {
    Reservation findById(int id);
    Reservation deleteById(int id);
}
