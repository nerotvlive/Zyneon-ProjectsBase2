package de.nerotv.projectsbase.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import java.io.File;
import java.util.List;

public class Inventory implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("inventory")) {
            if(!(s instanceof Player)) {
                if(args.length < 3) {
                    s.sendMessage("inventory restore [SPIELER] [RESTORE-INVENTORY]");
                } else {
                    if(Bukkit.getPlayer(args[1]) != null) {
                        Player p = Bukkit.getPlayer(args[1]);
                        final String SID = p.getUniqueId().toString();
                        final File file = new File("plugins/Utralo/Players/" + SID + ".yml");
                        final YamlConfiguration usr = YamlConfiguration.loadConfiguration(file);
                            org.bukkit.inventory.Inventory inv = Bukkit.createInventory(null, 45,"§cErst schließen, wenn du alles rausgenommen hast.");
                            final ItemStack[] items = ((List<ItemStack>) usr.get("Contents")).toArray(new ItemStack[0]);
                            inv.clear(); inv.setContents(items);
                    } else {
                        s.sendMessage("Dieser Spieler ist nicht online!");
                    }
                }
            } else {
                Player p = (Player)s;
            }
        }
        return false;
    }
}