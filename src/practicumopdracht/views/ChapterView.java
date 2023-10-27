package practicumopdracht.views;

import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import practicumopdracht.models.Chapter;
import practicumopdracht.models.Comic;

public class ChapterView extends View {

    private Button addChptButton;
    private Button saveChapter;
    private Button deleteChapter;
    private Button backButton;
    private CheckBox likedBox;
    private DatePicker releaseDatePicker;
    private ComboBox<Comic> comicSelector;
    private ListView<Chapter> chapterListView;

    private Alert addAlert;
    private Alert saveAlert;
    private Alert deleteAlert;
    private Alert closeAlert;

    private Alert saveDAOAlert;
    private Alert loadDAOAlert;
    private Alert backAlert;
    private Alert likedAlert;
    private Alert updateDateAlert;

    private TextField titleField;
    private TextField chapterField;
    //MenuItem Declaration
    private MenuItem saveDAOButton;
    private MenuItem loadDAOButton;
    private MenuItem closeButton;

    private ToggleGroup sortGroup;

    @Override
    protected Parent initializeView() {
        BorderPane rootBorderPane = new BorderPane();
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");
        saveDAOButton = new MenuItem("Save");
        loadDAOButton = new MenuItem("Load");
        closeButton = new MenuItem("Close Application");
        fileMenu.getItems().addAll(saveDAOButton, loadDAOButton, closeButton);
        menuBar.getMenus().add(fileMenu);
        rootBorderPane.setTop(menuBar);

        HBox bottomHbox = new HBox();
        Label sortLabel = new Label("Sorting method:");

        sortGroup = new ToggleGroup();
        RadioButton sortNrAscending = new RadioButton("Number ascending");
        sortNrAscending.setUserData(1);
        sortNrAscending.setToggleGroup(sortGroup);
        sortNrAscending.setSelected(true);

        RadioButton sortNrDescending = new RadioButton("Number descending");
        sortNrDescending.setUserData(2);
        sortNrDescending.setToggleGroup(sortGroup);

        RadioButton sortDateAscending = new RadioButton("Date ascending");
        sortDateAscending.setUserData(3);
        sortDateAscending.setToggleGroup(sortGroup);

        RadioButton sortDateDescending = new RadioButton("Date descending");
        sortDateDescending.setUserData(4);
        sortDateDescending.setToggleGroup(sortGroup);

        bottomHbox.getChildren().addAll(sortLabel, sortNrAscending, sortNrDescending, sortDateAscending, sortDateDescending);
        rootBorderPane.setBottom(bottomHbox);

        VBox rootVbox = new VBox();
        rootBorderPane.setCenter(rootVbox);

        HBox comboContainer = new HBox();
        Label comicName = new Label("Select Comic:");
        comicSelector = new ComboBox<>();
        comboContainer.getChildren().addAll(comicName, comicSelector);

        HBox chapterEditor = new HBox();
        VBox chapterList = new VBox();
        chapterListView = new ListView<>();
        addChptButton = new Button("Add Chapter");
        chapterList.getChildren().addAll(chapterListView, addChptButton);
        VBox chapterInfo = new VBox();

        HBox titleContainer = new HBox();
        Label titleLabel = new Label("Chapter Title:");
        titleField = new TextField();
        titleContainer.getChildren().addAll(titleLabel, titleField);

        HBox chapterContainer = new HBox();
        Label chapterLabel = new Label("Chapter Nr:");
        chapterField = new TextField();
        chapterContainer.getChildren().addAll(chapterLabel, chapterField);

        VBox releaseDateContainer = new VBox();
        Label dateLabel = new Label("Release Date:");
        releaseDatePicker = new DatePicker();
        releaseDateContainer.getChildren().addAll(dateLabel, releaseDatePicker);

        HBox likedContainer = new HBox();
        Label likedLabel = new Label("Like This Chapter");
        likedBox = new CheckBox();
        likedContainer.getChildren().addAll(likedLabel, likedBox);

        GridPane buttonContainer = new GridPane();
        saveChapter = new Button("Safe Chapter");
        deleteChapter = new Button("Delete");
        backButton = new Button("Back to Comic List");
        buttonContainer.add(saveChapter, 0, 0, 1, 1);
        buttonContainer.add(deleteChapter, 1, 0, 1, 1);
        buttonContainer.add(backButton, 2, 1, 1, 1);

        chapterInfo.getChildren().addAll(titleContainer, chapterContainer, releaseDateContainer, likedContainer, buttonContainer);
        chapterEditor.getChildren().addAll(chapterList, chapterInfo);

        rootVbox.getChildren().addAll(comboContainer, chapterEditor);

        addAlert = new Alert(Alert.AlertType.INFORMATION);
        addAlert.setContentText("add button clicked");

        saveAlert = new Alert(Alert.AlertType.INFORMATION);
        saveAlert.setContentText("save button clicked");

        deleteAlert = new Alert(Alert.AlertType.WARNING, "Are you sure that you want to delete this Chapter?", ButtonType.OK, ButtonType.CANCEL);
        deleteAlert.setTitle("Delete Chapter Warning");


        backAlert = new Alert(Alert.AlertType.INFORMATION);
        backAlert.setContentText("back button clicked");

        likedAlert = new Alert(Alert.AlertType.INFORMATION);
        likedAlert.setContentText("checkbox (un)ticked");

        updateDateAlert = new Alert(Alert.AlertType.INFORMATION);
        updateDateAlert.setContentText("date updated");

        closeAlert = new Alert(Alert.AlertType.WARNING,
                "If you close now all unsaved changes will be lost.\nDo you want to save before closing the application?",
                ButtonType.YES,
                ButtonType.NO);
        closeAlert.setTitle("Close application");

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

    public Button getAddChptButton() {
        return addChptButton;
    }

    public Button getSaveChapter() {
        return saveChapter;
    }

    public Button getDeleteChapter() {
        return deleteChapter;
    }

    public Button getBackButton() {
        return backButton;
    }

    public CheckBox getLikedBox() {
        return likedBox;
    }

    public DatePicker getReleaseDatePicker() {
        return releaseDatePicker;
    }

    public ComboBox<Comic> getComicSelector() {
        return comicSelector;
    }

    public ListView<Chapter> getChapterListView() {
        return chapterListView;
    }

    public Alert getAddAlert() {
        return addAlert;
    }

    public Alert getSaveAlert() {
        return saveAlert;
    }

    public Alert getDeleteAlert() {
        return deleteAlert;
    }

    public Alert getBackAlert() {
        return backAlert;
    }

    public Alert getLikedAlert() {
        return likedAlert;
    }

    public Alert getUpdateDateAlert() {
        return updateDateAlert;
    }

    public TextField getTitleField() {
        return titleField;
    }

    public TextField getChapterField() {
        return chapterField;
    }

    public Alert getCloseAlert() {
        return closeAlert;
    }

    public Alert getSaveDAOAlert() {
        return saveDAOAlert;
    }

    public Alert getLoadDAOAlert() {
        return loadDAOAlert;
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

    public ToggleGroup getSortGroup() {
        return sortGroup;
    }
}

