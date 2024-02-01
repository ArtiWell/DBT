package com.example.discordbot1;

import com.example.discordbot1.listeners.FlipListener;
import com.example.discordbot1.listeners.RollListener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DiscordBot1Application {

    public static void main(String[] args) {
		ArtemBot artemBot = new ArtemBot();
        FlipListener flipListenerBot = new FlipListener();
        RollListener rollListener = new RollListener();

        JDABuilder.createLight("")
                .addEventListeners(artemBot, rollListener, flipListenerBot)
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
