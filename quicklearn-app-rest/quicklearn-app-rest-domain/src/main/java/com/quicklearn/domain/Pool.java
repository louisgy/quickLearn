package com.quicklearn.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name="Pool_Gen",
table="ID_GEN",
pkColumnName="GEN_NAME",
valueColumnName="GEN_VAL",
pkColumnValue="pol_Gen",
initialValue=6000,
allocationSize=7)
public class Pool {
	
	@Id
	@GeneratedValue(generator = "Pool_Gen")
	private int poolId;
	
	@OneToMany(mappedBy="pool")
	private Collection<Question> question;
}
