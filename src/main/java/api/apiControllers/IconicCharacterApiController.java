package api.apiControllers;

import api.businessControllers.IconicCharacterBusinessController;
import api.dtos.Dto;
import api.dtos.IconicCharacterDto;

public class IconicCharacterApiController extends ValidatorApiController {

    public static final String ICONIC_CHARACTER = "/iconicCharacters";

    private IconicCharacterBusinessController iconicCharacterBusinessController = new IconicCharacterBusinessController();

    public String create(IconicCharacterDto iconicCharacterDto) {
        this.validateDto(iconicCharacterDto);
        return iconicCharacterBusinessController.create(iconicCharacterDto);
    }

    protected void validateDto(Dto dto) {
        IconicCharacterDto iconicCharacterDto = (IconicCharacterDto) dto;
        this.validateNotNull(iconicCharacterDto, "iconicCharacterDto");
        this.validateNotNull(iconicCharacterDto.getName(), "name");
    }

}
