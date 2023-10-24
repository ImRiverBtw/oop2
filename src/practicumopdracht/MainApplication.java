package practicumopdracht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import practicumopdracht.controllers.ChapterController;
import practicumopdracht.controllers.ComicController;
import practicumopdracht.controllers.Controller;
import practicumopdracht.data.*;
import practicumopdracht.models.Comic;

public class MainApplication extends Application {
    private String TITLE = String.format("Practicumopdracht OOP2 - %s", Main.studentNaam);
    private int WIDTH = 640;
    private int HEIGTH = 480;
    private static Stage stage = new Stage();
    private static ComicDAO comicDAO = new DummyComicDAO();

    private static ChapterDAO chapterDAO = new DummyChapterDAO();

    private static Comic selectedComic;


    @Override
    public void start(Stage stage) {
        if (!Main.launchedFromMain) {
            System.err.println("Je moet deze applicatie opstarten vanuit de Main-class, niet de MainApplication-class!");
            System.exit(1337);

            return;
        }
        stage.setTitle(TITLE);
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGTH);
        comicDAO.load();
        chapterDAO.load();
        MainApplication.stage = stage;
        Controller comicController = new ComicController(this);
        Controller chapterController = new ChapterController(this);
        switchController(comicController);
        MainApplication.stage.show();


    }

    public static void switchController(Controller controller) {
        stage.setScene(new Scene(controller.getView().getRoot()));
    }

    public static ComicDAO getComicDAO() {
        return comicDAO;
    }

    public static ChapterDAO getChapterDAO() {
        return chapterDAO;
    }

    public static void setSelectedComic(Comic selectedComic) {
        MainApplication.selectedComic = selectedComic;
    }

    public static Comic getSelectedComic() {
        return selectedComic;
    }
}
