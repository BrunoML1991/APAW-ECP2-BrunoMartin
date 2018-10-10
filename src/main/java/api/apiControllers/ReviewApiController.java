package api.apiControllers;

import api.businessControllers.ReviewBusinessController;
import api.dtos.ReviewDto;
import api.exceptions.ArgumentNotValidException;

public class ReviewApiController {

    public static final String REVIEWS = "/reviews";

    private ReviewBusinessController reviewBusinessController = new ReviewBusinessController();

    public Object create(ReviewDto reviewDto) {
        this.validate(reviewDto, "reviewDto");
        this.validate(reviewDto.getTitle(), "title");
        this.validate(reviewDto.getRating(), "rating");
        this.validateRating(reviewDto.getRating());
        return reviewBusinessController.create(reviewDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is NULL");
        }
    }

    private void validateRating(int rating) {
        if (0 > rating || rating > ReviewDto.LIMIT_RATING) {
            throw new IllegalArgumentException("Invalid rating " + rating);
        }
    }

}
