package api;

import api.apiControllers.VideogameApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.IconicCharacterDto;
import api.dtos.VideogameDto;
import http.Client;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VideogameIT extends RequestIT {

    IconicCharacterIT iconicCharacterIT = new IconicCharacterIT();
    private String videogamePath = VideogameApiController.VIDEOGAME;
    private String iconicCharacterId;

    @BeforeAll
    static void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    @BeforeEach
    void beforeEach() {
        iconicCharacterId = this.createIconicCharacter(new IconicCharacterDto("Super Mario"));
    }

    @Test
    void testCreateVideogame() {
        this.checkOK(this.createPostRequest(videogamePath, new VideogameDto("Odyssey", iconicCharacterId)));
    }

    protected String createIconicCharacter(Object body) {
        return (String) new Client().submit(iconicCharacterIT.
                createPostRequest(iconicCharacterIT.getCreatePath(), body)).getBody();
    }

}
