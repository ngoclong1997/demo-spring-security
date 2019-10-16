package com.drato.demospringsecurity.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role", schema = "public")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    @SequenceGenerator(
            name="role_seq",
            sequenceName = "role_id_seq",
            allocationSize = 1
    )
    @Column(name="id", updatable = false, nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
