
package com.csms.entity;

import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "materials")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Materials {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "material_id")
	private int material_id;

	@ManyToOne
	@JoinColumn(name = "site_id")
	private Sites site_id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user_id;

	@Column(name = "material_name")
	private String material_name;

	@Column(name = "unit")
	private String unit;

	@Column(name = "available_stock")
	private int available_stock;

	@Column(name = "unitPrice")
	private double unitPrice;

	@Column(name = "date_time")
	private Timestamp dateTime;

	@Column(name = "other")
	private String other;

	@Column(name = "estim_count")
	private int estim_count;

	public Materials(Sites site_id, Users user_id, String material_name, String unit, int available_stock,
			double unitPrice, Timestamp dateTime, String other, int estim_count) {
		super();
		this.site_id = site_id;
		this.user_id = user_id;
		this.material_name = material_name;
		this.unit = unit;
		this.available_stock = available_stock;
		this.unitPrice = unitPrice;
		this.dateTime = dateTime;
		this.other = other;
		this.estim_count = estim_count;
	}

}
