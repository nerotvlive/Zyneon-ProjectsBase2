package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.primal.Main;
import de.nerotv.projectsbase.api.API;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Name implements CommandExecutor
{
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("name")) {
            if (!(s instanceof Player)) {
                if (args.length == 0) {
                    s.sendMessage("/name [Spieler] [Name (Mitte) Nachname]");
                }
                else if (args.length == 1) {
                    s.sendMessage("/name [Spieler] [Name (Mitte) Nachname]");
                }
                else {
                    String RN = "";
                    final Player p = Bukkit.getPlayer(args[0]);
                    if (p == null) {
                        s.sendMessage("Dieser Spieler ist nicht verfügbar");
                    }
                    else {
                        final String SID = p.getUniqueId().toString();
                        final File file = new File("plugins/Utralo/Players/" + SID + ".yml");
                        final YamlConfiguration usr = YamlConfiguration.loadConfiguration(file);
                        if (args.length == 2) {
                            RN = args[1];
                        }
                        else if (args.length == 3) {
                            RN = args[1] + " " + args[2];
                        }
                        else if (args.length == 4) {
                            RN = args[1] + " " + args[2] + " " + args[3];
                        }
                        usr.set("Spieler." + p.getUniqueId().toString() + ".Roleplayname", (Object)RN);
                        API.saveConfig(file, usr);
                        API.reloadConfig(file, usr);
                        s.sendMessage("Du hast den Namen von " + p.getName() + " im Roleplay auf: " + RN + " gesetzt!");
                    }
                }
            }
            else {
                final Player p2 = (Player)s;
                final String SID2 = p2.getUniqueId().toString();
                final File file2 = new File("plugins/Utralo/Players/" + SID2 + ".yml");
                final YamlConfiguration usr2 = YamlConfiguration.loadConfiguration(file2);
                String RN2 = "";
                    if(args.length < 2) {
                        s.sendMessage("§4Fehler: §c/name [Vorname]§7 [Mittelname] §c[Nachname]");
                    } else if (args.length == 2) {
                        RN2 = args[0] + " " + args[1];
                        usr2.set("Spieler." + p2.getUniqueId().toString() + ".Roleplayname", (Object)RN2);
                        API.saveConfig(file2, usr2);
                        API.reloadConfig(file2, usr2);
                        s.sendMessage(Main.Pro02 + "§8 | §7Dein §eRoleplayname§7 lautet von nun an: §e" + RN2);
                    }
                    else {
                        RN2 = args[0] + " " + args[1] + " " + args[2];
                        usr2.set("Spieler." + p2.getUniqueId().toString() + ".Roleplayname", (Object)RN2);
                        API.saveConfig(file2, usr2);
                        API.reloadConfig(file2, usr2);
                        s.sendMessage(Main.Pro02 + "§8 | §7Dein §eRoleplayname§7 lautet von nun an: §e" + RN2);
                    }
                }
            }
        return false;
    }
}
