package practicumopdracht.views;

import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import practicumopdracht.models.Chapter;
import practicumopdracht.models.Comic;

public class ChapterView extends View {
    @Override
    protected Parent initializeView(){
        VBox rootVbox = new VBox();
        HBox comboContainer = new HBox();
        Label comicName = new Label("Select Comic:");
        ComboBox<Comic> comicSelector= new ComboBox<>();
        comboContainer.getChildren().addAll(comicName, comicSelector);

        HBox chapterEditor = new HBox();
        VBox chapterList = new VBox();
        ListView<Chapter> chapterListView = new ListView<>();
        Button addChptButton = new Button("Add Chapter");
        chapterList.getChildren().addAll(chapterListView, addChptButton);
        VBox chapterInfo = new VBox();

        HBox titleContainer = new HBox();
        Label titleLabel = new Label("Chapter Title:");
        TextField titleField = new TextField();
        titleContainer.getChildren().addAll(titleLabel, titleField);

        HBox chapterContainer = new HBox();
        Label chapterLabel = new Label("Chapter Nr:");
        TextField chapterField = new TextField();
        chapterContainer.getChildren().addAll(chapterLabel, chapterField);

        VBox releaseDateContainer = new VBox();
        Label dateLabel = new Label("Release Date:");
        DatePicker releaseDatePicker = new DatePicker();
        releaseDateContainer.getChildren().addAll(dateLabel, releaseDatePicker);

        HBox likedContainer = new HBox();
        Label likedLabel = new Label("Like This Chapter");
        CheckBox likedBox = new CheckBox();
        likedContainer.getChildren().addAll(likedLabel, likedBox);

        GridPane buttonContainer = new GridPane();
        Button saveChapter = new Button("Safe Chapter");
        Button deleteChapter = new Button("Delete");
        Button backButton = new Button("Back to Comic List");
        buttonContainer.add(saveChapter, 0, 0, 1, 1);
        buttonContainer.add(deleteChapter, 1, 0, 1, 1);
        buttonContainer.add(backButton, 2, 1, 1, 1);

        chapterInfo.getChildren().addAll(titleContainer, chapterContainer, releaseDateContainer, likedContainer, buttonContainer);
        chapterEditor.getChildren().addAll(chapterList, chapterInfo);




        rootVbox.getChildren().addAll(comboContainer, chapterEditor);

        return rootVbox;
    }
}

