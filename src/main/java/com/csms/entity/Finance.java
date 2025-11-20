
package com.csms.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "finance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Finance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "finance_id")
	private int finance_id;

	@ManyToOne
	@JoinColumn(name = "site_id")
	private Sites site_id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user_id;

	@Column(name = "expense_type")
	private String expense_type;

	@Column(name = "amount")
	private double amount;

	@Column(name = "currency")
	private String currency;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "modified_on")
	private LocalDate modified_on;

	@Column(name = "GST")
	private String gst;

	@Column(name = "expense_direction")
	private String expense_direction;

	public Finance(Sites site_id, Users user_id, String expense_type, double amount, String currency, LocalDate date,
			LocalDate modified_on, String gst, String expense_direction) {

		this.site_id = site_id;
		this.user_id = user_id;
		this.expense_type = expense_type;
		this.amount = amount;
		this.currency = currency;
		this.date = date;
		this.modified_on = modified_on;
		this.gst = gst;
		this.expense_direction = expense_direction;
	}

}
