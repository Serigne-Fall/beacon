package com.engires.beaconApi.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.engires.beaconApi.entity.Beacon;
import com.engires.beaconApi.entity.Produit;
import com.engires.beaconApi.service.BeaconServiceImpl;
import com.engires.beaconApi.service.ProduitServiceImpl;



@Controller
public class ProduitController {
	
	@Autowired
	ProduitServiceImpl produitServiceImpl;
	@Autowired
	BeaconServiceImpl beaconServiceImpl;
	
	@RequestMapping("/createProduit")
	public String showCreate(ModelMap modelMap) {
		List<Beacon> beacons=beaconServiceImpl.getAllBeacons();
		modelMap.addAttribute("produit",new Produit());
		modelMap.addAttribute("beacons",beacons);
		return "createProduit";
	}
	
	@RequestMapping("/saveProduit")
	public String saveProduit(@ModelAttribute("Produit") Produit produit,@RequestParam("date") String date,ModelMap modelMap,BindingResult bindingResult) throws ParseException{
		
		if(bindingResult.hasFieldErrors()) return "createProduit";
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreated=dateFormat.parse(date);
		produit.setDateCreated(dateCreated);
		Produit produitSave=produitServiceImpl.saveProduit(produit);
		String msg="Le produit a ete enregistre avec un id :"+produitSave.getId();
		modelMap.addAttribute("msg",msg);
		modelMap.addAttribute("produit",produit);
		return "createProduit";
	}
	@RequestMapping("/listeProduits")
	public String showListeProduits(ModelMap modelMap) {
		List<Produit> produits=produitServiceImpl.getAllProduits();
		modelMap.addAttribute("produits",produits);
		return "listeProduits";
	}
	
	@RequestMapping("/deleteProduit")
	public String deleteProduit(@RequestParam("id") Long id,ModelMap modelMap) {
		produitServiceImpl.deleteProduitById(id);
		List<Produit> produits=produitServiceImpl.getAllProduits();
		modelMap.addAttribute("produits",produits);
		return "listeProduits";
	}
	@RequestMapping("/editFormProduit")
	public String editProduitForm(@RequestParam("id") Long id,ModelMap modelMap) {
		Produit produit=produitServiceImpl.getProduitById(id);
		modelMap.addAttribute("produit",produit);
		return "editFormProduit";
	}
	@RequestMapping("/editProduit")
	public String editProduit(@ModelAttribute("Produit") Produit produit,@RequestParam("date") String date ,ModelMap modelMap) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreated=format.parse(date);
		produit.setDateCreated(dateCreated);
		produitServiceImpl.updateProduit(produit);
		List<Produit> produits=produitServiceImpl.getAllProduits();
		modelMap.addAttribute("produits",produits);
		return "listeProduits";
	}
	
}

