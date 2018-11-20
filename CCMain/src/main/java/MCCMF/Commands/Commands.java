package MCCMF.Commands;

import net.md_5.bungee.api.ChatColor;

import net.minecraft.server.v1_12_R1.CommandExecute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Commands extends CommandExecute implements Listener,CommandExecutor {

    public String cmd1 = "giveitem";
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
        if(sender instanceof Player){
            if(cmd.getName().equalsIgnoreCase(cmd1)){

            }
        }else{
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }
        return false;
    }
}
