package api.entities;

import java.time.LocalDateTime;

public class Review {

    private String id;
    private String title;
    private String text;
    private int rating;
    private LocalDateTime date;
    public static final int LIMIT_RATING = 10;

    public Review(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public int getRating() {
        return rating;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", rating=" + rating +
                ", date=" + date +
                '}';
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRating(int rating) {
        if (0 > rating || rating > Review.LIMIT_RATING) {
            throw new IllegalArgumentException("Invalid rating" + rating);
        }
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDate() {
        this.date = LocalDateTime.now();
    }

}
