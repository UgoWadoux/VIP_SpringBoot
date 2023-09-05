package com.vehicule.vehicule.webController;

import com.vehicule.vehicule.dao.Dao;
import com.vehicule.vehicule.model.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;

import java.util.List;

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
            vehiculeDao.save(vehicule);
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
