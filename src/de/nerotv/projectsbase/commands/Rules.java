package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.primal.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Rules implements CommandExecutor
{
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("rules")) {
            if (args.length == 0) {
                s.sendMessage("§8§l==================§7§l(§dUtralo§7§l)§8§l==================");
                s.sendMessage("§fRegelwerk§8: §b§b" + Main.Rul00);
                s.sendMessage("§8§l==================§7§l(§dUtralo§7§l)§8§l==================");
            }
            else if (args[0].equalsIgnoreCase("update")) {
                s.sendMessage("§8§l==================§7§l(§dUtralo§7§l)§8§l==================");
                s.sendMessage("§4Achtung: §7Am Regelwerk wurden Änderungen vorgenommen, stelle");
                s.sendMessage("§7sicher, dass du diese kennst! Unwissenheit schützt vor Strafe nicht!");
                s.sendMessage("§fRegelwerk§8: §b§n" + Main.Rul00);
                s.sendMessage("§8§l==================§7§l(§dUtralo§7§l)§8§l==================");
            }
            else {
                s.sendMessage("§8§l==================§7§l(§dUtralo§7§l)§8§l==================");
                s.sendMessage("§fRegelwerk§8: §b§n" + Main.Rul00);
                s.sendMessage("§8§l==================§7§l(§dUtralo§7§l)§8§l==================");
            }
        }
        return false;
    }
}
