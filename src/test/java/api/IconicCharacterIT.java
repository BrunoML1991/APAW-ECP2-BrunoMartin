package api;

import api.apiControllers.IconicCharacterApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.IconicCharacterDto;
import http.Client;
import http.HttpRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class IconicCharacterIT {

    @BeforeAll
    static void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    @Test
    void testCreateReview() {
        this.createIconicCharacter();
    }

    private String createIconicCharacter() {
        HttpRequest request = HttpRequest.builder().path(IconicCharacterApiController.ICONIC_CHARACTER)
                .body(new IconicCharacterDto("Super Mario")).post();
        return (String) new Client().submit(request).getBody();
    }

}
