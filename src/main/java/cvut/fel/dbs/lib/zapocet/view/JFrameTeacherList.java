package cvut.fel.dbs.lib.zapocet.view;

import cvut.fel.dbs.lib.zapocet.App;
import cvut.fel.dbs.lib.zapocet.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * In this windows you can read each teacher in DB. You can also delete it from DB, update it. There are buttons to create new teacher and refresh this list.
 */
public class JFrameTeacherList extends JFrame implements ActionListener {
    App app;

    JPanel mainPanel;


    JButton btnRefresh = new JButton("Refresh");
    JButton btnCreate = new JButton("Create");

    public JFrameTeacherList(App app){
        this.app = app;
    }

    public void init() {
        btnRefresh.addActionListener(this);
        btnCreate.addActionListener(this);

        this.setSize(new Dimension(700, 500));
        this.setLayout(new FlowLayout());
        this.mainPanel = new JPanel();;

        mainPanel.setLayout(new GridBagLayout());

        this.addHeading();

        mainPanel.add(btnRefresh);
        mainPanel.add(btnCreate);
        this.add(mainPanel);
    }

    public void addHeading() {
        ViewUtilities.addMyLabelCell(0, 0, " idteacher ", mainPanel);
        ViewUtilities.addMyLabelCell(1, 0, " pid ", mainPanel);
        ViewUtilities.addMyLabelCell(2, 0, " name ", mainPanel);
        ViewUtilities.addMyLabelCell(3, 0, " surname ", mainPanel);
        ViewUtilities.addMyLabelCell(4, 0, " phonenumber ", mainPanel);
        ViewUtilities.addMyLabelCell(5, 0, " street ", mainPanel);
        ViewUtilities.addMyLabelCell(6, 0, " city ", mainPanel);
        ViewUtilities.addMyLabelCell(7, 0, " zipcode ", mainPanel);
    }

    public void refreshPanel() {
        mainPanel.removeAll();
        this.addHeading();
        mainPanel.add(btnRefresh);
        mainPanel.add(btnCreate);
        this.listTeachers();

        mainPanel.revalidate();
    }

    public void listTeachers() {
        List<Teacher> listOfTeachers = app.getController().getListOfTeachers();
        System.out.println("There are: " + listOfTeachers.size() + " teachers in list");

        int row = 1;
        for (Teacher t : listOfTeachers) {
            System.out.println(t);
            ViewUtilities.addMyLabelCell(0, row, t.getIdperson().toString(), mainPanel);
            ViewUtilities.addMyLabelCell(1, row, t.getPid(), mainPanel);
            ViewUtilities.addMyLabelCell(2, row, t.getName(), mainPanel);
            ViewUtilities.addMyLabelCell(3, row, t.getSurname(), mainPanel);
            ViewUtilities.addMyLabelCell(4, row, t.getPhoneNumber(), mainPanel);
            ViewUtilities.addMyLabelCell(5, row, t.getStreet(), mainPanel);
            ViewUtilities.addMyLabelCell(6, row, t.getCity(), mainPanel);
            ViewUtilities.addMyLabelCell(7, row, String.valueOf(t.getZipcode()), mainPanel);
            ViewUtilities.addMyUpdateButtonCell(8, row, mainPanel, t.getIdperson(), this);
            ViewUtilities.addMyDeleteButtonCell(9, row, mainPanel, t.getIdperson(), this);
            row++;
        }
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] columns = e.getActionCommand().split(" ");
        String actionType = columns[0];
        String idPerson;
        switch (actionType){
            case "update":
                idPerson = columns[1];
                Teacher t = Teacher.getTeacherById(idPerson, app);
                app.getView().openJFrameUpdateTeacher(t, app);
                break;
            case "delete":
                idPerson = columns[1];
                app.getController().deleteTeacherById(Integer.parseInt(idPerson));
                break;
            case "Refresh":
                app.getView().refreshTeacherList();
                break;
            case "Create":
                app.getView().openJFrameCreateTeacher();
                break;
        }
    }
}