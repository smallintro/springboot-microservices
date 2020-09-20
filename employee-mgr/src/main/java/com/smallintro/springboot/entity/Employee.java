package com.smallintro.springboot.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("This model is for employee information")
@Entity
@Table(name = "tb_employee")
public class Employee extends RepresentationModel<Employee>{

	@ApiModelProperty(notes = "Employee ID should have first name initial+ Gender initial + YYYYMMDDHHMM", required = true, example = "SM201104180925", position = 1)
	@Id
	private String empId;
	private String empName;
	private Integer projectCode;
	private String eMailId;
	private Date joiningDate;

	@ManyToMany(mappedBy = "employees")
	private List<Technology> technologies = new ArrayList<Technology>();

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(Integer projectCode) {
		this.projectCode = projectCode;
	}

	public String geteMailId() {
		return eMailId;
	}

	public void seteMailId(String eMailId) {
		this.eMailId = eMailId;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public List<Technology> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<Technology> technologies) {
		this.technologies = technologies;
	}

}
