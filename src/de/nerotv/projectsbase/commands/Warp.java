package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.API;
import org.bukkit.Sound;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.Inventory;
import org.bukkit.command.CommandExecutor;

public class Warp implements CommandExecutor
{
    public static Inventory GUI;
    
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("warp")) {
            final Player p = (Player)s;
            (Warp.GUI = Bukkit.createInventory((InventoryHolder)null, InventoryType.HOPPER, ChatColor.DARK_PURPLE + "Liste der Warps")).setItem(3, API.GUIP);
            Warp.GUI.setItem(0, API.GUIP);
            Warp.GUI.setItem(1, API.FWHV);
            Warp.GUI.setItem(2, API.FRMW);
            Warp.GUI.setItem(3, API.ARNA);
            Warp.GUI.setItem(4, API.GUIP);
            p.openInventory(Warp.GUI);
            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG,100,100);
        }
        return false;
    }
}
