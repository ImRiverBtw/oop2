package practicumopdracht.models;

public class Comic {
    private String name;
    private double rating;
    private String author;
    private String description;

    public Comic(String name, double rating, String author, String description) {
        this.name = name;
        this.rating = rating;
        this.author = author;
        this.description = description;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(""+"");

        return sb.toString();
    };

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
