package practicumopdracht.controllers;

import practicumopdracht.views.ChapterView;
import practicumopdracht.views.View;

public class ChapterController extends Controller{

    private ChapterView view;

    public ChapterController() {
        view = new ChapterView();
    }

    @Override
    public View getView() {
        return view;
    }
}
