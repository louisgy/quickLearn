package com.quicklearn.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;


@Entity
@TableGenerator(name = "Course_Gen", table = "CRS_ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Addr_Gen", initialValue = 500, allocationSize = 2)
public class Course {

	@Id
	@GeneratedValue(generator = "Course_Gen")
	private int id;
	private String categorie;    // Java, 
	private String domain;    //  database, finance, Aviation, Architecture, language
	private String title;       // Introduction to African American Studies or 
	                            // Oracle Certified Associate, Java SE 8 Programmer 
	                            // or CIPM - Certified Information Privacy Manager) 
	private String description; // CIPM - Certified Information Privacy Manager) 
	private String code;        // BIOL101 or 1Z0-808 pr CIPM832
	
	@OneToMany(mappedBy="course")
	private Collection<CourseSession> courseSession;
	
	public Course(){
		//courseSession = new ArrayList<CourseSession>();
	}
	
	
	

	public Course(String categorie, String domain, String title, String description, String code) {
		super();
		this.categorie = categorie;
		this.domain = domain;
		this.title = title;
		this.description = description;
		this.code = code;
	}




	public Course(String categorie, String domain, String title, String description, String code,Collection<CourseSession>  courseSession ) {
		super();
		this.categorie = categorie;
		this.domain = domain;
		this.title = title;
		this.description = description;
		this.code = code;
		courseSession = new ArrayList<CourseSession>();

	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public Collection<CourseSession> getCourseSession() {
		return courseSession;
	}
}
