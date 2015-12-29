package ua.net.ums.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User extends AbstractUser implements Serializable {

    public static enum Status{
        MARRIED, NOT_MARRIED
    }

    @Column(name = "numbers")
    private String phoneNumber;

    @Column(name = "emails")
    private String eMail;

    @Column(name = "statuses")
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public User() {
    }

    public User(String name, String surname, String phoneNumber, String eMail) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        if (eMail != null ? !eMail.equals(user.eMail) : user.eMail != null) return false;
        return status == user.status;

    }

    @Override
    public int hashCode() {
        int result = phoneNumber != null ? phoneNumber.hashCode() : 0;
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

}
