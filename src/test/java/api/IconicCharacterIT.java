package api;

import api.apiControllers.IconicCharacterApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.IconicCharacterDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class IconicCharacterIT extends RequestIT {

    private String createPath = IconicCharacterApiController.ICONIC_CHARACTER;

    @BeforeAll
    static void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    @Test
    void testCreateIconicCharacter() {
        this.checkOK(this.createPostRequest(createPath, new IconicCharacterDto("Super Mario")));
    }

    @Test
    void testCreateIconicCharacterWithoutIconicCharacterDto() {
        this.checkBAD_REQUEST(this.createPostRequest(createPath, null));
    }

    @Test
    void testCreateIconicCharacterWithoutName() {
        this.checkBAD_REQUEST(this.createPostRequest(createPath, new IconicCharacterDto(null)));
    }

    @Test
    void testIconicCharacterInvalidRequest() {
        this.checkBAD_REQUEST(this.createPostRequest(createPath + "/invalid",
                new IconicCharacterDto("Super Mario")));
    }

}
