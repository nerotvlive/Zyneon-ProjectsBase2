package de.nerotv.projectsbase.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Gommemode implements CommandExecutor {

    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("gommemode")) {
            s.sendMessage("§7§lTROLOLOLOL §f§lGOMMEMODE§7§l!!");
        }
        return false;
    }
}