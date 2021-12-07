package com.engires.beaconApi.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Beacon {
	
	@Id
	private String uuid;
	private short minor;
	private short major;
	
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public short getMinor() {
		return minor;
	}
	public void setMinor(short minor) {
		this.minor = minor;
	}
	public short getMajor() {
		return major;
	}
	public void setMajor(short major) {
		this.major = major;
	}
	
	
	
	
	

}
