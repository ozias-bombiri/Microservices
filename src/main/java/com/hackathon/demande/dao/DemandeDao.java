package com.hackathon.demande.dao;

import com.hackathon.demande.model.Demande;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface DemandeDao extends JpaRepository<Demande, Integer> {
    public Demande findByIddemande(int iddemande);

    public  List<Demande> findByDatesoumissionGreaterThan(Date datesoumissionLimit);
}
