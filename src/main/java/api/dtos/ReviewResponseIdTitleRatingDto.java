package api.dtos;

import api.entities.Review;

public class ReviewResponseIdTitleRatingDto {

    private String id;
    private String title;
    private int rating;

    public ReviewResponseIdTitleRatingDto(Review review) {
        this.id = review.getId();
        this.title = review.getTitle();
        this.rating = review.getRating();
    }

    @Override
    public String toString() {
        return "ReviewResponseIdTitleRatingDto{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                '}';
    }
}
