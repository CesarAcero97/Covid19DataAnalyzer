package views.body;

import views.header.HeaderPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
    private TableElementsPanel tablePanel;
	
    public MainPanel(ActionListener listener) {
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        componentInit(listener);
    }

    private void componentInit(ActionListener listener) {
        tablePanel = new TableElementsPanel();
        HeaderPanel headerPanel = new HeaderPanel(listener);
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(tablePanel, BorderLayout.CENTER);
    }

    public void refreshTable(Object[][] list){
        tablePanel.refreshTable(list);
    }

    public String showFileDialog(){
        String path;
        JFileChooser chooser = new JFileChooser();
        int seleccion = chooser.showOpenDialog(new JTextField("xD"));
        if(seleccion == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            path = file.getAbsolutePath();
            chooser.setVisible(false);
            return path;
        }else {
            chooser.setVisible(false);
            return null;
        }
    }
}
