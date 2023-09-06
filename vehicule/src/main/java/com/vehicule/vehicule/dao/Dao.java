package com.vehicule.vehicule.dao;

import com.vehicule.vehicule.model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Dao extends JpaRepository<Vehicule, Integer> {

    List<Vehicule> findAll();

    Vehicule findById(int id);


    Vehicule deleteById(int id);





}
