package com.tiru.restfulwebservice.beans;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "All details about the user")
public class User {
	
public User(Integer id, String name, Date dateOfbirth) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfbirth = dateOfbirth;
	}

private Integer id;
public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Date getDateOfbirth() {
	return dateOfbirth;
}

public void setDateOfbirth(Date dateOfbirth) {
	this.dateOfbirth = dateOfbirth;
}

@Size(min=2, message = "name should have atlease 2 characters")
@ApiModelProperty(notes ="name should have atlease 2 characters")
private String name;
@Past()
@ApiModelProperty(notes ="Birth date should be in the past")
private Date dateOfbirth;

@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", dateOfbirth=" + dateOfbirth + "]";
}
}
