package de.nerotv.projectsbase.commands;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Achievements implements CommandExecutor
{
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("achievements")) {
            final Player p = (Player)s;
            p.performCommand("advancedachievements:aa list");
        }
        return false;
    }
}
