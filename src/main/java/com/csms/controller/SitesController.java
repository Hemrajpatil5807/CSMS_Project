package com.csms.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csms.dto.SitesDto;
import com.csms.entity.Sites;
import com.csms.service.SitesServices;


@RestController
@RequestMapping("/sites")
public class SitesController {
	
	@Autowired
	SitesServices sitesServices;

	@PostMapping("/addsite")
	public String addSite(@RequestBody SitesDto sitedto) {
		
		Sites s = sitesServices.addSite(sitedto);	
		if(s!= null)
		   return "Site Added Successfully !";
		else
			return "Site Not Added Successfully";
	}
	
	@GetMapping("/getsite")
	public Sites getSite(@RequestParam int id) {
	      return sitesServices.getSite(id);
	 }
	
	
	@GetMapping("/getallsites")
	public List<Sites> getAllSites() {
		
	     List<Sites> sites = sitesServices.getAllSites();		 
	     if(sites!=null)
			return sites;
		 else
			return null;
	}
	
	
	@PutMapping("/updatesite")
	public String updateSite(@RequestBody SitesDto sitedto) {
	
		Sites site = sitesServices.updateSite(sitedto);
		if(site != null) {
			 return "Site Update Successfully !"; 
		}else {
        	 return "Site Not Updated !"; 
		}	
	}
	
	
	@PutMapping("/updatesitestatus")
	public String updateSiteStatus(@RequestParam int site_id, @RequestParam String status) {
	
		boolean isUpdated = sitesServices.updateSiteStatus(site_id, status);
		if(isUpdated) {
			 return "Site Status Update Successfully !"; 
		}else {
        	 return "Site Status Not Updated !"; 
		}	
	}
	
	
	@DeleteMapping("/deletesite")
	public String deleteSite(@RequestParam int site_id) {
		boolean isDelete = sitesServices.deleteSite(site_id);
		if(isDelete) {
			 return "Site Delete Successfully !"; 
		}else {
         	 return "Site Not Deleted !"; 
		} 
	}
	
	
	
	
}
