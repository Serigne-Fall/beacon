package com.engires.beaconApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engires.beaconApi.entity.Beacon;
import com.engires.beaconApi.repository.BeaconRepository;

@Service
public class BeaconServiceImpl implements BeaconService {
	
	@Autowired
	BeaconRepository beaconRepository;

	@Override
	public List<Beacon> getAllBeacons() {
		// TODO Auto-generated method stub
		return beaconRepository.findAll();
	}

	@Override
	public Beacon getBeaconByUuid(String uuid) {
		// TODO Auto-generated method stub
		return beaconRepository.findById(uuid).get();
	}

	@Override
	public Beacon saveBeacon(Beacon bc) {
		// TODO Auto-generated method stub
		return beaconRepository.save(bc);
	}

	@Override
	public Beacon updateBeacon(Beacon bc) {
		// TODO Auto-generated method stub
		return beaconRepository.save(bc);
	}

	@Override
	public void deleteBeacon(Beacon bc) {
		// TODO Auto-generated method stub
		beaconRepository.delete(bc);
	}

	@Override
	public void deleteBeaconByUuid(String uuid) {
		// TODO Auto-generated method stub
		beaconRepository.deleteById(uuid);
	}

}
