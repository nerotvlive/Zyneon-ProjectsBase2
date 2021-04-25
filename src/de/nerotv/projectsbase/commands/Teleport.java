package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.API;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport implements CommandExecutor {

    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("teleport")) {
            if(s.hasPermission("pb.teleport")) {
                if(!(s instanceof Player)) {
                    if(args.length < 2) {
                        s.sendMessage("/teleport [Spieler(Target)] [Spieler(Ziel)]");
                    } else if(args.length == 4) {
                        if(Bukkit.getPlayer(args[0]) == null) {
                            s.sendMessage("§cDer Spieler §4"+args[0]+"§c ist nicht online!");
                        } else {
                            if(API.isNumeric(args[1])) {
                                if(API.isNumeric(args[2])) {
                                    if(API.isNumeric(args[3])) {
                                        Player p = Bukkit.getPlayer(args[0]);
                                        double x = Double.parseDouble(args[1]);
                                        double y = Double.parseDouble(args[2]);
                                        double z = Double.parseDouble(args[3]);
                                        Location loc = new Location(p.getWorld(), x, y, z, p.getLocation().getYaw(), p.getLocation().getPitch());
                                        p.teleport(loc);
                                        s.sendMessage("§cArgria §8| §7Du hast den Spieler §e"+p.getName()+"§7 zu §e"+x+" "+y+" "+z+"§7 teleportiert!");
                                    } else {
                                        s.sendMessage("§cDie Position ist ungültig!");
                                    }
                                } else {
                                    s.sendMessage("§cDie Position ist ungültig!");
                                }
                            } else {
                                s.sendMessage("§cDie Position ist ungültig!");
                            }
                        }
                    } else {
                        if(Bukkit.getPlayer(args[0]) == null) {
                            s.sendMessage("§cDer Spieler §4"+args[0]+"§c ist nicht online!");
                        } else {
                            if(Bukkit.getPlayer(args[1]) == null) {
                                s.sendMessage("§cDer Spieler §4"+args[0]+"§c ist nicht online!");
                            } else {
                                Player p1 = Bukkit.getPlayer(args[0]);
                                Player p2 = Bukkit.getPlayer(args[1]);
                                Location loc = p2.getLocation();
                                p1.teleport(loc);
                                s.sendMessage("§cArgria §8| §7Du hast den Spieler §e"+Bukkit.getPlayer(args[0]).getName()+"§7 zu §e"+Bukkit.getPlayer(args[1]).getName()+"§7 teleportiert!");
                            }
                        }
                    }
                } else {
                    Player p = (Player)s;
                    if(args.length == 0) {
                        API.sendPlayerMsg(p,"§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                        p.sendMessage("§4Fehler: §c/teleport [Spielername] §7[Spielername]");
                    } else if(args.length == 1) {
                        if(Bukkit.getPlayer(args[0]) == null) {
                            p.sendMessage("§cDer Spieler §4"+args[0]+"§c ist nicht online!");
                        } else {
                            Location loc = Bukkit.getPlayer(args[0]).getLocation();
                            p.teleport(loc);
                            API.sendPlayerMsg(p,"§cArgria §8| §7Du hast dich zu §e"+args[0]+"§7 teleportiert.");
                        }
                    } else if(args.length == 2) {
                        if(Bukkit.getPlayer(args[0]) == null) {
                            p.sendMessage("§cDer Spieler §4"+args[0]+"§c ist nicht online!");
                        } else {
                            if(Bukkit.getPlayer(args[1]) == null) {
                                p.sendMessage("§cDer Spieler §4"+args[1]+"§c ist nicht online!");
                            } else {
                                Location loc = Bukkit.getPlayer(args[1]).getLocation();
                                Bukkit.getPlayer(args[0]).teleport(loc);
                                API.sendPlayerMsg(p,"§cArgria §8| §7Du hast den Spieler §e"+Bukkit.getPlayer(args[0]).getName()+"§7 zu §e"+Bukkit.getPlayer(args[1]).getName()+"§7 teleportiert!");
                            }
                        }
                    } else if(args.length == 3) {
                        if(API.isNumeric(args[0])) {
                            if (API.isNumeric(args[1])) {
                                if (API.isNumeric(args[2])) {
                                    double x = Double.parseDouble(args[0]);
                                    double y = Double.parseDouble(args[1]);
                                    double z = Double.parseDouble(args[2]);
                                    Location loc = new Location(p.getWorld(),x,y,z,p.getLocation().getYaw(),p.getLocation().getPitch());
                                    p.teleport(loc);
                                    API.sendPlayerMsg(p,"§cArgria §8| §7Du hast dich zu §e"+x+" "+y+" "+z+"§7 teleportiert!");
                                } else {
                                    s.sendMessage("§cDie Position ist ungültig!");
                                }
                            } else {
                                s.sendMessage("§cDie Position ist ungültig!");
                            }
                        } else {
                            s.sendMessage("§cDie Position ist ungültig!");
                        }
                    } else {
                        if(Bukkit.getPlayer(args[0]) == null) {
                            p.sendMessage("§cDer Spieler §4"+args[0]+"§c ist nicht online!");
                        } else {
                            if(API.isNumeric(args[1])) {
                                if (API.isNumeric(args[2])) {
                                    if (API.isNumeric(args[3])) {
                                        double x = Double.parseDouble(args[1]);
                                        double y = Double.parseDouble(args[2]);
                                        double z = Double.parseDouble(args[3]);
                                        Player p2 = Bukkit.getPlayer(args[0]);
                                        Location loc = new Location(p2.getWorld(),x,y,z,p2.getLocation().getYaw(),p2.getLocation().getPitch());
                                        p2.teleport(loc);
                                        API.sendPlayerMsg(p,"§cArgria §8| §7Du hast den Spieler §e"+p2.getName()+"§7 zu §e"+x+" "+y+" "+z+" §7teleportiert!");
                                    } else {
                                        s.sendMessage("§cDie Position ist ungültig!");
                                    }
                                } else {
                                    s.sendMessage("§cDie Position ist ungültig!");
                                }
                            } else {
                                s.sendMessage("§cDie Position ist ungültig!");
                            }
                        }
                    }
                }
            } else {
                s.sendMessage("§cDies darfst du nicht tun!");
            }
        }
        return false;
    }
}