package com.quicklearn.web.dto;

import javax.validation.constraints.NotNull;

public class CourseDTO {


private String categorie;

private String domain;

private String title;

private String description;

private String code;



public CourseDTO(String categorie, String domain, String title,String description,
		String code) {
	super();
	this.categorie = categorie;
	this.domain = domain;
	this.title = title;
	this.description = description;
	this.code = code;
}
public String getCategorie() {
	return categorie;
}
public void setCategorie(String categorie) {
	this.categorie = categorie;
}
public String getDomain() {
	return domain;
}
public void setDomain(String domain) {
	this.domain = domain;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}





}
