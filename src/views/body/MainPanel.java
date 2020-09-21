package views.body;

import models.Patient;
import views.header.HeaderPanel;
import views.modifiers.TableBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
    private TableElementsPanel tablePanel;
	
    public MainPanel(ActionListener listener, Font[] fontList) {
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        componentInit(listener, fontList);
    }

    private void componentInit(ActionListener listener, Font[] fontList) {
        tablePanel = new TableElementsPanel(fontList);
        HeaderPanel headerPanel = new HeaderPanel(listener);
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(tablePanel, BorderLayout.CENTER);
    }

    public void refreshTable(Object[][] list){
        tablePanel.refreshTable(list);
    }

    public int getSelectedId(){
        return tablePanel.getSelectedId();
    }
}
