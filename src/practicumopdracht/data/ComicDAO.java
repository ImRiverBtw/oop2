package practicumopdracht.data;

import practicumopdracht.models.Comic;

import java.util.ArrayList;
import java.util.List;

public abstract class ComicDAO implements DAO<Comic>{

    protected List<Comic> comics;

    public ComicDAO(){
        comics = new ArrayList<>();
    }

    public Comic getById(int id){
        if (comics.get(id) == null){
            return null;
        }
        return comics.get(id);
    };

    @Override
    public List<Comic> getAll() {
        return comics;
    }

    @Override
    public void addOrUpdate(Comic object) {
        if(comics.contains(object)){
            return;
        }

        comics.add(object);
    }

    @Override
    public void remove(Comic object) {
        comics.remove (object);
    }

    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean load() {
        comics.add(new Comic("comic 1", 4.5, "Mark Rutte", "in een wereld"));
        comics.add(new Comic("comic 2", 4.5, "obama", "maar mensen zijn apen"));
        comics.add(new Comic("comic 3", 4.5, "dieuwertje", "vies bitter"));
        return true;
    }
}
