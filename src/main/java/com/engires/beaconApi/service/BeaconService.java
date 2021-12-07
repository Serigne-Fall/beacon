package com.engires.beaconApi.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.engires.beaconApi.entity.Beacon;

@Service
public interface BeaconService {
	
	List<Beacon> getAllBeacons();
	Beacon getBeaconByUuid(String uuid);
	
	Beacon saveBeacon(Beacon bc);
	Beacon updateBeacon(Beacon bc);
	
	void deleteBeacon(Beacon bc);
	void deleteBeaconByUuid(String uuid);
	
	
}
