package practicumopdracht.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import practicumopdracht.Main;
import practicumopdracht.MainApplication;
import practicumopdracht.data.ChapterDAO;
import practicumopdracht.data.ComicDAO;
import practicumopdracht.data.DummyChapterDAO;
import practicumopdracht.models.Chapter;
import practicumopdracht.models.Comic;
import practicumopdracht.views.ChapterView;
import practicumopdracht.views.View;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Optional;

public class ChapterController extends Controller {
    private ChapterDAO chapterDAO;
    private ComicDAO comicDAO;

    private ChapterView view;
    private MainApplication mainApplication;


    public ChapterController(MainApplication mainApplication) {
        chapterDAO = MainApplication.getChapterDAO();
        comicDAO = MainApplication.getComicDAO();
        this.mainApplication = mainApplication;
        view = new ChapterView();

        view.getComicSelector().setOnAction(actionEvent -> refreshChapters());
        view.getChapterListView().setOnMouseClicked(mouseEvent -> handleChapterListView());
        view.getAddChptButton().setOnAction(actionEvent -> handleAddButton());
        view.getSaveChapter().setOnAction(actionEvent -> handleSaveButton());
        view.getDeleteChapter().setOnAction(actionEvent -> handleDelButton());
        view.getBackButton().setOnAction(actionEvent -> handleBackButton());
        view.getLikedBox().setOnAction(actionEvent -> handleLikedBox());
        view.getReleaseDatePicker().setOnAction(actionEvent -> handleDatePicker());
        view.getSaveDAOButton().setOnAction(actionEvent -> handleSaveDAO());
        view.getLoadDAOButton().setOnAction(actionEvent -> handleLoadDAO());
        view.getCloseButton().setOnAction(actionEvent -> handleCloseButton());


        ArrayList<Comic> comics = comicDAO.getAll();
        comics.forEach(comic -> view.getComicSelector().getItems().add(comic));
        view.getComicSelector().setValue(MainApplication.getSelectedComic());
        refreshChapters();

    }

    private void refreshChapters() {
        ArrayList<Chapter> chapters = chapterDAO.getAllFor(view.getComicSelector().getValue());
        ObservableList<Chapter> chapterObservableList = FXCollections.observableArrayList(chapters);
        view.getChapterListView().setItems(chapterObservableList);
    }


    private void handleChapterListView() {
        Chapter chapter = view.getChapterListView().getSelectionModel().getSelectedItem();
        view.getTitleField().setText(chapter.getTitle());
        view.getChapterField().setText(String.valueOf(chapter.getChapterNumber()));
        view.getLikedBox().setSelected(chapter.isLiked());
        view.getReleaseDatePicker().setValue(chapter.getReleaseDate());
        view.getComicSelector().setValue(chapter.getBelongsTo());
    }

    private void handleAddButton() {
        view.getChapterListView().getSelectionModel().clearSelection();
        view.getTitleField().setText("");
        view.getReleaseDatePicker().setValue(null);
        view.getLikedBox().setSelected(false);
        view.getChapterField().setText("");
        view.getComicSelector().setValue(null);
    }

    private void handleDelButton() {
        Chapter chapter = view.getChapterListView().getSelectionModel().getSelectedItem();
        if (chapter == null) {
            return;
        }
        Optional<ButtonType> result = view.getDeleteAlert().showAndWait();
        if (result.get() == ButtonType.OK) {
            System.out.println("deleted");
            view.getChapterListView().getItems().remove(chapter);
            chapterDAO.remove(chapter);
        }
    }

    private void handleSaveButton() {
        boolean isValidTitle = !view.getTitleField().getText().trim().isEmpty();
        boolean isValidDate = view.getReleaseDatePicker().getValue() != null && view.getReleaseDatePicker().getValue().isBefore(LocalDate.now());
        String chapterNr = view.getChapterField().getText();
        int intValue = 0;
        boolean isError = false;

        StringBuilder sb = new StringBuilder();
        sb.append("One ore more errors have occured while saving this Chapter:\n \n");

        if (!isValidTitle) {
            sb.append("-Field \"Title\" can not be empty! \n");
            isError = true;
        }
        if (!isValidDate) {
            sb.append("-Release date is empty or contains a date in the future!\n");
            isError = true;
        }

        try {
            intValue = Integer.parseInt(chapterNr);

        } catch (NumberFormatException e) {
            sb.append("-Chapter number must be a valid integer!\n");
            isError = true;

        }
        String alert;
        if (!isError) {
            String title = view.getTitleField().getText();
            LocalDate releaseDate = view.getReleaseDatePicker().getValue();
            boolean isLiked = view.getLikedBox().isSelected();
            Chapter chapter = view.getChapterListView().getSelectionModel().getSelectedItem();
            Comic selectedComic = view.getComicSelector().getValue();
            if (chapter == null) {
                chapter = new Chapter(selectedComic, title, intValue, releaseDate, isLiked);
                view.getChapterListView().getItems().add(chapter);
            } else {
                chapter.setChapterNumber(intValue);
                chapter.setTitle(title);
                chapter.setReleaseDate(releaseDate);
                chapter.setLiked(isLiked);
            }
            chapterDAO.addOrUpdate(chapter);
            alert = chapter.toString();
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
            view.getSaveAlert().setContentText("Chapter saved succesfully:\n\n" + alert);
            view.getSaveAlert().setAlertType(Alert.AlertType.INFORMATION);
        }
        view.getSaveAlert().show();
    }

    private void handleBackButton() {
        MainApplication.switchController(new ComicController(mainApplication));
    }

    private void handleDatePicker() {

    }

    private void handleLikedBox() {

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

    @Override
    public View getView() {
        return view;
    }
}
