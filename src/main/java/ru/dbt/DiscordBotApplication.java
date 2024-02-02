package ru.dbt;

import org.springframework.boot.SpringApplication;
import ru.dbt.listeners.Listener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DiscordBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscordBotApplication.class, args);
    }

}
