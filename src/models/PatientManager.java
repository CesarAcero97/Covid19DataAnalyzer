package models;

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
	
	public void addPatient(Patient newPatient) {
		int id = genID();
		newPatient.setID(id);
		for (Patient patient : patientList){
			if(patient.getID() > id){
				int index = patientList.indexOf(patient);
				patientList.add(index, newPatient);
			}
		}
		patientList.add(newPatient);
	}

	private int genID(){
		int last = 0;
		int actual = 0;
		for (int i = 0; i < patientList.size(); i++) {
			actual = patientList.get(i).getID();
			if (last + 1 != actual) {
				return last + 1;
			} else {
				last = actual;
			}
		}
		return actual + 1;
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
	
	// Inicio de mï¿½todos de reportes
	
	public HashMap<String, Integer> report1() {
		HashMap<String, Integer> list1 = new HashMap<String, Integer>();
		int recovered = 0;
		int house = 0;
		int deceased = 0;
		int hospital = 0;
		int na = 0;
		int uci = 0;
		for (Patient patient : patientList) {
			if (patient.getAttention().equalsIgnoreCase("Recuperado")) {
				recovered++;
			} else if (patient.getAttention().equalsIgnoreCase("Casa")) {
				house++;
			} else if (patient.getAttention().equalsIgnoreCase("Fallecido")) {
				deceased++;
			} else if (patient.getAttention().equalsIgnoreCase("Hospital")) {
				hospital++;
			} else if (patient.getAttention().equalsIgnoreCase("N/A")) {
				na++;
			} else if (patient.getAttention().equalsIgnoreCase("Hospital UCI")) {
				uci++;
			}
			list1.put("Recuperados", recovered);
			list1.put("En casa", house);
			list1.put("Fallecidos", deceased);
			list1.put("En hospital", hospital);
			list1.put("N/A", na);
			list1.put("En UCIs", uci);
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
			if (patient.getSex().equalsIgnoreCase("M")) {
				M++;
			} else if (patient.getSex().equalsIgnoreCase("F")) {
				F++;
			}
		}
		list3.put("Hombres", M);
		list3.put("Mujeres", F);
		return list3;
	}
	
	public HashMap<String, Integer> report4() {
		HashMap<String, Integer> list4 = new HashMap<String, Integer>();
		int range1 = 0;
		for (Patient patient : patientList) {
			if (patient.getDepartment().equalsIgnoreCase("Boyacá")) {
				range1++;
			}
		}
		list4.put("Pacientes en Boyacá", range1);
		return list4;
	}
	
	public HashMap<String, Integer> report5() {
		HashMap<String, Integer> list5 = new HashMap<String, Integer>();
		int range1 = 0;
		int range2 = 0;
		int range3 = 0;
		for (Patient patient : patientList) {
			if (patient.getType().equalsIgnoreCase("En estudio") || patient.getType().equalsIgnoreCase("En Estudio")) {
				range1++;
			} else if (patient.getType().equalsIgnoreCase("Relacionado") || patient.getType().equalsIgnoreCase("relacionado") || patient.getType().equalsIgnoreCase("RELACIONADO")) {
				range2++;
			} else if (patient.getType().equalsIgnoreCase("Importado")) {
				range3++;
			}
		}
		list5.put("En estudio", range1);
		list5.put("Relacionado", range2);
		list5.put("Importado", range3);
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
			if (patient.getStatus().equalsIgnoreCase("Leve")) {
				range1++;
			} else if (patient.getStatus().equalsIgnoreCase("Asintomático")) {
				range2++;
			} else if (patient.getStatus().equalsIgnoreCase("Fallecido")) {
				range3++;
			} else if (patient.getStatus().equalsIgnoreCase("Moderado")) {
				range4++;
			} else if (patient.getStatus().equalsIgnoreCase("Grave")) {
				range5++;
			} else if (patient.getStatus().equalsIgnoreCase("N/A")) {
				range6++;
			}
		}
		list6.put("Leve", range1);
		list6.put("Asintomático", range2);
		list6.put("Fallecido", range3);
		list6.put("Moderado", range4);
		list6.put("Grave", range5);
		list6.put("N/A", range6);
		return list6;
	}
	
	public HashMap<String, Integer> report7() {
		HashMap<String, Integer> list7 = new HashMap<String, Integer>();
		int range1 = 0;
		int range2 = 0;
		for (Patient patient : patientList) {
			if (patient.getRecoveryType().equalsIgnoreCase("Tiempo")) {
				range1++;
			} else if (patient.getRecoveryType() == "PCR") {
				range2++;
			}
			list7.put("Recuperados por tiempo", range1);
			list7.put("Recuperados en segunda muestra", range2);
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
		int range23 = 0;
		for (Patient patient : patientList) {
			if (patient.getDepartment().equalsIgnoreCase("Bogotá D.C.")) {
				range1++;
			} else if (patient.getDepartment().equalsIgnoreCase("Antioquia")) {
				range2++;
			} else if (patient.getDepartment().equalsIgnoreCase("Valle del Cauca")) {
				range3++;
			} else if (patient.getDepartment().equalsIgnoreCase("Barranquilla D.E.")) {
				range4++;
			} else if (patient.getDepartment().equalsIgnoreCase("Cundinamarca")) {
				range5++;
			} else if (patient.getDepartment().equalsIgnoreCase("Atlántico")) {
				range6++;
			} else if (patient.getDepartment().equalsIgnoreCase("Santander")) {
				range7++;
			} else if (patient.getDepartment().equalsIgnoreCase("Córdoba")) {
				range8++;
			} else if (patient.getDepartment().equalsIgnoreCase("Cartagena D.T. y C.")) {
				range9++;
			} else if (patient.getDepartment().equalsIgnoreCase("Nariño")) {
				range10++;
			} else if (patient.getDepartment().equalsIgnoreCase("Córdoba")) {
				range11++;
			} else if (patient.getDepartment().equalsIgnoreCase("Cesar")) {
				range12++;
			} else if (patient.getDepartment().equalsIgnoreCase("Norte de Santander")) {
				range13++;
			} else if (patient.getDepartment().equalsIgnoreCase("Meta")) {
				range14++;
			} else if (patient.getDepartment().equalsIgnoreCase("Sucre")) {
				range15++;
			} else if (patient.getDepartment().equalsIgnoreCase("Tolima")) {
				range16++;
			} else if (patient.getDepartment().equalsIgnoreCase("Santa Marta D.T. y C.")) {
				range17++;
			} else if (patient.getDepartment().equalsIgnoreCase("Risaralda")) {
				range18++;
			} else if (patient.getDepartment().equalsIgnoreCase("Huila")) {
				range19++;
			} else if (patient.getDepartment().equalsIgnoreCase("Cauca")) {
				range20++;
			} else if (patient.getDepartment().equalsIgnoreCase("Caquetá")) {
				range21++;
			} else if (patient.getDepartment().equalsIgnoreCase("Amazonas")) {
				range22++;
			} else if (patient.getDepartment().equalsIgnoreCase("Vichada")) {
				range23++;
			}
		}
		list8.put("Bogotá D.C.", range1);
		list8.put("Antioquia", range2);
		list8.put("Valle del Cauca", range3);
		list8.put("Barranquilla D.E.", range4);
		list8.put("Cundinamarca", range5);
		list8.put("Atlántico", range6);
		list8.put("Santander", range7);
		list8.put("Córdoba", range8);
		list8.put("Cartagena D.T. y C.", range9);
		list8.put("Nariño", range10);
		list8.put("Córdoba", range11);
		list8.put("Cesar", range12);
		list8.put("Norte de Santander", range13);
		list8.put("Meta", range14);
		list8.put("Sucre", range15);
		list8.put("Tolima", range16);
		list8.put("Santa Marta D.T. y C.", range17);
		list8.put("Risaralda", range18);
		list8.put("Huila", range19);
		list8.put("Cauca", range20);
		list8.put("Caquetá", range21);
		list8.put("Amazonas", range22);
		list8.put("Vichada", range23);
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
			if (patient.getCity().equalsIgnoreCase("Tunja")) {
				range1++;
			}
		}
		list10.put("Resultados en Tunja", range1);
		return list10;
	}
	
	// Fin de mï¿½todos de reportes

	
}
