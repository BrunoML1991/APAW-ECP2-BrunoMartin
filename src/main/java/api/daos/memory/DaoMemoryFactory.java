package api.daos.memory;

import api.daos.DaoFactory;
import api.daos.ReviewDao;

public class DaoMemoryFactory extends DaoFactory {

    private ReviewDao reviewDao;

    @Override
    public ReviewDao getReviewDao() {
        if (reviewDao == null) {
            reviewDao = new ReviewDaoMemory();
        }
        return reviewDao;
    }
}
