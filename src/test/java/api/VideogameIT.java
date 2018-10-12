package api;

import api.apiControllers.VideogameApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.IconicCharacterDto;
import api.dtos.VideogameDto;
import http.Client;
import http.HttpRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VideogameIT extends RequestIT {

    IconicCharacterIT iconicCharacterIT = new IconicCharacterIT();
    private String createPath = VideogameApiController.VIDEOGAME;
    private String deletePath = VideogameApiController.VIDEOGAME + VideogameApiController.ID_ID;
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
        this.checkOK(this.createPostRequest(createPath, new VideogameDto("Odyssey", iconicCharacterId)));
    }

    @Test
    void testCreateVideogameWithoutReviewDto() {
        this.checkBAD_REQUEST(this.createPostRequest(createPath, null));
    }

    @Test
    void testCreateVideogameWithoutTitle() {
        this.checkBAD_REQUEST(this.createPostRequest(createPath, new VideogameDto(null, iconicCharacterId)));
    }

    @Test
    void testCreateVideogameWithoutIconicCharacter() {
        this.checkBAD_REQUEST(this.createPostRequest(createPath, new VideogameDto("Odyssey", null)));
    }

    @Test
    void testCreateVideogameWithoutIconicCharacterNotFound() {
        this.checkNOT_FOUND(this.createPostRequest(createPath, new VideogameDto("Odyssey", "ase")));
    }

    @Test
    void testVideogameInvalidRequest() {
        this.checkBAD_REQUEST(this.createPostRequest(createPath + "/invalid",
                new VideogameDto("Odyssey", iconicCharacterId)));
    }

    @Test
    void testDeleteVideogame() {
        this.checkOK(this.createDeleteRequest(this.createVideogame("Odyssey")));
    }

    @Test
    void testDeleteVideogameNotFound() {
        this.checkNOT_FOUND(this.createDeleteRequest("500"));
    }

    @Test
    void testGetAllVideogames (){
        this.createVideogame("Red Dead Redemption");
        this.createVideogame("Dark Souls");
        this.checkOK(this.createGetRequest());
    }

    @Test
    void testGetNotFound (){
        DaoFactory.setFactory(new DaoMemoryFactory());
        this.checkNOT_FOUND(this.createGetRequest());
    }

    protected HttpRequest createDeleteRequest(String path) {
        return HttpRequest.builder().path(deletePath).expandPath(path).delete();
    }

    protected HttpRequest createGetRequest (){
        return  HttpRequest.builder().path(createPath).get();
    }

    protected String createIconicCharacter(Object body) {
        return (String) new Client().submit(iconicCharacterIT.
                createPostRequest(iconicCharacterIT.getCreatePath(), body)).getBody();
    }

    protected String createVideogame(String title) {
        return (String) new Client().submit(this.createPostRequest(
                createPath, new VideogameDto(title, iconicCharacterId))).getBody();
    }

}
