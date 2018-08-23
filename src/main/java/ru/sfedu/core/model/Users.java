package ru.sfedu.core.model;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

/**
 *
 * @author sergei
 */
@Entity
@Table
public class Users implements Serializable {

    private long id;
    private String username;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private String token;
    private Permission permission; 

    public Users() {
    }

    public Users(String username) {
        this.username = username;
    }
    
    public Users(String username, String surname, String email, String password) {
        this.username = username;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }
    
    @Enumerated(EnumType.ORDINAL)
    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    @Transient
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    @Column (name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "password" + password  + " email " + email  + " фамилия " + surname + " телефон " + phone +"Token" + token;
    }

}
