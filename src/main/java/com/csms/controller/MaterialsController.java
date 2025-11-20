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

import com.csms.entity.Materials;
import com.csms.service.MaterialsServices;

@RestController
@RequestMapping("/materials")
public class MaterialsController {

	@Autowired
	MaterialsServices materialsServices;
	
//	@PostMapping("/registermaterial")
//	public ModelAndView registerMaterial(@ModelAttribute Materials material) {
//		
//		System.out.println(material);
//		materialsService.addMaterial(material);
//		
//		return new ModelAndView("admin/admindash", "message" ,"Material Added Succefully !");
//		
//	}
	
	@PostMapping("/addmaterial")
	public String addMaterial(@RequestBody Materials material) {
		
		if(materialsServices.addMaterial(material)) {
			return "Material Added Successfully";
		}else {
			return "Material Not Added Successfully";	
		}
		
	}
	
	@GetMapping("/getmaterial")
	public Materials getmaterial(@RequestParam int material_id) {
	
		return materialsServices.getMaterial(material_id);
	}
	
	@GetMapping("/getallmaterials")
	public List<Materials>  getAllMaterials() {
		
		 List<Materials> materials = materialsServices.getAllMaterials();
		if(materials!=null)
	       return materials;
		else
			return null;
	}
		
	
	@PutMapping("/updatematerial")
	public String updateMaterial(@RequestBody Materials material) {
		
		boolean isUpdated = materialsServices.updateMaterial(material);
		
		if(isUpdated) {
			 return "Material Update Successfully !"; 
		}else {
        	 return "Material Not Updated !"; 
		}	
	}
	
	
	@DeleteMapping("/deletematerial")
	public String deleteSite(@RequestParam int material_id) {
		
		boolean isDelete = materialsServices.deleteMaterial(material_id);
		if(isDelete) {
			 return "Material Delete Successfully !"; 
		}else {
         	 return "Material Not Deleted !"; 
		} 
	}
	
	
	
	
}
