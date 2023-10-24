package practicumopdracht.views;

import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import practicumopdracht.models.Chapter;
import practicumopdracht.models.Comic;

import java.util.Optional;

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
    private Alert backAlert;
    private Alert likedAlert;
    private Alert updateDateAlert;

    private TextField titleField;
    private TextField chapterField;

    @Override
    protected Parent initializeView() {
        VBox rootVbox = new VBox();
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


        return rootVbox;
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
}

