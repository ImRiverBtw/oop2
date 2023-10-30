package practicumopdracht.data;

import practicumopdracht.models.Chapter;
import practicumopdracht.models.Comic;
import java.util.ArrayList;

public abstract class ChapterDAO implements DAO<Chapter> {

    protected ArrayList<Chapter> chapters;

    public ChapterDAO() {
        chapters = new ArrayList<>();
    }

    public ArrayList<Chapter> getAllFor(Comic model) {
        ArrayList<Chapter> sortedChapters = new ArrayList<>();
        chapters.forEach(chapter -> {
            if (chapter.getBelongsTo().equals(model)) {
                sortedChapters.add(chapter);
            }
        });
        return sortedChapters;
    }

    @Override
    public ArrayList<Chapter> getAll() {
        return chapters;
    }

    @Override
    public void addOrUpdate(Chapter model) {
        if (chapters.contains(model)) {
            return;
        }
        chapters.add(model);
    }

    @Override
    public void remove(Chapter model) {
        if (!chapters.contains(model)) {
            return;
        }
        chapters.remove(model);
    }

    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean load() {
        return false;
    }
}
