package cvut.fel.dbs.lib.zapocet;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.controller.setApp(app);
        app.view.setApp(app);

        app.view.openJFrameInit();

    }
}
