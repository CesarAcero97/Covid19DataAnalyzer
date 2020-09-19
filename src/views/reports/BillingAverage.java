package views.reports;

import views.ConstantsUI;

import javax.swing.*;
import java.awt.*;

public class BillingAverage extends JDialog{

    private JProgressBar stratumOne, stratumTwo, stratumThree, stratumFour, stratumFive;

    public BillingAverage (){
        this.setLayout(new GridLayout(4, 1));
        this.setSize(300, 300);
        this.setVisible(false);
    }

    public void setValues(double[] values){
        double maximun = 0;
        for(double element : values){
            if(element > maximun)
                maximun = element * 1.2;
        }
        JLabel title = new JLabel(ConstantsUI.USER_AVRG);
        title.setHorizontalAlignment(0);
        this.add(title);
        stratumOne = new JProgressBar();
        stratumOne.setMaximum((int) Math.round(maximun));
        stratumOne.setMinimum(0);
        stratumOne.setValue((int) Math.round(values[0]));
        stratumOne.setBorder(BorderFactory.createTitledBorder( ConstantsUI.STRATUM_ONE + " = " + String.valueOf(values[0])));
        this.add(stratumOne);

        stratumTwo = new JProgressBar();
        stratumTwo.setMaximum((int) Math.round(maximun));
        stratumTwo.setMinimum(0);
        stratumTwo.setValue((int) Math.round(values[1]));
        stratumTwo.setBorder(BorderFactory.createTitledBorder( ConstantsUI.STRATUM_TWO + " = " + String.valueOf(values[1])));
        this.add(stratumTwo);

        stratumThree = new JProgressBar();
        stratumThree.setMaximum((int) Math.round(maximun));
        stratumThree.setMinimum(0);
        stratumThree.setValue((int) Math.round(values[2]));
        stratumThree.setBorder(BorderFactory.createTitledBorder( ConstantsUI.STRATUM_THREE + " = " + String.valueOf(values[2])));
        this.add(stratumThree);

        stratumFour = new JProgressBar();
        stratumFour.setMaximum((int) Math.round(maximun));
        stratumFour.setMinimum(0);
        stratumFour.setValue((int) Math.round(values[3]));
        stratumFour.setBorder(BorderFactory.createTitledBorder( ConstantsUI.STRATUM_FOUR + " = " + String.valueOf(values[3])));
        this.add(stratumFour);

        stratumFive = new JProgressBar();
        stratumFive.setMaximum((int) Math.round(maximun));
        stratumFive.setMinimum(0);
        stratumFive.setValue((int) Math.round(values[4]));
        stratumFive.setBorder(BorderFactory.createTitledBorder( ConstantsUI.STRATUM_FIVE + " = " + String.valueOf(values[4])));
        this.add(stratumFive);

        this.setVisible(true);
    }
}
