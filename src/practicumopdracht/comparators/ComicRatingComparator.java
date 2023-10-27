package practicumopdracht.comparators;

import practicumopdracht.models.Comic;

import java.util.Comparator;

public class ComicRatingComparator implements Comparator<Comic> {
    private boolean isAscending;
    public ComicRatingComparator(boolean isAscending){
        this.isAscending = isAscending;
    }

    @Override
    public int compare(Comic o1, Comic o2) {

        int a = Double.compare(o1.getRating(), o2.getRating());
        if (!isAscending){
            a = -a;
        }

        if(a==0){
            String comicName1 = o1.getName();
            String comicName2 = o1.getName();
            return comicName1.compareTo(comicName2);
        }
        return a;
    }
}
