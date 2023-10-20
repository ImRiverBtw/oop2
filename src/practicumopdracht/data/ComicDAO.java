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
        return false;
    }
}
