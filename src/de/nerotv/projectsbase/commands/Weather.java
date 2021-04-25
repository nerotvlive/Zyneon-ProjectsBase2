package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.API;
import de.nerotv.projectsbase.api.WorldAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Weather implements CommandExecutor {

    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("weather")) {
            if(s.hasPermission("pb.weather")) {
                if(!(s instanceof Player)) {
                    if(args.length < 2) {
                        s.sendMessage("/weather [sun/thunder/rain] [Welt]");
                    } else {
                        if(args[0].equalsIgnoreCase("sun")) {
                            WorldAPI.setSun(args[1]);
                            s.sendMessage("§cArgria §8| §7Du hast das Wetter der Welt §e"+args[1]+"§7 auf §eKlar§7 gesetzt.");
                        } else if(args[0].equalsIgnoreCase("thunder")) {
                            WorldAPI.setStorm(args[1]);
                            s.sendMessage("§cArgria §8| §7Du hast das Wetter der Welt §e"+args[1]+"§7 auf §eGewitter§7 gesetzt.");
                        } else if(args[0].equalsIgnoreCase("rain")) {
                            WorldAPI.setRain(args[1]);
                            s.sendMessage("§cArgria §8| §7Du hast das Wetter der Welt §e"+args[1]+"§7 auf §eRegen§7 gesetzt.");
                        } else if(args[0].equalsIgnoreCase("storm")) {
                            WorldAPI.setStorm(args[1]);
                            s.sendMessage("§cArgria §8| §7Du hast das Wetter der Welt §e"+args[1]+"§7 auf §eGewitter§7 gesetzt.");
                        } else if(args[0].equalsIgnoreCase("clear")) {
                            WorldAPI.setSun(args[1]);
                            s.sendMessage("§cArgria §8| §7Du hast das Wetter der Welt §e"+args[1]+"§7 auf §eKlar§7 gesetzt.");
                        } else {
                            s.sendMessage("/weather [clear/sun/thunder/storm/rain] [Welt]");
                        }
                    }
                } else {
                    Player p = (Player)s;
                    if(args.length == 0) {
                        API.sendPlayerMsg(p,"§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                        p.sendMessage("§4Fehler: §c/weather [sun/thunder/rain] §7(Welt)");
                    } else if(args.length == 1) {
                        if(args[0].equalsIgnoreCase("sun")) {
                            WorldAPI.setSun(WorldAPI.playerWorld(p));
                            s.sendMessage("§cArgria §8| §7Du hast das Wetter auf §eKlar§7 gesetzt.");
                        } else if(args[0].equalsIgnoreCase("thunder")) {
                            WorldAPI.setStorm(WorldAPI.playerWorld(p));
                            s.sendMessage("§cArgria §8| §7Du hast das Wetter auf §eGewitter§7 gesetzt.");
                        } else if(args[0].equalsIgnoreCase("rain")) {
                            WorldAPI.setRain(WorldAPI.playerWorld(p));
                            s.sendMessage("§cArgria §8| §7Du hast das Wetter auf §eRegen§7 gesetzt.");
                        } else if(args[0].equalsIgnoreCase("storm")) {
                            WorldAPI.setStorm(WorldAPI.playerWorld(p));
                            s.sendMessage("§cArgria §8| §7Du hast das Wetter auf §eGewitter§7 gesetzt.");
                        } else if(args[0].equalsIgnoreCase("clear")) {
                            WorldAPI.setSun(WorldAPI.playerWorld(p));
                            s.sendMessage("§cArgria §8| §7Du hast das Wetter auf §eKlar§7 gesetzt.");
                        } else {
                            API.sendPlayerMsg(p,"§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                            p.sendMessage("§4Fehler: §c/weather [sun/thunder/rain] §7(Welt)");
                        }
                    } else {
                        String w = args[1];
                        if(args[0].equalsIgnoreCase("sun")) {
                            WorldAPI.setSun(w);
                            s.sendMessage("§cArgria §8| §7Du hast das Wetter der Welt §e"+w+"§7 auf §eKlar§7 gesetzt.");
                        } else if(args[0].equalsIgnoreCase("thunder")) {
                            WorldAPI.setStorm(w);
                            s.sendMessage("§cArgria §8| §7Du hast das Wetter der Welt §e"+w+"§7 auf §eGewitter§7 gesetzt.");
                        } else if(args[0].equalsIgnoreCase("rain")) {
                            WorldAPI.setRain(w);
                            s.sendMessage("§cArgria §8| §7Du hast das Wetter der Welt §e"+w+"§7 auf §eRegen§7 gesetzt.");
                        } else if(args[0].equalsIgnoreCase("storm")) {
                            WorldAPI.setStorm(w);
                            s.sendMessage("§cArgria §8| §7Du hast das Wetter der Welt §e"+w+"§7 auf §eGewitter§7 gesetzt.");
                        } else if(args[0].equalsIgnoreCase("clear")) {
                            WorldAPI.setSun(w);
                            s.sendMessage("§cArgria §8| §7Du hast das Wetter der Welt §e"+w+"§7 auf §eKlar§7 gesetzt.");
                        } else {
                            API.sendPlayerMsg(p,"§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                            p.sendMessage("§4Fehler: §c/weather [sun/thunder/rain] §7(Welt)");
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