package api;

import api.apiControllers.ReviewApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.ReviewDto;
import api.dtos.ReviewResponseIdAndDateDto;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReviewIT {

    @BeforeAll
    static void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    @Test
    void testCreateReview() {
        this.createReview();
    }

    @Test
    void testCreateReviewWithoutReviewDto() {
        HttpRequest request = HttpRequest.builder().path(ReviewApiController.REVIEWS).body(null).post();
        this.checkBAD_REQUEST(request);
    }

    @Test
    void testCreateReviewWithoutTitle() {
        HttpRequest request = HttpRequest.builder().path(ReviewApiController.REVIEWS).body(new ReviewDto(null, 5)).post();
        this.checkBAD_REQUEST(request);
    }

    @Test
    void testCreateReviewRatingOutOfLimits() {
        HttpRequest request = HttpRequest.builder().path(ReviewApiController.REVIEWS).body(new ReviewDto("Juego", 11)).post();
        this.checkBAD_REQUEST(request);
    }

    @Test
    void testUserInvalidRequest() {
        HttpRequest request = HttpRequest.builder().path(ReviewApiController.REVIEWS + "/invalid").body(null).post();
        this.checkBAD_REQUEST(request);
    }

    @Test
    void testUpdateReview() {
        ReviewResponseIdAndDateDto response = this.createReview();
        HttpRequest request = HttpRequest.builder().path(ReviewApiController.REVIEWS).path(ReviewApiController.ID_ID)
                .expandPath(response.getId()).body(new ReviewDto("Game", 7)).put();
        new Client().submit(request).getBody();
    }

    @Test
    void testUpdateReviewWithoutReviewDto() {
        ReviewResponseIdAndDateDto response = this.createReview();
        HttpRequest request = HttpRequest.builder().path(ReviewApiController.REVIEWS).path(ReviewApiController.ID_ID)
                .expandPath(response.getId()).body(null).put();
        this.checkBAD_REQUEST(request);
    }

    @Test
    void testUpdateReviewWithoutTitle() {
        ReviewResponseIdAndDateDto response = this.createReview();
        HttpRequest request = HttpRequest.builder().path(ReviewApiController.REVIEWS).path(ReviewApiController.ID_ID)
                .expandPath(response.getId()).body(new ReviewDto(null, 7)).put();
        this.checkBAD_REQUEST(request);
    }

    @Test
    void testUpdateReviewRatingOutOfLimits() {
        ReviewResponseIdAndDateDto response = this.createReview();
        HttpRequest request = HttpRequest.builder().path(ReviewApiController.REVIEWS).path(ReviewApiController.ID_ID)
                .expandPath(response.getId()).body(new ReviewDto("Game", -1)).put();
        this.checkBAD_REQUEST(request);
    }

    @Test
    void testUpdateInvalidRequest() {
        ReviewResponseIdAndDateDto response = this.createReview();
        HttpRequest request = HttpRequest.builder().path(ReviewApiController.REVIEWS + "/invalid").path(ReviewApiController.ID_ID)
                .expandPath(response.getId()).body(new ReviewDto("Game", 7)).put();
        this.checkBAD_REQUEST(request);
    }

    @Test
    void testUpdateReviewNotFound() {
        HttpRequest request = HttpRequest.builder().path(ReviewApiController.REVIEWS).path(ReviewApiController.ID_ID)
                .expandPath("asdfa").body(new ReviewDto("Game", 7)).put();
        this.checkNOT_FOUND(request);
    }

    private ReviewResponseIdAndDateDto createReview() {
        HttpRequest request = HttpRequest.builder().path(ReviewApiController.REVIEWS).body(new ReviewDto("Juego", 5)).post();
        return (ReviewResponseIdAndDateDto) new Client().submit(request).getBody();
    }

    private void checkBAD_REQUEST(HttpRequest request) {
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    private void checkNOT_FOUND(HttpRequest request) {
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
    }

}