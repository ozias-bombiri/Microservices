package com.hackathon.demande.web.controller;

import com.hackathon.demande.dao.ClientDao;
import com.hackathon.demande.dao.ElementBesoinDao;
import com.hackathon.demande.model.Demande;
import com.hackathon.demande.model.Elementbesoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/Client", method = RequestMethod.GET)
public class ElementBesoinController {

    @Autowired
    private ElementBesoinDao elemententDao;

    @GetMapping(value="/ElementBesoins")
    public MappingJacksonValue listeDemandes() {

        List<Elementbesoin> elements = elemententDao.findAll();
        MappingJacksonValue demandesFiltres = new MappingJacksonValue(elements);
        return demandesFiltres;
    }
}
