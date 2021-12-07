package com.engires.beaconApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.engires.beaconApi.entity.Produit;

@Service
public interface ProduitService {
	Produit saveProduit(Produit p);
	Produit updateProduit(Produit p);
	void deleteProduit(Produit p);
	void deleteProduitById(Long id);
	Produit getProduitById(Long id);
	List<Produit> getAllProduits();
	
	Produit findByUuidProduit(String beacon_uuid);
}
