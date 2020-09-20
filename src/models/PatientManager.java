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
		int hospitalUCI = 0;
//		ArrayList<Patient> report1List = new ArrayList<>();
		for (Patient patient : patientList) {
			if (patient.getStatus() == "Recuperado") {
				list1.put("Recuperados", recovered++);
//				report1List.add(patient);
			} else if (patient.getStatus() == "Casa") {
				
			} else if (patient.getStatus() == "Fallecido") {
				
			} else if (patient.getStatus() == "Hospital") {
				
			} else if (patient.getStatus() == "N/A") {
				
			} else if (patient.getStatus() == "Hospital UCI") {
				
			}
		}
		return list1;
	}
	
	public ArrayList<Patient> report2() {
		ArrayList<Patient> report2List = new ArrayList<>();
		for (Patient patient : patientList) {
			if (patient.getStatus() == "Recuperado") {
				report2List.add(patient);
			}
		}
		return report2List;
	}
	
	public ArrayList<Patient> report3() {
		ArrayList<Patient> report3List = new ArrayList<>();
		for (Patient patient : patientList) {
			if (patient.getStatus() == "Recuperado") {
				report3List.add(patient);
			}
		}		return report3List;
	}
	
	public ArrayList<Patient> report4() {
		ArrayList<Patient> report4List = new ArrayList<>();
		String url = "https://www.datos.gov.co/resource/gt2j-8ykr.json?tipo_recuperac_n=Tiempo&";
		return report4List;
	}
	
	public ArrayList<Patient> report5() {
		ArrayList<Patient> report5List = new ArrayList<>();
		String url = "https://www.datos.gov.co/resource/gt2j-8ykr.json?";
		return report5List;
	}
	
	public ArrayList<Patient> report6() {
		ArrayList<Patient> report6List = new ArrayList<>();
		String url = "https://www.datos.gov.co/resource/gt2j-8ykr.json?";
		return report6List;
	}
	
	public ArrayList<Patient> report7() {
		ArrayList<Patient> report7List = new ArrayList<>();
		String url = "https://www.datos.gov.co/resource/gt2j-8ykr.json?";
		return report7List;
	}
	
	public ArrayList<Patient> report8() {
		ArrayList<Patient> report8List = new ArrayList<>();
		String url = "https://www.datos.gov.co/resource/gt2j-8ykr.json?";
		return report8List;
	}
	
	public ArrayList<Patient> report9() {
		ArrayList<Patient> report9List = new ArrayList<>();
		String url = "https://www.datos.gov.co/resource/gt2j-8ykr.json?";
		return report9List;
	}
	
	public ArrayList<Patient> report10() {
		ArrayList<Patient> report10List = new ArrayList<>();
		String url = "https://www.datos.gov.co/resource/gt2j-8ykr.json?";
		return report10List;
	}
	
	// Fin de métodos de reportes

}
