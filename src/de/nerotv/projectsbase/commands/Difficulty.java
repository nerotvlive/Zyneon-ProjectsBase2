package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.primal.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Difficulty implements CommandExecutor
{
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("difficulty")) {
            if (s.hasPermission("pb.difficulty")) {
                if (!(s instanceof Player)) {
                    if (args.length == 0) {
                        s.sendMessage("Fehler: /difficulty [0-3, get] [Welt]");
                    }
                    else if (args.length == 1) {
                        s.sendMessage("Fehler: /difficulty [0-3, get] [Welt]");
                    }
                    else if (args[1] == null) {
                        s.sendMessage("Die Welt " + args[1] + " existiert nicht!");
                    }
                    else if (args[0].equalsIgnoreCase("get")) {
                        s.sendMessage("Die Schwierigkeit der Welt " + args[1] + " ist " + Bukkit.getServer().getWorld(args[1]).getDifficulty() + "!");
                    }
                    else {
                        Main.changeDifficulty(args[1], args[0]);
                        s.sendMessage("Die Schwierigkeit der Welt " + args[1] + " wurde auf " + Bukkit.getServer().getWorld(args[1]).getDifficulty() + " gesetzt!");
                    }
                }
                else {
                    final Player p = (Player)s;
                    if (args.length == 0) {
                        p.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt §a" + p.getWorld().getName().toString() + "§7 ist §e" + p.getWorld().getDifficulty() + "§7!");
                    }
                    else if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("get")) {
                            p.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt §a" + p.getWorld().getName().toString() + "§7 ist §e" + p.getWorld().getDifficulty() + "§7!");
                        }
                        else if (args[0].equalsIgnoreCase("0")) {
                            Main.changeDifficulty2(p.getWorld(), args[0]);
                            s.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt§a " + p.getWorld().getName() + " §7wurde auf §e" + p.getWorld().getDifficulty() + " §7gesetzt!");
                        }
                        else if (args[0].equalsIgnoreCase("1")) {
                            Main.changeDifficulty2(p.getWorld(), args[0]);
                            s.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt§a " + p.getWorld().getName() + " §7wurde auf §e" + p.getWorld().getDifficulty() + " §7gesetzt!");
                        }
                        else if (args[0].equalsIgnoreCase("2")) {
                            Main.changeDifficulty2(p.getWorld(), args[0]);
                            s.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt§a " + p.getWorld().getName() + " §7wurde auf §e" + p.getWorld().getDifficulty() + " §7gesetzt!");
                        }
                        else if (args[0].equalsIgnoreCase("3")) {
                            Main.changeDifficulty2(p.getWorld(), args[0]);
                            s.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt§a " + p.getWorld().getName() + " §7wurde auf §e" + p.getWorld().getDifficulty() + " §7gesetzt!");
                        }
                        else if (args[0].equalsIgnoreCase("PEACE")) {
                            Main.changeDifficulty2(p.getWorld(), args[0]);
                            s.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt§a " + p.getWorld().getName() + " §7wurde auf §e" + p.getWorld().getDifficulty() + " §7gesetzt!");
                        }
                        else if (args[0].equalsIgnoreCase("PEACEFUL")) {
                            Main.changeDifficulty2(p.getWorld(), args[0]);
                            s.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt§a " + p.getWorld().getName() + " §7wurde auf §e" + p.getWorld().getDifficulty() + " §7gesetzt!");
                        }
                        else if (args[0].equalsIgnoreCase("PEACEFULL")) {
                            Main.changeDifficulty2(p.getWorld(), args[0]);
                            s.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt§a " + p.getWorld().getName() + " §7wurde auf §e" + p.getWorld().getDifficulty() + " §7gesetzt!");
                        }
                        else if (args[0].equalsIgnoreCase("EASY")) {
                            Main.changeDifficulty2(p.getWorld(), args[0]);
                            s.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt§a " + p.getWorld().getName() + " §7wurde auf §e" + p.getWorld().getDifficulty() + " §7gesetzt!");
                        }
                        else if (args[0].equalsIgnoreCase("NORMAL")) {
                            Main.changeDifficulty2(p.getWorld(), args[0]);
                            s.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt§a " + p.getWorld().getName() + " §7wurde auf §e" + p.getWorld().getDifficulty() + " §7gesetzt!");
                        }
                        else if (args[0].equalsIgnoreCase("HARD")) {
                            Main.changeDifficulty2(p.getWorld(), args[0]);
                            s.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt§a " + p.getWorld().getName() + " §7wurde auf §e" + p.getWorld().getDifficulty() + " §7gesetzt!");
                        }
                        else {
                            p.sendMessage("§c/command §cNEEDED §7OPTIONAL §FOPTIONAL-OPTIONAL");
                            p.sendMessage("§4Fehler: §c/difficulty §7[0-3, get, peaceful, easy, normal, hard] §f[Welt]");
                        }
                    }
                    else if (args[1] == null) {
                        p.sendMessage(Main.Pro02 + " §8| §cDie Welt §e" + args[1] + "§c existiert nicht!");
                    }
                    else if (args[0].equalsIgnoreCase("get")) {
                        p.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt §a" + Bukkit.getServer().getWorld(args[1]).getName().toString() + "§7 ist §e" + Bukkit.getServer().getWorld(args[1]).getDifficulty() + "§7!");
                    }
                    else if (args[0].equalsIgnoreCase("0")) {
                        Main.changeDifficulty2(Bukkit.getServer().getWorld(args[1]), args[0]);
                        s.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt§a " + Bukkit.getServer().getWorld(args[1]).getName() + " §7wurde auf §e" + Bukkit.getServer().getWorld(args[1]).getDifficulty() + " §7gesetzt!");
                    }
                    else if (args[0].equalsIgnoreCase("1")) {
                        Main.changeDifficulty2(Bukkit.getServer().getWorld(args[1]), args[0]);
                        s.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt§a " + Bukkit.getServer().getWorld(args[1]).getName() + " §7wurde auf §e" + Bukkit.getServer().getWorld(args[1]).getDifficulty() + " §7gesetzt!");
                    }
                    else if (args[0].equalsIgnoreCase("2")) {
                        Main.changeDifficulty2(Bukkit.getServer().getWorld(args[1]), args[0]);
                        s.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt§a " + Bukkit.getServer().getWorld(args[1]).getName() + " §7wurde auf §e" + Bukkit.getServer().getWorld(args[1]).getDifficulty() + " §7gesetzt!");
                    }
                    else if (args[0].equalsIgnoreCase("3")) {
                        Main.changeDifficulty2(Bukkit.getServer().getWorld(args[1]), args[0]);
                        s.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt§a " + Bukkit.getServer().getWorld(args[1]).getName() + " §7wurde auf §e" + Bukkit.getServer().getWorld(args[1]).getDifficulty() + " §7gesetzt!");
                    }
                    else if (args[0].equalsIgnoreCase("PEACE")) {
                        Main.changeDifficulty2(Bukkit.getServer().getWorld(args[1]), args[0]);
                        s.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt§a " + Bukkit.getServer().getWorld(args[1]).getName() + " §7wurde auf §e" + Bukkit.getServer().getWorld(args[1]).getDifficulty() + " §7gesetzt!");
                    }
                    else if (args[0].equalsIgnoreCase("PEACEFUL")) {
                        Main.changeDifficulty2(Bukkit.getServer().getWorld(args[1]), args[0]);
                        s.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt§a " + Bukkit.getServer().getWorld(args[1]).getName() + " §7wurde auf §e" + Bukkit.getServer().getWorld(args[1]).getDifficulty() + " §7gesetzt!");
                    }
                    else if (args[0].equalsIgnoreCase("PEACEFULL")) {
                        Main.changeDifficulty2(Bukkit.getServer().getWorld(args[1]), args[0]);
                        s.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt§a " + Bukkit.getServer().getWorld(args[1]).getName() + " §7wurde auf §e" + Bukkit.getServer().getWorld(args[1]).getDifficulty() + " §7gesetzt!");
                    }
                    else if (args[0].equalsIgnoreCase("EASY")) {
                        Main.changeDifficulty2(Bukkit.getServer().getWorld(args[1]), args[0]);
                        s.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt§a " + Bukkit.getServer().getWorld(args[1]).getName() + " §7wurde auf §e" + Bukkit.getServer().getWorld(args[1]).getDifficulty() + " §7gesetzt!");
                    }
                    else if (args[0].equalsIgnoreCase("NORMAL")) {
                        Main.changeDifficulty2(Bukkit.getServer().getWorld(args[1]), args[0]);
                        s.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt§a " + Bukkit.getServer().getWorld(args[1]).getName() + " §7wurde auf §e" + Bukkit.getServer().getWorld(args[1]).getDifficulty() + " §7gesetzt!");
                    }
                    else if (args[0].equalsIgnoreCase("HARD")) {
                        Main.changeDifficulty2(Bukkit.getServer().getWorld(args[1]), args[0]);
                        s.sendMessage(Main.Pro02 + " §8| §7Die Schwierigkeit der Welt§a " + Bukkit.getServer().getWorld(args[1]).getName() + " §7wurde auf §e" + Bukkit.getServer().getWorld(args[1]).getDifficulty() + " §7gesetzt!");
                    }
                    else {
                        p.sendMessage("§c/command §cNEEDED §7OPTIONAL §FOPTIONAL-OPTIONAL");
                        p.sendMessage("§4Fehler: §c/difficulty §7[0-3, get, peaceful, easy, normal, hard] §f[Welt]");
                    }
                }
            }
            else {
                s.sendMessage("§cDies darfst du nicht tun!");
            }
        }
        return false;
    }
}
