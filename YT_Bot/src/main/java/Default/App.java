package Default;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;

public class App {
    public static void main(String[] args) throws LoginException {

        String token = "token goes here!";

        JDABuilder.createDefault(token)
                  .addEventListeners(new ClearCommand())
                  .build();
    }
}
