package BANGUI.Main;

import java.io.File;
import BANGUI.Commands.Tempban;
import BANGUI.Events.SelectionScreen;
import BANGUI.Events.TempbanScreen;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin implements Listener {


    public String noAccessMessage = this.getConfig().getString("Messages.NoAccess");
    public String invalidUsageMessage = this.getConfig().getString("Messages.InvalidUsage");
    String reloadMessage = this.getConfig().getString("Messages.ReloadMessage");
    FileConfiguration config;
    File cfile;

    public Main() {
    }

    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nMCCBANGUI has been Enabled\n\n");
        this.getCommand("tempban").setExecutor(new Tempban(this));
        Bukkit.getPluginManager().registerEvents(new TempbanScreen(this), this);
        Bukkit.getPluginManager().registerEvents(new SelectionScreen(new TempbanScreen(this)), this);
        Bukkit.getPluginManager().registerEvents(new InventoryStealPrevention(), this);
        Bukkit.getPluginManager().registerEvents(this, this);
        this.config = this.getConfig();
        this.config.options().copyDefaults(true);
        this.saveConfig();
        this.cfile = new File(this.getDataFolder(), "config.yml");
    }

    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nMCCBANGUI has been Disabled\n\n");
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;
        if (command.getName().equalsIgnoreCase("guireload") && (player = (Player)sender).hasPermission("guibanner.reload")) {
            this.reloadConfig();
            player.sendMessage(ChatColor.GREEN + "[GUI Banner] " + ChatColor.BLUE + this.reloadMessage);
            return true;
        } else {
            return true;
        }
    }
}


