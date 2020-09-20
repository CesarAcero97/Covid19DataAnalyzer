package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import models.PatientFull;
import models.PatientManager;
import persistence.HandlerLanguage;
import persistence.JsonFileManager;
import views.ConstantsUI;
import views.MainWindow;


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
		case C_ES_LANGUAGE:
			manageChangeLanguageES();
			break;
		case C_US_LANGUAGE:
			manageChangeLanguageUS();
			break;
		case EXIT_APP:
			this.manageExitApp();
			case REFRESH:
				this.refresh();
		default:
			break;
		}		
	}

	private void webData(){
		JsonFileManager reader = new JsonFileManager();
		PatientFull[] list = reader.readJson("https://www.datos.gov.co/resource/gt2j-8ykr.json?pertenencia_etnica=Otro");
		PatientFull[] secondList = reader.readJson("https://www.datos.gov.co/resource/gt2j-8ykr.json?departamento=Boyac%C3%A1");
		manager.addList(list);
		manager.addList(secondList);
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
