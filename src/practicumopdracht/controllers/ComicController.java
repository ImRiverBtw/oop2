package practicumopdracht.controllers;

import javafx.scene.control.Alert;
import practicumopdracht.MainApplication;
import practicumopdracht.models.Chapter;
import practicumopdracht.models.Comic;
import practicumopdracht.views.ComicView;
import practicumopdracht.views.View;

import java.time.LocalDate;

public class ComicController extends Controller{

    private ComicView view;
    private MainApplication mainApplication;
    public ComicController(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
        view = new ComicView();

        view.getAddButton().setOnAction(actionEvent -> handleAddButton());
        view.getSaveButton().setOnAction(actionEvent -> handleSaveButton());
        view.getDelButton().setOnAction(actionEvent -> handleDelButton());
        view.getInspectButton().setOnAction(actionEvent -> handleInspectButton());
        view.getRatingSlider().setOnMouseReleased(mouseEvent -> handleRatingSlider());
    }

    private void handleAddButton(){
        view.getAddAlert().show();
    }
    private void handleSaveButton(){
        boolean isValidName = !view.getNameField().getText().trim().isEmpty();
        boolean isValidAuthor = !view.getAuthorField().getText().trim().isEmpty();
        boolean isValidDescription = !view.getDescriptionArea().getText().trim().isEmpty();
        boolean isError = false;

        StringBuilder sb = new StringBuilder();
        sb.append("One ore more errors have occured while saving this Chapter:\n \n");

        if (!isValidName){
            sb.append("-Field \"Name\" can not be empty! \n");
            isError = true;
        }
        if (!isValidAuthor){
            sb.append("-Field \"Author\" can not be empty! \n");
            isError = true;
        }
        if (!isValidDescription){
            sb.append("-Field \"Description\" can not be empty! \n");
            isError = true;
        }

        String alert;
        if(!isError){
            String name = view.getNameField().getText();
            double rating = view.getRatingSlider().getValue();
            String author = view.getAuthorField().getText();
            String description = view.getDescriptionArea().getText();

            Comic newComic = new Comic(name, rating, author, description);
            alert = newComic.toString();
            view.getNameField().setText("");
            view.getAuthorField().setText("");
            view.getDescriptionArea().setText("");
            view.getRatingSlider().setValue(1.0);

        } else{
            alert = sb.toString();
        }

        throwSafeAlert(alert, isError);
    }

    private void throwSafeAlert(String alert, boolean isError){
        if(isError){
            view.getSaveAlert().setContentText(alert);
            view.getSaveAlert().setAlertType(Alert.AlertType.WARNING);
        } else{
            view.getSaveAlert().setContentText("Comic saved succesfully:\n\n" + alert);
            view.getSaveAlert().setAlertType(Alert.AlertType.INFORMATION);
        }

        view.getSaveAlert().show();
    }

    private void handleDelButton(){
        view.getDelAlert().show();
    }
    private void handleInspectButton(){
        mainApplication.switchController(new ChapterController(mainApplication));
    }
    private void handleRatingSlider(){
        double ratingValue = view.getRatingSlider().getValue();
        view.getRatingViewLabel().setText(String.valueOf(ratingValue) + " ★");
    }

    @Override
    public View getView() {
        return view;
    }
}
