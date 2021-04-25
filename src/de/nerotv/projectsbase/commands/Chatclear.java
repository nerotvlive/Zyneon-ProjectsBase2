package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.API;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public class Chatclear implements CommandExecutor
{
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("Chatclear")) {
            if (s.hasPermission("pb.chatclear")) {
                if(args.length == 0) {
                    for(Player all : Bukkit.getOnlinePlayers()) {
                        if(all.hasPermission("pb.bypassclear")) {
                            all.sendMessage("§7Der Chat wurde geleert, aber du kannst ihn noch sehen, weil du die Rechte dazu hast.");
                        } else {
                            API.clearPlayerChat(all);
                        }
                        Bukkit.getServer().getConsoleSender().sendMessage("§7Der Chat wurde geleert, aber du kannst ihn noch sehen, weil du die Rechte dazu hast.");
                    }
                } else {
                    if(args[0].equalsIgnoreCase("p")) {
                        if(!(s instanceof Player)) {
                            for(Player all : Bukkit.getOnlinePlayers()) {
                                if(all.hasPermission("pb.bypassclear")) {
                                    all.sendMessage("§7Der Chat wurde geleert, aber du kannst ihn noch sehen, weil du die Rechte dazu hast.");
                                } else {
                                    API.clearPlayerChat(all);
                                }
                                Bukkit.getServer().getConsoleSender().sendMessage("§7Der Chat wurde geleert, aber du kannst ihn noch sehen, weil du die Rechte dazu hast.");
                            }
                        } else {
                            Player p = (Player)s;
                            API.clearPlayerChat(p);
                        }
                    } else {
                        for(Player all : Bukkit.getOnlinePlayers()) {
                            if(all.hasPermission("pb.bypassclear")) {
                                all.sendMessage("§7Der Chat wurde geleert, aber du kannst ihn noch sehen, weil du die Rechte dazu hast.");
                            } else {
                                API.clearPlayerChat(all);
                            }
                            Bukkit.getServer().getConsoleSender().sendMessage("§7Der Chat wurde geleert, aber du kannst ihn noch sehen, weil du die Rechte dazu hast.");
                        }
                    }
                }
            }
            else {
                s.sendMessage("§cDas darfst du nicht tun!");
            }
        }
        return false;
    }
}
