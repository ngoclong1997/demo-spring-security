package com.drato.demospringsecurity.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user", schema = "public")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(
            name="user_seq",
            sequenceName = "user_id_seq",
            allocationSize = 1
    )
    @Column(name="id", updatable = false, nullable = false)
    private long id;

    @Column(name = "username")
    @Length(min = 5, message = "*Your username must have at least 5 characters")
    @NotEmpty(message = "*Please provide an username")
    private String username;

    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide a valid password")
    private String password;

    @Column(name = "firstname")
    @NotEmpty(message = "*Please provide your firstname")
    private String firstname;

    @Column(name = "lastname")
    @NotEmpty(message = "*Please provide your lastname")
    private String lastname;

    @Column(name = "email")
    @Email(message = "*Please provide a valid email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    @Column(name = "enabled")
    private boolean enabled;

    private List<String> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public User() {
    }

    public User(String username, String password, String firstname, String lastname, String email, boolean enabled, List<String> roles) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.enabled = enabled;
        this.roles = roles;
    }
}
