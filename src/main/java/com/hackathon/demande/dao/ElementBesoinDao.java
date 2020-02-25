package com.hackathon.demande.dao;

import com.hackathon.demande.model.Elementbesoin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementBesoinDao  extends JpaRepository<Elementbesoin, Integer> {
    public ElementBesoinDao findByIdelementbesoin(int idelementbesoin);
}
