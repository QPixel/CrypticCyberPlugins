package com.qpixelgfx.plugins.MCCMF.Guis;

import com.qpixelgfx.plugins.MCCMF.Main.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

public class PermInventory implements Listener{

    private Plugin plugin = Main.getPlugin(Main.class);

        public void newInventory(Player player){
            Inventory i = plugin.getServer().createInventory(null, 9, ChatColor.RED + "Perm Set");
            player.openInventory(i);
        }



}
