package ru.dbt.dao;

import lombok.Getter;
import ru.dbt.listeners.command.role.Role;


@Getter
public class User {
    private final String name;
    private final int id;
    private final Role role;
    private final Long balans;

    public User(String name, int id, Role role, Long balans) {
        this.name = name;
        this.id = id;
        this.role = role;
        this.balans = balans;
    }


}
