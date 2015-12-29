package ua.net.ums.beans;

import ua.net.ums.model.User;
import ua.net.ums.service.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Collection;
import java.util.List;

@ViewScoped
@ManagedBean(name = "usersPage")
public class UserPageBean {

    private List<User> users;

    @EJB
    UserService userService;

    @PostConstruct
    public void doInit(){
        users = userService.getAll();
    }

    public void deleteUser(User user){
        userService.remove(user);
        users = userService.getAll();
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
