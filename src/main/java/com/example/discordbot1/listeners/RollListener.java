package com.example.discordbot1.listeners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RollListener extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()){
            return;
        }
        if ("$roll".equals(event.getMessage().getContentDisplay())){
            int a = (int) (Math.random()*100);
            event.getChannel().sendMessage(String.valueOf(a)).queue();
        }




    }

}
