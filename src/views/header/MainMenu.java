package views.header;

import views.ConstantsUI;

import javax.swing.*;
import java.awt.event.ActionListener;


public class MainMenu extends JMenuBar {

    private ActionListener listener;

    public MainMenu(ActionListener listener){
        this.listener = listener;
        componentsInit();
    }

    private void componentsInit(){
        JMenu archive = new JMenu(ConstantsUI.ARCHIVE);
        JMenuItem exit = new JMenuItem(ConstantsUI.EXIT);
        exit.addActionListener(this.listener);
        //exit.setActionCommand(Commands.EXIT_APP.toString());
        archive.add(exit);
        this.add(archive);

        JMenu reports = new JMenu(ConstantsUI.REPORTS);
        JMenuItem userPercentage = new JMenuItem(ConstantsUI.USER_AMOUNT);
        userPercentage.addActionListener(this.listener);
        //userPercentage.setActionCommand(Commands.ACCOUNT_TYPE_REPORT.toString());
        JMenuItem userAverage = new JMenuItem(ConstantsUI.USER_AVRG);
        //userAverage.setActionCommand(Commands.BILLING_AVERAGE_REPORT.toString());
        userAverage.addActionListener(this.listener);
        reports.add(userPercentage);
        reports.add(userAverage);
        this.add(reports);
    }
}
