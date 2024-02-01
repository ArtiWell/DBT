package com.example.discordbot1.listeners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class FlipListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()){
            return;
        }
        event.getChannel().sendMessage(event.getMessage().getContentDisplay())
                .queue();




    }
}
