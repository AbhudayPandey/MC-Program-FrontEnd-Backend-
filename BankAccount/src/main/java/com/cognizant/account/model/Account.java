package com.cognizant.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor 
@Entity
@ToString
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "acc_no")
	private long accountNo;
	@Column(name = "ifsc_code")
	private String ifsc;
	@Column(name = "bank_name")
	private String bankName;
	@Column(name = "micr_code")
	private long micrCode;
	@Column(name = "amount")
	private float amount;
	@Column(name = "pan",nullable = false)
	private String pan;
	

	
}
