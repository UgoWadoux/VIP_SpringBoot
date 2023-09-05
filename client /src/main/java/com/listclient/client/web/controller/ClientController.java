package com.listclient.client.web.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.listclient.client.dao.ClientDao;
import com.listclient.client.model.Client;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/customers")
     public class ClientController {
    @Autowired
    private  ClientDao clientDao;
    public ClientController(ClientDao clientDao){
        this.clientDao = clientDao;
    }

//    @ApiOperation(value = "Donne la liste de tous les clients")
//    @GetMapping("/clients")
//    public ArrayList<Client> test() {
//        return clientDao.findAll();
//    }
//
    @ApiOperation(value = "Trouve un client grace a son ID")
    @GetMapping("/{id}")
    public Client findClientById(@PathVariable int id) {
    return clientDao.findById(id);
    }

    @ApiOperation(value = "Supprime un client en fonction de son ID")
    @DeleteMapping("/{id}")
    public Client deleteClientById(@PathVariable int id) {
        return clientDao.deleteById(id);
    }

    @ApiOperation(value = "Ajout d'un client")
    @PostMapping
    public Client addClient (@RequestBody Client client){
//        checkLicense(client.getLicenseNumber());
        return clientDao.save(client);
    }

    @ApiOperation(value = "Modification des information d'un client")
    @PutMapping
    public Client modifyClient( @RequestBody Client client){
//        checkLicense(client.getLicenseNumber());
        return clientDao.save(client);
    }


//    @RequestMapping(value = "/clients", method = RequestMethod.GET)
//    public MappingJacksonValue clientList() {
//        Iterable<Client> clients = clientDao.findAll();
//        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");
//
//        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);
//
//        MappingJacksonValue produitsFiltres = new MappingJacksonValue(clients);
//
//        produitsFiltres.setFilters(listDeNosFiltres);
//
//        return produitsFiltres;
//    }
     @GetMapping
    public Iterable<Client> getAllUsers() {
        return clientDao.findAll();
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



