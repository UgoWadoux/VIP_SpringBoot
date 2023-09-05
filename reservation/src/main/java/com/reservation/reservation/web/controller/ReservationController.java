package com.reservation.reservation.web.controller;

import com.reservation.reservation.dao.ReservationDao;
import com.reservation.reservation.model.Reservation;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

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

    public void checkLicense(String licenseNumber){
        RestTemplate restTemplate =new RestTemplate();
        Boolean isValid = restTemplate.getForObject("http://localhost:8081/licenses/"+licenseNumber,Boolean.class);
        if (isValid== null || !isValid){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }

}
