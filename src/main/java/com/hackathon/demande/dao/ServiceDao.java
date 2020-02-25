package com.hackathon.demande.dao;

import com.hackathon.demande.model.Demande;
import com.hackathon.demande.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDao extends JpaRepository<Service, Integer> {
    public Service findByIdservice(int idservice);
}