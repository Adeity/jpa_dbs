package cvut.fel.dbs.lib.zapocet.view;

import cvut.fel.dbs.lib.zapocet.App;
import cvut.fel.dbs.lib.zapocet.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is a windows where a code of subject can be added to teacher. It will create a new relationship between teacher and subject.
 */
public class JFrameAddTaughtSubject extends JFrame implements ActionListener {
    App app;

    JButton btnAdd = new JButton("Add");
    JButton btnReset = new JButton("Reset");

    Teacher t;

    JTextField code;

    JLabel name;
    JLabel surname;

    JLabel wrongInput = new JLabel("Invalid input");
    JLabel succesLabel = new JLabel("Success");
    JLabel pid;


    JPanel mainPanel;

    public JFrameAddTaughtSubject(Teacher t, App app) {
        this.t = t;
        this.app = app;
    }

    public void init() {
        btnAdd.addActionListener(this);

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

        ViewUtilities.addMyLabelCell(0, 0, "Teacher", mainPanel);

        name = ViewUtilities.addMyLabelCell(1, 0, t.getName() + " " + t.getSurname(), mainPanel);

        ViewUtilities.addMyLabelCell(1, "Code", mainPanel);
        code = ViewUtilities.addMyTextFieldCell(1, "", mainPanel);

        btnAdd = ViewUtilities.addMyButtonCell(1, 2, mainPanel, this, "Add", "Add");

    }

    private void fillFields() {
        this.resetTextFields();
        name.setText(t.getName() + " " + t.getSurname());

    }

    private void resetTextFields() {
        name.setText("");
    }

    private void wrongInputLabel() {
        mainPanel.remove(succesLabel);
        mainPanel.remove(wrongInput);
        wrongInput = ViewUtilities.addMyLabelCell(3, "Wrong input", mainPanel);
        this.revalidate();
    }

    private void successLabel() {
        mainPanel.remove(wrongInput);
        mainPanel.remove(succesLabel);
        succesLabel = ViewUtilities.addMyLabelCell(3, "Success", mainPanel);
        this.revalidate();
    }

    public void setCurrentTeacher(Teacher t) {
        this.t = t;
        this.fillFields();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Add":
                if (app.getController().addTaugthSubjectToTeacher(this.t, code.getText())) {
                    successLabel();
                } else {
                    wrongInputLabel();
                }
//                mainPanel.remove(wrongInput);
                this.revalidate();
                break;
        }
    }
}
