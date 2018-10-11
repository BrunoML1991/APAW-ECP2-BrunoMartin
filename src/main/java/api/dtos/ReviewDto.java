package api.dtos;

import java.time.LocalDateTime;

public class ReviewDto implements Dto{


    private String id;
    private String title;
    private String text;
    private int rating;
    private LocalDateTime date;
    public static final int LIMIT_RATING = 10;

    public ReviewDto(String title, int rating) {
        this.title = title;
        this.rating = rating;
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

    public void setId(String id) {
        this.id = id;
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
