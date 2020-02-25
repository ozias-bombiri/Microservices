package com.hackathon.demande.web.controller;

import com.hackathon.demande.dao.DemandeDao;
import com.hackathon.demande.dao.EtatDemandeDao;
import com.hackathon.demande.model.Demande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/Client", method = RequestMethod.GET)
public class DemandeController {

    @Autowired
    private DemandeDao demandeDao;
    @Autowired
    private EtatDemandeDao etatDemandeDao;

    @GetMapping(value="/Demandes")
    public MappingJacksonValue listeDemandes() {

        List <Demande> demandes = demandeDao.findAll();
        MappingJacksonValue demandesFiltres = new MappingJacksonValue(demandes);
        return demandesFiltres;
    }
    @GetMapping(value="/Demandes/{id}")
    public Demande findDemande(@PathVariable String id) {
        return demandeDao.findByIddemande(Integer.parseInt(id));
    }

    @GetMapping(value="/Demandes/date")
    public ResponseEntity<Void> findDemandeDate(@RequestBody String dates) {
        try {
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            //Date d= formater.parse(dates);
            //List <Demande> demandes = demandeDao.findByDatesoumissionGreaterThan(d);
            List <Demande> demandes = demandeDao.findAll();
            MappingJacksonValue demandesFiltres = new MappingJacksonValue(demandes);

            if (demandes.isEmpty())
                return ResponseEntity.noContent().build();

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/Demandes")
                    .buildAndExpand(demandesFiltres)
                    .toUri();
                return ResponseEntity.created(location).build();
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/Demandes/add")
    public Demande ajouterDemande(@Valid @RequestBody Demande demande) {
        demande.setDatemodification(new Date());
        demande.setIdetatdemande(etatDemandeDao.findByIdetatdemande(1));
         return demandeDao.save(demande);
    }
    @PutMapping(value= "/Demandes/update/{id}")
    public Demande modifierDemande(@RequestBody Demande demande){

        return demandeDao.saveAndFlush(demande);


    }

    @DeleteMapping(value= "/Demandes/delete/{id}")
    public boolean supprimerDemande(@RequestBody Demande demande){
        try {
            demandeDao.delete(demande);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }


}
