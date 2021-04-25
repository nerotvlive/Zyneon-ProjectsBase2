package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.API;
import de.nerotv.projectsbase.primal.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Heal implements CommandExecutor
{
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("heal")) {
            if (s.hasPermission("pb.heal")) {
                if (!(s instanceof Player)) {
                    if (args.length == 0) {
                        s.sendMessage("/heal [Spieler]");
                    }
                    else {
                        final Player p = Bukkit.getPlayer(args[0]);
                        if (p == null) {
                            s.sendMessage("Dieser Spieler ist nicht online!");
                        }
                        else {
                            p.setHealth(20.0);
                            p.setFireTicks(0);
                            p.setFoodLevel(20);
                            API.sendPlayerMsg(p, Main.Pro02 + "§8 | §7Du wurdest §ageheilt§7!");
                            s.sendMessage("Du hast " + p.getName() + " geheilt");
                        }
                    }
                }
                else {
                    final Player p = (Player)s;
                    if (args.length == 0) {
                        p.setHealth(20.0);
                        p.setFireTicks(0);
                        p.setFoodLevel(20);
                        API.sendPlayerMsg(p, Main.Pro02 + "§8 | §7Du hast dich §ageheilt§7!");
                    }
                    else {
                        final Player t = Bukkit.getPlayer(args[0]);
                        if (t == null) {
                            API.sendPlayerMsg(p, "§cDieser Spieler ist nicht online!");
                        }
                        else {
                            t.setHealth(20.0);
                            t.setFireTicks(0);
                            t.setFoodLevel(20);
                            API.sendPlayerMsg(t, Main.Pro02 + "§8 | §7Du wurdest §ageheilt§7!");
                            API.sendPlayerMsg(p, Main.Pro02 + "§8 | §7Du hast §e" + t.getName() + "§a geheilt§7!");
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
