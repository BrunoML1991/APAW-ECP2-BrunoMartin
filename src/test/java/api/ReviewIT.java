package api;

import api.apiControllers.ReviewApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.ReviewDto;
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
        HttpRequest request = HttpRequest.builder().path(ReviewApiController.REVIEWS).body(new ReviewDto("Juego", 5)).post();
        new Client().submit(request).getBody();
    }

    @Test
    void testCreateReviewWithoutUserDto() {
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

    private void checkBAD_REQUEST(HttpRequest request) {
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

}