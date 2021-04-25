package de.nerotv.projectsbase.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Chat implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("chat")) {
            if(!(s instanceof Player)) {
                if(args.length >= 1) {
                    String msg="";
                    for(int i=0;i<args.length;i++) {
                        msg=msg+args[i]+" ";
                    }
                    Bukkit.broadcastMessage("§6§lKonsole§8: §f"+msg.replace("&","§"));
                }
            } else {
                Player p = (Player)s;
                p.performCommand("diesen befehl gibt es nicht");
            }
        }
        return false;
    }
}