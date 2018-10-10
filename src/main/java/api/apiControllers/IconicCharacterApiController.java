package api.apiControllers;

import api.businessControllers.IconicCharacterBusinessController;
import api.dtos.IconicCharacterDto;
import api.exceptions.ArgumentNotValidException;

public class IconicCharacterApiController {

    public static final String ICONIC_CHARACTER = "/iconicCharacters";

    private IconicCharacterBusinessController iconicCharacterBusinessController = new IconicCharacterBusinessController();

    public String create(IconicCharacterDto iconicCharacterDto) {
        this.validateReviewDto(iconicCharacterDto);
        return iconicCharacterBusinessController.create(iconicCharacterDto);
    }

    private void validateReviewDto(IconicCharacterDto iconicCharacterDto) {
        this.validateNotNull(iconicCharacterDto, "iconicCharacterDto");
        this.validateNotNull(iconicCharacterDto.getName(), "name");
    }

    private void validateNotNull(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is NULL");
        }
    }

}
