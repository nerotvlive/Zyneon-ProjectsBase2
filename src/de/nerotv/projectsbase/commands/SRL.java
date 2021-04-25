package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.API;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class SRL implements CommandExecutor
{
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("srl")) {
            if (s.hasPermission("pb.serverreload")) {
                if (args.length == 0) {
                    for (final Player all : Bukkit.getOnlinePlayers()) {
                        all.kickPlayer("§cServersysteme werden neugestartet. Bitte habe kurz Geduld!");
                    }
                    Bukkit.getServer().shutdown();
                }
                else if (args[0].equalsIgnoreCase("ProjectsBase")) {
                    s.sendMessage("§cProjectsBase wird neugeladen...");
                    API.reloadConfigs();
                    s.sendMessage("§aProjectsBase wurde neugeladen!");
                }
                else if (args[0].equalsIgnoreCase("1")) {
                    s.sendMessage("§cProjectsBase wird neugeladen...");
                    API.reloadConfigs();
                    s.sendMessage("§aProjectsBase wurde neugeladen!");
                }
                else if (args[0].equalsIgnoreCase("pb")) {
                    s.sendMessage("§cProjectsBase wird neugeladen!");
                    API.reloadConfigs();
                    s.sendMessage("§aProjectsBase wurde neugeladen!");
                }
                else {
                    for (final Player all : Bukkit.getOnlinePlayers()) {
                        all.kickPlayer("§cServersysteme werden neugestartet. Bitte habe kurz Geduld!");
                    }
                    Bukkit.getServer().shutdown();
                }
            }
            else {
                s.sendMessage("§cDies darfst du nicht tun!");
            }
        }
        return false;
    }
}
