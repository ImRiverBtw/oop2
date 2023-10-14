package practicumopdracht.views;

import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import practicumopdracht.models.Comic;

public class ComicView extends View {
    public ComicView() {
        super();
    }

    //Button declaration
    private Button addButton;
    private Slider ratingSlider;
    private Button saveButton;
    private Button delButton;
    private Button inspectButton;

    //Text input declaration
    private TextField nameField;
    private TextField authorField;
    private TextArea descriptionArea;

    //Alert declaration;
    private Alert addAlert;
    private Alert ratingAlert;
    private Alert saveAlert;
    private Alert delAlert;
    private Alert inspectAlert;

    //Misc declaration;
    private Label ratingViewLabel;
    private ListView<Comic> comicList;

    //View contents
    @Override
    protected Parent initializeView() {
        HBox rootHbox = new HBox();

        VBox comicListContainer = new VBox();
        Label listLabel = new Label("Comic List:");
        comicList = new ListView<>();
        addButton = new Button("Add Comic");
        comicListContainer.getChildren().addAll(listLabel, comicList, addButton);

        VBox infoContainer = new VBox();
        HBox nameContainer = new HBox();
        Label nameLabel = new Label("Name:");
        nameField = new TextField();
        nameContainer.getChildren().addAll(nameLabel, nameField);

        Label ratingLabel = new Label("Rating:");
        HBox ratingContainer = new HBox();

        //configures slider
        ratingSlider = new Slider(1, 5, 1);
        ratingSlider.setShowTickMarks(true);
        ratingSlider.setShowTickLabels(true);
        ratingSlider.setMajorTickUnit(1.0f);
        ratingSlider.setMinorTickCount(1);
        ratingSlider.setSnapToTicks(true);
        ratingViewLabel = new Label("1.0 ★");
        ratingContainer.getChildren().addAll(ratingSlider, ratingViewLabel);

        HBox authorContainer = new HBox();
        Label authorLabel = new Label("Author:");
        authorField = new TextField();
        authorContainer.getChildren().addAll(authorLabel, authorField);

        Label descriptionLabel = new Label("Description:");
        descriptionArea = new TextArea();

        HBox buttonContainer = new HBox();
        saveButton = new Button("Save");
        delButton = new Button("Delete");
        inspectButton = new Button("Inspect Chapters");
        buttonContainer.getChildren().addAll(delButton, saveButton, inspectButton);

        infoContainer.getChildren().addAll(nameContainer, ratingLabel, ratingContainer, authorContainer, descriptionLabel, descriptionArea, buttonContainer);

        rootHbox.getChildren().addAll(comicListContainer, infoContainer);

        addAlert = new Alert(Alert.AlertType.INFORMATION);
        addAlert.setContentText("add button clicked");

        ratingAlert = new Alert(Alert.AlertType.INFORMATION);
        ratingAlert.setContentText("rating adjusted");

        saveAlert = new Alert(Alert.AlertType.INFORMATION);
        saveAlert.setContentText("save button clicked");

        delAlert = new Alert(Alert.AlertType.INFORMATION);
        delAlert.setContentText("delete button clicked");
        inspectAlert = new Alert(Alert.AlertType.INFORMATION);
        inspectAlert.setContentText("inspect button clicked");

        return rootHbox;
    }

    //Button getters
    public Button getAddButton() {
        return addButton;
    }

    public Slider getRatingSlider() {
        return ratingSlider;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getDelButton() {
        return delButton;
    }

    public Button getInspectButton() {
        return inspectButton;
    }

    //Text field getters
    public TextField getNameField() {
        return nameField;
    }

    public TextField getAuthorField() {
        return authorField;
    }

    public TextArea getDescriptionArea() {
        return descriptionArea;
    }

    //Alert getters

    public Alert getAddAlert() {
        return addAlert;
    }

    public Alert getRatingAlert() {
        return ratingAlert;
    }

    public Alert getSaveAlert() {
        return saveAlert;
    }

    public Alert getDelAlert() {
        return delAlert;
    }

    public Alert getInspectAlert() {
        return inspectAlert;
    }

    //Misc getters

    public Label getRatingViewLabel() {
        return ratingViewLabel;
    }

    public ListView<Comic> getComicList() {
        return comicList;
    }
}
