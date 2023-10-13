package practicumopdracht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import practicumopdracht.controllers.ChapterController;
import practicumopdracht.controllers.ComicController;
import practicumopdracht.controllers.Controller;

public class MainApplication extends Application {
    private String TITLE = String.format("Practicumopdracht OOP2 - %s", Main.studentNaam);
    private int WIDTH = 640;
    private int HEIGTH = 480;

    private static Stage stage = new Stage();

    @Override
    public void start(Stage stage) {
        if(!Main.launchedFromMain) {
            System.err.println("Je moet deze applicatie opstarten vanuit de Main-class, niet de MainApplication-class!");
            System.exit(1337);

            return;
        }
        stage.setTitle(TITLE);
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGTH);
        MainApplication.stage = stage;
        Controller comicController = new ComicController(this);
        Controller chapterController = new ChapterController(this);
        switchController(chapterController);
        MainApplication.stage.show();

    }
    public void switchController (Controller controller){
        stage.setScene(new Scene(controller.getView().getRoot()));
    }
}
