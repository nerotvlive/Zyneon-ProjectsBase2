package de.nerotv.projectsbase.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Rucksack implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("rucksack")) {
            if(!(s instanceof Player)) {
                s.sendMessage("Dazu musst du ein Spieler sein.");
            } else {
                Player p = (Player)s;
                p.performCommand("bp");
            }
        }
        return false;
    }
}
