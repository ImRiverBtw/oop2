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
    private final String TITLE = String.format("Practicumopdracht OOP2 - %s", Main.studentNaam);
    private static final int WIDTH = 640;
    private static final int HEIGTH = 480;
    private static Stage stage = new Stage();
    private static final ComicDAO comicDAO = new BinaryComicDAO();

    private static final ChapterDAO chapterDAO = new ObjectChapterDAO();

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
        Scene scene = new Scene(controller.getView().getRoot(), WIDTH, HEIGTH);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
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
