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
	
	public void delete(int ID) {
		int index = 0;
		for (Patient patient : patientList) {
			if (ID == patient.getID()) {
				patientList.indexOf(patient);
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
			if (patient.getStatus() == "Recuperado") {
				list1.put("Recuperados", recovered++);
			} else if (patient.getStatus() == "Casa") {
				list1.put("En casa", house++);
			} else if (patient.getStatus() == "Fallecido") {
				list1.put("Fallecidos", deceased++);
			} else if (patient.getStatus() == "Hospital") {
				list1.put("En hospital", hospital++);
			} else if (patient.getStatus() == "N/A") {
				list1.put("N/A", na++);
			} else if (patient.getStatus() == "Hospital UCI") {
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
			if (patient.getAge() < 30) {
				list3.put("Menores de 30", M++);
			} else if (patient.getAge() >= 30 && patient.getAge() <= 40) {
				list3.put("30 - 40", F++);
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
			if (patient.getAge() < 30) {
				list5.put("Menores de 30", range1++);
			} else if (patient.getAge() >= 30 && patient.getAge() <= 40) {
				list5.put("30 - 40", range2++);
			} else if (patient.getAge() > 40) {
				list5.put("Mayores de 40", range3++);
			}
		}
		return list5;
	}
	
	public HashMap<String, Integer> report6() {
		HashMap<String, Integer> list6 = new HashMap<String, Integer>();
		int range1 = 0;
		int range2 = 0;
		int range3 = 0;
		for (Patient patient : patientList) {
			if (patient.getAge() < 30) {
				list6.put("Menores de 30", range1++);
			} else if (patient.getAge() >= 30 && patient.getAge() <= 40) {
				list6.put("30 - 40", range2++);
			} else if (patient.getAge() > 40) {
				list6.put("Mayores de 40", range3++);
			}
		}
		return list6;
	}
	
	public HashMap<String, Integer> report7() {
		HashMap<String, Integer> list7 = new HashMap<String, Integer>();
		int range1 = 0;
		int range2 = 0;
		int range3 = 0;
		for (Patient patient : patientList) {
			if (patient.getAge() < 30) {
				list7.put("Menores de 30", range1++);
			} else if (patient.getAge() >= 30 && patient.getAge() <= 40) {
				list7.put("30 - 40", range2++);
			} else if (patient.getAge() > 40) {
				list7.put("Mayores de 40", range3++);
			}
		}
		return list7;
	}
	
	public HashMap<String, Integer> report8() {
		HashMap<String, Integer> list8 = new HashMap<String, Integer>();
		int range1 = 0;
		int range2 = 0;
		int range3 = 0;
		for (Patient patient : patientList) {
			if (patient.getAge() < 30) {
				list8.put("Menores de 30", range1++);
			} else if (patient.getAge() >= 30 && patient.getAge() <= 40) {
				list8.put("30 - 40", range2++);
			} else if (patient.getAge() > 40) {
				list8.put("Mayores de 40", range3++);
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
			if (patient.getAge() < 30) {
				list9.put("Menores de 30", range1++);
			} else if (patient.getAge() >= 30 && patient.getAge() <= 40) {
				list9.put("30 - 40", range2++);
			} else if (patient.getAge() > 40) {
				list9.put("Mayores de 40", range3++);
			}
		}
		return list9;
	}
	
	public HashMap<String, Integer> report10() {
		HashMap<String, Integer> list10 = new HashMap<String, Integer>();
		int range1 = 0;
		int range2 = 0;
		int range3 = 0;
		for (Patient patient : patientList) {
			if (patient.getAge() < 30) {
				list10.put("Menores de 30", range1++);
			} else if (patient.getAge() >= 30 && patient.getAge() <= 40) {
				list10.put("30 - 40", range2++);
			} else if (patient.getAge() > 40) {
				list10.put("Mayores de 40", range3++);
			}
		}
		return list10;
	}
	
	// Fin de métodos de reportes

}
