package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.API;
import de.nerotv.projectsbase.api.Start;
import de.nerotv.projectsbase.api.WorldAPI;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class Argria implements CommandExecutor {

    final File file = new File("plugins/Utralo/ProjectsBase.yml");
    final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("argria")) {
            if(!(s instanceof Player)) {
                s.sendMessage("Fehler beim ausführen des Befehls.");
            } else {
                Player p = (Player)s;
                if(args.length == 0) {
                    p.performCommand("fhbjsdfhjbgsdjkf");
                } else {
                    if(p.getName().equalsIgnoreCase(cfg.getString("Projektleitung.Name"))) {
                        if(args[0].equalsIgnoreCase("1")) {
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"setblock -2905 53 -389 redstone_block");
                            for(Player p2 : Bukkit.getOnlinePlayers()) {
                                API.clearPlayerChat(p2);
                                p2.setHealth(20);
                                p2.setFireTicks(0);
                                p2.setFoodLevel(20);
                                p2.setLevel(0);
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"clear "+p2.getName());
                            }
                            WorldAPI.setTime(0,"FW1");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"title @a subtitle \"§7startet in §e5 §7Sekunden§7!\"");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"title @a title \"§cArgria - Wolfshaven\"");
                            API.playGlobalSound(Sound.BLOCK_NOTE_BLOCK_GUITAR);
                            Bukkit.broadcastMessage("§cArgria - Wolfshaven §7startet in §e5§7 Sekunden!");
                        } else if(args[0].equalsIgnoreCase("2")) {
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"title @a subtitle \"§7startet in §e4 §7Sekunden§7!\"");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"title @a title \"§cArgria - Wolfshaven\"");
                            API.playGlobalSound(Sound.BLOCK_NOTE_BLOCK_GUITAR);
                            Bukkit.broadcastMessage("§cArgria - Wolfshaven §7startet in §e4§7 Sekunden!");
                        } else if(args[0].equalsIgnoreCase("3")) {
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"title @a subtitle \"§7startet in §e3 §7Sekunden§7!\"");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"title @a title \"§cArgria - Wolfshaven\"");
                            API.playGlobalSound(Sound.BLOCK_NOTE_BLOCK_GUITAR);
                            Bukkit.broadcastMessage("§cArgria - Wolfshaven §7startet in §e3§7 Sekunden!");
                        } else if(args[0].equalsIgnoreCase("4")) {
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"title @a subtitle \"§7startet in §e2 §7Sekunden§7!\"");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"title @a title \"§cArgria - Wolfshaven\"");
                            API.playGlobalSound(Sound.BLOCK_NOTE_BLOCK_GUITAR);
                            Bukkit.broadcastMessage("§cArgria - Wolfshaven §7startet in §e2§7 Sekunden!");
                        } else if(args[0].equalsIgnoreCase("5")) {
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "title @a subtitle \"§7startet in §e1 §7Sekunde§7!\"");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "title @a title \"§cArgria - Wolfshaven\"");
                            API.playGlobalSound(Sound.BLOCK_NOTE_BLOCK_GUITAR);
                            Bukkit.broadcastMessage("§cArgria - Wolfshaven §7startet in §e1§7 Sekunde!");
                        } else if(args[0].equalsIgnoreCase("6")) {
                            Bukkit.broadcastMessage("§cArgria - Wolfshaven §ejetzt§7!");
                            API.playGlobalSound(Sound.BLOCK_NOTE_BLOCK_GUITAR);
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "subtitle @a title \"§7startet §ejetzt§7!\"");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "title @a title \"§cArgria - Wolfshaven\"");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "rg delete Brunnen -w Oberwelt");
                            p.performCommand("worldborder set 60000000 1");
                            p.performCommand("farmwelt 1 1");
                            p.performCommand("worldborder set 60000000 1");
                            for(Player p2 : Bukkit.getOnlinePlayers()) {
                                if(p2.hasPermission("pb.core")) {
                                    API.clearPlayerChat(p2);
                                    p2.sendMessage("§cArgria - Wolfshaven §7startet in §e5§7 Sekunden!");
                                    p2.sendMessage("§cArgria - Wolfshaven §7startet in §e4§7 Sekunden!");
                                    p2.sendMessage("§cArgria - Wolfshaven §7startet in §e3§7 Sekunden!");
                                    p2.sendMessage("§cArgria - Wolfshaven §7startet in §e2§7 Sekunden!");
                                    p2.sendMessage("§cArgria - Wolfshaven §7startet in §e1§7 Sekunden!");
                                    p2.sendMessage("§cArgria - Wolfshaven §7startet §ejetzt§7!");
                                } else {
                                    API.doNothing();
                                }
                            }
                            API.clearPlayerChat(p);
                            p.sendMessage("§cArgria - Wolfshaven §7startet in §e5§7 Sekunden!");
                            p.sendMessage("§cArgria - Wolfshaven §7startet in §e4§7 Sekunden!");
                            p.sendMessage("§cArgria - Wolfshaven §7startet in §e3§7 Sekunden!");
                            p.sendMessage("§cArgria - Wolfshaven §7startet in §e2§7 Sekunden!");
                            p.sendMessage("§cArgria - Wolfshaven §7startet in §e1§7 Sekunden!");
                            p.sendMessage("§cArgria - Wolfshaven §7startet §ejetzt§7!");
                            for(Player p2 : Bukkit.getOnlinePlayers()) {
                                p2.setHealth(20);
                                p2.setFireTicks(0);
                                p2.setFoodLevel(20);
                                p2.performCommand("spawn 1 1");
                                p2.sendMessage("§aDanke! Danke, dass du Argria - Wolfshaven spielst!");
                                p2.setLevel(0);
                            }
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "clear @a");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"setblock -2905 53 -389 air");
                            WorldAPI.setTime(0,"Oberwelt");
                        } else if(args[0].equalsIgnoreCase("start")) {
                            for (Player p2 : Bukkit.getOnlinePlayers()) {
                                p2.performCommand("spawn 1 1");
                            }
                            Start thread = new Start(p);
                            thread.run();
                        } else if(args[0].equalsIgnoreCase("stop")) {
                            if(args.length == 2) {
                                if(args[1].equalsIgnoreCase("confirm")) {
                                    Bukkit.dispatchCommand(API.CS, "minecraft:tp "+p.getName()+" -2874 68 -586");
                                    p.performCommand("/pos1");
                                    Bukkit.dispatchCommand(API.CS, "minecraft:tp "+p.getName()+" -2846 68 -614");
                                    p.performCommand("/pos2");
                                    p.performCommand("spawn 1 1");
                                    p.performCommand("/expand 5000 up");
                                    p.performCommand("/expand 5000 down");
                                    p.performCommand("rg define Brunnen");
                                    p.performCommand("rg flag Brunnen interact deny");
                                    p.performCommand("rg flag Brunnen block-break deny");
                                    p.performCommand("rg flag Brunnen block-place deny");
                                    for (Player p2 : Bukkit.getOnlinePlayers()) {
                                        if(p2.getName().equalsIgnoreCase(cfg.getString("Projektleitung.Name"))) {
                                            API.doNothing();
                                        } else {
                                            p2.performCommand("spawn 1 1");
                                        }
                                        p2.setHealth(20);
                                        p2.setFoodLevel(20);
                                        p2.setFireTicks(0);
                                        p2.setLevel(0);
                                    }
                                    p.performCommand("worldborder set 28");
                                    p.performCommand("farmwelt 1 1");
                                    p.performCommand("worldborder set 3");
                                    p.performCommand("spawn 1 1");
                                    for (Player p2 : Bukkit.getOnlinePlayers()) {
                                        API.clearPlayerChat(p2);
                                        p2.sendMessage("§cArgria wurde gestoppt.");
                                    }
                                } else {
                                    p.performCommand("342535435");
                                }
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG,100,100);
                                p.sendMessage("§cArgria§8 | §7Bist du dir sicher? Wenn ja, dann gibt §e/argria stop confirm§7 ein.");
                            }
                        } else {
                            p.performCommand("43232543543534");
                        }
                    } else {
                        p.performCommand("safdoiksdghfsdfkjgjkdfjhgdfsgjklfdsg");
                    }
                }
            }
        }
        return false;
    }
}