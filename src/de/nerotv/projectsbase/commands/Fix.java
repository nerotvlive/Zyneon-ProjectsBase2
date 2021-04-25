package de.nerotv.projectsbase.commands;

import org.bukkit.Bukkit;
import de.nerotv.projectsbase.primal.Main;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Fix implements CommandExecutor
{
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("fix")) {
            if (!(s instanceof Player)) {
                s.sendMessage("Dieser Befehl kann nur als Spieler ausgeführt werden.");
            }
            else {
                final Player p = (Player)s;
                p.sendMessage("§9" + Main.Pre00 + " §8| §7Dein Spiel wird gefixt...");
                p.sendMessage("§9         §8  §8- §7 lade Crafting-Rezepte neu...");
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "minecraft:recipe take " + p.getName() + " *");
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "minecraft:recipe give " + p.getName() + " *");
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "minecraft:recipe take " + p.getName() + " iron_ingot_from_nuggets");
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "minecraft:recipe take " + p.getName() + " gold_ingot_from_nuggets");
                p.sendMessage("§9         §8  §8- §a Erfolg!");
                p.sendMessage("§9" + Main.Pre00 + " §8| §7Dein Spiel wurde §aerfolgreich§7 gefixt...");
                p.sendMessage("§7Bitte bedenke, dass dieser Befehl §8(/fix)§7 nur Probleme Seitens des Server beheben kann. Solltest du Probleme mit Bugs anderer Art haben, wie zum Beispiel Chunks, versuche §fF3+A§7 oder wende dich an unseren Support!");
            }
        }
        return false;
    }
}
