package api.dtos;

import java.time.LocalDateTime;

public class ReviewResponseIdAndDateDto implements Dto{

    private String id;
    private LocalDateTime date;

    public ReviewResponseIdAndDateDto(String id, LocalDateTime date) {
        this.id = id;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ReviewResponseIdAndDateDto{" +
                "id='" + id + '\'' +
                ", date=" + date +
                '}';
    }
}
