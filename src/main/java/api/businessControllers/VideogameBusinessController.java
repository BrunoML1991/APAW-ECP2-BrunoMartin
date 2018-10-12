package api.businessControllers;

import api.daos.DaoFactory;
import api.dtos.VideogameDto;
import api.dtos.VideogameResponseIdAndTitle;
import api.entities.Videogame;
import api.exceptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class VideogameBusinessController {

    public String create(VideogameDto videogameDto) {
        Videogame videogame = new Videogame(videogameDto.getTitle());
        videogame.setIconicCharacter(DaoFactory.getFactory().getIconicCharacterDao().read(videogameDto.getIconicCharacterId())
                .orElseThrow(() -> new NotFoundException("Videogame id: " + videogameDto.getIconicCharacterId())));
        videogame.setSynopsis(videogameDto.getSynopsis()).setCompany(videogameDto.getCompany())
                .setCategory(videogameDto.getCategory());
        DaoFactory.getFactory().getVideogameDao().save(videogame);
        return videogame.getId();
    }

    public void delete(String id) {
        Videogame videogame = DaoFactory.getFactory().getVideogameDao().read(id).
                orElseThrow(() -> new NotFoundException("Videogame id: " + id));
        DaoFactory.getFactory().getVideogameDao().deleteById(videogame.getId());
    }

    public List<VideogameResponseIdAndTitle> readAll (){
        List<VideogameResponseIdAndTitle> videogameResponseIdAndTitleList = DaoFactory.getFactory().getVideogameDao().findAll().stream().map(
                videogame -> new VideogameResponseIdAndTitle(videogame.getId(),videogame.getTitle())
        ).collect(Collectors.toList());
        if(videogameResponseIdAndTitleList.isEmpty()){
             throw new NotFoundException("No videogame found");
        }
        return videogameResponseIdAndTitleList;
    }

}
