package api.dtos;

import java.time.LocalDateTime;

public class ReviewResponseIdAndDateDto {

    private String id;
    private LocalDateTime date;

    public ReviewResponseIdAndDateDto(String id, LocalDateTime date) {
        this.id = id;
        this.date = date;
    }

    @Override
    public String toString() {
        return "ReviewResponseIdAndDateDto{" +
                "id='" + id + '\'' +
                ", date=" + date +
                '}';
    }
}
