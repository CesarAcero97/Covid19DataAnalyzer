package views.header;

import javax.swing.*;
import java.awt.event.ActionListener;

public class HeaderPanel extends JPanel {

    public HeaderPanel(ActionListener listener){
        this.setLayout(new BoxLayout(this, 1));
        componentsInit(listener);
    }

    private void componentsInit(ActionListener listener){
        ToolBar toolBar = new ToolBar(listener);
        this.add(toolBar);
    }

}
