package com.hackathon.demande.dao;

import com.hackathon.demande.model.Demande;
import com.hackathon.demande.model.Etatdemande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtatDemandeDao extends JpaRepository<Etatdemande, Integer> {
    public Etatdemande findByIdetatdemande(int idetatdemande);
}
