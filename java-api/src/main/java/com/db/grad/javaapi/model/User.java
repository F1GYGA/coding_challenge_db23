package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @ManyToMany(mappedBy = "bookUsers")
    private Set<Book> userBooks = new HashSet<>();
}
