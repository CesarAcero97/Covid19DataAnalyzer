package models;

import java.time.LocalDate;

public class Patient {
	private int ID;
	private LocalDate admissionDate;
	private String city;
	private String department;
	private String attention;
	private byte age;
	private String sex;
	private String type;
	private String status;
	private String countryOfOrigin;
	private LocalDate firstSymptomsDate;
	private LocalDate diagnosticDate;
	private LocalDate recoveryDate;
	private String recoveryType;
	
	public Patient(int iD, LocalDate admissionDate, String city, String department, String attention, byte age,
			String sex, String type, String status, String countryOfOrigin, LocalDate firstSymptomsDate,
				   LocalDate diagnosticDate, LocalDate recoveryDate, String recoveryType) {
		ID = iD;
		this.admissionDate = admissionDate;
		this.city = city;
		this.department = department;
		this.attention = attention;
		this.age = age;
		this.sex = sex;
		this.type = type;
		this.status = status;
		this.countryOfOrigin = countryOfOrigin;
		this.firstSymptomsDate = firstSymptomsDate;
		this.diagnosticDate = diagnosticDate;
		this.recoveryDate =recoveryDate;
		this.recoveryType = recoveryType;
	}

	public int getID() {
		return ID;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public String getCity() {
		return city;
	}

	public String getDepartment() {
		return department;
	}

	public String getAttention() {
		return attention;
	}

	public byte getAge() {
		return age;
	}

	public String getSex() {
		return sex;
	}

	public String getType() {
		return type;
	}

	public String getStatus() {
		return status;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public LocalDate getFirstSymptomsDate() {
		return firstSymptomsDate;
	}

	public LocalDate getDiagnosticDate() {
		return diagnosticDate;
	}

	public LocalDate getRecoveryDate() {
		return recoveryDate;
	}

	public String getRecoveryType() {
		return this.recoveryType;
	}
	
	public void setID(int iD) {
		ID = iD;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public void setFirstSymptomsDate(LocalDate firstSymptomsDate) {
		this.firstSymptomsDate = firstSymptomsDate;
	}

	public void setDiagnosticDate(LocalDate diagnosticDate) {
		this.diagnosticDate = diagnosticDate;
	}

	public void setRecoveryDate(LocalDate recoveryDate) {
		this.recoveryDate = recoveryDate;
	}

	public void setRecoveryType(String recoveryType) {
		this.recoveryType = recoveryType;
	}

	public Object[] toObject() {
		return new Object[]{ID, admissionDate, city, department, attention, age, sex, type, status, countryOfOrigin, firstSymptomsDate, diagnosticDate, recoveryDate, recoveryType};
	}
	
}
