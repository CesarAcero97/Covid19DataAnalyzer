package views;

import views.body.MainPanel;
import views.reports.AccountType;
import views.reports.BillingAverage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private MainPanel mainPanel;
	private AccountType accountType;
	private BillingAverage billingAverage;

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
    //Constructor de prueba NO DEJAR PARA LA VERSION FINAL
    public MainWindow() {
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
        this.setLocationRelativeTo( null );
        this.setTitle(ConstantsUI.WINDOW_TITLE);
        this.setSize(1200, 600);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
        this.fontsInit();
        componentsInit(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void componentsInit(ActionListener listener) {
        mainPanel = new MainPanel(listener);
        accountType = new AccountType();
        billingAverage = new BillingAverage();
        this.add(mainPanel);
    }

    public void refreshTable(Object[][] list){
        mainPanel.refreshTable(list);
    }

    public String showFileDialog(){
        return mainPanel.showFileDialog();
    }

    public void showAccountTypeRep(int[] values){
        accountType.setValues(values);
    }

    public void showBillingAverageRep(double[] values){
        billingAverage.setValues(values);
    }

    //Font Init

    private void fontsInit(){
        try{
            InputStream pathToFont = new BufferedInputStream(new FileInputStream(ConstantsUI.PATH_ROBOTO_BLACK));
            Font robotoBlackBase = Font.createFont(Font.TRUETYPE_FONT, pathToFont);
            robotoBigBlack = robotoBlackBase.deriveFont(Font.PLAIN, 90);
            robotoMediumBlack = robotoBlackBase.deriveFont(Font.PLAIN, 70);
        }catch(IOException | FontFormatException e){
            System.out.println(ConstantsUI.EXCEPTION_MSG_FONT_ERROR);
        }

        try{
            InputStream pathToFont = new BufferedInputStream(new FileInputStream(ConstantsUI.PATH_ROBOTO_REGULAR));
            Font robotoRegularBase = Font.createFont(Font.TRUETYPE_FONT, pathToFont);
            robotoBigRegular = robotoRegularBase.deriveFont(Font.PLAIN, 12);
            robotoMediumRegular = robotoRegularBase.deriveFont(Font.PLAIN, 14);
            robotoSmallRegular = robotoRegularBase.deriveFont(Font.PLAIN, 16);
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
    }
}
