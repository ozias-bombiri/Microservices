package com.hackathon.demande.web.controller;

import com.hackathon.demande.dao.ClientDao;
import com.hackathon.demande.dao.ServiceDao;
import com.hackathon.demande.model.Client;
import com.hackathon.demande.model.Demande;
import com.hackathon.demande.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/Clients", method = RequestMethod.GET)
public class ClientController {

    @Autowired
    private ClientDao clientDao;

    @GetMapping(value="/Liste")
    public MappingJacksonValue listeClients() {

        List<Client> clients = clientDao.findAll();

        MappingJacksonValue clientsFiltres = new MappingJacksonValue(clients);
        return clientsFiltres;
    }

    @GetMapping(value="/{id}")
    public Client findClient(@PathVariable String id) {

        Client client = clientDao.findByIdclient(Integer.parseInt(id));

        MappingJacksonValue clientFiltres = new MappingJacksonValue(client);
        return client;
    }

    @PostMapping(path= "/add")
    public Client ajouterClient(@RequestBody Client client) {
        clientDao.save(client);
        return client;
    }
    @PutMapping(value= "/update/{id}")
    public Client modifierClient(@RequestBody Client client){
        clientDao.saveAndFlush(client);
        return client;

    }

    @DeleteMapping(value= "/delete/{id}")
    public boolean supprimerClient(@RequestBody Client client){
        try {
            clientDao.delete(client);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }
}
