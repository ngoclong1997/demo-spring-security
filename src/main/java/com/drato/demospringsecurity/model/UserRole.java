package com.drato.demospringsecurity.model;

import javax.persistence.*;

@Entity
@Table(name = "user_role", schema = "public")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_seq")
    @SequenceGenerator(
            name="user_role_seq",
            sequenceName = "user_role_id_seq",
            allocationSize = 1
    )
    @Column(name="id", updatable = false, nullable = false)
    private long id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "username")
    private String username;

    public UserRole() {
    }

    public UserRole(String roleName, String username) {
        this.roleName = roleName;
        this.username = username;
    }
}
