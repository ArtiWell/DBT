package com.example.discordbot1;

import com.example.discordbot1.listeners.Listener;
import com.example.discordbot1.listeners.command.Flip;
import com.example.discordbot1.listeners.command.Roll;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DiscordBot1Application {

    public static void main(String[] args) {
        Listener listener = new Listener();
        JDABuilder.createLight("")
                .addEventListeners(listener)
                .enableIntents(
                        List.of(
                                GatewayIntent.GUILD_MESSAGES,
                                GatewayIntent.MESSAGE_CONTENT
                        )
                )
                .setStatus(OnlineStatus.ONLINE)
				.setActivity(Activity.watching("Pron"))
                .build();


    }

}
