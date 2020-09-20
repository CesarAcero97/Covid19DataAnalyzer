package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import models.PatientFull;
import models.PatientManager;
import persistence.HandlerLanguage;
import persistence.JsonFileManager;
import views.ConstantsUI;
import views.MainWindow;
import views.reports.ChartPanel;
import views.reports.PieReport;


public class Controller implements ActionListener {
	
	private MainWindow mainWindow;
	private PatientManager manager;

	private static final String ENGLISH_PATH = "resources/languages/languageUS.properties";
	private static final String SPANISH_PATH = "resources/languages/languageES.properties";
	private static final String NAME_FILE_CONFIG = "resources/config/config.init";

	private HandlerLanguage config;

	public Controller() {
		loadConfiguration();
        mainWindow = new MainWindow(this);
		manager = new PatientManager();
        mainWindow.setVisible( true );
		webData();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch ( Commands.valueOf( e.getActionCommand() ) ) {
			case EXIT_APP:
				this.manageExitApp();
			case ADD_PATIENT:
				this.addPatient();
				break;
			case CANCEL:
				this.cancelCreation();
				break;
			case CREATE_PATIENT:
				this.createPatient();
				break;
			case REFRESH:
				this.refresh();
				break;
			case REMOVE_PATIENT:
				this.removePatient();
				break;
			case C_ES_LANGUAGE:
				manageChangeLanguageES();
			break;
			case C_US_LANGUAGE:
				manageChangeLanguageUS();
			break;
			//----------------------REPORTS COMMANDS--------
			case REPORT_ONE:
				this.reportGenerator(1);
				break;
			case REPORT_TWO:
				this.reportGenerator(2);
				break;
			case REPORT_THREE:
				this.reportGenerator(3);
				break;
			case REPORT_FOUR:
				this.reportGenerator(4);
				break;
			case REPORT_FIVE:
				this.reportGenerator(5);
				break;
			case REPORT_SIX:
				this.reportGenerator(6);
				break;
			case REPORT_SEVEN:
				this.reportGenerator(7);
				break;
			case REPORT_EIGHT:
				this.reportGenerator(8);
				break;
			case REPORT_NINE:
				this.reportGenerator(9);
				break;
			case REPORT_TEN:
				this.reportGenerator(10);
				break;
		default:
			break;
		}		
	}

	//Reports

	private void reportGenerator(int reportId){
		PieReport report;
		String title;
		HashMap<String, Integer> data;
		switch (reportId){
			case 1:
				title = ConstantsUI.REPORT_ONE_TITLE;
				data = manager.report1();
				break;
			case 2:
				title = ConstantsUI.REPORT_TWO_TITLE;
				data = manager.report2();
				break;
			case 3:
				title = ConstantsUI.REPORT_THREE_TITLE;
				data = manager.report3();
				ChartPanel chart = new ChartPanel(data, title);
				return;
			case 4:
				title = ConstantsUI.REPORT_FOUR_TITLE;
				data = manager.report4();
				break;
			case 5:
				title = ConstantsUI.REPORT_FIVE_TITLE;
				data = manager.report5();
				break;
			case 6:
				title = ConstantsUI.REPORT_SIX_TITLE;
				data = manager.report6();
				break;
			case 7:
				title = ConstantsUI.REPORT_SEVEN_TITLE;
				data = manager.report7();
				break;
			case 8:
				title = ConstantsUI.REPORT_EIGHT_TITLE;
				data = manager.report8();
				break;
			case  9:
				title = ConstantsUI.REPORT_NINE_TITLE;
				data = manager.report9();
				break;
			case 10:
				title = ConstantsUI.REPORT_TEN_TITLE;
				data = manager.report10();
				break;
			default:
				title = ConstantsUI.EXCEPTION_MSG_FONT_ERROR;
				data = null;
		}
		report = new PieReport(title, data);
	}

	private void cancelCreation(){
		mainWindow.makeInvisibleDialogs();
	}

	private void createPatient(){
		manager.addPatient(mainWindow.getPatient());
	}

	private void removePatient(){
		int id = mainWindow.getSelectedId();
		System.out.println(id);
		manager.delete(id);
		refresh();
	}

	private void addPatient(){
		mainWindow.setVisiblePatientPanel();
	}

	private void webData(){
		JsonFileManager reader = new JsonFileManager();
		PatientFull[] basicList = reader.readJsonWeb("https://www.datos.gov.co/resource/gt2j-8ykr.json");
		manager.addList(basicList);
		PatientFull[] boyacaList = reader.readJsonWeb("https://www.datos.gov.co/resource/gt2j-8ykr.json?departamento=Boyac%C3%A1");
		manager.addList(boyacaList);
		PatientFull[] antioquiaList = reader.readJsonWeb("https://www.datos.gov.co/resource/gt2j-8ykr.json?departamento=Antioquia");
		manager.addList(antioquiaList);
		PatientFull[] huilaList = reader.readJsonWeb("https://www.datos.gov.co/resource/gt2j-8ykr.json?departamento=Huila");
		manager.addList(huilaList);
		this.refresh();
	}

	private void refresh(){
		mainWindow.refreshTable(manager.getAccountValues());
	}

	private void manageExitApp() {
		int option = JOptionPane.showConfirmDialog( null, ConstantsUI.MESSAGE_EXIT_APP );

		if ( option == 0 ) {
			System.exit( 0 );
		}
	}

	//	controlador carga idioma de lo que necesita	
	public void loadConfiguration(){
		if(config == null){
			config = new HandlerLanguage(NAME_FILE_CONFIG);
		}
		try{
			config.loadLanguage();
		}catch(IOException e){
			JOptionPane.showMessageDialog(mainWindow, e.getMessage());
		}
	}

	private void manageChangeLanguageUS(){
		try {
			changeToEnglish();
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(mainWindow, e1.getMessage());
		}			
		manageChangeLanguage();
	}

	private void manageChangeLanguageES(){
		try {
			changeToSpanish();
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(mainWindow, e1.getMessage());
		}	
		manageChangeLanguage();
	}

	private void manageChangeLanguage(){
        //mainWindow.changeLanguage();
	}
	public void loadLanguage(){
		try {
			config.loadLanguage();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(mainWindow, e.getMessage());
		}
	}

	public void saveConfig(){
		try {
			new HandlerLanguage(NAME_FILE_CONFIG).saveLanguage();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(mainWindow, e.getMessage());
		}
	}

	public void changeToEnglish() throws IOException{
		HandlerLanguage.language = ENGLISH_PATH;
		saveConfig();
		loadLanguage();		
	}

	public void changeToSpanish() throws IOException{
		HandlerLanguage.language = SPANISH_PATH;
		saveConfig();
		loadLanguage();
	}

	public static void main(String[] args) {
		new Controller();
	}
}
