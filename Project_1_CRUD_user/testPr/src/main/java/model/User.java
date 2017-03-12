package model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "login", unique = true)
    private String login;
    @Column(name = "password", unique = true)
    private String password;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "role")
    private String role;

    @SuppressWarnings("UnusedDeclaration")
    public User() {

    }
    @SuppressWarnings("UnusedDeclaration")
    public User(String login, String password, String name, String role) {
        this.setId(-1);
        this.setLogin(login);
        this.setPassword(password);
        this.setName(name);
        this.setRole(role);
    }
    @SuppressWarnings("UnusedDeclaration")
    public User(int id, String login, String password, String name, String role) {
        this.setId(id);
        this.setLogin(login);
        this.setPassword(password);
        this.setName(name);
        this.setRole(role);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
