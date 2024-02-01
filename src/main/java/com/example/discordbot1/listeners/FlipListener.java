package com.example.discordbot1.listeners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class FlipListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()){
            return;
        }

if (("$flip").equals(event.getMessage().getContentDisplay()))
        event.getChannel().sendMessage(flip())
                .queue();
    }


    public String flip() {
        Random r = new Random();
        int chance = r.nextInt(2);
        if (chance == 1) {
            return"орёл";
        } else {
            return"решка";
        }
    }
}
