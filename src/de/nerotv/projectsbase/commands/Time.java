package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.API;
import de.nerotv.projectsbase.api.WorldAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Time implements CommandExecutor {

    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("time")) {
            if(s.hasPermission("pb.time")) {
                if(!(s instanceof Player)) {
                    if(args.length < 3) {
                        s.sendMessage("/time [add/remove/set] [Wert] [Welt]");
                    } else {
                        if(args[0].equalsIgnoreCase("set")) {
                            if(API.isNumeric(args[1])) {
                                Integer Time = Integer.parseInt(args[1]);
                                WorldAPI.setTime(Time,args[2]);
                                s.sendMessage("§cArgria §8| §7Du hast die Zeit von der Welt §e"+args[2]+"§7 auf §e"+Time+"§7 gesetzt.");
                            } else {
                                if(args[1].equalsIgnoreCase("day")) {
                                    WorldAPI.setTime(0,args[2]);
                                    s.sendMessage("§cArgria §8| §7Du hast die Zeit von der Welt §e"+args[2]+"§7 auf §e"+"Tag"+"§7 gesetzt.");
                                } else if(args[1].equalsIgnoreCase("night")) {
                                    WorldAPI.setTime(15000,args[2]);
                                    s.sendMessage("§cArgria §8| §7Du hast die Zeit von der Welt §e"+args[2]+"§7 auf §e"+"Nacht"+"§7 gesetzt.");
                                } else {
                                    s.sendMessage("/time [add/remove/set] [Wert] [Welt]");
                                }
                            }
                        } else if(args[0].equalsIgnoreCase("add")) {
                            if(API.isNumeric(args[1])) {
                                Integer Time = Integer.parseInt(args[1]);
                                WorldAPI.addTime(Time,args[2]);
                                s.sendMessage("§cArgria §8| §7Du hast die Zeit von der Welt §e"+args[2]+"§7 um §e"+Time+"§7 erhöht.");
                            } else {
                                s.sendMessage("/time [add/remove/set] [Wert] [Welt]");
                            }
                        } else if(args[0].equalsIgnoreCase("remove")) {
                            if(API.isNumeric(args[1])) {
                                Integer Time = Integer.parseInt(args[1]);
                                WorldAPI.removeTime(Time,args[2]);
                                s.sendMessage("§cArgria §8| §7Du hast die Zeit von der Welt §e"+args[2]+"§7 um §e"+Time+"§7 verringert.");
                            } else {
                                s.sendMessage("/time [add/remove/set] [Wert] [Welt]");
                            }
                        } else {
                            s.sendMessage("/time [add/remove/set] [Wert] [Welt]");
                        }
                    }
                } else {
                    Player p = (Player)s;
                    if(args.length == 0) {
                        API.sendPlayerMsg(p,"§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                        p.sendMessage("§4Fehler: §c/time [add/remove/set] [Wert] §7(Welt)");
                    } else if(args.length == 1) {
                        API.sendPlayerMsg(p,"§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                        p.sendMessage("§4Fehler: §c/time [add/remove/set] [Wert] §7(Welt)");
                    } else if(args.length == 2) {
                        if(args[0].equalsIgnoreCase("add")) {
                            if(API.isNumeric(args[1])) {
                                Integer Time = Integer.parseInt(args[1]);
                                WorldAPI.addTime(Time,WorldAPI.playerWorld(p));
                                API.sendPlayerMsg(p,"§cArgria §8| §7Du hast die Zeit um §e"+Time+"§7 erhöht.");
                            } else {
                                API.sendPlayerMsg(p,"§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                                p.sendMessage("§4Fehler: §c/time [add/remove/set] [Wert] §7(Welt)");
                            }
                        } else if(args[0].equalsIgnoreCase("remove")) {
                            if(API.isNumeric(args[1])) {
                                Integer Time = Integer.parseInt(args[1]);
                                WorldAPI.removeTime(Time,WorldAPI.playerWorld(p));
                                API.sendPlayerMsg(p,"§cArgria §8| §7Du hast die Zeit um §e"+Time+"§7 verringert.");
                            } else {
                                API.sendPlayerMsg(p,"§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                                p.sendMessage("§4Fehler: §c/time [add/remove/set] [Wert] §7(Welt)");
                            }
                        } else if(args[0].equalsIgnoreCase("set")) {
                            if(API.isNumeric(args[1])) {
                                Integer Time = Integer.parseInt(args[1]);
                                WorldAPI.setTime(Time,WorldAPI.playerWorld(p));
                                API.sendPlayerMsg(p,"§cArgria §8| §7Du hast die Zeit auf §e"+Time+"§7 gesetzt.");
                            } else {
                                if(args[1].equalsIgnoreCase("day")) {
                                    WorldAPI.setTime(0,WorldAPI.playerWorld(p));
                                    API.sendPlayerMsg(p,"§cArgria §8| §7Du hast die Zeit auf §e"+"Tag"+"§7 gesetzt.");
                                } else if(args[1].equalsIgnoreCase("night")) {
                                    WorldAPI.setTime(15000,WorldAPI.playerWorld(p));
                                    API.sendPlayerMsg(p,"§cArgria §8| §7Du hast die Zeit auf §e"+"Nacht"+"§7 gesetzt.");
                                } else {
                                    API.sendPlayerMsg(p,"§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                                    p.sendMessage("§4Fehler: §c/time [add/remove/set] [Wert] §7(Welt)");
                                }
                            }
                        } else {
                            API.sendPlayerMsg(p,"§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                            p.sendMessage("§4Fehler: §c/time [add/remove/set] [Wert] §7(Welt)");
                        }
                    } else {
                        if(args[0].equalsIgnoreCase("add")) {
                            if(API.isNumeric(args[1])) {
                                Integer Time = Integer.parseInt(args[1]);
                                WorldAPI.addTime(Time,args[2]);
                                s.sendMessage("§cArgria §8| §7Du hast die Zeit von der Welt §e"+args[2]+"§7 um §e"+Time+"§7 erhöht.");
                            } else {
                                API.sendPlayerMsg(p,"§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                                p.sendMessage("§4Fehler: §c/time [add/remove/set] [Wert] §7(Welt)");
                            }
                        } else if(args[0].equalsIgnoreCase("remove")) {
                            if(API.isNumeric(args[1])) {
                                Integer Time = Integer.parseInt(args[1]);
                                WorldAPI.removeTime(Time,args[2]);
                                s.sendMessage("§cArgria §8| §7Du hast die Zeit von der Welt §e"+args[2]+"§7 um §e"+Time+"§7 erhöht.");
                            } else {
                                API.sendPlayerMsg(p,"§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                                p.sendMessage("§4Fehler: §c/time [add/remove/set] [Wert] §7(Welt)");
                            }
                        } else if(args[0].equalsIgnoreCase("set")) {
                            if(API.isNumeric(args[1])) {
                                Integer Time = Integer.parseInt(args[1]);
                                WorldAPI.setTime(Time,args[2]);
                                s.sendMessage("§cArgria §8| §7Du hast die Zeit von der Welt §e"+args[2]+"§7 auf §e"+Time+"§7 gesetzt.");
                            } else {
                                if(args[1].equalsIgnoreCase("day")) {
                                    WorldAPI.setTime(0,args[2]);
                                    s.sendMessage("§cArgria §8| §7Du hast die Zeit von der Welt §e"+args[2]+"§7 auf §e"+"Tag"+"§7 gesetzt.");
                                } else if(args[1].equalsIgnoreCase("night")) {
                                    WorldAPI.setTime(15000,args[2]);
                                    s.sendMessage("§cArgria §8| §7Du hast die Zeit von der Welt §e"+args[2]+"§7 auf §e"+"Nacht"+"§7 gesetzt.");
                                } else {
                                    API.sendPlayerMsg(p, "§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                                    p.sendMessage("§4Fehler: §c/time [add/remove/set] [Wert] §7(Welt)");
                                }
                            }
                        } else {
                            API.sendPlayerMsg(p,"§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                            p.sendMessage("§4Fehler: §c/time [add/remove/set] [Wert] §7[Welt]");
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