package cvut.fel.dbs.lib.zapocet.view;

import cvut.fel.dbs.lib.zapocet.App;
import cvut.fel.dbs.lib.zapocet.Teacher;

import javax.swing.*;

/**
 * This is a router for every JFrame.
 */
public class View {
    App app;

    JFrameCreateTeacher jFrameCreateTeacher;
    JFrameInit jFrameInit;
    JFrameUpdateTeacher jFrameUpdateTeacher;
    JFrameTeacherList jFrameTeacherList;
    JFrameRelationshipList jFrameRelationshipList;
    JFrameSubjectList jFrameSubjectList;
    JFrameAddTaughtSubject jFrameAddTaughtSubject;

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

    public void refreshRelationshipList() {
        jFrameRelationshipList.refreshPanel();
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

    public void openJFrameAddTaugthSubject(Teacher t, App app) {
        if (jFrameAddTaughtSubject == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    jFrameAddTaughtSubject = new JFrameAddTaughtSubject(t, app);
                    jFrameAddTaughtSubject.init();
                    jFrameAddTaughtSubject.setVisible(true);
                }
            });
        }
        else {
            jFrameAddTaughtSubject.setVisible(true);
            jFrameAddTaughtSubject.setCurrentTeacher(t);
            jFrameAddTaughtSubject.repaint();
        }
    }

    public void openJFrameRelationshipList() {
        if (jFrameRelationshipList == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    jFrameRelationshipList = new JFrameRelationshipList(app);
                    jFrameRelationshipList.init();
                    jFrameRelationshipList.listRelationships();
                    jFrameRelationshipList.setVisible(true);
                }
            });
        }
        else {
            jFrameRelationshipList.setVisible(true);
            jFrameRelationshipList.repaint();
        }
    }

    public void openJFrameSubjectList() {
        if (jFrameSubjectList == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    jFrameSubjectList = new JFrameSubjectList(app);
                    jFrameSubjectList.init();
                    jFrameSubjectList.listSubjects();
                    jFrameSubjectList.setVisible(true);
                }
            });
        }
        else {
            jFrameSubjectList.setVisible(true);
            jFrameSubjectList.repaint();
        }
    }
}
