package cvut.fel.dbs.lib.zapocet.view;

import cvut.fel.dbs.lib.zapocet.App;
import cvut.fel.dbs.lib.zapocet.Subject;
import cvut.fel.dbs.lib.zapocet.Teacher;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class JFrameSubjectList extends JFrame {
    App app;

    JPanel mainPanel;

    public JFrameSubjectList(App app){
        this.app = app;
    }

    public void init() {

        this.setSize(new Dimension(700, 500));
        this.setLayout(new FlowLayout());
        this.mainPanel = new JPanel();;

        mainPanel.setLayout(new GridBagLayout());

        this.addHeading();
        this.add(mainPanel);
    }

    public void addHeading() {
        ViewUtilities.addMyLabelCell(0, 0, " idsubject ", mainPanel);
        ViewUtilities.addMyLabelCell(1, 0, " code ", mainPanel);
        ViewUtilities.addMyLabelCell(2, 0, " name ", mainPanel);
        ViewUtilities.addMyLabelCell(3, 0, " description ", mainPanel);
        ViewUtilities.addMyLabelCell(4, 0, " semester ", mainPanel);
    }


    public void listSubjects() {
        List<Subject> listOfSubjects = app.getController().getListOfSubjects();
        System.out.println("There are: " + listOfSubjects.size() + " teachers in list");

        int row = 1;
        for (Subject s : listOfSubjects) {
            System.out.println(s);
            ViewUtilities.addMyLabelCell(0, row, s.getIdsubject().toString(), mainPanel);
            ViewUtilities.addMyLabelCell(1, row, s.getCode(), mainPanel);
            ViewUtilities.addMyLabelCell(2, row, s.getName(), mainPanel);
            ViewUtilities.addMyLabelCell(3, row, s.getDescription(), mainPanel);
            ViewUtilities.addMyLabelCell(4, row, s.getRecommendedsemester(), mainPanel);
            row++;
        }
        this.repaint();
    }
}
