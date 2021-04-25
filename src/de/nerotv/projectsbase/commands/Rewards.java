package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.RewardAPI;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Rewards implements CommandExecutor
{
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("rewards")) {
            if (s instanceof Player) {
                final Player p = (Player)s;
                RewardAPI.intShop(p);
            }
        }
        return false;
    }
}
