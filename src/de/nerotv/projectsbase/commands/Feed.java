package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.API;
import de.nerotv.projectsbase.primal.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Feed implements CommandExecutor
{
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("feed")) {
            if (s.hasPermission("pb.feed")) {
                if (!(s instanceof Player)) {
                    if (args.length == 0) {
                        s.sendMessage("/feed [Spieler]");
                    }
                    else {
                        final Player p = Bukkit.getPlayer(args[0]);
                        if (p == null) {
                            s.sendMessage("Dieser Spieler ist nicht online!");
                        }
                        else {
                            p.setFoodLevel(20);
                            API.sendPlayerMsg(p, Main.Pro02 + "§8 | §7Dein Hunger wurde aufgefüllt!");
                            s.sendMessage("Du hast " + p.getName() + "'s Hunger aufgefüllt.");
                        }
                    }
                }
                else {
                    final Player p = (Player)s;
                    if (args.length == 0) {
                        p.setFoodLevel(20);
                        API.sendPlayerMsg(p, Main.Pro02 + "§8 | §7Dein Hunger wurde aufgefüllt!");
                    }
                    else {
                        final Player t = Bukkit.getPlayer(args[0]);
                        if (t == null) {
                            API.sendPlayerMsg(p, "§cDieser Spieler ist nicht online!");
                        }
                        else {
                            t.setFoodLevel(20);
                            API.sendPlayerMsg(t, Main.Pro02 + "§8 | §7Dein Hunger wurde aufgefüllt!");
                            API.sendPlayerMsg(p, Main.Pro02 + "§8 | §7Du hast §e" + t.getName() + "s§7 Hunger aufgefüllt!");
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
