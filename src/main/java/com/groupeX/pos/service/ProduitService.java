package com.groupeX.pos.service;

import com.groupeX.pos.dto.ProduitDto;
import com.groupeX.pos.entity.Produit;
import com.groupeX.pos.repository.ProduitRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    private ProduitRepository produitRepository;

    public Produit findProduitById(Long id){
        return produitRepository.findById(id).orElseThrow(() -> new RuntimeException("produit not found"));
    }

    public List<Produit> findProduitByNom(String keyword){
        return produitRepository.findByNomContainingIgnoreCase(keyword);
    }

    public List<Produit> findProduitByCategorieId(Long id){
        return produitRepository.findByCategorieId(id);
    }

    public List<Produit> findProduitDisponible(boolean disponible){
        return produitRepository.findByDisponible(disponible);
    }

    public Page<Produit> findAllProduits(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return produitRepository.findAll(pageable);
    }

    public Produit saveProduit(Produit produit){
        return produitRepository.save(produit);
    }

    public Produit updateProduit(Long id,Produit produit){
        produit.setId(id);
        return produitRepository.save(produit);
    }

    public void deleteProduit(Produit produit){
        produitRepository.delete(produit);
    }

    public void deleteProduitById(Long id){
        produitRepository.deleteById(id);
    }

}
