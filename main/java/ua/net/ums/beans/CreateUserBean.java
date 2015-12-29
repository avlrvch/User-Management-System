package ua.net.ums.beans;

import ua.net.ums.enums.PageTypes;
import ua.net.ums.model.User;
import ua.net.ums.service.UserService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "createUser")
public class CreateUserBean {

    private final String MARRIED_STATUS_VALUE = User.Status.MARRIED.toString();

    private String name;
    private String surname;
    private String number;
    private String eMail;
    private String status;

    @EJB
    UserService userService;

    public String createUser(){
        User user = new User(name,surname,number,eMail);
        if (status.equalsIgnoreCase(MARRIED_STATUS_VALUE)){
            user.setStatus(User.Status.MARRIED);
        } else {
            user.setStatus(User.Status.NOT_MARRIED);
        }

        userService.create(user);
        return PageTypes.USERS_PAGE.getUrl();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
