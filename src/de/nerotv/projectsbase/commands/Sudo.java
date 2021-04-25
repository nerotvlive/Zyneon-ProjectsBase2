package de.nerotv.projectsbase.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Sudo implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("sudo")) {
            if(s.hasPermission("teamleitung.sudo")) {
                if(!(s instanceof Player)) {
                    if(args.length >= 2) {
                        String cmnd="";
                        for(int i=1;i<args.length;i++) {
                            cmnd=cmnd+args[i]+" ";
                        }
                        if(Bukkit.getPlayer(args[0]) != null) {
                            s.sendMessage("§7Du hast §e"+Bukkit.getPlayer(args[0]).getName()+"§7 dazu gezwungen §6/"+cmnd+"§7auszuführen.");
                            Bukkit.getPlayer(args[0]).performCommand(cmnd);
                        } else {
                            s.sendMessage("§cDieser Spieler ist nicht online!");
                        }
                    }
                } else {
                    Player p = (Player)s;
                    if(args.length >= 2) {
                        String cmnd="";
                        for(int i=1;i<args.length;i++) {
                            cmnd=cmnd+args[i]+" ";
                        }
                        if(Bukkit.getPlayer(args[0]) != null) {
                            p.sendMessage("§7Du hast §e"+Bukkit.getPlayer(args[0]).getName()+"§7 dazu gezwungen §6/"+cmnd+"§7auszuführen.");
                            Bukkit.getPlayer(args[0]).performCommand(cmnd);
                        } else {
                            if(args[0].equalsIgnoreCase("console")) {
                                p.sendMessage("§7Du hast §eDie Konsole§7 dazu gezwungen §6/"+cmnd+"§7auszuführen.");
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(),cmnd);
                            } else {
                                p.sendMessage("§cDieser Spieler ist nicht online!");
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}