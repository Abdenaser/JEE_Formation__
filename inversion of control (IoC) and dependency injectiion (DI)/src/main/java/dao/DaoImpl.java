package dao;

import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImpl implements IDao{
    @Override
    public double getData() {

        /*
         * je me conncet a la bd
         */

        double data = 100;
        return data;
    }
}
