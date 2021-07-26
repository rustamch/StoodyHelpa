package model;
import events.StudyTimeEvent.StudyTimeEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import javax.security.auth.login.LoginException;
import java.util.EnumSet;



public class Bot {
    public static JDA BOT_JDA;

    public static void main(String[] args) throws LoginException {
        EnumSet<GatewayIntent> intents = EnumSet.of(
                GatewayIntent.GUILD_EMOJIS, 
                GatewayIntent.GUILD_VOICE_STATES,
                GatewayIntent.GUILD_MESSAGES
        );
        BOT_JDA = JDABuilder.createDefault(System.getenv("discord_token"),intents)
                            .setActivity(Activity.playing("On the watch! >:(")).build();
        BOT_JDA.addEventListener(new MessageListener(),
                                new StudyTimeEvent());
    }
}

