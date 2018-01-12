//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package BANGUI.Main;

import BANGUI.Commands.Tempban;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public final class InventoryStealPrevention implements Listener {
    public InventoryStealPrevention() {
    }

    @EventHandler
    private static void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player)event.getWhoClicked();
        if (event.getInventory().getName().equalsIgnoreCase(ChatColor.AQUA + "Tempban " + Tempban.targetPlayer)) {
            event.setCancelled(true);
            player.updateInventory();
        }

    }
}
