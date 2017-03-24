package AbstractFactory;

import dao.UserDaoHibeImpl;
import service.UserServiceHibeImpl;
import util.ConnectionHibe;

public class HibeFactoryImpl implements AbstractFactory{

    @Override
    public ConnectionHibe getConnect() {
        return new ConnectionHibe();
    }

    @Override
    public UserDaoHibeImpl getUserDao() {
        return new UserDaoHibeImpl(getConnect());
    }

    @Override
    public UserServiceHibeImpl getDbService() {
        return new UserServiceHibeImpl(getUserDao());
    }
}