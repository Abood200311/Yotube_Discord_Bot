package Default;

import javax.security.auth.login.LoginException;

import Commands.ClearCommand;
import Events.MemberJoinEvent;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class App {
    public static void main(String[] args) throws LoginException {

        String token = "ODEyODA5MDI2MTIyOTQwNDU2.YDGJZQ.DoSEBXIkC0e1QE8BDL1DknEwFRw";

        JDABuilder.createDefault(token)
                  .addEventListeners(new ClearCommand(), new MemberJoinEvent())
                  .enableIntents(GatewayIntent.GUILD_MEMBERS)
                  .build();
    }
}
