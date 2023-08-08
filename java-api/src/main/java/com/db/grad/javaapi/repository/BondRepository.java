package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Bond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BondRepository extends JpaRepository<Bond, Integer> {

    List<Bond> findAll();

    Bond findByIsin(String isin);
}
