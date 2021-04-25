package de.nerotv.projectsbase.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Buch implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("buch")) {
            if(s instanceof Player) {
                Player p = (Player)s;
                p.sendMessage("§cArgria§8 | §7Du hast ein Buch erhalten!");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"give "+p.getName()+" writable_book");
            }
        }
        return false;
    }
}