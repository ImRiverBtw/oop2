package practicumopdracht.data;

import practicumopdracht.models.Comic;

public class DummyComicDAO extends ComicDAO{

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

