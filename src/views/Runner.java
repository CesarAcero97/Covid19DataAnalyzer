package views;

import models.PatientFull;
import persistence.JsonFileManager;

public class Runner {


    public static void main(String[] args) {
        Runner runner = new Runner();
        JsonFileManager reader = new JsonFileManager();
        PatientFull[] list = reader.readJson("https://www.datos.gov.co/resource/gt2j-8ykr.json?pertenencia_etnica=Otro");
        for (PatientFull patient : list){
            System.out.println(patient.toPatient().getAdmissionDate());
        }
    }
}