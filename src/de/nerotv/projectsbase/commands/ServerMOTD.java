package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.API;
import de.nerotv.projectsbase.api.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ServerMOTD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("changemotd")) {
            if(s.hasPermission("pb.changemotd")) {
                if(args.length >= 2) {
                    String msg="";
                    for(int i=1;i<args.length;i++) {
                        msg=msg+args[i]+" ";
                    }
                    if(args[0].equalsIgnoreCase("1")) {
                        API.setMOTD(Type.LINE1,msg);
                        s.sendMessage("§cArgria §8| §7Die MOTD-Zeile 1 steht nun auf§8: "+msg.replace("&","§"));
                    } else if(args[0].equalsIgnoreCase("2")) {
                        API.setMOTD(Type.LINE2,msg);
                        s.sendMessage("§cArgria §8| §7Die MOTD-Zeile 2 steht nun auf§8: "+msg.replace("&","§"));
                    } else {
                        s.sendMessage("§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                        s.sendMessage("§4Fehler: §c/changemotd [1/2] [Inhalt]");
                    }
                } else {
                    s.sendMessage("§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                    s.sendMessage("§4Fehler: §c/changemotd [1/2] [Inhalt]");
                }
            } else {
                s.sendMessage("§cDas darfst du nicht!");
            }
        }
        return false;
    }
}
