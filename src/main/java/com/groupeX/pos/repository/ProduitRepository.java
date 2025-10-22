package com.groupeX.pos.repository;

import com.groupeX.pos.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    // Recherche des produits par nom (insensible à la casse)
    List<Produit> findByNomContainingIgnoreCase(String nom);

    // Recherche des produits par disponibilité
    List<Produit> findByDisponible(boolean disponible);

    // Optionnel : recherche des produits par catégorie
    List<Produit> findByCategorieId(Long categorieId);
}


