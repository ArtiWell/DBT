package ru.dbt.dao;

import jakarta.persistence.Entity;
import lombok.Getter;
import ru.dbt.listeners.command.role.Role;


@Getter
public class User {
    private  int id;
    private  Role role;

    public User(int id, Role role) {
        this.id = id;
        this.role = role;
    }


    public User() {

    }
}
