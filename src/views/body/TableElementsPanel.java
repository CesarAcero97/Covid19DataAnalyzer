package views.body;

import views.ConstantsUI;
import views.modifiers.TableBorder;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
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
        this.setBackground(Color.BLACK);
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
        table.getTableHeader().setBackground( ConstantsUI.MAIN_COLOR );
        table.getTableHeader().setPreferredSize( new Dimension(0, 60));
        table.getTableHeader().setForeground(Color.white);
        table.setBackground(Color.white);
        table.setFillsViewportHeight(true);
        table.setRowHeight( 35 );
        table.setBorder(null);

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

}
