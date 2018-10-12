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

    public LocalDateTime getDate() {
        return date;
    }

    public int getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public Review setText(String text) {
        this.text = text;
        return this;
    }

    public Review setRating(int rating) {
        if (0 > rating || rating > Review.LIMIT_RATING) {
            throw new IllegalArgumentException("Invalid rating" + rating);
        }
        this.rating = rating;
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Review setDate() {
        this.date = LocalDateTime.now();
        return this;
    }

    public Review setTitle(String title) {
        this.title = title;
        return this;
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

}
