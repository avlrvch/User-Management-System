package ua.net.ums.dao;

import ua.net.ums.model.User;

import javax.ejb.Local;

@Local
public interface UserDao extends GenericDao<User> {
}
