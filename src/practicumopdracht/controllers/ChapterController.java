package practicumopdracht.controllers;

import practicumopdracht.Main;
import practicumopdracht.MainApplication;
import practicumopdracht.views.ChapterView;
import practicumopdracht.views.View;

public class ChapterController extends Controller{

    private ChapterView view;
    private MainApplication mainApplication;

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
