package practicumopdracht.controllers;

import javafx.scene.control.Alert;
import practicumopdracht.views.ComicView;
import practicumopdracht.views.View;

public class ComicController extends Controller{

    private ComicView view;
    public ComicController() {
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
        view.getSaveAlert().show();
    }

    private void handleDelButton(){
        view.getDelAlert().show();
    }
    private void handleInspectButton(){
        view.getInspectAlert().show();
    }
    private void handleRatingSlider(){
        view.getRatingAlert().show();
    }

    @Override
    public View getView() {
        return view;
    }
}
