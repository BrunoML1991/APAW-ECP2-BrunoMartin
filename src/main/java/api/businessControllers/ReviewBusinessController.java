package api.businessControllers;

import api.daos.DaoFactory;
import api.dtos.ReviewDto;
import api.dtos.ReviewResponseIdAndDateDto;
import api.entities.Review;

public class ReviewBusinessController {

    public Object create (ReviewDto reviewDto){
        Review review = new Review(reviewDto.getTitle());
        review.setRating(reviewDto.getRating()).setText(reviewDto.getText()).setDate();
        DaoFactory.getFactory().getReviewDao().save(review);
        return new ReviewResponseIdAndDateDto(review.getId(),review.getDate());
    }

}
