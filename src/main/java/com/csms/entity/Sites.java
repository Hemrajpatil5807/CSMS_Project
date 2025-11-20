
package com.csms.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sites")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sites {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "site_id")
	private int site_id;

	@Column(name = "site_name")
	private String site_name;

	@Column(name = "location")
	private String location;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "end_date")
	private LocalDate endDate;

	@Column(name = "status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users manager;

	@Column(name = "stage")
	private String stage;

	@Column(name = "type")
	private String type;

	@OneToOne
	@JoinColumn(name = "tender_id")
	private Tender tender_id;

	@Column(name = "tender_amount")
	private String tender_amount;

	public Sites(String site_name, String location, LocalDate startDate, LocalDate endDate, String status,
			Users manager, String stage, String type, Tender tender_id, String tender_amount) {
		super();
		this.site_name = site_name;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.manager = manager;
		this.stage = stage;
		this.type = type;
		this.tender_id = tender_id;
		this.tender_amount = tender_amount;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = LocalDate.parse(startDate);
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = LocalDate.parse(endDate);
	}

}
