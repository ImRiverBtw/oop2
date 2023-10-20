package practicumopdracht.controllers;

import javafx.scene.control.Alert;
import practicumopdracht.Main;
import practicumopdracht.MainApplication;
import practicumopdracht.models.Chapter;
import practicumopdracht.models.Comic;
import practicumopdracht.views.ChapterView;
import practicumopdracht.views.View;

import java.time.LocalDate;

public class ChapterController extends Controller{

    private ChapterView view;
    private MainApplication mainApplication;

    private Comic testComic = new Comic("testcomic", 4.5, "Barack Obama", "blablabla...");

    public ChapterController(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
        view = new ChapterView();

        view.getAddChptButton().setOnAction(actionEvent -> handleAddButton());
        view.getSaveChapter().setOnAction(actionEvent -> handleSaveButton());
        view.getDeleteChapter().setOnAction(actionEvent -> handleDelButton());
        view.getBackButton().setOnAction(actionEvent -> handleBackButton());
        view.getLikedBox().setOnAction(actionEvent -> handleLikedBox());
        view.getReleaseDatePicker().setOnAction(actionEvent -> handleDatePicker());
    }



    public void handleAddButton(){
        view.getAddAlert().show();
    }

    public void handleDelButton(){
        view.getDeleteAlert().show();
    }

    public void handleSaveButton(){
        boolean isValidTitle = !view.getTitleField().getText().trim().isEmpty();
        boolean isValidDate = view.getReleaseDatePicker().getValue() != null && view.getReleaseDatePicker().getValue().isBefore(LocalDate.now());
        String chapterNr = view.getChapterField().getText();
        int intValue =0;
        boolean isError = false;

        StringBuilder sb = new StringBuilder();
        sb.append("One ore more errors have occured while saving this Chapter:\n \n");

        if (!isValidTitle){
            sb.append("-Field \"Title\" can not be empty! \n");
            isError = true;
        }
        if(!isValidDate){
            sb.append("-Release date is empty or contains a date in the future!\n");
            isError = true;
        }

        try{
        intValue = Integer.parseInt(chapterNr);

        }catch(NumberFormatException e){
            sb.append("-Chapter number must be a valid integer!\n");
            isError = true;

        }
        String alert;
        if(!isError){
            String title = view.getTitleField().getText();
            LocalDate releaseDate = view.getReleaseDatePicker().getValue();
            boolean isLiked = view.getLikedBox().isSelected();

            Chapter savedChapter = new Chapter(testComic, title, intValue, releaseDate, isLiked);
            alert = savedChapter.toString();
            view.getTitleField().setText("");
            view.getReleaseDatePicker().setValue(null);
            view.getLikedBox().setSelected(false);
            view.getChapterField().setText("");
            view.getComicSelector().setValue(null);

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
            view.getSaveAlert().setContentText("Chapter saved succesfully:\n\n" + alert);
            view.getSaveAlert().setAlertType(Alert.AlertType.INFORMATION);
        }

        view.getSaveAlert().show();
    }

    public void handleBackButton(){
        mainApplication.switchController(new ComicController(mainApplication));
    }

    public void handleDatePicker(){
        view.getUpdateDateAlert().show();
    }

    public void handleLikedBox(){
        view.getLikedAlert().show();
    }

    @Override
    public View getView() {
        return view;
    }
}
