
package com.csms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tender")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tender {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tender_id")
	private int tender_id;

	@Column(name = "tender_name")
	private String tend_name;

	@Column(name = "tender_amount")
	private String tend_amount;

	@Column(name = "tender_pass_amount")
	private String tend_pass_amount;

}
