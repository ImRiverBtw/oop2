package practicumopdracht.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import practicumopdracht.MainApplication;
import practicumopdracht.models.Comic;
import practicumopdracht.views.ComicView;
import practicumopdracht.views.View;
import java.util.ArrayList;

public class ComicController extends Controller {

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
//        ArrayList<Comic> comics = (ArrayList<Comic>) MainApplication.getComicDAO().getAll();
        ArrayList<Comic> comics = new ArrayList<>();
        comics.add(new Comic("comic 1", 4.5, "Mark Rutte", "in een wereld"));
        comics.add(new Comic("comic 2", 4.5, "obama", "maar mensen zijn apen"));
        comics.add(new Comic("comic 3", 4.5, "dieuwertje", "vies bitter"));
        ObservableList<Comic> comicObservableList = FXCollections.observableArrayList(comics);
        view.getComicList().setItems(comicObservableList);
    }

    private void handleAddButton() {
        view.getNameField().setText("");
        view.getAuthorField().setText("");
        view.getDescriptionArea().setText("");
        view.getRatingSlider().setValue(1.0);
        view.getComicList().getSelectionModel().clearSelection();
        view.getAddAlert().show();
    }

    private void handleSaveButton() {
        boolean isValidName = !view.getNameField().getText().trim().isEmpty();
        boolean isValidAuthor = !view.getAuthorField().getText().trim().isEmpty();
        boolean isValidDescription = !view.getDescriptionArea().getText().trim().isEmpty();
        boolean isError = false;

        StringBuilder sb = new StringBuilder();
        sb.append("One ore more errors have occured while saving this Chapter:\n \n");

        if (!isValidName) {
            sb.append("-Field \"Name\" can not be empty! \n");
            isError = true;
        }
        if (!isValidAuthor) {
            sb.append("-Field \"Author\" can not be empty! \n");
            isError = true;
        }
        if (!isValidDescription) {
            sb.append("-Field \"Description\" can not be empty! \n");
            isError = true;
        }

        String alert;
        if (!isError) {
            String name = view.getNameField().getText();
            double rating = view.getRatingSlider().getValue();
            String author = view.getAuthorField().getText();
            String description = view.getDescriptionArea().getText();
            Comic comic = view.getComicList().getSelectionModel().getSelectedItem();
            if (comic == null){
                comic = new Comic(name, rating, author, description);
                view.getComicList().getItems().add(comic);
            } else {
                comic.setAuthor(author);
                comic.setRating(rating);
                comic.setName(name);
                comic.setDescription(description);
                view.getComicList().refresh();
            }

            alert = comic.toString();


        } else {
            alert = sb.toString();
        }

        throwSafeAlert(alert, isError);
    }

    private void throwSafeAlert(String alert, boolean isError) {
        if (isError) {
            view.getSaveAlert().setContentText(alert);
            view.getSaveAlert().setAlertType(Alert.AlertType.WARNING);
        } else {
            view.getSaveAlert().setContentText("Comic saved succesfully:\n\n" + alert);
            view.getSaveAlert().setAlertType(Alert.AlertType.INFORMATION);
        }

        view.getSaveAlert().show();
    }

    private void handleDelButton() {
        Comic comic = view.getComicList().getSelectionModel().getSelectedItem();
        if (comic == null){
            return;
        } else{
            view.getComicList().getItems().remove(comic);
            view.getDelAlert().show();
        }

    }

    private void handleInspectButton() {
        mainApplication.switchController(new ChapterController(mainApplication));
    }

    private void handleRatingSlider() {
        double ratingValue = view.getRatingSlider().getValue();
        view.getRatingViewLabel().setText(String.valueOf(ratingValue) + " ★");
    }

    @Override
    public View getView() {
        return view;
    }
}
