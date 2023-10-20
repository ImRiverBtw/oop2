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
        chapters.add(new Chapter(comicDAO.getById(0), "De tiet van Adam", 1, LocalDate.now(), true));
        chapters.add(new Chapter(comicDAO.getById(0), "De melk van Adam", 2, LocalDate.now(), true));
        chapters.add(new Chapter(comicDAO.getById(1), "Peter Griffin vs The Nazi's", 1, LocalDate.of(1739, Month.SEPTEMBER, 4), true));

       return true;

    }
}


