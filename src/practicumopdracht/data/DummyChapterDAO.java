package practicumopdracht.data;

import practicumopdracht.MainApplication;
import practicumopdracht.models.Chapter;
import java.time.LocalDate;
import java.time.Month;

public class DummyChapterDAO extends ChapterDAO {
    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean load() {
        ComicDAO comicDAO = MainApplication.getComicDAO();
        chapters.add(new Chapter(comicDAO.getById(0), "De cola van Adam", 1, LocalDate.now(), true));
        chapters.add(new Chapter(comicDAO.getById(0), "De melk van Adam", 2, LocalDate.now(), true));
        chapters.add(new Chapter(comicDAO.getById(1), "Peter Griffin vs The Simpsons", 1, LocalDate.of(1739, Month.SEPTEMBER, 4), true));
        System.out.println("chapterdao.load called");
        return true;

    }
}


