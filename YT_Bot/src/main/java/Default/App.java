package Default;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;

public class App {
    public static void main(String[] args) throws LoginException {

        String token = "ODEyODA5MDI2MTIyOTQwNDU2.YDGJZQ.TmFcROcRlRaw75H26oQbIt7Wg80";

        JDABuilder.createDefault(token)
                  .addEventListeners(new ClearCommand())
                  .build();
    }
}
