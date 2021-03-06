package com.ievgen.iaroshenko.usercore.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
@Entity
@Table(name = "user_info")
@Builder
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "uuid", nullable = false)
    private UUID uuid;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "role_id", nullable = false)
    @Convert(converter = RoleConverter.class)
    private Role role;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Builder.Default
    @Column(name = "locked", nullable = false)
    private Boolean locked = false;

    @Builder.Default
    @Column(name = "enabled", nullable = false)
    private Boolean enabled = false;

    @Builder.Default
    @Column(name = "account_expired", nullable = false)
    private Boolean accountExpired = false;

    @Builder.Default
    @Column(name = "credentials_expired", nullable = false)
    private Boolean credentialsExpired = false;
}
