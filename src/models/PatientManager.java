package models;

import java.util.ArrayList;

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
