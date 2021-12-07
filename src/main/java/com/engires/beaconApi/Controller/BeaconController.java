package com.engires.beaconApi.Controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.engires.beaconApi.entity.Beacon;
import com.engires.beaconApi.entity.Produit;
import com.engires.beaconApi.service.BeaconServiceImpl;



@Controller
public class BeaconController {
	
	@Autowired
	private BeaconServiceImpl beaconServiceImpl;
	
	@RequestMapping("/")
	public String index() {
		return "template";
	}
	@RequestMapping("/showCreateBeacon")
	public String showCreate(ModelMap modelMap) {
		modelMap.addAttribute("produit",new Produit());
		return "createBeacon";
	}
	
	@RequestMapping("/listeBeacons")
	public String showListeBeacons(ModelMap modelMap) {
		List<Beacon> beacons=beaconServiceImpl.getAllBeacons();
		modelMap.addAttribute("beacons",beacons);
		return "listeBeacons";
	}
	//---------------------------------------------
	@RequestMapping("/editFormBeacon")
	public String editBeaconForm(@RequestParam("uuid") String uuid,ModelMap modelMap) {
		Beacon beacon=beaconServiceImpl.getBeaconByUuid(uuid);
		modelMap.addAttribute("beacon",beacon);
		return "editFormBeacon";
	}
	@RequestMapping("/editBeacon")
	public String editProduit(@ModelAttribute("Beacon") Beacon beacon,ModelMap modelMap) throws ParseException{
		beaconServiceImpl.updateBeacon(beacon);
		List<Beacon> beacons=beaconServiceImpl.getAllBeacons();
		modelMap.addAttribute("beacons",beacons);
		return "listeBeacons";
	}
	//---------------------------------------------
	@RequestMapping("/saveBeacon")
	public String saveBeacon(@ModelAttribute("Beacon") Beacon bc,ModelMap modelMap){
		Beacon beaconSave=beaconServiceImpl.saveBeacon(bc);
		String msg="Le produit a ete enregistre avec un id :"+beaconSave.getUuid();
		modelMap.addAttribute("msg",msg);
		modelMap.addAttribute("beacon",bc);
		return "createBeacon";
	}
	//---------------------------------------------
	@RequestMapping("/deleteBeacon")
	public String deleteBeaconByUuid(@RequestParam("uuid") String uuid,ModelMap modelMap){
		 beaconServiceImpl.deleteBeaconByUuid(uuid);
		 List<Beacon> beacons=beaconServiceImpl.getAllBeacons();
		 modelMap.addAttribute("beacons",beacons);
		 return "listeBeacons";
	}
	
}
