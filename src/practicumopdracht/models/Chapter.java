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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("From: " + belongsTo.getName() + "\n");
        sb.append("Title: " + title + "\n");
        sb.append("Chapter:" + chapterNumber + "\n");
        sb.append("releasedate: " + releaseDate.toString() + "\n");
        sb.append("Liked: " + isLiked);

        return sb.toString();
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
};
