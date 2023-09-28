package practicumopdracht.models;

import java.time.LocalDate;

public class Chapter {
    private Comic belongsTo;
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
}
