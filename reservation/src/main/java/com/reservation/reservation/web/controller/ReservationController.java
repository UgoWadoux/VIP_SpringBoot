package com.reservation.reservation.web.controller;

import com.reservation.reservation.dao.ReservationDao;
import com.reservation.reservation.model.Reservation;
import com.reservation.reservation.model.Vehicule;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationDao reservationDao;
    public ReservationController(ReservationDao reservationDao){
        this.reservationDao = reservationDao;
    }
    @ApiOperation(value = "Recupére toute les reservation")
    @GetMapping
    public Iterable<Reservation> getAllReservation(){
        return reservationDao.findAll();
    }
    @GetMapping("/vehicule")
    public Vehicule returnVCehicule(){
        return checkLicense(1);
    }
    @ApiOperation(value = "Récupère une réservation par id")
    @GetMapping("/{id}")
    public Reservation findReservationById(@PathVariable int id){
        return reservationDao.findById(id);
    }
    @ApiOperation(value = "Ajoute une réservation")
    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation){
        return reservationDao.save(reservation);
    }
    @ApiOperation(value = "Modifie une reservation")
    @PutMapping
    public Reservation modifyReservation(@RequestBody Reservation reservation){
        return reservationDao.save(reservation);
    }
    @ApiOperation(value = "Supprime une opération par id")
    @DeleteMapping("/{id}")
    public Reservation deleteReservation(@PathVariable int id){
        return reservationDao.deleteById(id);
    }

    public Vehicule checkLicense(int idVehicule){
        RestTemplate restTemplate =new RestTemplate();
      Vehicule vehicule=  restTemplate.getForObject("http://192.168.1.202:8083/vehicules/" + idVehicule, Vehicule.class);
    return vehicule;
    }

}
