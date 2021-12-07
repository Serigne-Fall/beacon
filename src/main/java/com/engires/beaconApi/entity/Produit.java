package com.engires.beaconApi.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomProduit;
	private String description;
	private boolean isPromo;
	private int quantite;
	private int prix;
	private Date dateCreated;
	private String beaconUuid;

	public Long getId() {
		return id;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPromo() {
		return isPromo;
	}

	public void setPromo(boolean isPromo) {
		this.isPromo = isPromo;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getBeaconUuid() {
		return beaconUuid;
	}

	public void setBeaconUuid(String beaconUuid) {
		this.beaconUuid = beaconUuid;
	}

	
	
}
