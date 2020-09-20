package views.body;

import views.ConstantsUI;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {

    private Font[] fontList;

    public TitlePanel(Font[] fontList){
        this.setVisible(true);
        this.fontList = fontList;
        componentsInit();
    }

    private void componentsInit(){
        JLabel titleLabel = new JLabel();
        titleLabel.setFont(fontList[0]);
        titleLabel.setText(ConstantsUI.WINDOW_TITLE);
        this.add(titleLabel);
    }
}
