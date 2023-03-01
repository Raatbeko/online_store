package com.example.online_store.domain;

import com.example.online_store.domain.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity {

    @NotNull
    @Column(name = "firstname")
    String firstname;

    @NotNull
    @Column(name = "surname")
    String surname;

    @NotNull
    @Column(name = "email")
    String email;

    @NotNull
    @Column(name = "password")
    String password;
}
