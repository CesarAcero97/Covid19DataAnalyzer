package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import persistence.HandlerLanguage;
import views.ConstantsUI;
import views.MainWindow;
//import views.JFMainWindow;

public class Controller implements ActionListener {
	
	private MainWindow mainWindow;

	private static final String ENGLISH_PATH = "resources/languages/languageUS.properties";
	private static final String SPANISH_PATH = "resources/languages/languageES.properties";
	private static final String NAME_FILE_CONFIG = "resources/config/config.init";

	private HandlerLanguage config;

	public Controller() {
		loadConfiguration();
        mainWindow = new MainWindow(this);
        mainWindow.setVisible( true );
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
		case C_EXIT_APP:
			this.manageExitApp();
		default:
			break;
		}		
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
