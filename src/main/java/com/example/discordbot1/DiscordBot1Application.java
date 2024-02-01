package com.example.discordbot1;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DiscordBot1Application {

    public static void main(String[] args) {
		ArtemBot artemBot = new ArtemBot();

        JDABuilder.createLight("MTE5ODU3MTU3NjI2MjY3MjQzNA.GhZvwz.Ux3-YFnoRA7as5hCMDTE2HOnxEgK6JK2HUq2mk")
                .addEventListeners(artemBot)
                .enableIntents(
                        List.of(
                                GatewayIntent.GUILD_MESSAGES,
                                GatewayIntent.MESSAGE_CONTENT
                        )
                )
                .setStatus(OnlineStatus.ONLINE)
				.setActivity(Activity.watching("Porno"))
                .build();


    }

}
