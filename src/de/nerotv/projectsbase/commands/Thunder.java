package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.WorldAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Thunder implements CommandExecutor {

    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("thunder")) {
            if(s.hasPermission("pb.weather")) {
                if(!(s instanceof Player)) {
                    s.sendMessage("/weather [clear/sun/thunder/storm/rain] [Welt]");
                } else {
                    Player p = (Player)s;
                    WorldAPI.setStorm(WorldAPI.playerWorld(p));
                    s.sendMessage("§cArgria §8| §7Du hast das Wetter auf §eGewitter§7 gesetzt.");
                }
            } else {
                s.sendMessage("§cDies darfst du nicht tun!");
            }
        }
        return false;
    }
}