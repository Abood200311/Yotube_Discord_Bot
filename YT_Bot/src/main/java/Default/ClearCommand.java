package Default;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ClearCommand extends ListenerAdapter {
    
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        
        //Gets the message
        String message = e.getMessage().getContentRaw();

        String[] args = message.split("\\s++");

        if (args[0].equalsIgnoreCase("$clear")) {
            try {
                int numLines = Integer.parseInt(args[1])+1;
    
                if (numLines == 1) {
                    throw new IllegalArgumentException();
                } else {
                    //run the command
                    e.getChannel().getHistory()
                                  .retrievePast(numLines)
                                  .queue(messages -> {
                                        e.getChannel().purgeMessages(messages);
                                  });
                }
    
            } catch (IndexOutOfBoundsException ex) {
                e.getChannel().sendMessage("Missing Arguments!").queue();
            } catch (NumberFormatException ex) {
                e.getChannel().sendMessage(args[1] + " is not a number!").queue();
            } catch (IllegalArgumentException ex) {
                e.getChannel().sendMessage("Can only delete 1-99 lines").queue();
            }
        }
    }

}
