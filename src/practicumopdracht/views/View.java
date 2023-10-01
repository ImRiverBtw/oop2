package practicumopdracht.views;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class View {
    private Parent root;

    public View() {
        this.root = initializeView();
    }

    protected Parent initializeView(){
        return null;
    }

    public Parent getRoot(){
        return this.root;
    }
}
