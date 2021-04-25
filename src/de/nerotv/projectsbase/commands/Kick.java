package de.nerotv.projectsbase.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Kick implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("kick")) {
            if(s.hasPermission("pb.team")) {
                if(args.length >= 2) {
                    if(Bukkit.getPlayer(args[0]) == null) {
                        s.sendMessage("§cDer Spieler §4"+args[0]+"§c ist nicht online!");
                    } else {
                        String reason="";
                        for(int i=1;i<args.length;i++) {
                            reason=reason+args[i]+" ";
                        }
                        Bukkit.getPlayer(args[0]).kickPlayer(reason.replace("&","§"));
                    }
                } else {
                    s.sendMessage("§4Du meinst: §c/kick [Spieler] §c[Grund]");
                }
            }
        }
        return false;
    }
}