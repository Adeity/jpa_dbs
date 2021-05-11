package cvut.fel.dbs.lib.zapocet.view;

import cvut.fel.dbs.lib.zapocet.App;

import javax.swing.*;
import java.util.Objects;

public class View {
    App app;

    JFrameCreateTeacher jFrameCreateTeacher;
    JFrameInit jFrameInit;
    JFrameUpdateTeacher jFrameUpdateTeacher;
    JFrameTeacherList jFrameTeacherList;

    public void setApp(App app) {
        this.app = app;
    }

    public void openJFrameInit() {
        if (jFrameInit == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    jFrameInit = new JFrameInit(app);
                    jFrameInit.init();
                    jFrameInit.setVisible(true);
                }
            });
        }
        else {
            jFrameInit.repaint();
        }
    }

    public void openJFrameTeacherList() {
        if (jFrameTeacherList == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    jFrameTeacherList = new JFrameTeacherList(app);
                    jFrameTeacherList.init();
                    jFrameTeacherList.listTeachers();
                    jFrameTeacherList.setVisible(true);
                }
            });
        }
        else {
            jFrameTeacherList.repaint();
        }
    }
}
