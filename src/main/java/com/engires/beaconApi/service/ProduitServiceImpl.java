package com.engires.beaconApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engires.beaconApi.entity.Produit;
import com.engires.beaconApi.repository.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	private ProduitRepository produitRepository;
	@Override
	public Produit saveProduit(Produit p) {
		// TODO Auto-generated method stub
		return produitRepository.save(p);
	}

	@Override
	public Produit updateProduit(Produit p) {
		// TODO Auto-generated method stub
		return produitRepository.save(p);
	}

	@Override
	public void deleteProduit(Produit p) {
		// TODO Auto-generated method stub
		produitRepository.delete(p);

	}

	@Override
	public void deleteProduitById(Long id) {
		// TODO Auto-generated method stub
		produitRepository.deleteById(id);

	}

	@Override
	public Produit getProduitById(Long id) {
		// TODO Auto-generated method stub
		return produitRepository.findById(id).get();
	}

	@Override
	public List<Produit> getAllProduits() {
		// TODO Auto-generated method stub
		return produitRepository.findAll();
	}

	@Override
	public Produit findByUuidProduit(String beacon_uuid) {
		// TODO Auto-generated method stub
		return produitRepository.findByBeaconUuidContains(beacon_uuid);
	}


}
