package views;

import models.Patient;
import views.body.AddPatientPanel;
import views.body.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private MainPanel mainPanel;
	private AddPatientPanel addPatientPanel;
	private JFileChooser fileChooser;

	private Font[] fonts;

	public Font robotoBigBlack;
	public Font robotoMediumBlack;
	public Font robotoBigRegular;
	public Font robotoMediumRegular;
	public Font robotoSmallRegular;
	public Font robotoMediumLigth;
	public Font awesomeMediumBrand;

    public MainWindow(ActionListener listener) {
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
        this.setLocationRelativeTo( null );
        this.setTitle(ConstantsUI.WINDOW_TITLE);
        this.setSize(1200, 600);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
        this.fontsInit();
        componentsInit(listener);
    }

    private void componentsInit(ActionListener listener) {
        mainPanel = new MainPanel(listener, fonts);
        addPatientPanel = new AddPatientPanel(listener, fonts);
        this.add(mainPanel);
    }

    public void refreshTable(Object[][] list){
        mainPanel.refreshTable(list);
    }

    public int getSelectedId(){
        return mainPanel.getSelectedId();
    }

    public void setVisiblePatientPanel(){
        addPatientPanel.setVisible(true);
    }

    public void makeInvisibleDialogs(){
        if (addPatientPanel != null)
            addPatientPanel.setVisible(false);
    }

    public Patient getPatient(){
        return addPatientPanel.getPatient();
    }

    public String getFilePath(){
        fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(this);

        if(seleccion == JFileChooser.APPROVE_OPTION){
            File fichero = fileChooser.getSelectedFile();
            return fichero.getAbsolutePath();
        }else{
            return "";
        }
    }

    public String getSavePath(){
        fileChooser = new JFileChooser();
        int seleccion = fileChooser.showSaveDialog(this);
        if(seleccion == JFileChooser.APPROVE_OPTION){
            File fichero = fileChooser.getSelectedFile();
            return fichero.getAbsolutePath();
        }else{
            return "";
        }
    }
    //Font Init

    private void fontsInit(){
        try{
            InputStream pathToFont = new BufferedInputStream(new FileInputStream(ConstantsUI.PATH_ROBOTO_BLACK));
            Font robotoBlackBase = Font.createFont(Font.TRUETYPE_FONT, pathToFont);
            robotoBigBlack = robotoBlackBase.deriveFont(Font.PLAIN, 80);
            robotoMediumBlack = robotoBlackBase.deriveFont(Font.PLAIN, 30);
        }catch(IOException | FontFormatException e){
            System.out.println(ConstantsUI.EXCEPTION_MSG_FONT_ERROR);
        }

        try{
            InputStream pathToFont = new BufferedInputStream(new FileInputStream(ConstantsUI.PATH_ROBOTO_REGULAR));
            Font robotoRegularBase = Font.createFont(Font.TRUETYPE_FONT, pathToFont);
            robotoBigRegular = robotoRegularBase.deriveFont(Font.PLAIN, 16);
            robotoMediumRegular = robotoRegularBase.deriveFont(Font.PLAIN, 14);
            robotoSmallRegular = robotoRegularBase.deriveFont(Font.PLAIN, 12);
        }catch(IOException | FontFormatException e){
            System.out.println(ConstantsUI.EXCEPTION_MSG_FONT_ERROR);
        }

        try{
            InputStream pathToFont = new BufferedInputStream(new FileInputStream(ConstantsUI.PATH_ROBOTO_LIGHT));
            Font robotoLigthBase = Font.createFont(Font.TRUETYPE_FONT, pathToFont);
            robotoMediumLigth = robotoLigthBase.deriveFont(Font.PLAIN, 12);
        }catch(IOException | FontFormatException e){
            System.out.println(ConstantsUI.EXCEPTION_MSG_FONT_ERROR);
        }

        try{
            InputStream pathToFont = new BufferedInputStream(new FileInputStream(ConstantsUI.PATH_AWESEOME_BRAND));
            Font awesomeFont = Font.createFont(Font.TRUETYPE_FONT, pathToFont);
            awesomeMediumBrand = awesomeFont.deriveFont(Font.PLAIN, 15);
        }catch(IOException | FontFormatException e){
            System.out.println(ConstantsUI.EXCEPTION_MSG_FONT_ERROR);
        }
        fonts = new Font[7];
        fonts[0] = robotoBigBlack;
        fonts[1] = robotoMediumBlack;
        fonts[2] = robotoBigRegular;
        fonts[3] = robotoMediumRegular;
        fonts[4] = robotoSmallRegular;
        fonts[5] = robotoMediumLigth;
        fonts[6] = awesomeMediumBrand;
    }
}
