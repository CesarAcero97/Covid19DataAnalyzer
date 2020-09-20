package views.header;

import controllers.Commands;
import views.ConstantsUI;
import views.modifiers.ButtonTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ToolBar extends JToolBar {

    private ButtonTool exitButton, importButton, exportButton, refreshButton, addButton, removeButton, reportsButton;
    private ButtonTool spacer;

    public ToolBar(ActionListener listener){
        setLayout( new FlowLayout(FlowLayout.CENTER));
        setBackground( ConstantsUI.BUTTON_BG_COLOR);
        setFloatable(false);
        componentsInit(listener);
    }

    private void componentsInit(ActionListener listener){
        exitButton = new ButtonTool();
        Image exitIcon = (new ImageIcon(getClass().getResource(ConstantsUI.PATH_EXIT_ICON)).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        exitButton.setIcon(new ImageIcon(exitIcon));
        exitButton.setActionCommand( Commands.EXIT_APP.name() );
        exitButton.addActionListener( listener );
        exitButton.setToolTipText( ConstantsUI.EXIT );
        exitButton.setBorderPainted(false);
        add(exitButton);

        addButton = new ButtonTool();
        Image addIcon = (new ImageIcon(getClass().getResource(ConstantsUI.PATH_ADD_ICON)).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        addButton.setIcon(new ImageIcon(addIcon));
        addButton.setActionCommand( Commands.ADD_PATIENT.name() );
        addButton.addActionListener( listener );
        addButton.setToolTipText( ConstantsUI.ADD_PATIENT );
        addButton.setBorderPainted(false);
        add(addButton);

        removeButton = new ButtonTool();
        Image removeIcon = (new ImageIcon(getClass().getResource(ConstantsUI.PATH_DELETE_ICON)).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        removeButton.setIcon(new ImageIcon(removeIcon));
        removeButton.setActionCommand( Commands.REMOVE_PATIENT.name() );
        removeButton.addActionListener( listener );
        removeButton.setToolTipText( ConstantsUI.REMOVE_PATIENT );
        removeButton.setBorderPainted(false);
        add(removeButton);

        refreshButton = new ButtonTool();
        Image refreshIcon = (new ImageIcon(getClass().getResource(ConstantsUI.PATH_REFRESH_ICON)).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        refreshButton.setIcon(new ImageIcon(refreshIcon));
        refreshButton.setActionCommand( Commands.REFRESH.name() );
        refreshButton.addActionListener( listener );
        refreshButton.setToolTipText( ConstantsUI.REFRESH );
        refreshButton.setBorderPainted(false);
        add(refreshButton);

        importButton = new ButtonTool();
        Image importIcon = (new ImageIcon(getClass().getResource(ConstantsUI.PATH_IMPORT_ICON)).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        importButton.setIcon(new ImageIcon(importIcon));
        //importButton.setActionCommand( Commands.IMPORT_FILE.name() );
        importButton.addActionListener( listener );
        importButton.setToolTipText( ConstantsUI.IMPORT );
        importButton.setBorderPainted(false);
        add(importButton);

        exportButton = new ButtonTool();
        Image exportIcon = (new ImageIcon(getClass().getResource(ConstantsUI.PATH_EXPORT_ICON)).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        exportButton.setIcon(new ImageIcon(exportIcon));
        //exportButton.setActionCommand( Commands.EXPORT_FILE.name() );
        exportButton.addActionListener( listener );
        exportButton.setToolTipText( ConstantsUI.EXPORT );
        exportButton.setBorderPainted(false);
        add(exportButton);

        JMenuBar reportsBar = new JMenuBar();
        reportsBar.setBackground(ConstantsUI.BUTTON_BG_COLOR);
        reportsBar.setBorderPainted(false);
        JMenu reportsButton = new JMenu();
        reportsButton.setToolTipText(ConstantsUI.REPORTS);
        Image reportsIcon = (new ImageIcon(getClass().getResource(ConstantsUI.PATH_REPORTS_ICON)).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        reportsButton.setIcon(new ImageIcon(reportsIcon));
        reportsButton.setToolTipText( ConstantsUI.REPORTS );
        reportsButton.setBorderPainted(false);
        JMenuItem userPercentage = new JMenuItem(ConstantsUI.USER_AMOUNT);
        userPercentage.addActionListener(listener);
        //userPercentage.setActionCommand(Commands.ACCOUNT_TYPE_REPORT.toString());
        JMenuItem userAverage = new JMenuItem(ConstantsUI.USER_AVRG);
        //userAverage.setActionCommand(Commands.BILLING_AVERAGE_REPORT.toString());
        userAverage.addActionListener(listener);
        reportsButton.add(userPercentage);
        reportsButton.add(userAverage);
        reportsBar.add(reportsButton);
        this.add(reportsBar);
    }
}
