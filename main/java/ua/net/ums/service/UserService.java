package ua.net.ums.service;

import ua.net.ums.dao.UserDao;
import ua.net.ums.model.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UserService {

    @EJB
    UserDao userDao;

    public void create(User user){
        userDao.create(user);
    }

    public void remove(User user){
        userDao.remove(user);
    }

    public User findById(Long id){
        return userDao.findById(id);
    }

    public void update(User user){
        userDao.update(user);
    }

    public List<User> getAll(){
        return userDao.getAll();
    }

}
