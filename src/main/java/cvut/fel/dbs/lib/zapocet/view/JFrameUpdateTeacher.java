package cvut.fel.dbs.lib.zapocet.view;

import cvut.fel.dbs.lib.zapocet.App;
import cvut.fel.dbs.lib.zapocet.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This windows has a form for selected teacher where you can update teachers attributes.
 */
public class JFrameUpdateTeacher extends JFrame implements ActionListener {
    App app;

    JButton btnUpdate = new JButton("Update");
    JButton btnReset = new JButton("Reset");

    Teacher t;

    JTextField name;
    JTextField surname;
    JFormattedTextField phonenumber;
    JTextField street;
    JTextField city;
    JFormattedTextField zipcode;

    JLabel wrongInput = new JLabel("Invalid input");
    JLabel succesLabel = new JLabel("Success");
    JLabel pid;


    JPanel mainPanel;

    public JFrameUpdateTeacher(Teacher t, App app) {
        this.t = t;
        this.app = app;
    }

    public void init() {
        btnUpdate.addActionListener(this);

        this.setSize(new Dimension(400, 300));
        this.setLayout(new FlowLayout());

        this.mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        this.addGrids();

        this.fillFields();


//        this.add(new JLabel("Create new user"));
        this.add(mainPanel);
    }

    private void addGrids() {
        mainPanel.removeAll();

        ViewUtilities.addMyLabelCell(0, "Update teacher", mainPanel);

        ViewUtilities.addMyLabelCell(1, "name", mainPanel);
        name = ViewUtilities.addMyTextFieldCell(1, " ", mainPanel);

        ViewUtilities.addMyLabelCell(2, "surname", mainPanel);
        surname = ViewUtilities.addMyTextFieldCell(2, " ", mainPanel);

        ViewUtilities.addMyLabelCell(3, "phonenumber", mainPanel);
        phonenumber = ViewUtilities.addMyTextFieldCell(3, " ", mainPanel, true);

        ViewUtilities.addMyLabelCell(4, "street", mainPanel);
        street = ViewUtilities.addMyTextFieldCell(4, " ", mainPanel);

        ViewUtilities.addMyLabelCell(5, "city", mainPanel);
        city = ViewUtilities.addMyTextFieldCell(5, " ", mainPanel);

        String zipcodeStr;
        if (t.getZipcode() == null) {
            zipcodeStr = "";
        } else {
            zipcodeStr = t.getZipcode().toString();
        }

        ViewUtilities.addMyLabelCell(6, "zipcode", mainPanel);
        zipcode = ViewUtilities.addMyTextFieldCell(6, zipcodeStr, mainPanel, true);

        ViewUtilities.addMyLabelCell(7, "pid", mainPanel);
        pid = ViewUtilities.addMyLabelCell(1, 7, t.getPid(), mainPanel);

        btnUpdate = ViewUtilities.addMyButtonCell(0, 8, mainPanel, this, "Update", "Update");
        btnReset = ViewUtilities.addMyButtonCell(1, 8, mainPanel, this, "Reset", "Reset");
    }

    private void fillFields() {
        this.resetTextFields();

        name.setText(t.getName());
        surname.setText(t.getSurname());
        phonenumber.setText(t.getPhoneNumber());
        street.setText(t.getStreet());
        city.setText(t.getCity());
        zipcode.setValue(t.getZipcode());
        pid.setText(t.getPid());

    }

    private void resetTextFields() {
        name.setText("");
        surname.setText("");
        phonenumber.setValue(null);
        street.setText("");
        city.setText("");
        zipcode.setValue(null);
        this.pid.setText(null);
    }

    private void wrongInputLabel() {
        mainPanel.remove(succesLabel);
        mainPanel.remove(wrongInput);
        wrongInput = ViewUtilities.addMyLabelCell(9, "Wrong input", mainPanel);
        this.revalidate();
    }

    private void successLabel() {
        mainPanel.remove(wrongInput);
        mainPanel.remove(succesLabel);
        succesLabel = ViewUtilities.addMyLabelCell(9, "Success", mainPanel);
        this.revalidate();
    }

    public void setCurrentTeacher(Teacher t) {
        this.t = t;
        this.fillFields();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Update":
                mainPanel.remove(wrongInput);
                this.revalidate();
                if(app.getController().updateTeacher(this.t, String.valueOf(ViewUtilities.getParsableToInt(pid.getText())), name.getText(), surname.getText(), ViewUtilities.getParsableToInt(phonenumber.getText()), street.getText(), city.getText(), ViewUtilities.getParsableToInt(zipcode.getText()))){
                    this.successLabel();
                }
                else {
                    this.wrongInputLabel();
                    System.out.println("Wrong input.");
                }
                break;
            case "Reset":
                mainPanel.remove(wrongInput);
                mainPanel.remove(succesLabel);
                this.revalidate();
                this.fillFields();
                break;
        }
    }
}
