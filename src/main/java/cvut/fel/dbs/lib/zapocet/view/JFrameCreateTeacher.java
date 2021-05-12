package cvut.fel.dbs.lib.zapocet.view;

import cvut.fel.dbs.lib.zapocet.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameCreateTeacher extends JFrame implements ActionListener {
    App app;

    JButton btnCreate = new JButton("Create");
    JButton btnReset = new JButton("Reset");

    JTextField name;
    JTextField surname;
    JFormattedTextField phonenumber;
    JTextField street;
    JTextField city;
    JFormattedTextField zipcode;
    JFormattedTextField pid;

    JLabel wrongInput = new JLabel("Invalid input");
    JLabel succesLabel = new JLabel("Success");


    JPanel mainPanel;

    public JFrameCreateTeacher(App app) {
        this.app = app;
    }

    public void init() {
        btnCreate.addActionListener(this);

        this.setSize(new Dimension(400, 300));
        this.setLayout(new FlowLayout());

        this.mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        this.addGrids();


//        this.add(new JLabel("Create new user"));
        this.add(mainPanel);
    }

    private void addGrids() {
        mainPanel.removeAll();

        ViewUtilities.addMyLabelCell(0, "Create teacher", mainPanel);

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

        ViewUtilities.addMyLabelCell(6, "zipcode", mainPanel);
        zipcode = ViewUtilities.addMyTextFieldCell(6, " ", mainPanel, true);

        ViewUtilities.addMyLabelCell(7, "pid", mainPanel);
        pid = ViewUtilities.addMyTextFieldCell(7, " ", mainPanel, true);

        btnCreate = ViewUtilities.addMyButtonCell(0, 8, mainPanel, this, "Create", "Create");
        btnReset = ViewUtilities.addMyButtonCell(1, 8, mainPanel, this, "Reset", "Reset");



    }

    private void resetTextFields() {
        name.setText("");
        surname.setText("");
        phonenumber.setValue(null);
        street.setText("");
        city.setText("");
        zipcode.setValue(null);
        this.pid.setValue(null);
    }

    private void wrongInputLabel() {
        mainPanel.remove(succesLabel);
        wrongInput = ViewUtilities.addMyLabelCell(9, "Wrong input", mainPanel);
        this.revalidate();
    }

    private void successLabel() {
        mainPanel.remove(wrongInput);
        succesLabel = ViewUtilities.addMyLabelCell(9, "Success", mainPanel);
        this.resetTextFields();
        this.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Create":
                mainPanel.remove(wrongInput);
                this.revalidate();
                if (app.getController().createNewTeacher(String.valueOf(ViewUtilities.getParsableToInt(pid.getText())), name.getText(), surname.getText(), ViewUtilities.getParsableToInt(phonenumber.getText()), street.getText(), city.getText(), ViewUtilities.getParsableToInt(zipcode.getText()))) {
                    successLabel();
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
                this.resetTextFields();
                break;
        }
    }
}
