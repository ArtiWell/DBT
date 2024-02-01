package com.example.discordbot1;

import com.example.discordbot1.listeners.RollListener;
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
        RollListener rollListener = new RollListener();


        JDABuilder.createLight("MTE5ODU3MTU3NjI2MjY3MjQzNA.GpflHa.JlUyXSJ7SCBlPk6PtoH5r1NX_A0T5pr7Npp_Fs")
                .addEventListeners(artemBot, rollListener)
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
