package com.emmlg.ForoAluraHub.user.modelo;

import com.emmlg.ForoAluraHub.topics.modelo.Topic;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "user_id")
    private Integer userId;

    @Column(nullable = false, unique = true, name = "user_name", length = 25)
    private String userName;

    @Column(nullable = false, unique = true, name = "user_email", length = 80)
    private String userEmail;

    @Column(nullable = false, name = "user_password", length = 50)
    private String userPassword;

    @Column(nullable = false, name = "user_role", length = 10)
    private String userRole;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Topic> topics;

}
