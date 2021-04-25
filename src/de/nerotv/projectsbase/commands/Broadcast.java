package de.nerotv.projectsbase.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Broadcast implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("broadcast")) {
            if(s.hasPermission("core.broadcast")) {
                if(args.length >= 1) {
                    String msg="";
                    for(int i=0;i<args.length;i++) {
                        msg=msg+args[i]+" ";
                    }
                    Bukkit.broadcastMessage("§c§lWICHTIG§r §8| §7"+msg.replace("&","§"));
                }
            }
        }
        return false;
    }
}
