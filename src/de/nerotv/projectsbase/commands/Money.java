package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.API;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Money implements CommandExecutor {

    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if(cmd.getName().equalsIgnoreCase("money")) {
            if (args.length < 2) {
                if(!(s instanceof Player)) {
                    s.sendMessage("Dieser Befehl kann nur von einem Spieler ausgeführt werden!");
                } else {
                    Player p = (Player)s;
                    p.performCommand("AP");
                }
            } else {
                if(s.hasPermission("pb.money")) {
                    if(!(s instanceof Player)) {
                        s.sendMessage("Dieser Befehl kann nur von einem Spieler ausgeführt werden!");
                    } else {
                        Player p = (Player) s;
                        p.getInventory().addItem(new ItemStack[]{API.PP001});
                        p.getInventory().addItem(new ItemStack[]{API.PP002});
                        p.getInventory().addItem(new ItemStack[]{API.PP005});
                        p.getInventory().addItem(new ItemStack[]{API.PP010});
                        p.getInventory().addItem(new ItemStack[]{API.PP020});
                        p.getInventory().addItem(new ItemStack[]{API.PP050});
                        p.getInventory().addItem(new ItemStack[]{API.PM001});
                        p.getInventory().addItem(new ItemStack[]{API.PM002});
                        p.getInventory().addItem(new ItemStack[]{API.PM005});
                        p.getInventory().addItem(new ItemStack[]{API.PM010});
                        p.getInventory().addItem(new ItemStack[]{API.PM020});
                        p.getInventory().addItem(new ItemStack[]{API.PM050});
                        p.getInventory().addItem(new ItemStack[]{API.PM100});
                        p.getInventory().addItem(new ItemStack[]{API.PM200});
                        p.getInventory().addItem(new ItemStack[]{API.PM500});
                    }
                }
            }
        }
        return false;
    }
}