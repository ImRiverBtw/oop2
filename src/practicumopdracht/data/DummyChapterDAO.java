package practicumopdracht.data;

import practicumopdracht.MainApplication;
import practicumopdracht.models.Chapter;
import practicumopdracht.models.Comic;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class DummyChapterDAO extends ChapterDAO{
    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean load() {
        ComicDAO comicDAO = MainApplication.getComicDAO();


       return true;

    }
}


