package practicumopdracht.data;

import practicumopdracht.models.Comic;

import java.util.List;

public interface DAO<T> {

    public List<T> getAll();

    void addOrUpdate(T object);

    public void remove(T object);


    public boolean save();

    public boolean load();
}
