package BANGUI.Commands;

import BANGUI.Main.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanGuiConfig implements CommandExecutor {
    public static String targetPlayer;
    private final Main main;

    public BanGuiConfig(Main passed) {
        this.main = passed;
    }

    public final boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("forceban") && sender instanceof Player) {
            Player player = (Player) sender;
            if ((player = (Player) sender).hasPermission("MCCMF.BanGuiConfig")) {
                player.sendMessage(ChatColor.GREEN + "[GUI Banner] " + ChatColor.BLUE + "Mode Changed to Litebans");
                }
            }

        return true;
    }
}


