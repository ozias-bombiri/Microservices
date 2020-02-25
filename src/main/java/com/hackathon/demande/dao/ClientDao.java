package com.hackathon.demande.dao;

import com.hackathon.demande.model.Client;
import com.hackathon.demande.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client, Integer> {
    public Client findByIdclient(int idclient);
}
