package com.groupeX.pos.repository;

import com.groupeX.pos.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface CategorieRepository extends JpaRepository<Categorie, Long> {

    List<Categorie> findByNomContainingIgnoreCase(String nom);

}

