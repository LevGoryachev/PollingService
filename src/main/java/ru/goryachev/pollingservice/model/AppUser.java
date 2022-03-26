package ru.goryachev.pollingservice.model;

import javax.persistence.*;

/**
 * Модель сущности "Пользователь" (AppUser - т. к. в Spring Security есть класс User)
 * @author Lev Goryachev
 * @version 1.0
 */

@Entity
@Table (name = "app_user")
public class AppUser {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "app_user_id")
    private Long appUserId;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    /*@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "app_user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;*/


    public Long getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Long id) {
        this.appUserId = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public Set<Role> getRoles() {
        return roles;
    }*/

    /*public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }*/


}
