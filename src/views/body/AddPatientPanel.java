package views.body;

import com.toedter.calendar.JDateChooser;
import controllers.Commands;
import models.Patient;
import utilities.Utilities;
import views.ConstantsUI;
import views.modifiers.RoundedJButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddPatientPanel extends JDialog {

    private final ActionListener listener;
    private JSpinner employees;
    private JTextField city, department, age, status, countryOfOrigin, recoveryType;
    private JDateChooser admissionDate, firtsSymptomsDate, diagnosticDate, recoveryDate;
    private Font[] fontList;
    private JComboBox<String> sex, type, attention;

    private JLabel infoText;

    public AddPatientPanel(ActionListener listener, Font[] fontList){
        this.fontList = fontList;
        this.listener = listener;
        this.setAlwaysOnTop(true);
        this.setSize(800,500);
        this.setLayout(new BorderLayout());
        this.setBackground(ConstantsUI.MAIN_COLOR);
        componentsInit();
    }

    private void componentsInit(){
        JPanel mainPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(5,2);
        mainPanel.setLayout(gridLayout);
        mainPanel.setBorder(new EmptyBorder( 20, 20, 20, 20));
        mainPanel.setFont(fontList[3]);
        mainPanel.setBackground(ConstantsUI.BLUE_BG_COLOR);

        JLabel createTitle = new JLabel(ConstantsUI.CREATE_PATIENT_TITLE, SwingConstants.CENTER);
        createTitle.setFont(fontList[1]);;
        createTitle.setForeground(ConstantsUI.TEXT_COLOR);
        mainPanel.add(createTitle);

        admissionDate = new JDateChooser();
        admissionDate.setBorder(BorderFactory.createTitledBorder(null, ConstantsUI.ADMISSION_DATE, 1,  1, fontList[3], ConstantsUI.TEXT_COLOR));
        admissionDate.setBackground(ConstantsUI.MAIN_COLOR);
        admissionDate.setFont(fontList[3]);
        admissionDate.setForeground(ConstantsUI.TEXT_COLOR);
        mainPanel.add(admissionDate);


        city = new JTextField();
        city.setBorder(BorderFactory.createTitledBorder(null, ConstantsUI.CITY, 1,  1, fontList[3], ConstantsUI.TEXT_COLOR));
        city.setBackground(ConstantsUI.MAIN_COLOR);
        city.setFont(fontList[3]);
        city.setForeground(ConstantsUI.TEXT_COLOR);
        mainPanel.add(city);

        department = new JTextField();
        department.setBorder(BorderFactory.createTitledBorder(null, ConstantsUI.DEPARTMENT, 1,  1, fontList[3], ConstantsUI.TEXT_COLOR));
        department.setBackground(ConstantsUI.MAIN_COLOR);
        department.setFont(fontList[3]);
        department.setForeground(ConstantsUI.TEXT_COLOR);
        mainPanel.add(department);

        attention = new JComboBox<String>(ConstantsUI.ATTENTION_OPTIONS);
        attention.setBorder(BorderFactory.createTitledBorder(null, ConstantsUI.ATTENTION, 1,  1, fontList[3], ConstantsUI.TEXT_COLOR));
        attention.setBackground(ConstantsUI.MAIN_COLOR);
        attention.setFont(fontList[3]);
        attention.setForeground(ConstantsUI.TEXT_COLOR);
        mainPanel.add(attention);

        age = new JTextField();
        age.setBorder(BorderFactory.createTitledBorder(null, ConstantsUI.AGE, 1,  1, fontList[3], ConstantsUI.TEXT_COLOR));
        age.setBackground(ConstantsUI.MAIN_COLOR);
        age.setFont(fontList[3]);
        age.setForeground(ConstantsUI.TEXT_COLOR);
        mainPanel.add(age);

        sex = new JComboBox<String>(ConstantsUI.SEX_OPTIONS);
        sex.setBorder(BorderFactory.createTitledBorder(null, ConstantsUI.SEX, 1,  1, fontList[3], ConstantsUI.TEXT_COLOR));
        sex.setBackground(ConstantsUI.MAIN_COLOR);
        sex.setFont(fontList[3]);
        sex.setForeground(ConstantsUI.TEXT_COLOR);
        mainPanel.add(sex);

        type = new JComboBox<String>(ConstantsUI.TYPE_OPTIONS);
        type.setBorder(BorderFactory.createTitledBorder(null, ConstantsUI.TYPE, 1,  1, fontList[3], ConstantsUI.TEXT_COLOR));
        type.setBackground(ConstantsUI.MAIN_COLOR);
        type.setFont(fontList[3]);
        type.setForeground(ConstantsUI.TEXT_COLOR);
        mainPanel.add(type);

        status = new JTextField();
        status.setBorder(BorderFactory.createTitledBorder(null, ConstantsUI.STATUS, 1,  1, fontList[3], ConstantsUI.TEXT_COLOR));
        status.setBackground(ConstantsUI.MAIN_COLOR);
        status.setFont(fontList[3]);
        status.setForeground(ConstantsUI.TEXT_COLOR);
        mainPanel.add(status);

        countryOfOrigin = new JTextField();
        countryOfOrigin.setBorder(BorderFactory.createTitledBorder(null, ConstantsUI.COUNTRY_OF_ORIGIN, 1,  1, fontList[3], ConstantsUI.TEXT_COLOR));
        countryOfOrigin.setBackground(ConstantsUI.MAIN_COLOR);
        countryOfOrigin.setFont(fontList[3]);
        countryOfOrigin.setForeground(ConstantsUI.TEXT_COLOR);
        mainPanel.add(countryOfOrigin);

        firtsSymptomsDate = new JDateChooser();
        firtsSymptomsDate.setBorder(BorderFactory.createTitledBorder(null, ConstantsUI.FIRTS_SYMPTOMS_DATE, 1,  1, fontList[3], ConstantsUI.TEXT_COLOR));
        firtsSymptomsDate.setBackground(ConstantsUI.MAIN_COLOR);
        firtsSymptomsDate.setFont(fontList[3]);
        firtsSymptomsDate.setForeground(ConstantsUI.TEXT_COLOR);
        mainPanel.add(firtsSymptomsDate);

        diagnosticDate = new JDateChooser();
        diagnosticDate.setBorder(BorderFactory.createTitledBorder(null, ConstantsUI.DIAGNOSTIC_DATE, 1,  1, fontList[3], ConstantsUI.TEXT_COLOR));
        diagnosticDate.setBackground(ConstantsUI.MAIN_COLOR);
        diagnosticDate.setFont(fontList[3]);
        diagnosticDate.setForeground(ConstantsUI.TEXT_COLOR);
        mainPanel.add(diagnosticDate);

        recoveryDate = new JDateChooser();
        recoveryDate.setBorder(BorderFactory.createTitledBorder(null, ConstantsUI.RECOVERY_DATE, 1,  1, fontList[3], ConstantsUI.TEXT_COLOR));
        recoveryDate.setBackground(ConstantsUI.MAIN_COLOR);
        recoveryDate.setFont(fontList[3]);
        recoveryDate.setForeground(ConstantsUI.TEXT_COLOR);
        mainPanel.add(recoveryDate);

        recoveryType = new JTextField();
        recoveryType.setBorder(BorderFactory.createTitledBorder(null, ConstantsUI.RECOVERY_TYPE, 1,  1, fontList[3], ConstantsUI.TEXT_COLOR));
        recoveryType.setBackground(ConstantsUI.MAIN_COLOR);
        recoveryType.setFont(fontList[3]);
        recoveryType.setForeground(ConstantsUI.TEXT_COLOR);
        mainPanel.add(recoveryType);

        RoundedJButton cancelButton = new RoundedJButton(15, 15, ConstantsUI.CANCEL, ConstantsUI.BUTTON_BG_COLOR, ConstantsUI.BLUE_BG_COLOR, fontList[2], Commands.CANCEL.toString(), listener);
        Image exitIcon = (new ImageIcon(getClass().getResource(ConstantsUI.PATH_EXIT_ICON)).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        cancelButton.setIcon(new ImageIcon(exitIcon));
        mainPanel.add(cancelButton);

        RoundedJButton createButton = new RoundedJButton(15, 15, ConstantsUI.CREATE, ConstantsUI.BUTTON_BG_COLOR, ConstantsUI.BLUE_BG_COLOR, fontList[2], Commands.CREATE_PATIENT.toString(), listener);
        Image addIcon = (new ImageIcon(getClass().getResource(ConstantsUI.PATH_ADD_ICON)).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        createButton.setIcon(new ImageIcon(addIcon));
        mainPanel.add(createButton);

        this.add(mainPanel);
        /*
        documentTypeBox = new JComboBox<>(DocumentType.values());
        documentTypeBox.setBorder(BorderFactory.createTitledBorder(null, ConstantsUI.DOCUMENT_TYPE, 1,  1, fontList.get(0), ConstantsUI.TEXT_COLOR));
        documentTypeBox.setBackground(ConstantsUI.MAIN_COLOR);
        documentTypeBox.setFont(fontList.get(0));
        documentTypeBox.setForeground(ConstantsUI.TEXT_COLOR);
        mainPanel.add(documentTypeBox);

        documentNumber = new JTextField();
        documentNumber.setBorder(BorderFactory.createTitledBorder(null, ConstantsUI.DOCUMENT_NUMBER, 1,  1, fontList.get(0), ConstantsUI.TEXT_COLOR));
        documentNumber.setBackground(ConstantsUI.MAIN_COLOR);
        documentNumber.setFont(fontList.get(0));
        documentNumber.setForeground(ConstantsUI.TEXT_COLOR);
        mainPanel.add(documentNumber);

        employees = new JSpinner(new SpinnerNumberModel(5, 1, Integer.MAX_VALUE, 1));
        ((DefaultFormatter) ((JSpinner.NumberEditor)employees.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        employees.setBorder(BorderFactory.createTitledBorder(null, ConstantsUI.EMPLOYEE_AMOUNT, 1,  1, fontList.get(0), ConstantsUI.TEXT_COLOR));
        employees.setBackground(ConstantsUI.MAIN_COLOR);
        employees.setForeground(ConstantsUI.TEXT_COLOR);
        employees.setFont(fontList.get(1));
        mainPanel.add(employees);

        admissionDate = new JDateChooser();
        admissionDate.setBorder(BorderFactory.createTitledBorder(null, ConstantsUI.DATE, 1,  1, fontList.get(0), ConstantsUI.TEXT_COLOR));
        admissionDate.setBackground(ConstantsUI.MAIN_COLOR);
        admissionDate.setFont(fontList.get(0));
        admissionDate.setForeground(ConstantsUI.TEXT_COLOR);
        mainPanel.add(admissionDate);

        RoundedJButton cancelButton = new RoundedJButton(15, 15, ConstantsUI.CANCEL_REQUEST, ConstantsUI.BUTTON_COLOR, ConstantsUI.TEXT_COLOR, fontList.get(2), Commands.C_CANCEL.toString(), listener);
        mainPanel.add(cancelButton);

        RoundedJButton createButton = new RoundedJButton(15, 15, ConstantsUI.CREATE_REQUEST, ConstantsUI.OK_BUTTON_COLOR, ConstantsUI.TEXT_COLOR, fontList.get(2), Commands.C_ADD_REQUEST.toString(), listener);
        mainPanel.add(createButton);

        this.add(mainPanel, BorderLayout.CENTER);

        infoText = new JLabel(ConstantsUI.INFO_TEXT, SwingConstants.CENTER);
        infoText.setFont(fontList.get(1));
        infoText.setBackground(ConstantsUI.MAIN_COLOR);
        infoText.setOpaque(true);
        infoText.setForeground(ConstantsUI.TEXT_COLOR);
        this.add(infoText, BorderLayout.SOUTH);

         */
    }
    /*
    public Request tryCreateRequest() throws BadDataException{
        String[] infoList = {city.getText(), documentNumber.getText(), admissionDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString()};
        if(RequestValidator.correctData(infoList) || admissionDate.getDate() == null)
            return createRequest();
        else
            throw new BadDataException();

    }

    public void printError(String errorMsg){
        infoText.setText(errorMsg);
        infoText.setForeground(Color.red);
    }
*/
    private void clearAreas(){
        sex.setSelectedItem(0);
        type.setSelectedItem(0);
        attention.setSelectedItem(0);
        city.setText("");
        department.setText("");
        age.setText("");
        status.setText("");
        countryOfOrigin.setText("");
        recoveryType.setText("");
        admissionDate.setDate(null);
        firtsSymptomsDate.setDate(null);
        diagnosticDate.setDate(null);
        recoveryDate.setDate(null);
    }

    public Patient getPatient(){
        this.setVisible(false);
        Patient patient = new Patient(0, Utilities.convertToLocalDate(admissionDate.getDate()), city.getText(), department.getText(), (String) attention.getSelectedItem(), Byte.parseByte(age.getText()), (String) sex.getSelectedItem(), (String) type.getSelectedItem(), status.getText(), countryOfOrigin.getText(),  Utilities.convertToLocalDate(firtsSymptomsDate.getDate()),  Utilities.convertToLocalDate(diagnosticDate.getDate()),  Utilities.convertToLocalDate(recoveryDate.getDate()), recoveryType.getText());
        clearAreas();
        return patient;
    }


}
