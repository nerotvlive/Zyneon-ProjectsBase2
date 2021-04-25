package de.nerotv.projectsbase.api;

import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.event.Listener;

public class RewardAPI implements Listener
{
    public static Inventory Shop;
    public static Inventory SONS;
    public static Inventory FALK;
    public static Inventory SHER;


    public static void intShop(final Player p) {
        (RewardAPI.Shop = Bukkit.createInventory((InventoryHolder)null, InventoryType.HOPPER, ChatColor.DARK_PURPLE + "Liste der Belohnungen")).setItem(0, API.M001);
        RewardAPI.Shop.setItem(1, API.M005);
        RewardAPI.Shop.setItem(2, API.M050);
        RewardAPI.Shop.setItem(3, API.M100);
        RewardAPI.Shop.setItem(4, API.M500);
        p.openInventory(RewardAPI.Shop);
    }
    
    @EventHandler
    public void InvClick(final InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        if(e.getCurrentItem() != null) {
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    final ItemStack i = e.getCurrentItem();
                    if (i.getItemMeta().getDisplayName().equals(API.M001.getItemMeta().getDisplayName())) {
                        if (API.checkPayment(p, 2).equalsIgnoreCase("accept")) {
                            final String Value = "1 Mark";
                            p.getInventory().addItem(new ItemStack[]{API.PM001});
                            p.sendMessage(ChatColor.BLUE + "Primal 2 " + ChatColor.DARK_GRAY + "| " + ChatColor.GRAY + "Du hast dir " + ChatColor.YELLOW + Value + ChatColor.GRAY + " gekauft!");
                        } else {
                            p.sendMessage(ChatColor.BLUE + "Primal 2 " + ChatColor.DARK_GRAY + "| " + ChatColor.GRAY + "Das kannst du dir nicht leisten!");
                        }
                        e.setCancelled(true);
                    } else if (i.getItemMeta().getDisplayName().equals(API.M005.getItemMeta().getDisplayName())) {
                        if (API.checkPayment(p, 10).equalsIgnoreCase("accept")) {
                            final String Value = "5 Mark";
                            p.getInventory().addItem(new ItemStack[]{API.PM005});
                            p.sendMessage(ChatColor.BLUE + "Primal 2 " + ChatColor.DARK_GRAY + "| " + ChatColor.GRAY + "Du hast dir " + ChatColor.YELLOW + Value + ChatColor.GRAY + " gekauft!");
                        } else {
                            p.sendMessage(ChatColor.BLUE + "Primal 2 " + ChatColor.DARK_GRAY + "| " + ChatColor.GRAY + "Das kannst du dir nicht leisten!");
                        }
                        e.setCancelled(true);
                    } else if (i.getItemMeta().getDisplayName().equals(API.M050.getItemMeta().getDisplayName())) {
                        if (API.checkPayment(p, 100).equalsIgnoreCase("accept")) {
                            final String Value = "50 Mark";
                            p.getInventory().addItem(new ItemStack[]{API.PM050});
                            p.sendMessage(ChatColor.BLUE + "Primal 2 " + ChatColor.DARK_GRAY + "| " + ChatColor.GRAY + "Du hast dir " + ChatColor.YELLOW + Value + ChatColor.GRAY + " gekauft!");
                        } else {
                            p.sendMessage(ChatColor.BLUE + "Primal 2 " + ChatColor.DARK_GRAY + "| " + ChatColor.GRAY + "Das kannst du dir nicht leisten!");
                        }
                        e.setCancelled(true);
                    } else if (i.getItemMeta().getDisplayName().equals(API.M100.getItemMeta().getDisplayName())) {
                        if (API.checkPayment(p, 200).equalsIgnoreCase("accept")) {
                            final String Value = "100 Mark";
                            p.getInventory().addItem(new ItemStack[]{API.PM100});
                            p.sendMessage(ChatColor.BLUE + "Primal 2 " + ChatColor.DARK_GRAY + "| " + ChatColor.GRAY + "Du hast dir " + ChatColor.YELLOW + Value + ChatColor.GRAY + " gekauft!");
                        } else {
                            p.sendMessage(ChatColor.BLUE + "Primal 2 " + ChatColor.DARK_GRAY + "| " + ChatColor.GRAY + "Das kannst du dir nicht leisten!");
                        }
                        e.setCancelled(true);
                    } else if (i.getItemMeta().getDisplayName().equals(API.M500.getItemMeta().getDisplayName())) {
                        if (API.checkPayment(p, 1000).equalsIgnoreCase("accept")) {
                            final String Value = "500 Mark";
                            p.getInventory().addItem(new ItemStack[]{API.PM500});
                            p.sendMessage(ChatColor.BLUE + "Primal 2 " + ChatColor.DARK_GRAY + "| " + ChatColor.GRAY + "Du hast dir " + ChatColor.YELLOW + Value + ChatColor.GRAY + " gekauft!");
                        } else {
                            p.sendMessage(ChatColor.BLUE + "Primal 2 " + ChatColor.DARK_GRAY + "| " + ChatColor.GRAY + "Das kannst du dir nicht leisten!");
                        }
                        e.setCancelled(true);
                    } else if (i.getItemMeta().getDisplayName().equals(API.GUIP.getItemMeta().getDisplayName())) {
                        e.setCancelled(true);
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
                    } else if (i.getItemMeta().getDisplayName().equals(API.GUI2.getItemMeta().getDisplayName())) {
                        e.setCancelled(true);
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
                    } else if (i.getItemMeta().getDisplayName().equals(API.FLKW.getItemMeta().getDisplayName())) {
                        (RewardAPI.FALK = Bukkit.createInventory((InventoryHolder) null, InventoryType.HOPPER, ChatColor.DARK_PURPLE + "Liste der Warps")).setItem(3, API.GUIP);
                        FALK.setItem(0, API.GUIP);
                        FALK.setItem(1, API.FWHV);
                        FALK.setItem(2, API.GUIP);
                        FALK.setItem(3, API.FWHO);
                        FALK.setItem(4, API.GUIP);
                        e.setCancelled(true);
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
                        p.openInventory(FALK);
                    } else if (i.getItemMeta().getDisplayName().equals(API.FWHV.getItemMeta().getDisplayName())) {
                        p.performCommand("spawn go");
                        e.setCancelled(true);
                        p.closeInventory();
                    } else if (i.getItemMeta().getDisplayName().equals(API.FWHO.getItemMeta().getDisplayName())) {
                        p.performCommand("falkenwacht go");
                        e.setCancelled(true);
                        p.closeInventory();
                    } else if (i.getItemMeta().getDisplayName().equals(API.ARNA.getItemMeta().getDisplayName())) {
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG,100,100);
                        //p.sendMessage("§cDer Nether ist für den Anfang des Projektes deaktiviert. Dies dient dazu damit man nicht zu schnell mit zu guten Equipment herumlaufen kann.");
                        p.performCommand("arena go");
                        e.setCancelled(true);
                        p.closeInventory();
                    } else if (i.getItemMeta().getDisplayName().equals(API.FRMW.getItemMeta().getDisplayName())) {
                        p.performCommand("farmwelt go");
                        e.setCancelled(true);
                        p.closeInventory();
                    } else if (i.getItemMeta().getDisplayName().equals(API.SHEV.getItemMeta().getDisplayName())) {
                        e.setCancelled(true);
                    } else if (i.getItemMeta().getDisplayName().equals(API.SHES.getItemMeta().getDisplayName())) {
                        p.performCommand("shervann go");
                        e.setCancelled(true);
                        p.closeInventory();
                    }
                    else if(i.getItemMeta().getDisplayName().equals(API.SONS.getItemMeta().getDisplayName())){
                        (RewardAPI.SONS = Bukkit.createInventory((InventoryHolder)null, InventoryType.HOPPER, ChatColor.DARK_PURPLE + "Liste der Warps")).setItem(3,API.GUIP);
                        SONS.setItem(0,API.GUIP);
                        SONS.setItem(1,API.ARNA);
                        SONS.setItem(2,API.GUIP);
                        SONS.setItem(3,API.FRMW);
                        SONS.setItem(4,API.GUIP);
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
                        e.setCancelled(true);
                        p.openInventory(SONS);
                    } else {
                        e.setCancelled(false);
                    }
                }
            }
        }
    }
}
