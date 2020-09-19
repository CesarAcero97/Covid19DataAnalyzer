package persistence;
import com.google.gson.Gson;
import models.Patient;
import org.json.simple.*;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class JsonFileManager {

    public static final String JsonAdapterPrefix = "{\"Patients\":";
    public static final String JsonAdapterSuffix = "}";

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static String readFileFromUrl(String url) throws IOException {
            InputStream is = new URL(url).openStream();
            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                return readAll(rd);
            } finally {
                is.close();
            }
    }

    public Patient[] readJson(String jsonText){
        return new Gson().fromJson(jsonText, Patient[].class);
    }

    /*
    public ArrayList<Patient> readJson(String fileName) throws FileNotFoundException, IOException, DeserializationException{
        ArrayList<Patient> patientList = new ArrayList<>();
        JsonObject jsonObject = (JsonObject) Jsoner.deserialize(new FileReader(fileName));
        JsonArray listOfEmployees = (JsonArray) jsonObject.get("Patients");
        for (Object object : listOfEmployees) {
            JsonObject personObj = (JsonObject) object;
            int ID = personObj.getInteger("id_de_caso");
            String admissionDate = personObj.getString("fecha_de_notificaci_n");
            String divipolaCode = personObj.getString("c_digo_divipola");
            String city = personObj.getString("ciudad_de_ubicaci_n");
            String department= personObj.getString("departamento");
            String attention = personObj.getString("atenci_n");
            String age = personObj.getString("edad");
            String sex = personObj.getString("sexo");
            String type = personObj.getString("tipo");
            String status = personObj.getString("estado");
            String countryOfOrigin = personObj.getString("pa_s_de_procedencia");
            String firstSymptomsDate = personObj.getString("fis");
            String diagnosticDate = personObj.getString("fecha_diagnostico");
            String recoveryDate = personObj.getString("fecha_recuperado");
            String webReportDate = personObj.getString("fecha_reporte_web");
            String recoveryType = personObj.getString("tipo_recuperaci_n");
            String departmentCode = personObj.getString("codigo_departamento");
            String countryCode = personObj.getString("codigo_pais");
            String ethnicalBelonging = personObj.getString("pertenencia_etnica");
            Patient patient = new Patient(ID, admissionDate, city, department, attention, age, sex, type, status, countryOfOrigin, firstSymptomsDate, diagnosticDate, recoveryDate, recoveryType);
            patientList.add(patient);
        }
        return patientList;
    }
     */
}
