package MCCMF.Main;

import MCCMF.Commands.Commands;
import MCCMF.Events.EventsClass;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {
    private Commands commands = new Commands();
    public void onEnable(){
        getCommand(commands.cmd1).setExecutor(commands);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nMCCMainFrame has been Enabled\n\n");
        getServer().getPluginManager().registerEvents(new EventsClass(), this);
        getServer().getPluginManager().
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



