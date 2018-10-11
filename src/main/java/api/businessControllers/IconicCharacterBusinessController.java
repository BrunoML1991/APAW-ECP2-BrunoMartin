package api.businessControllers;

import api.daos.DaoFactory;
import api.dtos.IconicCharacterDto;
import api.entities.IconicCharacter;

public class IconicCharacterBusinessController {

    public String create(IconicCharacterDto iconicCharacterDto) {
        IconicCharacter iconicCharacter = new IconicCharacter(iconicCharacterDto.getName());
        iconicCharacter.setRole(iconicCharacterDto.getRole());
        DaoFactory.getFactory().getIconicCharacterDao().save(iconicCharacter);
        return iconicCharacter.getId();
    }

}
