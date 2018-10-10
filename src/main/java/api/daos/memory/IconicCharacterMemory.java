package api.daos.memory;

import api.daos.IconicCharacterDao;
import api.entities.IconicCharacter;

import java.util.HashMap;

public class IconicCharacterMemory extends GenericDaoMemory<IconicCharacter> implements IconicCharacterDao {

    public IconicCharacterMemory() {
        super(new HashMap<>());
    }

    @Override
    public String getId(IconicCharacter entity) {
        return entity.getId();
    }

    @Override
    public void setId(IconicCharacter entity, String id) {
        entity.setId(id);
    }

}
