package api.apiControllers;

import api.businessControllers.ReviewBusinessController;
import api.dtos.ReviewDto;
import api.exceptions.ArgumentNotValidException;

public class ReviewApiController {

    public static final String REVIEWS = "/reviews";
    public static final String ID_ID = "/{id}";

    private ReviewBusinessController reviewBusinessController = new ReviewBusinessController();

    public Object create(ReviewDto reviewDto) {
        this.validateReviewDto(reviewDto);
        return reviewBusinessController.create(reviewDto);
    }

    public Object update(String id, ReviewDto reviewDto) {
        this.validateReviewDto(reviewDto);
        return reviewBusinessController.update(id, reviewDto);
    }

    private void validateReviewDto(ReviewDto reviewDto) {
        this.validateNotNull(reviewDto, "reviewDto");
        this.validateNotNull(reviewDto.getTitle(), "title");
        this.validateNotNull(reviewDto.getRating(), "rating");
        this.validateRatingLimits(reviewDto.getRating());
    }

    private void validateNotNull(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is NULL");
        }
    }

    private void validateRatingLimits(int rating) {
        if (0 > rating || rating > ReviewDto.LIMIT_RATING) {
            throw new IllegalArgumentException("Invalid rating " + rating);
        }
    }

}
