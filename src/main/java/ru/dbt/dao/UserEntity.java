package ru.dbt.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.dbt.listeners.command.role.Role;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UserEntity {
    @Id
    @Column(name = "id")
    private  Long id;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private  Role role;

    public UserEntity(Long id, Role role) {
        this.id = id;
        this.role = role;
    }

    public UserEntity() {
    }
}
