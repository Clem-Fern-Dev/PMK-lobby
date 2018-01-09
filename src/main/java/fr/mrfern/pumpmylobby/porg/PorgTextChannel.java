package fr.mrfern.pumpmylobby.porg;

import java.util.Collection;
import java.util.List;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Invite;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.PermissionOverride;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.Webhook;
import net.dv8tion.jda.core.managers.ChannelManager;
import net.dv8tion.jda.core.managers.ChannelManagerUpdatable;
import net.dv8tion.jda.core.requests.RestAction;
import net.dv8tion.jda.core.requests.restaction.AuditableRestAction;
import net.dv8tion.jda.core.requests.restaction.InviteAction;
import net.dv8tion.jda.core.requests.restaction.PermissionOverrideAction;

public class PorgTextChannel implements TextChannel{

	private TextChannel textChannel;
	private boolean isOK;
	private JDA jda;
	
	public PorgTextChannel(MisterPorg misterPorg, String channelID) {
		try {
			textChannel = misterPorg.getJda().getTextChannelById(channelID);
			isOK = true;
		} catch (Exception e) {
			System.out.println("error textchannel");
			isOK = false;
		}
	}
	
	public RestAction<Message> sendPorgMessage(MessageEmbed embed) {
		return textChannel.sendMessage(embed);
	}
	
	public RestAction<Message> sendPorgMessage(Message msg) {
		return textChannel.sendMessage(msg);
	}
	
	public RestAction<Message> sendPorgMessage(String text) {
		// TODO Auto-generated method stub
		return textChannel.sendMessage(text);
	}
	
	@Override
	public RestAction<Message> sendMessage(MessageEmbed embed) {
		return textChannel.sendMessage(embed);
	}
	
	@Override
	public RestAction<Message> sendMessage(Message msg) {
		return textChannel.sendMessage(msg);
	}
	
	@Override
	public RestAction<Message> sendMessage(String text) {
		// TODO Auto-generated method stub
		return textChannel.sendMessage(text);
	}
	
	@Override
	public RestAction<List<Message>> getPinnedMessages(){
		return textChannel.getPinnedMessages();
	}
	
	public List<Message> getListPinnedMessages() {
		return getPinnedMessages().complete();
	}
	
	public TextChannel getTextChannel() {
		return textChannel;
	}

	public void setTextChannel(TextChannel textChannel) {
		this.textChannel = textChannel;
	}

	@Override
	public ChannelType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Guild getGuild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPositionRaw() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public JDA getJDA() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PermissionOverride getPermissionOverride(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PermissionOverride getPermissionOverride(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PermissionOverride> getPermissionOverrides() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PermissionOverride> getMemberPermissionOverrides() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PermissionOverride> getRolePermissionOverrides() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChannelManager getManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChannelManagerUpdatable getManagerUpdatable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuditableRestAction<Void> delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PermissionOverrideAction createPermissionOverride(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PermissionOverrideAction createPermissionOverride(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InviteAction createInvite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestAction<List<Invite>> getInvites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getIdLong() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLatestMessageIdLong() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasLatestMessage() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int compareTo(TextChannel o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getAsMention() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTopic() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isNSFW() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RestAction<List<Webhook>> getWebhooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestAction<Void> deleteMessages(Collection<Message> messages) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestAction<Void> deleteMessagesByIds(Collection<String> messageIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuditableRestAction<Void> deleteWebhookById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestAction<Void> clearReactionsById(String messageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canTalk() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canTalk(Member member) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isOK() {
		return isOK;
	}

	public void setOK(boolean isOK) {
		this.isOK = isOK;
	}

	public JDA getJda() {
		return jda;
	}

	public void setJda(JDA jda) {
		this.jda = jda;
	}
}
