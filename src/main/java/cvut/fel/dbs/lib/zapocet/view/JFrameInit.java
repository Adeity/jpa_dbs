package cvut.fel.dbs.lib.zapocet.view;

import cvut.fel.dbs.lib.zapocet.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameInit extends JFrame implements ActionListener {
    App app;

    JLabel heading = new JLabel("DBS App");

    JButton btnTeacher = new JButton("Teacher");
    JButton btnRelationShip = new JButton("Relationship");

    JPanel panelInit;

    public JFrameInit(App app) {
        this.app = app;
    }

    public void init() {
        this.setSize(new Dimension(500, 500));
        this.setActionCommands();
        panelInit = new JPanel();

        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(btnTeacher);
        horizontalBox.add(Box.createRigidArea(new Dimension(5, 0)));
        horizontalBox.add(btnRelationShip);

        panelInit.add(heading);

        panelInit.add(horizontalBox);

        this.add(panelInit);
    }

    private void setActionCommands() {
        this.btnTeacher.addActionListener(this);
        this.btnRelationShip.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Teacher":
                app.getView().openJFrameTeacherList();
                break;
            case "Relationship":
                app.getView().openJFrameRelationshipList();
                app.getView().openJFrameSubjectList();
                break;
        }
    }
}
