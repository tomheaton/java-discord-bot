package dev.tomheaton.java_discord_bot;

import io.github.cdimascio.dotenv.Dotenv;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main {

    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.load();
        String token = dotenv.get("BOT_TOKEN");

        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!ping")) {
                event.getChannel().sendMessage("Pong!");
            }
        });

        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
    }
}