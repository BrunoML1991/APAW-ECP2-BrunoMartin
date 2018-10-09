package api.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReviewTest {

    private Review review;

    @BeforeEach
    void beforeEach() {
        review = new Review("My review");
    }

    @Test
    void testSetRatingFail() {
        assertThrows(IllegalArgumentException.class, () -> review.setRating(12));
    }

    @Test
    void testSetRatingPass() {
        assertDoesNotThrow(() -> review.setRating(5));
    }

}
