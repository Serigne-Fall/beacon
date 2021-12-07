package com.engires.beaconApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.engires.beaconApi.entity.Beacon;

public interface BeaconRepository extends JpaRepository<Beacon, String> {

}
