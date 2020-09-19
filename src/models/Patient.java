package models;

import java.time.LocalDate;

public class Patient {
	private int ID;
	private LocalDate admissionDate;
	private String city;
	private String department;
	private String attention;
	private byte age;
	private char sex;
	private String type;
	private String status;
	private String countryOfOrigin;
	private LocalDate firstSymptomsDate;
	private LocalDate diagnosticDate;
	private LocalDate recoveryDate;
	private String recoveryType;
	
	public Patient(int iD, LocalDate admissionDate, String city, String department, String attention, byte age,
			char sex, String type, String status, String countryOfOrigin, LocalDate firstSymptomsDate,
			LocalDate diagnosticDate, LocalDate recoveryDate, String recoveryType) {
		super();
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
		this.recoveryDate = recoveryDate;
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

	public char getSex() {
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
		return recoveryType;
	}
	
}
