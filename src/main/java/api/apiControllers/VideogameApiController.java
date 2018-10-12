package api.apiControllers;

import api.businessControllers.VideogameBusinessController;
import api.dtos.Dto;
import api.dtos.VideogameDto;
import api.dtos.VideogameResponseIdAndTitle;
import api.entities.Category;

import java.util.List;

public class VideogameApiController extends ValidatorApiController {

    private VideogameBusinessController videogameBusinessController = new VideogameBusinessController();

    public static final String VIDEOGAME = "/videogames";
    public static final String ID_ID = "/{id}";
    public static final String CATEGORY = "/category";

    public String create(VideogameDto videogameDto) {
        this.validateDto(videogameDto);
        return videogameBusinessController.create(videogameDto);
    }

    public void delete(String id) {
        videogameBusinessController.delete(id);
    }

    public List<VideogameResponseIdAndTitle> readAll() {
        return videogameBusinessController.readAll();
    }

    public void updateCategory (String id, Category category){
        this.validateNotNull(category,"category");
        videogameBusinessController.updateCategory(id,category);
    }

    @Override
    protected void validateDto(Dto dto) {
        VideogameDto videogameDto = (VideogameDto) dto;
        this.validateNotNull(videogameDto, "videogameDto");
        this.validateNotNull(videogameDto.getTitle(), "title");
        this.validateNotNull(videogameDto.getIconicCharacterId(), "iconicCharacterId");
    }

}
