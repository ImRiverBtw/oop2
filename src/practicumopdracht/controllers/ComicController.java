package practicumopdracht.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import practicumopdracht.MainApplication;
import practicumopdracht.comparators.ComicRatingComparator;
import practicumopdracht.data.ComicDAO;
import practicumopdracht.models.Comic;
import practicumopdracht.views.ComicView;
import practicumopdracht.views.View;

import java.util.ArrayList;
import java.util.Optional;

public class ComicController extends Controller {
    private ComicDAO comicDAO;

    private ComicView view;
    private MainApplication mainApplication;
    private ObservableList<Comic> comicObservableList;
    private ArrayList<Comic> comics;
    private boolean sortOrder;

    public ComicController(MainApplication mainApplication) {
        comicDAO = MainApplication.getComicDAO();
        this.mainApplication = mainApplication;
        view = new ComicView();

        comics = comicDAO.getAll();
        comicObservableList = FXCollections.observableArrayList(comics);
        updateSorting();
        view.getComicList().setItems(comicObservableList);

        view.getComicList().setOnMouseClicked(mouseEvent -> handleComicList());
        view.getAddButton().setOnAction(actionEvent -> handleAddButton());
        view.getSaveButton().setOnAction(actionEvent -> handleSaveButton());
        view.getDelButton().setOnAction(actionEvent -> handleDelButton());
        view.getInspectButton().setOnAction(actionEvent -> handleInspectButton());
        view.getRatingSlider().setOnMouseReleased(mouseEvent -> handleRatingSlider());
        view.getSaveDAOButton().setOnAction(actionEvent -> handleSaveDAO());
        view.getLoadDAOButton().setOnAction(actionEvent -> {
            if (handleLoadDAO()){
                refreshComics();
                handleComicList();
            }
        });
        view.getCloseButton().setOnAction(actionEvent -> handleCloseButton());
        view.getSortAscending().setOnAction(actionEvent -> handleSort(true));
        view.getSortDescending().setOnAction(actionEvent -> handleSort(false));


    }

    private void handleSort(boolean isAscending){
        sortOrder = isAscending;
        updateSorting();
    }

    private void refreshComics(){
        comicObservableList.setAll(comics);
        view.getComicList().refresh();
        updateSorting();
    }
    private void updateSorting(){
        FXCollections.sort(view.getComicList().getItems(), new ComicRatingComparator(sortOrder));
    }

    private void handleComicList() {
        Comic comic = view.getComicList().getSelectionModel().getSelectedItem();
        if (comic == null){
            return;
        }
        System.out.println(comicDAO.getComicId(comic));
        view.getNameField().setText(comic.getName());
        view.getAuthorField().setText(comic.getAuthor());
        view.getRatingSlider().setValue(comic.getRating());
        view.getDescriptionArea().setText(comic.getDescription());
    }

    private void handleAddButton() {
        view.getComicList().getSelectionModel().clearSelection();
        view.getNameField().setText("");
        view.getAuthorField().setText("");
        view.getDescriptionArea().setText("");
        view.getRatingSlider().setValue(1.0);
        view.getAddAlert().show();
    }

    private void handleSaveButton() {
        boolean isValidName = !view.getNameField().getText().trim().isEmpty();
        boolean isValidAuthor = !view.getAuthorField().getText().trim().isEmpty();
        boolean isValidDescription = !view.getDescriptionArea().getText().trim().isEmpty();
        boolean isError = false;

        StringBuilder sb = new StringBuilder();
        sb.append("One ore more errors have occured while saving this Comic:\n \n");

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
            if (comic == null) {
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
            comicDAO.addOrUpdate(comic);
            updateSorting();
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
        if (comic == null) {
            return;
        }
        Optional<ButtonType> result = view.getDelAlert().showAndWait();
        if (result.get() == ButtonType.OK) {
            System.out.println("deleted");
            view.getComicList().getItems().remove(comic);
            comicDAO.remove(comic);
            MainApplication.getChapterDAO().getAllFor(comic).forEach(chapter -> MainApplication.getChapterDAO().remove(chapter));
        }
    }

    private void handleInspectButton() {
        Comic selectedComic = view.getComicList().getSelectionModel().getSelectedItem();
        if (selectedComic == null) {
            return;
        }
        MainApplication.setSelectedComic(selectedComic);
        MainApplication.switchController(new ChapterController(mainApplication));
    }

    private void handleRatingSlider() {
        double ratingValue = view.getRatingSlider().getValue();
        view.getRatingViewLabel().setText(ratingValue + " ★");
    }



    @Override
    public View getView() {
        return view;
    }

    @Override
    protected Alert getCloseAlert() {
        return view.getCloseAlert();
    }

    @Override
    protected Alert getSaveDAOAlert() {
        return view.getSaveDAOAlert();
    }

    @Override
    protected Alert getLoadDAOAlert() {
        return view.getLoadDAOAlert();
    }
}
