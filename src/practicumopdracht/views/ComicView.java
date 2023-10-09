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

    @Override
    protected Parent initializeView() {
        HBox rootHbox = new HBox();

        VBox comicListContainer = new VBox();
        Label listLabel = new Label("Comic List:");
        ListView<Comic> comicList = new ListView<>();
        Button addButton = new Button("Add Comic");
        comicListContainer.getChildren().addAll(listLabel, comicList, addButton);

        VBox infoContainer = new VBox();
        HBox nameContainer = new HBox();
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Button chapterButton = new Button("Check Chapters");
        nameContainer.getChildren().addAll(nameLabel, nameField);

        Label ratingLabel = new Label("Rating:");
        HBox ratingContainer = new HBox();

        //configures slider
        Slider ratingSlider = new Slider(1, 5, 3);
        ratingSlider.setShowTickMarks(true);
        ratingSlider.setShowTickLabels(true);
        ratingSlider.setMajorTickUnit(1.0f);
        ratingSlider.setMinorTickCount(1);
        ratingSlider.setSnapToTicks(true);
        ratingContainer.getChildren().addAll(ratingSlider);

        HBox authorContainer = new HBox();
        Label authorLabel = new Label("Author:");
        TextField authorField = new TextField();
        authorContainer.getChildren().addAll(authorLabel, authorField);

        Label descriptionLabel = new Label("Description:");
        TextArea descriptionArea = new TextArea();

        HBox buttonContainer = new HBox();
        Button saveButton = new Button("Save");
        Button delButton = new Button("Delete");
        Button inspectButton = new Button("Inspect Chapters");
        buttonContainer.getChildren().addAll(delButton, saveButton, inspectButton);

        infoContainer.getChildren().addAll(nameContainer, ratingLabel, ratingContainer, authorContainer, descriptionLabel, descriptionArea, buttonContainer);

        rootHbox.getChildren().addAll(comicListContainer, infoContainer);

        return rootHbox;
    }
}
