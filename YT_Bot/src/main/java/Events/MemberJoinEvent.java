/**
 * @name: MemberJoinEvent.java
 * @date: 28/2/2021
 * @author: Abdallah Alqashqish
 * @functionality: Greets members to the server
 */

package Events;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MemberJoinEvent extends ListenerAdapter {
    
    /**
     * Name: onGuildMemberJoin
     * Date: 28/2/2021
     * @param e: The event
     * Functionality: Welcomes new members to the server
     */
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent e) {
        
        //The welcome channel
        TextChannel welcomChannel = e.getGuild().getTextChannelById("815377694006181940");

        //The new member
        Member newMember = e.getMember();

        //Get the member role
        Role memberRole = e.getGuild().getRolesByName("Member", false).get(0);

        //Welcome the new member
        welcomChannel.sendMessage(newMember.getAsMention() + ", welcome to DEMO's server!").queue();

        //Add the role to the new Member
        e.getGuild().addRoleToMember(newMember, memberRole).queue();

    }

}
