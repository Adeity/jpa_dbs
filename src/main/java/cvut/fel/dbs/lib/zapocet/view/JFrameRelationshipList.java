package cvut.fel.dbs.lib.zapocet.view;

import cvut.fel.dbs.lib.zapocet.App;
import cvut.fel.dbs.lib.zapocet.Subject;
import cvut.fel.dbs.lib.zapocet.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;

public class JFrameRelationshipList extends JFrame implements ActionListener {
    App app;

    JPanel mainPanel;


    JButton btnRefresh = new JButton("Refresh");

    public JFrameRelationshipList(App app){
        this.app = app;
    }

    public void init() {
        btnRefresh.addActionListener(this);

        this.setSize(new Dimension(700, 500));
        this.setLayout(new FlowLayout());
        this.mainPanel = new JPanel();;

        mainPanel.setLayout(new GridBagLayout());

        this.addHeading();

        mainPanel.add(btnRefresh);
        this.add(mainPanel);
    }

    public void addHeading() {
//        ViewUtilities.addMyLabelCell(0, 0, " idteacher ", mainPanel);
//        ViewUtilities.addMyLabelCell(1, 0, " pid ", mainPanel);
//        ViewUtilities.addMyLabelCell(2, 0, " name ", mainPanel);
//        ViewUtilities.addMyLabelCell(3, 0, " surname ", mainPanel);
    }

    public void refreshPanel() {
        mainPanel.removeAll();
        this.addHeading();
        mainPanel.add(btnRefresh);
        this.listRelationships();

        mainPanel.revalidate();
    }

    public void listRelationships() {
        List<Teacher> listOfTeachers = app.getController().getListOfTeachers();
        System.out.println("There are: " + listOfTeachers.size() + " teachers in list");

        int row = 1;
        for (Teacher t : listOfTeachers) {
            System.out.println(t);
            ViewUtilities.addMyLabelCell(0, row, "Teacher", mainPanel);
            ViewUtilities.addMyLabelCell(1, row, t.getIdperson().toString(), mainPanel);
            ViewUtilities.addMyLabelCell(2, row, t.getName(), mainPanel);
            ViewUtilities.addMyLabelCell(3, row, t.getSurname(), mainPanel);
            ViewUtilities.addMyButtonCell(4, row, mainPanel, this, "add "+t.getIdperson(), "Add new subject");

            Collection<Subject> subjectsTaughtByTeacher = t.getTaughtSubjects();
//            System.out.println("There are: " + subjectsTaughtByTeacher.size() );
            if (subjectsTaughtByTeacher != null) {
                for (Subject s : subjectsTaughtByTeacher) {
                    row++;
                    ViewUtilities.addMyLabelCell(0, row, "Subject", mainPanel);
                    ViewUtilities.addMyLabelCell(1, row, s.getIdsubject().toString(), mainPanel);
                    ViewUtilities.addMyLabelCell(2, row, s.getCode(), mainPanel);
                    ViewUtilities.addMyLabelCell(3, row, s.getName(), mainPanel);
                    ViewUtilities.addMyButtonCell(4, row, mainPanel, this, "delete "+t.getIdperson() + " " + s.getIdsubject(), "Delete");
                }
            }

            row++;
        }
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] columns = e.getActionCommand().split(" ");
        String actionType = columns[0];
        String idPerson;
        String idSubject;
        switch (actionType){
            case "update":
                idPerson = columns[1];
                Teacher t = Teacher.getTeacherById(idPerson, app);
                app.getView().openJFrameUpdateTeacher(t, app);
                break;
            case "delete":
                idPerson = columns[1];
                idSubject = columns[2];
                app.getController().deleteTeachersTaugthSubject(Integer.parseInt(idPerson), Integer.parseInt(idSubject));
                break;
            case "Refresh":
                app.getView().refreshRelationshipList();
                break;
        }
    }
}
