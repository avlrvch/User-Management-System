package ua.net.ums.enums;

public enum PageTypes {

    USERS_PAGE ("/pages/users.xhtml"),
    CREATE_USER_PAGE ("pages/create-user.xhtml"),
    EDIT_USER_PAGE ("pages/edit-user.xhtml");

    private String url;

    PageTypes(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}