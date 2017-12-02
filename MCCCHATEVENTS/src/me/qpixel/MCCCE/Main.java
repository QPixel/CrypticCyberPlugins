package me.qpixel.MCCCE;

import org.bukkit.plugin.java.JavaPlugin;

import me.qpixel.MCCMF.Events.EventsClass;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	
	public void onEnable(){
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nMCCMainFrame has been Enabled\n\n");
		getServer().getPluginManager().registerEvents(new EventsClass(), this);


		}

		public void onDisable(){
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nMCCMainFrame has been Disabled\n\n");
		}

}
