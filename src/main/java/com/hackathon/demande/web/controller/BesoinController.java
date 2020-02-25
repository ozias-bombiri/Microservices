package com.hackathon.demande.web.controller;

import com.hackathon.demande.dao.*;
import com.hackathon.demande.model.Besoin;
import com.hackathon.demande.model.Demande;
import com.hackathon.demande.model.Elementbesoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Besoins", method = RequestMethod.GET)
public class BesoinController {
    @Autowired
    private BesoinDao besoinDao;
    @PostMapping(path= "/add")
    public Besoin ajouterBesoin(Besoin besoin){

        return besoinDao.save(besoin);
    }

    @GetMapping(value="/Liste")
    public MappingJacksonValue listeBesoins() {

        List <Besoin> besoins = besoinDao.findAll();
        MappingJacksonValue besoinsFiltres = new MappingJacksonValue(besoins);
        return besoinsFiltres;
    }
    @GetMapping(value="/{id}")
    public Besoin findBesoin(@PathVariable String id) {
        return besoinDao.findByIdbesoin(Integer.parseInt(id));
    }
    @PutMapping(value= "/update/{id}")
    public Besoin modifierBesoin(@RequestBody Besoin besoin){
        return besoinDao.saveAndFlush(besoin);

    }

    @DeleteMapping(value= "/delete/{id}")
    public boolean supprimerBesoin(@RequestBody Besoin besoin){
        try {
            besoinDao.delete(besoin);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }
}
