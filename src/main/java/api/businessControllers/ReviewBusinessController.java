package api.businessControllers;

import api.daos.DaoFactory;
import api.dtos.ReviewDto;
import api.dtos.ReviewResponseIdAndDateDto;
import api.dtos.ReviewResponseIdTitleRatingDto;
import api.entities.Review;
import api.exceptions.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewBusinessController {

    public Object create(ReviewDto reviewDto) {
        Review review = new Review(reviewDto.getTitle());
        review.setRating(reviewDto.getRating()).setText(reviewDto.getText()).setDate();
        DaoFactory.getFactory().getReviewDao().save(review);
        return new ReviewResponseIdAndDateDto(review.getId(), review.getDate());
    }

    public LocalDateTime update(String id, ReviewDto reviewDto) {
        Review review = DaoFactory.getFactory().getReviewDao().read(id).orElseThrow(() -> new NotFoundException("User id: " + id));
        review.setTitle(reviewDto.getTitle()).setRating(reviewDto.getRating()).setText(reviewDto.getText()).setDate();
        DaoFactory.getFactory().getReviewDao().save(review);
        return review.getDate();
    }

    public List<ReviewResponseIdTitleRatingDto> findByRatingGreaterThanEqual(int ratingGoal) {
        return DaoFactory.getFactory().getReviewDao().findAll().stream()
                .filter(review -> review.getRating() >= ratingGoal).map(ReviewResponseIdTitleRatingDto::new)
                .collect(Collectors.toList());
    }

}
