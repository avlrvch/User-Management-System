package ua.net.ums.beans;

import ua.net.ums.enums.PageTypes;
import ua.net.ums.model.User;
import ua.net.ums.service.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean(name = "editUser")
public class EditUserBean {

    private String changedStatus;
    private User user;

    @EJB
    UserService userService;

    @PostConstruct
    public void doInit(){
        user = userService.findById(retrieveUserId());
    }

    private Long retrieveUserId() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        return Long.valueOf(externalContext.getRequestParameterMap().get("userId"));
    }

    public String updateUser(){
        updateStatus();
        userService.update(user);
        return PageTypes.USERS_PAGE.getUrl();
    }

    private void updateStatus(){
        if (changedStatus.equalsIgnoreCase(User.Status.MARRIED.toString())){
            user.setStatus(User.Status.MARRIED);
        } else {
            user.setStatus(User.Status.NOT_MARRIED);
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getChangedStatus() {
        return changedStatus;
    }

    public void setChangedStatus(String changedStatus) {
        this.changedStatus = changedStatus;
    }
}
