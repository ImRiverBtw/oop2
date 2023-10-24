package practicumopdracht.data;

import java.util.List;

public interface DAO<T> {

    public List<T> getAll();

    void addOrUpdate(T model);

    public void remove(T model);


    public boolean save();

    public boolean load();
}
