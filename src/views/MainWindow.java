package views;

import views.body.MainPanel;
import views.reports.AccountType;
import views.reports.BillingAverage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
}
