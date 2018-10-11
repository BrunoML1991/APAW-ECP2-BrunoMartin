package api.businessControllers;

import api.daos.DaoFactory;
import api.dtos.VideogameDto;
import api.entities.Videogame;
import api.exceptions.NotFoundException;

public class VideogameBusinessController {

    public String create(VideogameDto videogameDto) {
        Videogame videogame = new Videogame(videogameDto.getTitle());
        videogame.setIconicCharacter(DaoFactory.getFactory().getIconicCharacterDao().read(videogameDto.getIconicCharacterId())
                .orElseThrow(() -> new NotFoundException("User id: " + videogameDto.getIconicCharacterId())));
        videogame.setSynopsis(videogameDto.getSynopsis()).setCompany(videogameDto.getCompany())
                .setCategory(videogameDto.getCategory());
        DaoFactory.getFactory().getVideogameDao().save(videogame);
        return videogame.getId();
    }

}
