/**
 * @name: ClearCommand.java
 * @date: 20/2/2021
 * @author: Abdallah Alqashqish
 * @functionality: Clears 1-99 past messages from a text channel
 */

package Commands;

//Import statements
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ClearCommand extends ListenerAdapter {
    

    /**
     * Name: onGuildMessageRecieved
     * Date: 20/2/2021
     * @param e: The event
     * Functionality: Checks and executes the command 
     */
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        
        //The message
        String message = e.getMessage().getContentRaw();

        //Get the arguments -> Arguments start from second item (Index 1)
        String[] args = message.split("\\s++");

        //Is this the clear command?
        if (args[0].equalsIgnoreCase("$clear")) {
            try {
                //The number of lines
                int numLines = Integer.parseInt(args[1])+1;
    
                if (numLines == 1) { //Did the user input 0?
                    //Throw error
                    throw new IllegalArgumentException();

                } else {
                    //run the command
                    e.getChannel().getHistory()
                                  .retrievePast(numLines)
                                  .queue(messages -> {
                                        e.getChannel().purgeMessages(messages);
                                  });
                }
    
            } catch (IndexOutOfBoundsException ex) { //Missing arguments?
                e.getChannel().sendMessage("Missing Arguments!").queue();
            } catch (NumberFormatException ex) { //Invalid number for lines?
                e.getChannel().sendMessage(args[1] + " is not a number!").queue();
            } catch (IllegalArgumentException ex) { //Invalid number of lines?
                e.getChannel().sendMessage("Can only delete 1-99 lines").queue();
            }
        }
    }

}
