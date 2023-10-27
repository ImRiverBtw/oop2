package practicumopdracht.views;

import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
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
//    private Alert ratingAlert;
    private Alert saveAlert;
    private Alert closeAlert;
    private Alert delAlert;
    private Alert saveDAOAlert;
    private Alert loadDAOAlert;
//    private Alert inspectAlert;

    //Misc declaration;
    private Label ratingViewLabel;
    private ListView<Comic> comicList;

    //MenuItem Declaration
    private MenuItem saveDAOButton;
    private MenuItem loadDAOButton;
    private MenuItem closeButton;

    private MenuItem sortAscending;
    private MenuItem sortDescending;

    //View contents
    @Override
    protected Parent initializeView() {
        BorderPane rootBorderPane = new BorderPane();
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");
        saveDAOButton = new MenuItem("Save");
        loadDAOButton = new MenuItem("Load");
        closeButton = new MenuItem("Close Application");
        fileMenu.getItems().addAll(saveDAOButton, loadDAOButton, closeButton);

        Menu sortMenu = new Menu("sort");
        sortAscending = new MenuItem("Rating (Ascending)");
        sortDescending = new MenuItem("Ratubg (Descending)");
        sortMenu.getItems().addAll(sortAscending, sortDescending);

        menuBar.getMenus().addAll(fileMenu, sortMenu);
        rootBorderPane.setTop(menuBar);



        HBox rootHbox = new HBox();
        rootBorderPane.setCenter(rootHbox);

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
//
//        ratingAlert = new Alert(Alert.AlertType.INFORMATION);
//        ratingAlert.setContentText("rating adjusted");
//
        saveAlert = new Alert(Alert.AlertType.INFORMATION);
        saveAlert.setContentText("save button clicked");

        closeAlert = new Alert(Alert.AlertType.WARNING,
                "If you close now all unsaved changes will be lost.\nDo you want to save before closing the application?",
                ButtonType.YES,
                ButtonType.NO);
        closeAlert.setTitle("Close application");

        delAlert = new Alert(Alert.AlertType.WARNING,
                "Are you sure that you want to delete this comic?",
                ButtonType.OK,
                ButtonType.CANCEL);
        delAlert.setTitle("Delete Comic");
//        inspectAlert = new Alert(Alert.AlertType.INFORMATION);
//        inspectAlert.setContentText("inspect button clicked");

        saveDAOAlert = new Alert(Alert.AlertType.WARNING,
                "Are you sure that you want to save?",
                ButtonType.YES,
                ButtonType.NO);
        saveDAOAlert.setTitle("Save to DAO");

        loadDAOAlert = new Alert(Alert.AlertType.WARNING,
                "Are you sure that you want to load?",
                ButtonType.YES,
                ButtonType.NO);
        loadDAOAlert.setTitle("Load from DAO");

        return rootBorderPane;
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
//
//    public Alert getRatingAlert() {
//        return ratingAlert;
//    }
//
    public Alert getSaveAlert() {
        return saveAlert;
    }

    public Alert getDelAlert() {
        return delAlert;
    }

    public Alert getCloseAlert() {
        return closeAlert;
    }
    //    public Alert getInspectAlert() {
//        return inspectAlert;
//    }

    public Alert getSaveDAOAlert() {
        return saveDAOAlert;
    }

    public Alert getLoadDAOAlert() {
        return loadDAOAlert;
    }


    //Misc getters

    public Label getRatingViewLabel() {
        return ratingViewLabel;
    }

    public ListView<Comic> getComicList() {
        return comicList;
    }

    public MenuItem getSaveDAOButton() {
        return saveDAOButton;
    }

    public MenuItem getLoadDAOButton() {
        return loadDAOButton;
    }

    public MenuItem getCloseButton() {
        return closeButton;
    }

    public MenuItem getSortAscending() {
        return sortAscending;
    }

    public MenuItem getSortDescending() {
        return sortDescending;
    }
}

