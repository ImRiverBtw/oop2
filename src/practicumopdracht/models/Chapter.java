package practicumopdracht.models;

import java.io.Serializable;
import java.time.LocalDate;

public class Chapter implements Serializable {
    private final transient Comic belongsTo;
    private String title;
    private int chapterNumber;
    private LocalDate releaseDate;
    private boolean isLiked;

    public Chapter(Comic belongsTo, String title, int chapterNumber, LocalDate releaseDate, boolean isLiked) {
        this.belongsTo = belongsTo;
        this.title = title;
        this.chapterNumber = chapterNumber;
        this.releaseDate = releaseDate;
        this.isLiked = isLiked;
    }

    @Override
    public String toString() {
        return String.format("Title: %s\nChapter: %d\nRelease date: %s\nLiked: %b", title, chapterNumber, releaseDate.toString(), isLiked);
    }

    public Comic getBelongsTo() {
        return belongsTo;
    }

    public String getTitle() {
        return title;
    }

    public int getChapterNumber() {
        return chapterNumber;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setChapterNumber(int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }
}
