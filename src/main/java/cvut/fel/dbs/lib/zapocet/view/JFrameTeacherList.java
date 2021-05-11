package cvut.fel.dbs.lib.zapocet.view;

import cvut.fel.dbs.lib.zapocet.App;
import cvut.fel.dbs.lib.zapocet.Teacher;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JFrameTeacherList extends JFrame {
    App app;

    JPanel mainPanel;

    public JFrameTeacherList(App app){
        this.app = app;
    }

    public void init() {
        this.mainPanel = new JPanel();

        mainPanel.setLayout(new GridBagLayout());

        ViewUtilities.addMyLabelCell(0, 0, " idteacher ", mainPanel);
        ViewUtilities.addMyLabelCell(1, 0, " pid ", mainPanel);
        ViewUtilities.addMyLabelCell(2, 0, " name ", mainPanel);
        ViewUtilities.addMyLabelCell(3, 0, " surname ", mainPanel);
        ViewUtilities.addMyLabelCell(4, 0, " phonenumber ", mainPanel);
        ViewUtilities.addMyLabelCell(5, 0, " street ", mainPanel);
        ViewUtilities.addMyLabelCell(6, 0, " city ", mainPanel);
        ViewUtilities.addMyLabelCell(7, 0, " zipcode ", mainPanel);

        this.add(mainPanel);
    }

    public void listTeachers() {
        List<Teacher> listOfTeachers = app.getController().getListOfTeachers();
        System.out.println("There are: " + listOfTeachers.size() + " teachers in list");
        int row = 1;
        for (Teacher t : listOfTeachers) {
            System.out.println(t);
            ViewUtilities.addMyLabelCell(0, row, t.getIdperson().toString(), mainPanel);
            ViewUtilities.addMyLabelCell(2, row, t.getName(), mainPanel);
            ViewUtilities.addMyLabelCell(3, row, t.getSurname(), mainPanel);
            ViewUtilities.addMyLabelCell(4, row, t.getPhoneNumber(), mainPanel);
            ViewUtilities.addMyLabelCell(5, row, t.getStreet(), mainPanel);
            ViewUtilities.addMyLabelCell(6, row, t.getCity(), mainPanel);
            ViewUtilities.addMyLabelCell(7, row, String.valueOf(t.getZipcode()), mainPanel);
            row++;
        }
        this.repaint();
    }

}
