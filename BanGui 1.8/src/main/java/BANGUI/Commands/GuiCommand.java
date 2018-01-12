package BANGUI.Commands;

import BANGUI.Main.Main;
import BANGUI.Guis.Gui;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public final class GuiCommand implements CommandExecutor {
    //
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

    private Main main;
    public static String targetPlayer;

    public GuiCommand(Main passed) {
        this.main = passed;
    }

    public final boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("gui") && sender instanceof Player) {
            Player player = (Player) sender;
            if ((player = (Player) sender).hasPermission("MCCMF.Gui")) {
                if (args.length == 1) {
                    targetPlayer = args[0];
                    Gui.openBanSelectionScreen(player);
                }
            }
        }
        return true;
    }
}

