package api;

import api.apiControllers.ReviewApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.ReviewDto;
import api.dtos.ReviewResponseIdAndDateDto;
import http.Client;
import http.HttpRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ReviewIT extends RequestIT {

    private String createPath = ReviewApiController.REVIEWS;
    private String updatePath = ReviewApiController.REVIEWS + ReviewApiController.ID_ID;

    @BeforeAll
    static void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    @Test
    void testCreateReview() {
        this.checkOK(this.createPostRequest(createPath, new ReviewDto("Juego", 5)));
    }

    @Test
    void testCreateReviewWithoutReviewDto() {
        this.checkBAD_REQUEST(this.createPostRequest(createPath, null));
    }

    @Test
    void testCreateReviewWithoutTitle() {
        this.checkBAD_REQUEST(this.createPostRequest(createPath, new ReviewDto(null, 5)));
    }

    @Test
    void testCreateReviewRatingOutOfLimits() {
        this.checkBAD_REQUEST(this.createPostRequest(createPath, new ReviewDto("Juego", 11)));
    }

    @Test
    void testReviewInvalidRequest() {
        this.checkBAD_REQUEST(this.createPostRequest(createPath + "/invalid",
                new ReviewDto("Juego", 11)));
    }

    @Test
    void testUpdateReview() {
        this.checkOK(this.createUpdateRequest(updatePath, new ReviewDto("Game", 7)));
    }

    @Test
    void testUpdateReviewWithoutReviewDto() {
        this.checkBAD_REQUEST(this.createUpdateRequest(updatePath, null));
    }

    @Test
    void testUpdateReviewWithoutTitle() {
        this.checkBAD_REQUEST(this.createUpdateRequest(updatePath, new ReviewDto(null, 7)));
    }

    @Test
    void testUpdateReviewRatingOutOfLimits() {
        this.checkBAD_REQUEST(this.createUpdateRequest(updatePath, new ReviewDto("Game", -1)));
    }

    @Test
    void testUpdateInvalidRequest() {
        this.checkBAD_REQUEST(this.createUpdateRequest(updatePath + "/invalid", new ReviewDto("Game", 7)));
    }

    @Test
    void testUpdateReviewNotFound() {
        this.checkNOT_FOUND(this.createUpdateRequest(updatePath + "ass", new ReviewDto("Game", 7)));
    }

    private HttpRequest createUpdateRequest(String path, Object body) {
        ReviewResponseIdAndDateDto response = (ReviewResponseIdAndDateDto) new Client()
                .submit(this.createPostRequest(createPath, new ReviewDto("Juego", 5))).getBody();
        return HttpRequest.builder().path(path).expandPath(response.getId()).body(body).put();
    }

}