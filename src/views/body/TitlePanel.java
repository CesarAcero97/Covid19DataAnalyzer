package views.body;

import views.ConstantsUI;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {

    private Font[] fontList;

    public TitlePanel(Font[] fontList){
        this.setVisible(true);
        this.fontList = fontList;
        this.setBackground(ConstantsUI.BLUE_BG_COLOR);
        componentsInit();
    }

    private void componentsInit(){
        JLabel titleLabel = new JLabel("");
        titleLabel.setText(ConstantsUI.WINDOW_TITLE);
        titleLabel.setFont(fontList[0]);
        titleLabel.setForeground(ConstantsUI.TITLE_COLOR);
        titleLabel.setVerticalTextPosition(JLabel.CENTER);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        this.add(titleLabel);
    }
}
