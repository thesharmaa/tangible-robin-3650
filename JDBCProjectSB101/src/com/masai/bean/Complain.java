package com.masai.bean;

public class Complain {

	int id;
	String complainName;
	String category;
	String empId;
	String engineer;
	String status;
	public Complain() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Complain(int id, String complainName, String category, String empId, String engineer, String status) {
		super();
		this.id = id;
		this.complainName = complainName;
		this.category = category;
		this.empId = empId;
		this.engineer = engineer;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComplainName() {
		return complainName;
	}
	public void setComplainName(String complainName) {
		this.complainName = complainName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEngineer() {
		return engineer;
	}
	public void setEngineer(String engineer) {
		this.engineer = engineer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Complain [id=" + id + ", complainName=" + complainName + ", category=" + category + ", empId=" + empId
				+ ", engineer=" + engineer + ", status=" + status + "]";
	}
	
	
}
