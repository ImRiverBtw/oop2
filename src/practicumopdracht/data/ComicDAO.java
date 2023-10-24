package practicumopdracht.data;

import practicumopdracht.models.Comic;

import java.util.ArrayList;
import java.util.List;

public abstract class ComicDAO implements DAO<Comic> {

    protected ArrayList<Comic> comics;

    public ComicDAO() {
        comics = new ArrayList<>();
    }

    public Comic getById(int id) {
        if (comics.get(id) == null) {
            return null;
        }
        return comics.get(id);
    }

    ;

    @Override
    public ArrayList<Comic> getAll() {
        return comics;
    }

    @Override
    public void addOrUpdate(Comic model) {
        if (comics.contains(model)) {
            return;
        }

        comics.add(model);
    }

    @Override
    public void remove(Comic model) {
        if (!comics.contains(model)) {
            return;
        }
        comics.remove(model);
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
