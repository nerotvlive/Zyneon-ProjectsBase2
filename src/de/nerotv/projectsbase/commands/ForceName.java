package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.primal.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class ForceName implements CommandExecutor
{
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("forcename")) {
            if (s.hasPermission("pb.forcename")) {
                if (args.length < 2) {
                    s.sendMessage("§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                    s.sendMessage("§cFehler: §c/forcename [Spieler] [Name §7(Mitte)§c Nachname]");
                }
                else if (args.length == 2) {
                    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "name " + args[0] + " " + args[1]);
                    s.sendMessage(Main.Pro02 + "§8 | §7Versuche den Namen von §e" + args[0] + " auf §e" + args[1] + "§7 zu setzen...");
                }
                else if (args.length == 3) {
                    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "name " + args[0] + " " + args[1] + " " + args[2]);
                    s.sendMessage(Main.Pro02 + "§8 | §7Versuche den Namen von §e" + args[0] + " auf §e" + args[1] + " " + args[2] + "§7 zu setzen...");
                }
                else {
                    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "name " + args[0] + " " + args[1] + " " + args[2] + " " + args[3]);
                    s.sendMessage(Main.Pro02 + "§8 | §7Versuche den Namen von §e" + args[0] + " auf §e" + args[1] + " " + args[2] + " " + args[3] + "§7 zu setzen...");
                }
            }
            else {
                s.sendMessage("§cDas darfst du nicht tun!");
            }
        }
        return false;
    }
}
