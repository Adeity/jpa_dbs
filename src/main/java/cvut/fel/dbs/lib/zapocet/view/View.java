package cvut.fel.dbs.lib.zapocet.view;

import cvut.fel.dbs.lib.zapocet.App;
import cvut.fel.dbs.lib.zapocet.Teacher;

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
            jFrameInit.setVisible(true);
            jFrameInit.repaint();
        }
    }

    public void refreshTeacherList() {
        jFrameTeacherList.refreshPanel();
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
            jFrameTeacherList.setVisible(true);
            jFrameTeacherList.repaint();
        }
    }

    public void openJFrameCreateTeacher() {
        if (jFrameCreateTeacher == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    jFrameCreateTeacher = new JFrameCreateTeacher(app);
                    jFrameCreateTeacher.init();
                    jFrameCreateTeacher.setVisible(true);
                }
            });
        }
        else {
            jFrameCreateTeacher.setVisible(true);
            jFrameCreateTeacher.repaint();
        }
    }

    public void openJFrameUpdateTeacher(Teacher t, App app) {
        if (jFrameUpdateTeacher == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    jFrameUpdateTeacher = new JFrameUpdateTeacher(t, app);
                    jFrameUpdateTeacher.init();
                    jFrameUpdateTeacher.setVisible(true);
                }
            });
        }
        else {
            jFrameUpdateTeacher.setVisible(true);
            jFrameUpdateTeacher.setCurrentTeacher(t);
            jFrameUpdateTeacher.repaint();
        }
    }
}
