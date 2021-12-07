package com.engires.beaconApi.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.engires.beaconApi.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	Produit findByBeaconUuidContains(String beacon_uuid);
}