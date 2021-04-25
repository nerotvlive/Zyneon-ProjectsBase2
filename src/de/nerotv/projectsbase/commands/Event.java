package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.API;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Event implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equals("event")) {
            if(s.hasPermission("pb.event")) {
                if(args.length >= 2) {
                    if(args[0].equalsIgnoreCase("dorffest")) {
                        if(args[1].equalsIgnoreCase("true")) {
                            API.setDorffest(true);
                            s.sendMessage("§cArgria §8| §7Das Event §eDorffest§7 steht nun auf§8: §a"+API.isDorffest());
                        } else if(args[1].equalsIgnoreCase("false")) {
                            API.setDorffest(false);
                            s.sendMessage("§cArgria §8| §7Das Event §eDorffest§7 steht nun auf§8: §a"+API.isDorffest());
                        } else {
                            s.sendMessage("§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                            s.sendMessage("§4Fehler: §c/event [event] [true/false]");
                        }
                    } else {
                        s.sendMessage("§cDieses Event existiert nicht!");
                    }
                } else {
                    s.sendMessage("§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                    s.sendMessage("§4Fehler: §c/event [event] [true/false]");
                }
            } else {
                s.sendMessage("§cDieser Befehl existiert nicht!");
            }
        }
        return false;
    }
}
