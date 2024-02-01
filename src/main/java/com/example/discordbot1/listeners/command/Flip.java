package com.example.discordbot1.listeners.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;


public class Flip implements Command {


    @Override
    public void command(MessageReceivedEvent event) {
        int chance = (int) (Math.random() * 2);
        String asMention = event.getAuthor().getAsMention();
        if (chance == 1) {
            asMention += "\nорёл";
        } else {
            asMention += "\nрешка";
        }
        event.getChannel().sendMessage(asMention).queue();
    }
}
