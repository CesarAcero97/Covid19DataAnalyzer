package views.reports;

import views.ConstantsUI;

import javax.swing.*;
import java.awt.*;

public class AccountType extends JDialog {
    private JProgressBar domesticBar, commercialBar;
    public AccountType (){
        commercialBar = new JProgressBar();
        domesticBar = new JProgressBar();
        this.setLayout(new GridLayout(4, 1));
        this.setSize(300, 300);
        this.setVisible(false);
    }

    public void setValues(int[] values){
        int maximun = values[0] + values[1];
        JLabel title = new JLabel(ConstantsUI.USER_AMOUNT);
        title.setHorizontalAlignment(0);
        this.add(title);
        commercialBar.setMaximum(maximun);
        commercialBar.setMinimum(0);
        commercialBar.setValue(values[0]);
        commercialBar.setBorder(BorderFactory.createTitledBorder( ConstantsUI.COMMERCIAL + " = " + String.valueOf(values[0])));
        this.add(commercialBar);
        domesticBar.setMaximum(maximun);
        domesticBar.setMinimum(0);
        domesticBar.setValue(values[1]);
        domesticBar.setBorder(BorderFactory.createTitledBorder( ConstantsUI.DOMESTIC + " = " + String.valueOf(values[1])));
        this.add(domesticBar);
        this.setVisible(true);
    }
}
