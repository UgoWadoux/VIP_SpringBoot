package com.vehicule.vehicule.webController;

import com.vehicule.vehicule.dao.Dao;
import com.vehicule.vehicule.model.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
public class VehiculeController {




    @RestController
    @RequestMapping("/vehicules")
    public class VehiculesController {



        @Autowired
        private Dao vehiculeDao;







        @ApiOperation(value = "Affiche la liste des véhicules.")
        @GetMapping
        public List<Vehicule> vehiculeArrayList() {
            return vehiculeDao.findAll();
        }

        @ApiOperation(value = "Recupère un véhicule via son id, a condition qu'il soit en stock. ")
        @GetMapping("/{id}")
        public Vehicule findByVehiculeId(@PathVariable int id) {
            return vehiculeDao.findById(id);
        }

        @ApiOperation(value = "Ajoute un vehicule a la liste.")
        @PostMapping
        public void addVehicule(@RequestBody Vehicule vehicule) {
            motoCm3(vehicule);
            utilitaryM3(vehicule);
            vehiculeDao.save(vehicule);
        }

        public void motoCm3 (Vehicule vehicule) {

            if(vehicule.getType().equals("moto")){
                if(vehicule.getCm3() == 0){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "cm3 need to be set");
                }
            }
        }

        public void utilitaryM3 (Vehicule vehicule) {

            if(vehicule.getType().equals("utilitaire")){
                if(vehicule.getM3Chargement() == 0){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "m3Chargement need to be set");
                }
            }
        }


        @ApiOperation(value = "Modifie un véhicule existant.")
        @PutMapping
        public Vehicule modifyVehiculeById(@RequestBody Vehicule vehicule){
            return vehiculeDao.save(vehicule);
        }

        @ApiOperation(value = "Supprime un véhicule déjà éxistant de la liste.")
        @DeleteMapping("/{id}")
        public Vehicule deleteByVehiculeId(@PathVariable int id){
            return vehiculeDao.deleteById(id);
        }
    }
}
