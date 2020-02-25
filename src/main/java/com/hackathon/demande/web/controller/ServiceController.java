package com.hackathon.demande.web.controller;

import com.hackathon.demande.dao.ServiceDao;
import com.hackathon.demande.model.Client;
import com.hackathon.demande.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Services", method = RequestMethod.GET)
public class ServiceController {

    @Autowired
    private ServiceDao serviceDao;

    @GetMapping(value="/Liste")

    public MappingJacksonValue listeServices() {
        List<Service> services = serviceDao.findAll();
        MappingJacksonValue demandesFiltres = new MappingJacksonValue(services);
        return demandesFiltres;
    }

    @GetMapping(value="/{id}")
    public Service findClient(@PathVariable String id) {

        Service service = serviceDao.findByIdservice(Integer.parseInt(id));
        return service;
    }

    @PostMapping(path= "/add")
    public Service ajouterService(@RequestBody Service service) {
        return serviceDao.save(service);

    }
    @PutMapping(value= "/update/{id}")
    public Service modifierService(@RequestBody Service service){
        return serviceDao.saveAndFlush(service);


    }

    @DeleteMapping(value= "/delete/{id}")
    public boolean supprimerService(@RequestBody Service service){
        try {
            serviceDao.delete(service);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }


}
