package practicumopdracht;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import practicumopdracht.views.ComicView;
import practicumopdracht.views.View;

public class MainApplication extends Application {
    private String TITLE;
    private int WIDTH;
    private int HEIGTH;

    public MainApplication() {
        this.TITLE = String.format("Practicumopdracht OOP2 - %s", Main.studentNaam);
        this.WIDTH = 640;
        this.HEIGTH = 480;
    }

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
        stage.show();

        View view = new ComicView();
        Parent rootElement = view.getRoot();

        Scene scene = new Scene(rootElement);
        stage.setScene(scene);


    }
}
