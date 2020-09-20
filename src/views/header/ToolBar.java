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
        importButton.setActionCommand( Commands.IMPORT.name() );
        importButton.addActionListener( listener );
        importButton.setToolTipText( ConstantsUI.IMPORT );
        importButton.setBorderPainted(false);
        add(importButton);

        exportButton = new ButtonTool();
        Image exportIcon = (new ImageIcon(getClass().getResource(ConstantsUI.PATH_EXPORT_ICON)).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        exportButton.setIcon(new ImageIcon(exportIcon));
        exportButton.setActionCommand( Commands.EXPORT.name() );
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

        JMenuItem reportOne = new JMenuItem(ConstantsUI.REPORT_ONE);
        reportOne.addActionListener(listener);
        reportOne.setActionCommand(Commands.REPORT_ONE.toString());
        reportsButton.add(reportOne);

        JMenuItem reportTwo = new JMenuItem(ConstantsUI.REPORT_TWO);
        reportTwo.addActionListener(listener);
        reportTwo.setActionCommand(Commands.REPORT_TWO.toString());
        reportsButton.add(reportTwo);

        JMenuItem reportThree = new JMenuItem(ConstantsUI.REPORT_THREE);
        reportThree.addActionListener(listener);
        reportThree.setActionCommand(Commands.REPORT_THREE.toString());
        reportsButton.add(reportThree);

        JMenuItem reportFour = new JMenuItem(ConstantsUI.REPORT_FOUR);
        reportFour.addActionListener(listener);
        reportFour.setActionCommand(Commands.REPORT_FOUR.toString());
        reportsButton.add(reportFour);

        JMenuItem reportFive = new JMenuItem(ConstantsUI.REPORT_FIVE);
        reportFive.addActionListener(listener);
        reportFive.setActionCommand(Commands.REPORT_FIVE.toString());
        reportsButton.add(reportFive);

        JMenuItem reportSix = new JMenuItem(ConstantsUI.REPORT_SIX);
        reportSix.addActionListener(listener);
        reportSix.setActionCommand(Commands.REPORT_SIX.toString());
        reportsButton.add(reportSix);

        JMenuItem reportSeven = new JMenuItem(ConstantsUI.REPORT_SEVEN);
        reportSeven.addActionListener(listener);
        reportSeven.setActionCommand(Commands.REPORT_SEVEN.toString());
        reportsButton.add(reportSeven);

        JMenuItem reportEight = new JMenuItem(ConstantsUI.REPORT_EIGHT);
        reportEight.addActionListener(listener);
        reportEight.setActionCommand(Commands.REPORT_EIGHT.toString());
        reportsButton.add(reportEight);

        JMenuItem reportNine = new JMenuItem(ConstantsUI.REPORT_NINE);
        reportNine.addActionListener(listener);
        reportNine.setActionCommand(Commands.REPORT_NINE.toString());
        reportsButton.add(reportNine);

        JMenuItem reportTen = new JMenuItem(ConstantsUI.REPORT_TEN);
        reportTen.addActionListener(listener);
        reportTen.setActionCommand(Commands.REPORT_TEN.toString());
        reportsButton.add(reportTen);

        reportsBar.add(reportsButton);
        this.add(reportsBar);
    }
}
