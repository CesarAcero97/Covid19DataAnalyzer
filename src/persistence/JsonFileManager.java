package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import models.Patient;

public class JsonFileManager {
    public ArrayList<Patient> readFile(String fileName) throws FileNotFoundException, IOException, DeserializationException{
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
    
/*    public void writeFile(String path, ArrayList<Employee> employeeList) {
		try {
			File file=new File(path);  
			file.createNewFile();  
			FileWriter fileWriter = new FileWriter(file);  
			JsonArray personsArray = new JsonArray();
			JsonObject jsonObjectRoot = new JsonObject();
			for (Employee employee : employeeList) {
				JsonObject jsonObjPerson = new JsonObject();
				jsonObjPerson.put("Nombre", employee.getName());
				jsonObjPerson.put("Apellido", employee.getLastName());
				jsonObjPerson.put("Categoria", employee.getCategory());
				jsonObjPerson.put("Tipo Vinculación", employee.getType());
				jsonObjPerson.put("Tipo Documento", employee.getDocumentType());
				jsonObjPerson.put("Puntos salariales", employee.getSalaryPoints());
				jsonObjPerson.put("Numero Documento", employee.getDocumentNumber());
				jsonObjPerson.put("Fecha Ingreso", employee.getDate());
				jsonObjPerson.put("Tiempo de Vinculacion", employee.getVinculationTime());
				jsonObjPerson.put("Valor del Salario", employee.getSalary());
				jsonObjPerson.put("Valor Neto", employee.getNetValue());
				personsArray.add(jsonObjPerson);
			}
			
			jsonObjectRoot.put("personas", personsArray);
			
			fileWriter.write(jsonObjectRoot.toJson());
			fileWriter.flush();  
            fileWriter.close();  
		} catch (Exception e) {

		}
	}*/

}
