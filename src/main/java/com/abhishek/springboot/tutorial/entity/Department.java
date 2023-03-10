package com.abhishek.springboot.tutorial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // annotate with @Entity so tthat it can interact with jpa
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long departmentId;
	
	@NotBlank(message = "please add department name")   // this will help validate the data, also add @valid annotation in the postmapping to use it
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;

//	constrctor injection
//	public Department(long departmentId, String departmentName, String departmentAddress, String departmentCode) {
//
//		this.departmentId = departmentId;
//		this.departmentName = departmentName;
//		this.departmentAddress = departmentAddress;
//		this.departmentCode = departmentCode;
//	}
//
//	public Department() {
//
//	}

//	getters and setters
//	public long getDepartmentId() {
//		return departmentId;
//	}
//
//	public void setDepartmentId(long departmentId) {
//		this.departmentId = departmentId;
//	}
//
//	public String getDepartmentName() {
//		return departmentName;
//	}
//
//	public void setDepartmentName(String departmentName) {
//		this.departmentName = departmentName;
//	}
//
//	public String getDepartmentAddress() {
//		return departmentAddress;
//	}
//
//	public void setDepartmentAddress(String departmentAddress) {
//		this.departmentAddress = departmentAddress;
//	}
//
//	public String getDepartmentCode() {
//		return departmentCode;
//	}
//
//	public void setDepartmentCode(String departmentCode) {
//		this.departmentCode = departmentCode;
//	}
//
//	@Override
//	public String toString() {
//		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName
//				+ ", departmentAddress=" + departmentAddress + ", departmentCode=" + departmentCode + "]";
//	}

}
