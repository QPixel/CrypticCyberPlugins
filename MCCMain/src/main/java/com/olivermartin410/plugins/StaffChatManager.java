package com.olivermartin410.plugins;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class StaffChatManager {

	/**
	 * Manage chat input to the staff chats, both mod and admin
	 */
	
	public void sendModMessage(String username, String displayname, String server, String message) {
		
		String OriginalMessage = message;
	    
	    ChatManipulation chatfix = new ChatManipulation();
	    
	    String URLBIT = chatfix.getURLBIT(OriginalMessage);
	     
	    String MessageFormat = MultiChat.configman.config.getString("modchat.format");
	    for (ProxiedPlayer onlineplayer : ProxyServer.getInstance().getPlayers()) {
	      if (onlineplayer.hasPermission("multichat.staff.mod"))
	      {
	    	  
	    	  if (!MultiChat.modchatpreferences.containsKey(onlineplayer.getUniqueId()))
	          {
	            TChatInfo chatinfo = new TChatInfo();
	            chatinfo.setChatColor(MultiChat.configman.config.getString("modchat.ccdefault").toCharArray()[0]);
	            chatinfo.setNameColor(MultiChat.configman.config.getString("modchat.ncdefault").toCharArray()[0]);
	            
	            MultiChat.modchatpreferences.put(onlineplayer.getUniqueId(), chatinfo);
	          }
	    	  
	        message = chatfix.replaceModChatVars(MessageFormat, username, displayname, server, OriginalMessage, onlineplayer);
	        String finalmessage = chatfix.FixFormatCodes(message);
	        
	        onlineplayer.sendMessage(new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', finalmessage)).event(new ClickEvent(ClickEvent.Action.OPEN_URL, URLBIT)).create());
	      }
	    }
	    System.out.println("\033[36m[StaffChat] /mc {" + username + "}  " + OriginalMessage);
		
	}
	
	public void sendAdminMessage(String username, String displayname, String server, String message) {
		
		String OriginalMessage = message;
	    
	    ChatManipulation chatfix = new ChatManipulation();
	    
	    String URLBIT = chatfix.getURLBIT(OriginalMessage);
	    
	    String MessageFormat = MultiChat.configman.config.getString("adminchat.format");
	    for (ProxiedPlayer onlineplayer : ProxyServer.getInstance().getPlayers()) {
	      if (onlineplayer.hasPermission("multichat.staff.admin"))
	      {
	    	  
	    	  if (!MultiChat.adminchatpreferences.containsKey(onlineplayer.getUniqueId()))
	          {
	            TChatInfo chatinfo = new TChatInfo();
	            chatinfo.setChatColor(MultiChat.configman.config.getString("adminchat.ccdefault").toCharArray()[0]);
	            chatinfo.setNameColor(MultiChat.configman.config.getString("adminchat.ncdefault").toCharArray()[0]);
	            
	            MultiChat.adminchatpreferences.put(onlineplayer.getUniqueId(), chatinfo);
	          }
	    	  
	        message = chatfix.replaceAdminChatVars(MessageFormat, username, displayname, server, OriginalMessage, onlineplayer);
	        String finalmessage = chatfix.FixFormatCodes(message);
	        
	        onlineplayer.sendMessage(new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', finalmessage)).event(new ClickEvent(ClickEvent.Action.OPEN_URL, URLBIT)).create());
	      }
	    }
	    System.out.println("\033[35m[StaffChat] /ac {" + username + "}  " + OriginalMessage);
		
	}
	
}
