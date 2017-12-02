package MCCMF.Guis;

import MCCMF.Main.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

public class RankInventory implements Listener{

    private Plugin plugin = Main.getPlugin(Main.class);

    public void newInventory(Player player){
        Inventory i = plugin.getServer().createInventory(null, 9, ChatColor.DARK_GREEN + "Rank Set");
        player.openInventory(i);
    }

}
