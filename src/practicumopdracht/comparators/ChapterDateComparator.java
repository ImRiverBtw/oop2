package practicumopdracht.comparators;

import practicumopdracht.models.Chapter;

import java.util.Comparator;

public class ChapterDateComparator implements Comparator<Chapter> {
    private final boolean isAscending;

    public ChapterDateComparator(boolean isAscending) {
        this.isAscending = isAscending;
    }

    @Override
    public int compare(Chapter o1, Chapter o2) {

        int a = o1.getReleaseDate().compareTo(o2.getReleaseDate());
        if (!isAscending) {
            a = -a;
        }

        if (a == 0) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
        return a;
    }
}
