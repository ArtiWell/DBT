package ru.dbt.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.dbt.role.Role;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UserEntity {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "balance")
    private Integer balance;
    @Column(name = "stavka")
    private Integer stavka;


    public UserEntity(Long id, Role role, Integer balance, Integer stavka) {
        this.id = id;
        this.role = role;
        this.balance = balance;
        this.stavka = stavka;
    }

    public UserEntity() {
    }
}
