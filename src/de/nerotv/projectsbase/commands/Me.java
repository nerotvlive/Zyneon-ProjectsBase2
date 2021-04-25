package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.API;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Me implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("me")) {
            if(args.length >= 1) {
                if(!(s instanceof Player)) {
                    s.sendMessage("Dazu musst du ein Spieler sein!");
                } else {
                    Player p = (Player)s;
                    String msg="";
                    for(int i = 0; i<args.length;i++) {
                        msg = msg+args[i]+" ";
                    }
                    for(Player all : Bukkit.getOnlinePlayers()) {
                        if(p.getLocation().getWorld().getName().equals(all.getLocation().getWorld().getName()) && p.getLocation().distance(all.getLocation()) <= 29) {
                            all.sendMessage("§6* §e"+ API.resolveName(p)+"§7 "+msg+"§6*");
                        }
                    }
                }
            } else {
                s.sendMessage("§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                s.sendMessage("§4Fehler: §c/me [Inhalt]");
            }
        }
        return false;
    }
}