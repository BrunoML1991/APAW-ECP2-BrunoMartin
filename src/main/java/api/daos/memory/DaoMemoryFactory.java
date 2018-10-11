package api.daos.memory;

import api.daos.DaoFactory;
import api.daos.IconicCharacterDao;
import api.daos.ReviewDao;
import api.daos.VideogameDao;

public class DaoMemoryFactory extends DaoFactory {

    private ReviewDao reviewDao;
    private IconicCharacterDao iconicCharacterDao;
    private VideogameDao videogameDao;

    @Override
    public ReviewDao getReviewDao() {
        if (reviewDao == null) {
            reviewDao = new ReviewDaoMemory();
        }
        return reviewDao;
    }

    @Override
    public IconicCharacterDao getIconicCharacterDao() {
        if (iconicCharacterDao == null) {
            iconicCharacterDao = new IconicCharacterDaoMemory();
        }
        return iconicCharacterDao;
    }

    @Override
    public VideogameDao getVideogameDao() {
        if (videogameDao == null) {
            videogameDao = new VideogameDaoMemory();
        }
        return videogameDao;
    }
}
