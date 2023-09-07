package com.reservation.reservation.web.controller;


import com.reservation.reservation.dao.ReservationDao;
import com.reservation.reservation.model.Reservation;
import com.reservation.reservation.model.Vehicule;
import com.reservation.reservation.model.Client;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
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


    public int BirthdateCalcul(LocalDate startDate, LocalDate endDate) {

        Period period = Period.between(startDate, endDate);
        return period.getYears();

    }
public LocalDate fromDateToLocaleDate(Date date){
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
}
    public Client newClient(int idClient) {

    RestTemplate restTemplate = new RestTemplate();
    Client client = restTemplate.getForObject("http://192.168.1.229:8082/customers/" + idClient, Client.class);
    return client;

}
        public int BirthdatePerm (Client client){


        Date customerDate = client.getBirthdate();
        LocalDate startDate = fromDateToLocaleDate(customerDate);
        LocalDate endDate = LocalDate.parse("2023-09-08");

        return BirthdateCalcul(startDate, endDate);
    }

    @GetMapping("/client")
    public int clientAge(){
        Client client = newClient(2);
        return  BirthdatePerm(client);
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

    public void disponiblity(Vehicule vehicule, Reservation reservation){

//        listStarDate.forEach();

    }

    @GetMapping("/idVehicle")
    public Iterable<Integer> findAllStartDate (){
        Date startDate = convertToDateViaSqlDate( LocalDate.of (2023,9,6));
        Date endDate = convertToDateViaSqlDate(LocalDate.of(2023,9,20));
        return reservationDao.carNotDisponible(startDate,endDate);
    }

    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }
}
