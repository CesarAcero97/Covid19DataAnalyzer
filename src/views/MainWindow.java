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

    public MainWindow(ActionListener listener) {
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
        this.setLocationRelativeTo( null );
        this.setTitle(ConstantsUI.WINDOW_TITLE);
        this.setSize(1200, 600);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
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
            InputStream pathToFont = new BufferedInputStream(new FileInputStream(ConstantsUI.PATH_BLOCKBE_CONDENSED));
            Font blockbaseFont = Font.createFont(Font.TRUETYPE_FONT, pathToFont);
            bigBlockBeCondensed = blockbaseFont.deriveFont(Font.PLAIN, 90);
            normalBlockBeCondensed = blockbaseFont.deriveFont(Font.PLAIN, 70);
            smallBlockBeCondensed = blockbaseFont.deriveFont(Font.PLAIN, 55);
        }catch(IOException | FontFormatException e){
            System.out.println(ConstantsUI.EXCEPTION_MSG_FONT_ERROR);
        }

        try{
            InputStream pathToFont = new BufferedInputStream(new FileInputStream(ConstantsUI.PATH_LATO_REGULAR));
            Font latoBaseFont = Font.createFont(Font.TRUETYPE_FONT, pathToFont);
            smallLatoFont = latoBaseFont.deriveFont(Font.PLAIN, 12);
            normalSmallLatoFont = latoBaseFont.deriveFont(Font.PLAIN, 14);
            normalLatoFont = latoBaseFont.deriveFont(Font.PLAIN, 16);
            bigLatoFont = latoBaseFont.deriveFont(Font.PLAIN, 25);
        }catch(IOException | FontFormatException e){
            System.out.println(ConstantsUI.EXCEPTION_MSG_FONT_ERROR);
        }

        try{
            InputStream pathToFont = new BufferedInputStream(new FileInputStream(ConstantsUI.PATH_AWESEOME_BRAND));
            Font awesomeFont = Font.createFont(Font.TRUETYPE_FONT, pathToFont);
            awesomeBrand = awesomeFont.deriveFont(Font.PLAIN, 15);
        }catch(IOException | FontFormatException e){
            System.out.println(ConstantsUI.EXCEPTION_MSG_FONT_ERROR);
        }
    }
}
