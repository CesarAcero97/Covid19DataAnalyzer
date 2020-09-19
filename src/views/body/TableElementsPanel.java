package views.body;

import views.ConstantsUI;

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

    private JTable jtElements;
    private JScrollPane jsTable;
    private ArrayList<Font> fontList;

    public TableElementsPanel(){
        this.setVisible(true);
        initComponents();
    }

    private void initComponents(){
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        dtmElements = new DefaultTableModel();
        dtmElements.setColumnIdentifiers( ConstantsUI.HEADERS_TABLE );

        jtElements = new JTable();
        jtElements.setModel(dtmElements);
        jtElements.getTableHeader().setReorderingAllowed(false);
        jtElements.getTableHeader().setBackground( ConstantsUI.MAIN_COLOR );
        jtElements.getTableHeader().setPreferredSize( new Dimension(0, 60));
        jtElements.getTableHeader().setForeground(Color.white);
        jtElements.setBackground(Color.white);
        jtElements.setFillsViewportHeight(true);
        jtElements.setRowHeight( 35 );
        jtElements.setBorder(null);

        centerTextInCell();

        jsTable = new JScrollPane(jtElements);
        jsTable.setForeground(Color.white);
        jsTable.setBorder(null);
        jsTable.setAlignmentX(Component.LEFT_ALIGNMENT);
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
            jtElements.getColumnModel().getColumn(i).setCellRenderer(centerModel);
        }
    }

}
