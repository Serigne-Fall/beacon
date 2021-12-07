package com.engires.beaconApi.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.engires.beaconApi.entity.Produit;
import com.engires.beaconApi.service.ProduitServiceImpl;


@RequestMapping("/api")
@RestController
public class BeaconProduit {
	@Autowired
	ProduitServiceImpl produitServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Produit> getAllProduits(){
		return produitServiceImpl.getAllProduits();
	}
	
	@RequestMapping(value = "/{beacon_uuid}", method = RequestMethod.GET)
	public Produit getProduit(@PathVariable("beacon_uuid") String beacon_uuid) {
		return produitServiceImpl.findByUuidProduit(beacon_uuid);
	}
}
