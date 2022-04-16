package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements  IMetier{
    /*
     * Couplage faible
     */
    @Autowired
    public IDao dao;
    @Override
    public double calcule() {
        double d = dao.getData();
        double res = d*23;
        return res;
    }

    public IDao getDao() {
        return dao;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
