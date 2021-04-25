package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.API;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import java.io.File;

public class AP implements CommandExecutor
{
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("ap")) {
            if (args.length < 3) {
                if (!(s instanceof Player)) {
                    s.sendMessage("/ap add [Spieler] [AP]");
                }
                else {
                    final Player c = (Player)s;
                    final File List = new File("plugins/Utralo/Players/" + c.getUniqueId().toString() + ".yml");
                    final YamlConfiguration UUIDs = YamlConfiguration.loadConfiguration(List);
                    API.reloadConfig(List, UUIDs);
                    final int J = Integer.parseInt(UUIDs.getString(c.getUniqueId().toString() + ".AP"));
                    int j;
                    if (J == 1) {
                        j = 0;
                    }
                    else {
                        j = J - 1;
                    }
                    s.sendMessage(ChatColor.BLUE + "Primal 2 " + ChatColor.DARK_GRAY + "| " + ChatColor.GRAY + "Du hast " + ChatColor.YELLOW + String.valueOf(j) + ChatColor.GRAY + " AP.");
                }
            }
            else if (s.hasPermission("pb.apchange")) {
                final Player p = Bukkit.getPlayer(args[1]);
                final File List = new File("plugins/Utralo/Players/" + p.getUniqueId().toString() + ".yml");
                final YamlConfiguration UUIDs = YamlConfiguration.loadConfiguration(List);
                API.reloadConfig(List, UUIDs);
                final int a = Integer.parseInt(UUIDs.getString(p.getUniqueId().toString() + ".AP"));
                int a2;
                if (a < 1) {
                    a2 = 1;
                }
                else {
                    a2 = a;
                }
                final int b = Integer.parseInt(args[2]);
                final int CC = a2 + b;
                final String E = String.valueOf(CC);
                UUIDs.set(p.getUniqueId().toString() + ".AP", (Object)E);
                API.saveConfig(List, UUIDs);
                s.sendMessage(p.getName() + " wurden " + args[2] + " AP gegeben.");
                p.sendMessage(ChatColor.BLUE + "Primal 2 " + ChatColor.DARK_GRAY + "| " + ChatColor.GRAY + "Du hast " + ChatColor.YELLOW + args[2] + ChatColor.GRAY + " AP erhalten!");
                API.saveConfig(List, UUIDs);
            }
        }
        return false;
    }
}