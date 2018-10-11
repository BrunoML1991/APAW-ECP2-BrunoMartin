package api.apiControllers;

import api.businessControllers.ReviewBusinessController;
import api.dtos.Dto;
import api.dtos.ReviewDto;

public class ReviewApiController extends ValidatorApiController {

    public static final String REVIEWS = "/reviews";
    public static final String ID_ID = "/{id}";

    private ReviewBusinessController reviewBusinessController = new ReviewBusinessController();

    public Object create(ReviewDto reviewDto) {
        this.validateDto(reviewDto);
        return reviewBusinessController.create(reviewDto);
    }

    public Object update(String id, ReviewDto reviewDto) {
        this.validateDto(reviewDto);
        return reviewBusinessController.update(id, reviewDto);
    }

    protected void validateDto(Dto dto) {
        ReviewDto reviewDto = (ReviewDto) dto;
        this.validateNotNull(reviewDto, "reviewDto");
        this.validateNotNull(reviewDto.getTitle(), "title");
        this.validateNotNull(reviewDto.getRating(), "rating");
        this.validateRatingLimits(reviewDto.getRating());
    }

    private void validateRatingLimits(int rating) {
        if (0 > rating || rating > ReviewDto.LIMIT_RATING) {
            throw new IllegalArgumentException("Invalid rating " + rating);
        }
    }

}
