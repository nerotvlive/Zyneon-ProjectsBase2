package de.nerotv.projectsbase.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Say implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("say")) {
            s.sendMessage("§cDieser Befehl existiert nicht!");
        }
        return false;
    }
}