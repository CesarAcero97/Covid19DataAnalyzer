package views.header;

import views.ConstantsUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ToolBar extends JToolBar {

    private JButton exitButton, importButton, exportButton, refreshButton;

    public ToolBar(ActionListener listener){
        setLayout( new FlowLayout(FlowLayout.LEFT));
        setBackground( ConstantsUI.MAIN_COLOR);
        setFloatable(false);
        componentsInit(listener);
    }

    private void componentsInit(ActionListener listener){
        exitButton = new JButton();
        Image addIcon = (new ImageIcon(getClass().getResource(ConstantsUI.PATH_EXIT_ICON)).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        exitButton.setIcon(new ImageIcon(addIcon));
        //exitButton.setActionCommand( Commands.EXIT_APP.name() );
        exitButton.addActionListener( listener );
        exitButton.setToolTipText( ConstantsUI.EXIT );
        exitButton.setBorderPainted(false);
        add(exitButton);

        importButton = new JButton();
        Image importIcon = (new ImageIcon(getClass().getResource(ConstantsUI.PATH_IMPORT_ICON)).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        importButton.setIcon(new ImageIcon(importIcon));
        //importButton.setActionCommand( Commands.IMPORT_FILE.name() );
        importButton.addActionListener( listener );
        importButton.setToolTipText( ConstantsUI.IMPORT );
        importButton.setBorderPainted(false);
        add(importButton);

        exportButton = new JButton();
        Image exportIcon = (new ImageIcon(getClass().getResource(ConstantsUI.PATH_EXPORT_ICON)).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        exportButton.setIcon(new ImageIcon(exportIcon));
        //exportButton.setActionCommand( Commands.EXPORT_FILE.name() );
        exportButton.addActionListener( listener );
        exportButton.setToolTipText( ConstantsUI.EXPORT );
        exportButton.setBorderPainted(false);
        add(exportButton);

        refreshButton = new JButton();
        Image refreshIcon = (new ImageIcon(getClass().getResource(ConstantsUI.PATH_REFRESH_ICON)).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        refreshButton.setIcon(new ImageIcon(refreshIcon));
        //refreshButton.setActionCommand( Commands.REFRESH.name() );
        refreshButton.addActionListener( listener );
        refreshButton.setToolTipText( ConstantsUI.REFRESH );
        refreshButton.setBorderPainted(false);
        add(refreshButton);


    }
}
