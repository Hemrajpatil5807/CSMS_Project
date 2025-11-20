package com.csms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csms.dao.SitesDao;
import com.csms.dao.UsersDao;
import com.csms.dto.SitesDto;
import com.csms.entity.Sites;
import com.csms.entity.Users;
import com.csms.service.SitesServices;

@Service
public class SitesServicesImpl implements SitesServices{
	
	@Autowired
	SitesDao sitesDao;
	
	@Autowired
	UsersDao usersDao;

	Sites site = new Sites();
	
	@Override
	public Sites addSite(SitesDto sitedto) {
		
		Users u = usersDao.findByName(sitedto.getManager_name());
		if(u!=null) {
		     site.setSite_name(sitedto.getSite_name());
		     site.setLocation(sitedto.getLocation());
		     site.setStartDate(sitedto.getStartDate());
		     site.setEndDate(sitedto.getEndDate());
		     site.setStatus(sitedto.getStatus());
		     site.setManager(u);
		     site.setStage(sitedto.getStage());
		     site.setType(sitedto.getType());
		     site.setTender_id(sitedto.getTender_id());
		     site.setTender_amount(sitedto.getTender_amount());
		     
		    return sitesDao.save(site);      
		}
		return null;
	}

	@Override
	public List<Sites> getAllSites() {
		
		List<Sites> sites = (List<Sites>) sitesDao.findAll();
		if(sites!=null)
			return sites;
		else
			return null;
	}
	
	@Override
	public Sites getSite(int site_id) {
		
		Optional<Sites> os = sitesDao.findById(site_id);
		if(os.isEmpty()) 
			return null;
		else 
			return os.get();
	}

	@Override
	public Sites updateSite(SitesDto sitedto) {
		
        return sitesDao.findById(sitedto.getSite_id()).map(site ->{
        	     site.setSite_name(sitedto.getSite_name());
		     site.setLocation(sitedto.getLocation());
		     site.setStartDate(sitedto.getStartDate());
		     site.setEndDate(sitedto.getEndDate());
		     site.setStatus(sitedto.getStatus());
		     site.setManager(usersDao.findByName(sitedto.getManager_name()));
		     site.setStage(sitedto.getStage());
		     site.setType(sitedto.getType());
		     site.setTender_id(sitedto.getTender_id());
		     site.setTender_amount(sitedto.getTender_amount());
		     
		     return sitesDao.save(site);
        }).orElseThrow();	
	}

	@Override
	public boolean updateSiteStatus(int site_id, String status) {
		
		return sitesDao.findById(site_id).map( site ->{	
			site.setStatus(status);
			sitesDao.save(site);
			
			 return true;
	    }).orElse(false);
	}

	@Override
	public boolean deleteSite(int site_id) {
		sitesDao.deleteById(site_id);
		Optional<Sites> os = sitesDao.findById(site_id);
		if (os.isEmpty())
			return true;
		else
			return false;
	}
	
	
}
