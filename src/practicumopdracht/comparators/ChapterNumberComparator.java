package practicumopdracht.comparators;

import practicumopdracht.models.Chapter;

import java.util.Comparator;

public class ChapterNumberComparator implements Comparator<Chapter> {
    private boolean isAscending;

    public ChapterNumberComparator(boolean isAscending){
        this.isAscending = isAscending;
    }

    @Override
    public int compare(Chapter o1, Chapter o2) {

        int a = Integer.compare(o1.getChapterNumber(), o2.getChapterNumber());

        if (!isAscending) {
            a = -a;
        }
        return a;
    }
}
