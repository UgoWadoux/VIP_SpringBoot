package com.reservation.reservation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int idVehicle;
    int idCustomer;
    Date startDate;
    Date endDate;
    Double price;

    public Reservation(int id, int idVehicle, int idCustomer, Date startDate, Date endDate, Double price) {
        this.id = id;
        this.idVehicle = idVehicle;
        this.idCustomer = idCustomer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public Reservation() {

    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "ReservationModel{" +
                "id=" + id +
                ", idVehicle=" + idVehicle +
                ", idCustomer=" + idCustomer +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
