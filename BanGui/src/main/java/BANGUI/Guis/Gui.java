package BANGUI.Guis;

import java.util.Arrays;
import java.util.List;

import BANGUI.Events.TempbanScreen;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public final class Gui implements Listener {





        public static void openBanSelectionScreen(Player player) {
            Inventory selectionScreen = Bukkit.createInventory((InventoryHolder)null, 9, ChatColor.DARK_RED + "Select to Continue");
            ItemStack tempbanOptionButton;
            ItemMeta tempbanOptionButtonMeta = (tempbanOptionButton = new ItemStack(Material.DIAMOND_SWORD)).getItemMeta();
            ItemStack cancelButton;
            ItemMeta cancelButtonMeta = (cancelButton = new ItemStack(Material.STAINED_GLASS_PANE)).getItemMeta();
            List<String> tempbanOptionButtonLore = Arrays.asList(ChatColor.GOLD + "Click to open tempban menu...");
            tempbanOptionButtonMeta.setDisplayName(ChatColor.GREEN + "Tempban Menu");
            tempbanOptionButtonMeta.setLore(tempbanOptionButtonLore);
            tempbanOptionButton.setItemMeta(tempbanOptionButtonMeta);
            cancelButtonMeta.setDisplayName(ChatColor.RED + "Cancel");
            cancelButton.setItemMeta(cancelButtonMeta);
            selectionScreen.setItem(3, tempbanOptionButton);
            selectionScreen.setItem(5, cancelButton);
            player.openInventory(selectionScreen);
        }

        @EventHandler
        private void onSelectionScreenClick(InventoryClickEvent event) {
            Player player = (Player)event.getWhoClicked();
            if (event.getInventory().getName().equalsIgnoreCase(ChatColor.DARK_RED + "Select to Continue")) {
                ItemStack tempbanOptionButton = event.getCurrentItem();
                if (tempbanOptionButton.getType() == Material.DIAMOND_SWORD) {
                    player.closeInventory();
                } else {
                    ItemStack cancelButton = event.getCurrentItem();
                    if (cancelButton.getType() == Material.STAINED_GLASS_PANE) {
                        player.closeInventory();
                        player.sendMessage(ChatColor.GREEN + "[GUI Banner] " + ChatColor.DARK_RED + "Ban Cancelled");
                    } else {
                        player.closeInventory();
                    }
                }
            }
        }
    }









