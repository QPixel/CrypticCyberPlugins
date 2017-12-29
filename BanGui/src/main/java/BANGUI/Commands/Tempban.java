package BANGUI.Commands;

import BANGUI.Main.Main;
import BANGUI.Events.SelectionScreen;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class Tempban implements CommandExecutor{
    //
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

    private Main main;
        public static String targetPlayer;

        public Tempban(Main passed) {
            this.main = passed;
        }

        public final boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (cmd.getName().equalsIgnoreCase("tempban") && sender instanceof Player) {
                Player player = (Player)sender;
                if ((player = (Player)sender).hasPermission("litebans.tempban")) {
                    if (args.length == 1) {
                        targetPlayer = args[0];
                        SelectionScreen.openBanSelectionScreen(player);
                    }

                    if (args.length != 1 || args == null) {
                        player.sendMessage(ChatColor.RED + this.main.invalidUsageMessage);
                    }

                    if (!player.hasPermission("essentials.tempban")) {
                        player.sendMessage(ChatColor.DARK_RED + this.main.noAccessMessage);
                    }
                }
            }

            return true;
        }
    }


