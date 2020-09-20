package views;

import models.Patient;
import models.PatientFull;
import models.PatientManager;
import persistence.JsonFileManager;

import java.util.ArrayList;
import java.util.Collections;

public class Runner {


    public static void main(String[] args) {
        Runner runner = new Runner();
        JsonFileManager reader = new JsonFileManager();
        PatientFull[] list = reader.readJson("https://www.datos.gov.co/resource/gt2j-8ykr.json?pertenencia_etnica=Otro");
        PatientManager manager = new PatientManager();
        manager.addList(list);
    }
}