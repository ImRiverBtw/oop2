package practicumopdracht.data;

import practicumopdracht.models.Chapter;
import practicumopdracht.models.Comic;

import java.util.List;
import java.util.stream.Collectors;

public class ChapterDAO implements DAO<Chapter>{

    protected List<Chapter> chapters;

    public List<Chapter> getAllFor(Comic object) {
        return chapters.stream().filter(chapter -> chapter.getBelongsTo().equals(object))
                .collect(Collectors.toList());
    }

    @Override
    public List<Chapter> getAll() {
        return chapters;
    }

    @Override
    public void addOrUpdate(Chapter object) {
        if(chapters.contains(object)){
            return;
        }

        chapters.add(object);
    }

    @Override
    public void remove(Chapter object) {
        chapters.remove(object);
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
