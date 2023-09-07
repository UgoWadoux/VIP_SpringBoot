package com.reservation.reservation.dao;

import com.reservation.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ReservationDao extends JpaRepository<Reservation,Integer> {
    Reservation findById(int id);
    Reservation deleteById(int id);
    @Query(value = "SELECT id_vehicle FROM reservation " +
            "WHERE end_date BETWEEN :startDate AND :endDate\n" +
            "OR  start_date BETWEEN :startDate AND :endDate\n" +
            "OR (end_date >:startDate AND  start_date<:endDate)", nativeQuery = true)
    public Iterable <Integer> carNotDisponible(@Param("startDate")Date startDate,@Param("endDate") Date endDate);



}
