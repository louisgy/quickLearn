package com.quicklearn.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name="Address_Gen",
table="ID_GEN",
pkColumnName="GEN_NAME",
valueColumnName="GEN_VAL",
pkColumnValue="Addr_Gen",
initialValue=10,
allocationSize=1)
public class Address {
	@Id
	@GeneratedValue(generator = "Address_Gen")
	private int addressId;
	private int zipCode;
	private String city;
	private String Country;
	private String streetl;
	private Date dateSubmitted;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;

}
