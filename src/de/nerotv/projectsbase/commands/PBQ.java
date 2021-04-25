package de.nerotv.projectsbase.commands;

import java.util.UUID;
import de.nerotv.projectsbase.primal.Main;
import de.nerotv.projectsbase.api.API;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class PBQ implements CommandExecutor
{
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("pbq")) {
            if (!(s instanceof Player)) {
                if (args.length == 0) {
                    s.sendMessage("pbq set [Spieler] [Quest] [Level/Fortschritt]");
                }
                else if (args[0].equalsIgnoreCase("set") && s.hasPermission("pb.pbq.set")) {
                    if (args.length == 1) {
                        s.sendMessage("/pbq set [Spieler] [Quest] [Level/Fortschritt]");
                    }
                    else if (args.length == 2) {
                        s.sendMessage("/pbq set [Spieler] [Quest] [Level/Fortschritt]");
                    }
                    else {
                        final Player t = Bukkit.getPlayer(args[1]);
                        if (t == null) {
                            s.sendMessage("Dieser Spieler existiert nicht oder ist nicht online.");
                        }
                        else {
                            final String SID = t.getUniqueId().toString();
                            final File file = new File("plugins/Utralo/Players/" + SID + ".yml");
                            final YamlConfiguration usr = YamlConfiguration.loadConfiguration(file);
                            usr.set("Spieler." + t.getUniqueId().toString() + ".Quest." + args[2], (Object)args[3]);
                            s.sendMessage("Die Quest " + args[2] + " wurde für " + args[1] + " auf das Fortschrittslevel " + args[3] + " gesetzt.");
                            API.saveConfig(file, usr);
                        }
                    }
                }
            }
            else {
                final Player p = (Player)s;
                final UUID PID = p.getUniqueId();
                final String SID2 = PID.toString();
                final File file2 = new File("plugins/Utralo/Players/" + SID2 + ".yml");
                final YamlConfiguration usr2 = YamlConfiguration.loadConfiguration(file2);
                API.reloadConfig(file2, usr2);
                if (args.length == 0) {
                    p.performCommand("DiesenBefehlWirdEsNiemalsGebenDeshalbPerformstDuDenGerade");
                }
                else if (args[0].equalsIgnoreCase("set")) {
                    if (s.hasPermission("pb.pbq.set")) {
                        if (args.length == 1) {
                            s.sendMessage("§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                            s.sendMessage("§4Fehler:§c /pbq set [Spieler] [Quest] [Level/Fortschritt]");
                        }
                        else if (args.length == 2) {
                            s.sendMessage("§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                            s.sendMessage("§4Fehler:§c /pbq set [Spieler] [Quest] [Level/Fortschritt]");
                        }
                        else {
                            final Player t2 = Bukkit.getPlayer(args[1]);
                            if (t2 == null) {
                                s.sendMessage("§cDieser Spieler existiert nicht oder ist nicht online.");
                            }
                            else {
                                usr2.set("Spieler." + t2.getUniqueId().toString() + ".Quest." + args[2], (Object)args[3]);
                                s.sendMessage(Main.Pro02 + "§8 | §7Die Quest §e" + args[2] + " §7wurde für §e" + args[1] + "§7 auf das Fortschrittslevel §e" + args[3] + " §7gesetzt.");
                                API.saveConfig(file2, usr2);
                            }
                        }
                    }
                    else {
                        p.performCommand("DiesenBefehlWirdEsNiemalsGebenDeshalbPerformstDuDenGerade");
                    }
                }
                else if (args[0].equalsIgnoreCase("kaptn")) {
                    if (usr2.contains("Spieler." + SID2 + ".Quest.Kaptn")) {
                        if (usr2.getString("Spieler." + SID2 + ".Quest.Kaptn", "1").equalsIgnoreCase("0")) {
                            usr2.set("Spieler." + SID2 + ".Quest.Kaptn", (Object)"1");
                        }
                        if (usr2.getString("Spieler." + SID2 + ".Quest.Kaptn").equalsIgnoreCase("1")) {
                            s.sendMessage("Hast du schon mit dem Graphen gesprochen?");
                            s.sendMessage("§aSprich mit Graph van Duin, er sollte im gro?en Gebäude nicht weit von hier sein.");
                        }
                        else if (usr2.getString("Spieler." + SID2 + ".Quest.Kaptn").equalsIgnoreCase("2")) {
                            usr2.set("Spieler." + SID2 + ".Quest.Kaptn", (Object)"3");
                        }
                        else {
                            s.sendMessage("§4Der Käpt'n §8-> §cDir§8: §7Ahoi Matrose! Ich hoffe dir hat die Überfaht vom Schandau hierher gefallen! Aber pass auf, wenn du vor'n an den Masten schaust, siehst du unsere Fahrpläne zum Sammeln von Materialien! Wenn du Lust hast, können wir dich mitnehm' Matrose!");
                        }
                    }
                    else {
                        usr2.set("Spieler." + SID2 + ".Quest.Kaptn", (Object)"1");
                    }
                }
                else if (args[0].equalsIgnoreCase("saergo")) {
                    s.sendMessage("§4Saergo §8-> §cDir§8: §7Pssst..eyy! Du wirkst wie eine starke Person auf mich, ja? Komm in ein paar Tagen wieder, ich hab da einen Auftrag für dich!");
                }
                else if (args[0].equalsIgnoreCase("natja")) {
                    s.sendMessage("§4Natja §8-> §cDir§8: §7Was macht ein Fremder in unserem Haus?! Ich hoffe Sie dürfen hier sein, sonst helfe ihn Gott!");
                }
                else if (args[0].equalsIgnoreCase("vanDuin")) {
                    if (!usr2.contains("Spieler." + SID2 + ".Quest.Kaptn")) {
                        p.sendMessage("§fWer sind Sie und was machen Sie hier? Wenn Sie zum Käpt'n gehören, sprechen Sie lieber erst mit ihm!");
                        p.sendMessage("§aSprich mit dem Käpt'n am Hafen.");
                    }
                    else if (usr2.getString("Spieler." + SID2 + ".Quest.Kaptn").equalsIgnoreCase("0")) {
                        p.sendMessage("§fWer sind Sie und was machen Sie hier? Wenn Sie zum K\u00e4pten geh\u00f6ren, sprechen Sie lieber erst mit ihm!");
                        p.sendMessage("§aSprich mit dem K\u00e4pten am Hafen.");
                    }
                    else if (usr2.getString("Spieler." + SID2 + ".Quest.Kaptn").equalsIgnoreCase("1")) {
                        usr2.set("Spieler." + SID2 + ".Quest.Kaptn", (Object)"2");
                        API.clearPlayerChat(p);
                        p.sendMessage("Sch\u00f6n, dass ihr endlich da seid! Ich werde dem K\u00e4pten seine Belohnung geben. Nun kehren Sie zu ihm zur\u00fcck um ihm zu sagen, er wird hier auch eine Hausierungsberechtigung erhalten, wenn er denn wolle.");
                        p.sendMessage("§aSprich wieder mit dem K\u00e4pten am Hafen.");
                    }
                    else if (usr2.getString("Spieler." + SID2 + ".Quest.Kaptn").equalsIgnoreCase("2")) {
                        p.sendMessage("Haben Sie bereits mit dem K\u00e4pten gesprochen?");
                        p.sendMessage("§aSprich wieder mit dem K\u00e4pten am Hafen.");
                    }
                    else {
                        p.sendMessage("§4Graph van Duin §8-> §cDir§8: §7Ich denke ich kann derzeit nichts f\u00fcr Sie tun, und Sie auch nichts f\u00fcr mich.");
                    }
                }
                API.saveConfig(file2, usr2);
                API.reloadConfig(file2, usr2);
            }
        }
        else if (cmd.getName().equalsIgnoreCase("saergo")) {
            if (!(s instanceof Player)) {
                s.sendMessage("Ein Spieler hat mit Saergo gesprochen.");
            }
            else {
                final Player p = (Player)s;
                p.performCommand("pbq saergo");
            }
        }
        else if (cmd.getName().equalsIgnoreCase("vanDuin")) {
            final Player p = (Player)s;
            p.performCommand("pbq vanDuin");
        }
        else if (cmd.getName().equalsIgnoreCase("KPTN")) {
            final Player p = (Player)s;
            p.performCommand("pbq kaptn");
        }
        else if (cmd.getName().equalsIgnoreCase("natja")) {
            final Player p = (Player)s;
            p.performCommand("pbq natja");
        }
        return false;
    }
}
