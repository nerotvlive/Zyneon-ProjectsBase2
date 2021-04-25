package de.nerotv.projectsbase.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Support implements CommandExecutor
{
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("support")) {
            s.sendMessage("§8§l==================§7§l(§dUtralo§7§l)§8§l==================");
            s.sendMessage("§fWenn du Hilfe bei etwas brauchst, oder eine Frage hast, melde");
            s.sendMessage("§fdich auf unserem §9Discord §fim §eSupportbereich§f, wir stehen dir");
            s.sendMessage("§fgerne zur Seite!");
            s.sendMessage("§f - §9Discordlink§8: §b§nhttps://discord.gg/6CnEEJc");
            s.sendMessage("§8§l==================§7§l(§dUtralo§7§l)§8§l==================");
        }
        return false;
    }
}
