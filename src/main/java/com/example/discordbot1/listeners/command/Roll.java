package com.example.discordbot1.listeners.command;


import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Roll implements Command {


    @Override
    public void command(MessageReceivedEvent event) {
         event.getChannel().sendMessage(event.getAuthor().getAsMention()
                + "\n"
                + (int)(Math.random()*100)).queue();
    }
}