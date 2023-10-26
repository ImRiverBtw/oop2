package practicumopdracht.controllers;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import practicumopdracht.MainApplication;
import practicumopdracht.views.View;

import java.util.Optional;

public abstract class Controller {
    public abstract View getView();

    protected void saveDAO(){
        MainApplication.getChapterDAO().save();
        MainApplication.getComicDAO().save();
    }

    protected void loadDAO(){
        MainApplication.getChapterDAO().load();
        MainApplication.getComicDAO().load();
    }
    protected void handleSaveDAO(){
        Alert saveDAOAlert = getSaveDAOAlert();
        Optional<ButtonType> result = saveDAOAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.YES) {
            saveDAO();
        }
    }

    protected void handleLoadDAO(){
        Alert loadDAOAlert = getLoadDAOAlert();
        Optional<ButtonType> result = loadDAOAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.YES) {
            loadDAO();
        }
    }
    protected abstract Alert getCloseAlert();
    protected abstract Alert getSaveDAOAlert();
    protected abstract Alert getLoadDAOAlert();


    protected void handleCloseButton() {
        Alert closeAlert = getCloseAlert();
        Optional<ButtonType> result = closeAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.YES) {
            handleSaveDAO();
            Platform.exit();
        } else if (result.isPresent() && result.get() == ButtonType.NO) {
            Platform.exit();
        }
    }


}
