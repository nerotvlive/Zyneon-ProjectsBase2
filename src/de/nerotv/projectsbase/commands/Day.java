package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.API;
import de.nerotv.projectsbase.api.WorldAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Day implements CommandExecutor {

    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if(cmd.getName().equalsIgnoreCase("day")) {
            if(s.hasPermission("pb.time")) {
                if(!(s instanceof Player)) {
                    s.sendMessage("/time [add/set/remove] [Wert] [Welt]");
                } else {
                    Player p = (Player)s;
                    WorldAPI.setTime(0,WorldAPI.playerWorld(p));
                    API.sendPlayerMsg(p,"§cArgria §8| §7Du hast die Zeit auf §eTag§7 gesetzt.");
                }
            } else {
                s.sendMessage("§cDies darfst du nicht tun!");
            }
        }
        return false;
    }
}