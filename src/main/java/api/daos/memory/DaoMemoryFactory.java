package api.daos.memory;

import api.daos.DaoFactory;
import api.daos.IconicCharacterDao;
import api.daos.ReviewDao;

public class DaoMemoryFactory extends DaoFactory {

    private ReviewDao reviewDao;
    private IconicCharacterDao iconicCharacterDao;

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
            iconicCharacterDao = new IconicCharacterMemory();
        }
        return iconicCharacterDao;
    }
}
