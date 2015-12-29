package ua.net.ums.dao.impl;

import ua.net.ums.dao.UserDao;
import ua.net.ums.model.User;

import javax.ejb.Stateless;

@Stateless
public class UserJpaDao extends JpaDao<User> implements UserDao {
}
