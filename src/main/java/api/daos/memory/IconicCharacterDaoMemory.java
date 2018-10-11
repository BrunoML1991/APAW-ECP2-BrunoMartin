package api.daos.memory;

import api.daos.IconicCharacterDao;
import api.entities.IconicCharacter;

import java.util.HashMap;

public class IconicCharacterDaoMemory extends GenericDaoMemory<IconicCharacter> implements IconicCharacterDao {

    public IconicCharacterDaoMemory() {
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
