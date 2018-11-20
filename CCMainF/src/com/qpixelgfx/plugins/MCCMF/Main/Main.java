package com.qpixelgfx.plugins.MCCMF.Main;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import com.qpixelgfx.plugins.MCCMF.Events.EventsClass;

public class Main extends JavaPlugin implements Listener {
    public void onEnable(){
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nMCCMainFrame has been Enabled\n\n");
        getServer().getPluginManager().registerEvents(new EventsClass(), this);
        loadConfig();


    }

    public void onDisable(){
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nMCCMainFrame has been Disabled\n\n");
    }

    public void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

}



