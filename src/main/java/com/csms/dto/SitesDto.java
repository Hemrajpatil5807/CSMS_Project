package com.csms.dto;

import com.csms.entity.Tender;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SitesDto {

	
	private int site_id;
	
	private String site_name;
	
	private String location;
	
    private String startDate;
	  
    private String endDate;
    
    private String status;

	private String manager_name;
	
	private String stage;

	private String type;

	private Tender tender_id;

	private String tender_amount;

	public SitesDto(String site_name, String location, String startDate, String endDate, String status,
			String manager_name, String stage, String type, Tender tender_id, String tender_amount) {
		super();
		this.site_name = site_name;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.manager_name = manager_name;
		this.stage = stage;
		this.type = type;
		this.tender_id = tender_id;
		this.tender_amount = tender_amount;
	}
	
	
}
