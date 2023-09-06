package com.reservation.reservation.web.controller;

import com.reservation.reservation.dao.ReservationDao;
import com.reservation.reservation.model.Reservation;
import com.reservation.reservation.model.Vehicule;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.Period;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    @GetMapping("/vehicule/{id}")
    public Vehicule returnVCehicule(@PathVariable int id){
        return newVehicule(id);
    }
    @GetMapping("/vehicule")
    public List<Vehicule> getAllVehicule(){
        RestTemplate restTemplate =new RestTemplate();

        return Arrays.asList(restTemplate.getForObject("http://192.168.1.202:8083/vehicules", Vehicule[].class));
    }
    @ApiOperation(value = "Récupère une réservation par id")
    @GetMapping("/{id}")
    public Reservation findReservationById(@PathVariable int id){
        return reservationDao.findById(id);
    }
    @ApiOperation(value = "Ajoute une réservation")
    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation, @RequestParam int nbKilometer){
        reservation.setPrice(calculPriceCar(nbKilometer,reservation.getIdVehicle()));
        return reservationDao.save(reservation);
    }
    @ApiOperation(value = "Modifie une reservation")
    @PutMapping
    public Reservation modifyReservation(@RequestBody Reservation reservation){
        reservation.setPrice(calculPriceCar(500,reservation.getIdVehicle()));
        return reservationDao.save(reservation);
    }
    @ApiOperation(value = "Supprime une opération par id")
    @DeleteMapping("/{id}")
    public Reservation deleteReservation(@PathVariable int id){
        return reservationDao.deleteById(id);
    }

    public Vehicule newVehicule(int idVehicule){
        RestTemplate restTemplate =new RestTemplate();
      Vehicule vehicule=  restTemplate.getForObject("http://192.168.1.202:8083/vehicules/" + idVehicule, Vehicule.class);
    return vehicule;
    }

    public Double calculPriceCar(int nbKilometer, int idVehicule){
        Vehicule vehicule = newVehicule(idVehicule);
        String type = vehicule.getType();
        switch (type) {
            case "car":
                return (double) (vehicule.getPrixReservation() + vehicule.getPrixKillometre() * nbKilometer);
            case "moto":
                return (double) (vehicule.getPrixReservation() + vehicule.getCm3() * 0.001 * vehicule.getPrixKillometre() * nbKilometer);
            case "utilitaire":
                return (double) (vehicule.getPrixReservation() + vehicule.getM3Chargement() * 0.05 * vehicule.getPrixKillometre() * nbKilometer);
            default:
                return null;

        }}
//    public Double calculPriceMoto(int nbKilometer){
//        Vehicule vehicule = newVehicule(1);
//
//    }

}
