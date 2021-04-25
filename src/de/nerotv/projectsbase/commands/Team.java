package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.API;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Team implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("team")) {
            if(!(s instanceof Player)) {
                s.sendMessage("Du musst ein Spieler sein um diesen Befehl ausführen zu können.");
            } else {
                Player p = (Player)s;
                if(p.hasPermission("pb.teamstuff")) {
                    if(args.length == 0) {
                        p.sendMessage("/team [on/off/help]");
                    } else if(args.length == 1){
                        if(args[0].equalsIgnoreCase("help")) {
                            p.performCommand("help team");
                        } else if(args[0].equalsIgnoreCase("on")) {
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"pex user "+p.getName()+" add lwc.*");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"pex user "+p.getName()+" add LWC.*");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"pex user "+p.getName()+" add trust.*");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"pex user "+p.getName()+" add lwctrust.*");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"pex reload");
                            API.sendPlayerMsg(p,"§cDu hast die Sicherungsumgehungen eingeschalten.");
                        } else if(args[0].equalsIgnoreCase("off")) {
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"pex user "+p.getName()+" remove lwc.*");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"pex user "+p.getName()+" remove LWC.*");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"pex user "+p.getName()+" remove trust.*");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"pex user "+p.getName()+" remove lwctrust.*");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"pex reload");
                            API.sendPlayerMsg(p,"§cDu hast die Sicherungsumgehungen ausgeschalten.");
                        } else {
                            p.sendMessage("/team [on/off/help]");
                        }
                    } else {
                        if(args[0].equalsIgnoreCase("help")) {
                            p.performCommand("help team "+args[1]);
                        } else {
                            p.sendMessage("/team [on/off/help]");
                        }
                    }
                } else {
                    p.performCommand("say");
                }
            }
        }
        return false;
    }
}
