package de.nerotv.projectsbase.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Msg implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("msg")) {
            if(!(s instanceof Player)) {
                if(args.length >= 2) {
                    String msg="";
                    for(int i=1;i<args.length;i++) {
                        msg=msg+args[i]+" ";
                    }
                    if(Bukkit.getPlayer(args[0]) != null) {
                        Player p2 = Bukkit.getPlayer(args[0]);
                        p2.sendMessage("§8[§7MSG§8] §4Server §f-> §6Dir§8: §7"+msg.replace("&","§"));
                        s.sendMessage("§8[§7MSG§8] §eDu §f-> §e"+p2.getName()+"§8: §7"+msg);
                    } else {
                        s.sendMessage("Dieser Spieler ist nicht online!");
                    }
                } else {
                    s.sendMessage("msg [Spieler] <Nachricht>");
                }
            } else {
                Player p = (Player)s;
                if(args.length >= 2) {
                    String msg="";
                    for(int i=1;i<args.length;i++) {
                        msg=msg+args[i]+" ";
                    }
                    if(args[0].equalsIgnoreCase("Server")) {
                        p.sendMessage("§8[§7MSG§8] §6Du §f-> §4Server§8: §7"+msg);
                        Bukkit.getConsoleSender().sendMessage("§8[§7MSG§8] §e"+p.getName()+" §f-> §6Dir§8: §7"+msg);
                    } else {
                        if(Bukkit.getPlayer(args[0]) != null) {
                            Player p2 = Bukkit.getPlayer(args[0]);
                            p2.sendMessage("§8[§7MSG§8] §e"+p.getName()+" §f-> §6Dir§8: §7"+msg);
                            p.sendMessage("§8[§7MSG§8] §6Du §f-> §e"+p2.getName()+"§8: §7"+msg);
                        } else {
                            p.sendMessage("§cDer Spieler §4"+args[0]+"§c ist nicht online!");
                        }
                    }
                } else {
                    p.sendMessage("§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                    p.sendMessage("§4Fehler: §c/msg [Spieler] <Nachricht>");
                }
            }
        }
        return false;
    }
}
