package io.github.smallintro.springboot.projectservice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;

@ApiModel("This model is for department information")
@Entity
@Table(name = "tb_department")
public class Department extends RepresentationModel<Department> {

	@Id
	@GeneratedValue
	private Long deptId;
	@JsonView(Views.External.class)
	private String deptName;
	@OneToMany(mappedBy = "department")
	private List<Project> projects;

	public Department() {
		super();
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Project> getProjects() {

		List<Project> projectList = new ArrayList<Project>();

		for (Project proj : projects) {

			projectList.add(new Project(proj.getProjectCode(), proj.getProjectName()));

		}

		return projectList;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
