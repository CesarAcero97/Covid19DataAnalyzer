package models;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PatientFull{
	private String id_de_caso;
	private String fecha_de_notificaci_n;
	private String c_digo_divipola;
	private String ciudad_de_ubicaci_n;
	private String departamento;
	private String atenci_n;
	private String edad;
	private String sexo;
	private String tipo;
	private String estado;
	private String pa_s_de_procedencia;
	private String fis;
	private String fecha_diagnostico;
	private String fecha_recuperado;
	private String fecha_reporte_web;
	private String tipo_recuperaci_n;
	private String codigo_departamento;
	private String codigo_pais;
	private String pertenencia_etnica;

	public Patient toPatient(){
		int id = Integer.parseInt(this.id_de_caso);
		LocalDate admissionDate = date(fecha_de_notificaci_n);
		byte age = Byte.parseByte(edad);
		LocalDate firstSymptomsDate = date(fis);
		LocalDate diagnosticDate = date(fecha_diagnostico);
		LocalDate recoveryDate = date(fecha_recuperado);
		return new Patient(id, admissionDate, ciudad_de_ubicaci_n, departamento, atenci_n, age, sexo, tipo, estado, pa_s_de_procedencia,
				firstSymptomsDate, diagnosticDate, recoveryDate, tipo_recuperaci_n);
	}

	private LocalDate date(String dateText){
		if (dateText == null)
			return LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		byte index = (byte)dateText.indexOf("T");
		dateText = dateText.substring(0, index);
		dateText.replaceAll(" ", "");
		return LocalDate.parse(dateText, formatter);
	}

	/*

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

	 */
}
