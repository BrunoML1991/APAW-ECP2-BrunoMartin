package api.daos.memory;

import api.daos.VideogameDao;
import api.entities.Videogame;

import java.util.HashMap;

public class VideogameDaoMemory extends GenericDaoMemory<Videogame> implements VideogameDao {

    public VideogameDaoMemory() {
        super(new HashMap<>());
    }

    @Override
    public String getId(Videogame entity) {
        return entity.getId();
    }

    @Override
    public void setId(Videogame entity, String id) {
        entity.setId(id);
    }

}
