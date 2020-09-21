package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class PatientManager {

	private ConverterThread converterThread;
	protected ArrayList<Patient> patientList;

	public PatientManager() {
		patientList = new ArrayList<>();
		converterThread = new ConverterThread();
		converterThread.run(this);
	}
	
	public void addList(ArrayList<Patient> list){
		patientList.addAll(list);
	}

	public void addList(PatientFull[] list){
		converterThread.addList(list);
	}
	
	public void add(Patient patient) {
		patientList.add(patient);
	}
	
	public void addPatient(Patient patient) {
		int maxID = patientList.size() + 1;
		if (patient.getID() < patientList.get(patientList.size() + 1).getID()) {
			patient.setID(maxID);
			patientList.add(patient);
		}
	}
	
	public void delete(int ID) {
		int index = 0;
		for (Patient patient : patientList) {
			if (patient.getID() == ID) {
				index = patientList.indexOf(patient);
			}
		}
		patientList.remove(index);
	}

	public ArrayList<Patient> getPatientList() {
		return patientList;
	}
	
	public Object[][] getAccountValues() {
        Object[][] accListObjVersion = new Object[patientList.size()][];
        for (int i = 0; i < patientList.size(); i++) {
            accListObjVersion[i] = patientList.get(i).toObject();
        }
        return accListObjVersion;
    }
	
	// Inicio de métodos de reportes
	
	public HashMap<String, Integer> report1() {
		HashMap<String, Integer> list1 = new HashMap<String, Integer>();
		int recovered = 0;
		int house = 0;
		int deceased = 0;
		int hospital = 0;
		int na = 0;
		int uci = 0;
		for (Patient patient : patientList) {
			if (patient.getAttention() == "Recuperado") {
				list1.put("Recuperados", recovered++);
			} else if (patient.getAttention() == "Casa") {
				list1.put("En casa", house++);
			} else if (patient.getAttention() == "Fallecido") {
				list1.put("Fallecidos", deceased++);
			} else if (patient.getAttention() == "Hospital") {
				list1.put("En hospital", hospital++);
			} else if (patient.getAttention() == "N/A") {
				list1.put("N/A", na++);
			} else if (patient.getAttention() == "Hospital UCI") {
				list1.put("En UCIs", uci++);
			}
		}
		return list1;
	}
	
	public HashMap<String, Integer> report2() {
		HashMap<String, Integer> list2 = new HashMap<String, Integer>();
		int range1 = 0;
		int range2 = 0;
		int range3 = 0;
		for (Patient patient : patientList) {
			if (patient.getAge() < 30) {
				list2.put("Menores de 30", range1++);
			} else if (patient.getAge() >= 30 && patient.getAge() <= 40) {
				list2.put("30 - 40", range2++);
			} else if (patient.getAge() > 40) {
				list2.put("Mayores de 40", range3++);
			}
		}
		return list2;
	}
	
	public HashMap<String, Integer> report3() {
		HashMap<String, Integer> list3 = new HashMap<String, Integer>();
		int M = 0;
		int F = 0;
		for (Patient patient : patientList) {
			if (patient.getSex() == "M") {
				list3.put("Hombres", M++);
			} else if (patient.getSex() == "F") {
				list3.put("Mujeres", F++);
			}
		}
		return list3;
	}
	
	public HashMap<String, Integer> report4() {
		HashMap<String, Integer> list4 = new HashMap<String, Integer>();
		int range1 = 0;
		int range2 = 0;
		int range3 = 0;
		for (Patient patient : patientList) {
			if (patient.getAge() < 30) {
				list4.put("Menores de 30", range1++);
			} else if (patient.getAge() >= 30 && patient.getAge() <= 40) {
				list4.put("30 - 40", range2++);
			} else if (patient.getAge() > 40) {
				list4.put("Mayores de 40", range3++);
			}
		}
		return list4;
	}
	
	public HashMap<String, Integer> report5() {
		HashMap<String, Integer> list5 = new HashMap<String, Integer>();
		int range1 = 0;
		int range2 = 0;
		int range3 = 0;
		for (Patient patient : patientList) {
			if (patient.getType() == "En estudio" || patient.getType() == "En Estudio") {
				list5.put("En estudio", range1++);
			} else if (patient.getType() == "Relacionado" || patient.getType() == "relacionado" || patient.getType() == "RELACIONADO") {
				list5.put("Relacionado", range2++);
			} else if (patient.getType() == "Importado") {
				list5.put("Importado", range3++);
			}
		}
		return list5;
	}
	
	public HashMap<String, Integer> report6() {
		HashMap<String, Integer> list6 = new HashMap<String, Integer>();
		int range1 = 0;
		int range2 = 0;
		int range3 = 0;
		int range4 = 0;
		int range5 = 0;
		int range6 = 0;
		for (Patient patient : patientList) {
			if (patient.getStatus() == "Leve") {
				list6.put("Leve", range1++);
			} else if (patient.getStatus() == "Asintomático") {
				list6.put("Asintomático", range2++);
			} else if (patient.getStatus() == "Fallecido") {
				list6.put("Fallecido", range3++);
			} else if (patient.getStatus() == "Moderado") {
				list6.put("Moderado", range4++);
			} else if (patient.getStatus() == "Grave") {
				list6.put("Grave", range5++);
			} else if (patient.getStatus() == "N/A") {
				list6.put("N/A", range6++);
			}
		}
		return list6;
	}
	
	public HashMap<String, Integer> report7() {
		HashMap<String, Integer> list7 = new HashMap<String, Integer>();
		int range1 = 0;
		int range2 = 0;
		for (Patient patient : patientList) {
			if (patient.getRecoveryType() == "Tiempo") {
				list7.put("Recuperados por tiempo", range1++);
			} else if (patient.getRecoveryType() == "PCR") {
				list7.put("Recuperados en segunda muestra", range2++);
			}
		}
		return list7;
	}
	
	public HashMap<String, Integer> report8() {
		HashMap<String, Integer> list8 = new HashMap<String, Integer>();
		int range1 = 0;
		int range2 = 0;
		int range3 = 0;
		int range4 = 0;
		int range5 = 0;
		int range6 = 0;
		int range7 = 0;
		int range8 = 0;
		int range9 = 0;
		int range10 = 0;
		int range11 = 0;
		int range12 = 0;
		int range13 = 0;
		int range14 = 0;
		int range15 = 0;
		int range16 = 0;
		int range17 = 0;
		int range18 = 0;
		int range19 = 0;
		int range20 = 0;
		int range21 = 0;
		int range22 = 0;
		for (Patient patient : patientList) {
			if (patient.getDepartment() == "Bogotá D.C.") {
				list8.put("Bogotá D.C.", range1++);
			} else if (patient.getDepartment() == "Antioquia") {
				list8.put("Antioquia", range2++);
			} else if (patient.getDepartment() == "Valle del Cauca") {
				list8.put("Valle del Cauca", range3++);
			} else if (patient.getDepartment() == "Barranquilla D.E.") {
				list8.put("Barranquilla D.E.", range4++);
			} else if (patient.getDepartment() == "Cundinamarca") {
				list8.put("Cundinamarca", range5++);
			} else if (patient.getDepartment() == "Atlántico") {
				list8.put("Atlántico", range6++);
			} else if (patient.getDepartment() == "Santander") {
				list8.put("Santander", range7++);
			} else if (patient.getDepartment() == "Córdoba") {
				list8.put("Córdoba", range8++);
			} else if (patient.getDepartment() == "Cartagena D.T. y C.") {
				list8.put("Cartagena D.T. y C.", range9++);
			} else if (patient.getDepartment() == "Nariño") {
				list8.put("Nariño", range10++);
			} else if (patient.getDepartment() == "Córdoba") {
				list8.put("Córdoba", range11++);
			} else if (patient.getDepartment() == "Cesar") {
				list8.put("Cesar", range12++);
			} else if (patient.getDepartment() == "Norte de Santander") {
				list8.put("Norte de Santander", range13++);
			} else if (patient.getDepartment() == "Meta") {
				list8.put("Meta", range14++);
			} else if (patient.getDepartment() == "Sucre") {
				list8.put("Sucre", range15++);
			} else if (patient.getDepartment() == "Tolima") {
				list8.put("Tolima", range16++);
			} else if (patient.getDepartment() == "Santa Marta D.T. y C.") {
				list8.put("Santa Marta D.T. y C.", range17++);
			} else if (patient.getDepartment() == "Risaralda") {
				list8.put("Risaralda", range18++);
			} else if (patient.getDepartment() == "Huila") {
				list8.put("Huila", range19++);
			} else if (patient.getDepartment() == "Cauca") {
				list8.put("Cauca", range20++);
			} else if (patient.getDepartment() == "Caquetá") {
				list8.put("Caquetá", range21++);
			} else if (patient.getDepartment() == "Amazonas") {
				list8.put("Amazonas", range21++);
			} else if (patient.getDepartment() == "Vichada") {
				list8.put("Vichada", range22++);
			}
		}
		return list8;
	}
	
	public HashMap<String, Integer> report9() {
		HashMap<String, Integer> list9 = new HashMap<String, Integer>();
		int range1 = 0;
		int range2 = 0;
		int range3 = 0;
		for (Patient patient : patientList) {
			if (patient.getFirstSymptomsDate().getMonthValue() == 7) {
				list9.put("Mes de Julio", range1++);
			} else if (patient.getFirstSymptomsDate().getMonthValue() == 8) {
				list9.put("Mes de Agosto", range2++);
			} else if (patient.getFirstSymptomsDate().getMonthValue() == 9) {
				list9.put("Mes de Septiembre", range3++);
			}
		}
		return list9;
	}
	
	public HashMap<String, Integer> report10() {
		HashMap<String, Integer> list10 = new HashMap<String, Integer>();
		int range1 = 0;
		for (Patient patient : patientList) {
			if (patient.getCity() == "Tunja") {
				list10.put("Resultados en Tunja", range1++);
			}
		}
		return list10;
	}
	
	// Fin de métodos de reportes

}
