package models;

import java.util.ArrayList;

public class ConverterThread extends Thread{

    private PatientManager manager;
    public void run(PatientManager manager){
        this.manager = manager;
    }

    protected void addList(PatientFull[] list){
        for(PatientFull patientFull : list)
            manager.patientList.add(patientFull.toPatient());
    }
}
