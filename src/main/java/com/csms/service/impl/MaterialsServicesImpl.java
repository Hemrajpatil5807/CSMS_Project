package com.csms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csms.dao.MaterialsDao;
import com.csms.entity.Materials;
import com.csms.service.MaterialsServices;

@Service
public class MaterialsServicesImpl implements MaterialsServices{
	
	@Autowired
	MaterialsDao materialsDao;

	@Override
	public boolean addMaterial(Materials material) {

		Materials mt = materialsDao.save(material);
		if(mt!=null)
			return true;
		else
		   return false;
	}

	@Override
	public List<Materials> getAllMaterials() {
		
		return (List<Materials>) materialsDao.findAll();
	}

	@Override
	public Materials getMaterial(int material_id) {
		
		Optional<Materials> om =  materialsDao.findById(material_id);
		
		if(om.isEmpty())
			return null;
		else
			return om.get();
	}

	@Override
	public boolean updateMaterial(Materials material) {
		
		 return materialsDao.findById(material.getMaterial_id()).map(mtr ->{
	        
			 mtr.setMaterial_name(material.getMaterial_name());
			 mtr.setUnit(material.getUnit());
			 mtr.setUnitPrice(material.getUnitPrice());
			 mtr.setAvailable_stock(material.getAvailable_stock());
		     
		     materialsDao.save(mtr);
		     return true;
        	
        }).orElse(false);
		
	}

	@Override
	public boolean deleteMaterial(int material_id) {
         
		materialsDao.deleteById(material_id);
		
		Optional<Materials> om = materialsDao.findById(material_id);
		if (om.isEmpty())
			return true;
		else
			return false;
	}
	
	
	

}
