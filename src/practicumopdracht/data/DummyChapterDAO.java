package practicumopdracht.data;

import practicumopdracht.models.Chapter;

public class DummyChapterDAO extends ChapterDAO{
    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean load() {
        chapters.add(new Chapter())
    }
}


