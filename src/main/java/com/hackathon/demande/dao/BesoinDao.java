package com.hackathon.demande.dao;

import com.hackathon.demande.model.Besoin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BesoinDao extends JpaRepository<Besoin, Integer> {
    public Besoin findByIdbesoin(int idbesoin);
}
