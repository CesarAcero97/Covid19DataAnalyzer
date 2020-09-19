package models;

import java.util.ArrayList;

public class PatientManager {
	private ArrayList<Patient> patientList;

	public PatientManager() {
		patientList = new ArrayList<>();
	}
	
	public void addList(ArrayList<Patient> list){
		patientList.addAll(list);
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
	
	

}
