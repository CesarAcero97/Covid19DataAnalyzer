package views.body;

import models.Patient;
import views.ConstantsUI;
import views.modifiers.TableBorder;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.util.ArrayList;

public class TableElementsPanel extends JPanel{

    private static final long serialVersionUID = 1L;
    private DefaultTableModel dtmElements;

    public DefaultTableModel getDtmElements() {
        return dtmElements;
    }

    private JTable table;
    private JScrollPane jsTable;
    private Font[] fontList;
    private TitlePanel titlePanel;

    public TableElementsPanel(Font[] fontList){
        this.setVisible(true);
        this.fontList = fontList;
        initComponents();
    }

    private void initComponents(){
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        dtmElements = new DefaultTableModel();
        dtmElements.setColumnIdentifiers( ConstantsUI.HEADERS_TABLE );

        titlePanel = new TitlePanel(fontList);
        this.add(titlePanel);

        table = new JTable();
        table.setModel(dtmElements);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setBackground(ConstantsUI.TABLE_BG_COLOR);
        table.getTableHeader().setPreferredSize( new Dimension(0, 60));
        table.getTableHeader().setForeground(Color.white);
        table.getTableHeader().setFont(fontList[3]);
        table.setBackground(ConstantsUI.BUTTON_BG_COLOR);
        table.setFillsViewportHeight(true);
        table.setRowHeight(30);
        table.setFont(fontList[3]);
        table.setSelectionBackground(ConstantsUI.SELECTED_BG_COLOR);
        MatteBorder border = new MatteBorder(1, 1, 0, 0, ConstantsUI.TABLE_BG_COLOR);
        table.setBorder(border);

        centerTextInCell();

        jsTable = new JScrollPane(table);
        jsTable.setForeground(Color.white);
        jsTable.setBorder(null);
        this.add(jsTable, BorderLayout.PAGE_END);
        this.setBorder(null);


    }
    public void refreshTable(Object[][] list){
        cleanRowsTable();
        for (Object[] objects : list)
            addElementToTable(objects);
    }

    public void addElementToTable(Object[] vector){
        dtmElements.addRow(vector);
    }

    public void cleanRowsTable() {
        dtmElements.setNumRows(0);
    }

    private void centerTextInCell() {
        DefaultTableCellRenderer centerModel = new DefaultTableCellRenderer();
        centerModel.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < dtmElements.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerModel);
        }
    }

    public int getSelectedId(){
        Object id = table.getValueAt(table.getSelectedRow(), 0);
        return (Integer) id;
    }


}
