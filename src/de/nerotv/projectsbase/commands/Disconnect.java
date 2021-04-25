package de.nerotv.projectsbase.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Disconnect implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("disconnect")) {
            if(!(s instanceof Player)) {

            } else {
                Player p = (Player)s;
                p.kickPlayer("§7Du hast den Server §cverlassen§8. §aDanke§7 fürs Spielen§8!");
            }
        }
        return false;
    }
}