package BANGUI.Commands;

import BANGUI.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    private Main main;
    public static String targetPlayer;

    public Commands(Main passed) {
        this.main = passed;
    }

    public final boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("forceban") && sender instanceof Player) {
            Player player = (Player) sender;
            if ((player = (Player) sender).hasPermission("MCCMF.Forceban")) {
                if (args.length == 1) {
                    targetPlayer = args[0];
                    Bukkit.dispatchCommand(sender, "litebans:ban " + Tempban.targetPlayer);
                }
            }
        }
        return true;
    }
}

