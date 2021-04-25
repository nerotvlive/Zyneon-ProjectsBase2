package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.API;
import de.nerotv.projectsbase.primal.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ForceJob implements CommandExecutor {
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("forcejob")) {
            if (s.hasPermission("pb.forcejob")) {
                if (args.length < 2) {
                    s.sendMessage("§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                    s.sendMessage("§cFehler: §c/forcejob [Spieler-UUID] [Wort1 §7Wort2§7 Wort3§c]");
                }
                else if (args.length == 2) {
                    API.forceJob(args[0],args[1]);
                    s.sendMessage(Main.Pro02 + "§8 | §7Versuche den Job von §e" + args[0] + " auf §e" + args[1] + "§7 zu setzen...");
                }
                else if (args.length == 3) {
                    API.forceJob(args[0],args[1]+" "+args[2]);
                    s.sendMessage(Main.Pro02 + "§8 | §7Versuche den Job von §e" + args[0] + " auf §e" + args[1] + " " + args[2] + "§7 zu setzen...");
                }
                else {
                    API.forceJob(args[0],args[1]+" "+args[2]+" "+args[3]);
                    s.sendMessage(Main.Pro02 + "§8 | §7Versuche den Job von §e" + args[0] + " auf §e" + args[1] + " " + args[2] + " " + args[3] + "§7 zu setzen...");
                }
            }
            else {
                s.sendMessage("§cDas darfst du nicht tun!");
            }
        }
        return false;
    }
}