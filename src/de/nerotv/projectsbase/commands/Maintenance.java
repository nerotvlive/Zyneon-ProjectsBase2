package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.API;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Maintenance implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("maintenance")) {
            if(!(s instanceof Player)) {
                if(args.length == 0) {
                    s.sendMessage("§cArgria §8| §7Der §eWartungsmodus §7steht auf§8: §a§n"+API.isMaintenance()+"§r");
                } else {
                    if(args[0].equalsIgnoreCase("on")) {
                        API.setMaintenance(true);
                        s.sendMessage("§cArgria §8| §7Der §eWartungsmodus §7steht nun auf§8: §a§n"+API.isMaintenance()+"§r");
                    } else if(args[0].equalsIgnoreCase("off")) {
                        API.setMaintenance(false);
                        s.sendMessage("§cArgria §8| §7Der §eWartungsmodus §7steht nun auf§8: §a§n"+API.isMaintenance()+"§r");
                    } else {
                        API.toggleMaintenance();
                        s.sendMessage("§cArgria §8| §7Der §eWartungsmodus §7steht nun auf§8: §a§n"+API.isMaintenance()+"§r");
                    }
                }
            } else {
                Player p = (Player)s;
                if(p.hasPermission("ProjectLeading.Permission")) {
                    if(args.length == 0) {
                        s.sendMessage("§cArgria §8| §7Der §eWartungsmodus §7steht auf§8: §a§n"+API.isMaintenance()+"§r");
                    } else {
                        if(args[0].equalsIgnoreCase("on")) {
                            API.setMaintenance(true);
                            s.sendMessage("§cArgria §8| §7Der §eWartungsmodus §7steht nun auf§8: §a§n"+API.isMaintenance()+"§r");
                        } else if(args[0].equalsIgnoreCase("off")) {
                            API.setMaintenance(false);
                            s.sendMessage("§cArgria §8| §7Der §eWartungsmodus §7steht nun auf§8: §a§n"+API.isMaintenance()+"§r");
                        } else {
                            API.toggleMaintenance();
                            s.sendMessage("§cArgria §8| §7Der §eWartungsmodus §7steht nun auf§8: §a§n"+API.isMaintenance()+"§r");
                        }
                    }
                } else if(API.isLeading(p.getName())) {
                    if(args.length == 0) {
                        s.sendMessage("§cArgria §8| §7Der §eWartungsmodus §7steht auf§8: §a§n"+API.isMaintenance()+"§r");
                    } else {
                        if(args[0].equalsIgnoreCase("on")) {
                            API.setMaintenance(true);
                            s.sendMessage("§cArgria §8| §7Der §eWartungsmodus §7steht nun auf§8: §a§n"+API.isMaintenance()+"§r");
                        } else if(args[0].equalsIgnoreCase("off")) {
                            API.setMaintenance(false);
                            s.sendMessage("§cArgria §8| §7Der §eWartungsmodus §7steht nun auf§8: §a§n"+API.isMaintenance()+"§r");
                        } else {
                            API.toggleMaintenance();
                            s.sendMessage("§cArgria §8| §7Der §eWartungsmodus §7steht nun auf§8: §a§n"+API.isMaintenance()+"§r");
                        }
                    }
                } else {
                    p.performCommand("What?");
                }
            }
        }
        return false;
    }
}
