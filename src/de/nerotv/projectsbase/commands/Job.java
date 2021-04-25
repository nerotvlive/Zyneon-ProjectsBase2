package de.nerotv.projectsbase.commands;

import java.util.UUID;
import de.nerotv.projectsbase.api.API;
import de.nerotv.projectsbase.primal.Main;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Job implements CommandExecutor
{
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("Job")) {
            final Player p = (Player)s;
            final UUID PID = p.getUniqueId();
            final String SID = PID.toString();
            final File file = new File("plugins/Utralo/Players/" + SID + ".yml");
            final YamlConfiguration usr = YamlConfiguration.loadConfiguration(file);
            if (args.length == 0) {
                s.sendMessage("§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                s.sendMessage("§4Fehler: §c/job §c[NAME DES JOBS§7 (Maximal 3 Worte) §c]");
            }
            else if (args.length == 1) {
                if(API.isJobBlocked(args[0])) {
                    s.sendMessage("§cDieser Job ist nicht verfügbar.");
                } else {
                    usr.set("Spieler." + SID + ".Job", (Object) args[0]);
                    try {
                        usr.save(file);
                    } catch (IOException ef) {
                        ef.printStackTrace();
                    }
                    p.sendMessage(Main.Pro02 + " §8| §7Dein Job Wurde auf §a" + usr.getString("Spieler." + SID + ".Job") + "§7 gesetzt!");
                }
            }
            else if (args.length == 2) {
                if(API.isJobBlocked(args[0] + " " + args[1])) {
                    s.sendMessage("§cDieser Job ist nicht verfügbar.");
                } else {
                    usr.set("Spieler." + SID + ".Job", (Object) (args[0] + " " + args[1]));
                    try {
                        usr.save(file);
                    } catch (IOException ef) {
                        ef.printStackTrace();
                    }
                    p.sendMessage(Main.Pro02 + " §8| §7Dein Job Wurde auf §a" + usr.getString("Spieler." + SID + ".Job") + "§7 gesetzt!");
                }
            }
            else if (args.length == 3) {
                if(API.isJobBlocked(args[0] + " " + args[1] + " " + args[2])) {
                    s.sendMessage("§cDieser Job ist nicht verfügbar.");
                } else {
                    usr.set("Spieler." + SID + ".Job", (Object) (args[0] + " " + args[1] + " " + args[2]));
                    try {
                        usr.save(file);
                    } catch (IOException ef) {
                        ef.printStackTrace();
                    }
                    p.sendMessage(Main.Pro02 + " §8| §7Dein Job Wurde auf §a" + usr.getString("Spieler." + SID + ".Job") + "§7 gesetzt!");
                }
            }
            else {
                s.sendMessage("§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                s.sendMessage("§4Fehler: §c/job §c[NAME DES JOBS&7 (Maximal 3 Worte) §c]");
            }
            try {
                usr.save(file);
            }
            catch (IOException ef) {
                ef.printStackTrace();
            }
        }
        return false;
    }
}
