package de.nerotv.projectsbase.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import de.nerotv.projectsbase.primal.Main;
import org.bukkit.command.CommandExecutor;

public class Help implements CommandExecutor {

    private Main MAIN;
    public Help(final Main main) {
        this.MAIN = main;
    }
    
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("?")) {
            if(args.length == 0) {
                s.sendMessage("§7ProjectsBase §8-§7 by nerotvlive §8-§7 " + this.MAIN.getDescription().getVersion());
                s.sendMessage("§8==============§7(§dUtralo§7)§8==============");
                s.sendMessage("Projekt: " + Main.Pro02 + " §bv" + Main.Ver00);
                s.sendMessage("Art: " + Main.Art02);
                s.sendMessage("Leitung: " + Main.Own02);
                s.sendMessage(Main.Des00);
                s.sendMessage(Main.Des01);
                s.sendMessage(Main.Des02);
                s.sendMessage(Main.Des03);
                s.sendMessage("§8==============§7(§dUtralo§7)§8==============");
            } else if(args.length == 1) {
                if(args[0].equalsIgnoreCase("team")) {
                    if(s.hasPermission("pb.team")) {
                        s.sendMessage("§8=============§7(§dTeamhilfe 1/3§7)§8=============");
                        s.sendMessage("§7/§9cc §8- §7Leert den Chat für alle Spieler.");
                        s.sendMessage("§7/§9cc p §8- §7Leert den Chat nur für dich.");
                        s.sendMessage("§7/§9gm [0-3] §8- §7Wechselt deinen Spielmodus.");
                        s.sendMessage("§7/§9check [Spieler] §8-§7 zeigt dir nützliche");
                        s.sendMessage("§7Informationen zu einem Spieler an.");
                        s.sendMessage("§7/§9forcename [Spieler] [Vor-] (Mit-) [Nachname]");
                        s.sendMessage("§7Ändert den Roleplay-Namen eines Spielerns.");
                        s.sendMessage("§7/§9tp [Spieler] [Spieler/XYZ] §8- §7Teleportation");
                        s.sendMessage("§8=============§7(§dTeamhilfe 1/3§7)§8=============");
                    } else {
                        s.sendMessage("§7Utralo ProjectsBase §8-§7 by NeroTV §8-§7 " + this.MAIN.getDescription().getVersion());
                        s.sendMessage("§8==============§7(§dUtralo§7)§8==============");
                        s.sendMessage("Projekt: " + Main.Pro02 + " §bv" + Main.Ver00);
                        s.sendMessage("Art: " + Main.Art02);
                        s.sendMessage("Leitung: " + Main.Own02);
                        s.sendMessage(Main.Des00);
                        s.sendMessage(Main.Des01);
                        s.sendMessage(Main.Des02);
                        s.sendMessage(Main.Des03);
                        s.sendMessage("§8==============§7(§dUtralo§7)§8==============");
                    }
                } else {
                    s.sendMessage("§7ProjectsBase §8-§7 by nerotvlive §8-§7 " + this.MAIN.getDescription().getVersion());
                    s.sendMessage("§8==============§7(§dUtralo§7)§8==============");
                    s.sendMessage("Projekt: " + Main.Pro02 + " §bv" + Main.Ver00);
                    s.sendMessage("Art: " + Main.Art02);
                    s.sendMessage("Leitung: " + Main.Own02);
                    s.sendMessage(Main.Des00);
                    s.sendMessage(Main.Des01);
                    s.sendMessage(Main.Des02);
                    s.sendMessage(Main.Des03);
                    s.sendMessage("§8==============§7(§dUtralo§7)§8==============");
                }
            } else {
                if(args[0].equalsIgnoreCase("team")) {
                    if(s.hasPermission("pb.team")) {
                        if(args[1].equalsIgnoreCase("1")) {
                            s.sendMessage("§8=============§7(§dTeamhilfe 1/3§7)§8=============");
                            s.sendMessage("§7/§9cc §8- §7Leert den Chat für alle Spieler.");
                            s.sendMessage("§7/§9cc p §8- §7Leert den Chat nur für dich.");
                            s.sendMessage("§7/§9gm [0-3] §8- §7Wechselt deinen Spielmodus.");
                            s.sendMessage("§7/§9check [Spieler] §8-§7 zeigt dir nützliche");
                            s.sendMessage("§7Informationen zu einem Spieler an.");
                            s.sendMessage("§7/§9forcename [Spieler] [Vor-] (Mit-) [Nachname]");
                            s.sendMessage("§7Ändert den Roleplay-Namen eines Spielerns.");
                            s.sendMessage("§7/§9tp [Spieler] [Spieler/XYZ] §8- §7Teleportation");
                            s.sendMessage("§8=============§7(§dTeamhilfe 1/3§7)§8=============");
                        } else if(args[1].equalsIgnoreCase("2")) {
                            s.sendMessage("§8=============§7(§dTeamhilfe 2/3§7)§8=============");
                            s.sendMessage("§7/§9invsee [Spieler] §8- §7Zeigt dir das Inventar");
                            s.sendMessage("§7eines Spielers an.");
                            s.sendMessage("§7/§9invsee armor [Spieler] §8- §7Zeigt dir die");
                            s.sendMessage("§7Aktive Rüstung eines Spielers an.");
                            s.sendMessage("§7/§9ban [Spieler] [Grund] §8- §7Spieler sperren");
                            s.sendMessage("§7/§9unban [Spieler/ID/IP] §8- §7Spieler entsperren");
                            s.sendMessage("§7/§9kick [Spieler] [Grund] §8- §7Spieler kicken");
                            s.sendMessage("§7/§9lb tool §8- §7Gibt dir das LogBlock-Tool");
                            s.sendMessage("§8=============§7(§dTeamhilfe 2/3§7)§8=============");
                        } else if(args[1].equalsIgnoreCase("3")) {
                            s.sendMessage("§8=============§7(§dTeamhilfe 3/3§7)§8=============");
                            s.sendMessage("§7/§9srl §8- §7Startet den Server neu.");
                            s.sendMessage("§7/§9money cheat start §8- §7Cheatet dir jedes Item");
                            s.sendMessage("§7/§9forcejob§8 - §7Ändert den Job eines Spielers");
                            s.sendMessage("§7der Ingame-Währung. Nur in Notfällen benutzen.");
                            s.sendMessage("§fHilfe zum LogBlock-Tool:");
                            s.sendMessage("§7Das LogBlock-Tool zeigt dir, wenn du damit");
                            s.sendMessage("§7Rechtsklick auf einen Block machst, den Log eines");
                            s.sendMessage("§7Blocks an.");
                            s.sendMessage("§8=============§7(§dTeamhilfe 3/3§7)§8=============");
                        } else {
                            s.sendMessage("§4Fehler: §cNutze /help team [1-3]");
                        }
                    } else {
                        s.sendMessage("§7ProjectsBase §8-§7 by nerotvlive §8-§7 " + this.MAIN.getDescription().getVersion());
                        s.sendMessage("§8==============§7(§dUtralo§7)§8==============");
                        s.sendMessage("Projekt: " + Main.Pro02 + " §bv" + Main.Ver00);
                        s.sendMessage("Art: " + Main.Art02);
                        s.sendMessage("Leitung: " + Main.Own02);
                        s.sendMessage(Main.Des00);
                        s.sendMessage(Main.Des01);
                        s.sendMessage(Main.Des02);
                        s.sendMessage(Main.Des03);
                        s.sendMessage("§8==============§7(§dUtralo§7)§8==============");
                    }
                } else {
                    s.sendMessage("§7ProjectsBase §8-§7 by nerotvlive §8-§7 " + this.MAIN.getDescription().getVersion());
                    s.sendMessage("§8==============§7(§dUtralo§7)§8==============");
                    s.sendMessage("Projekt: " + Main.Pro02 + " §bv" + Main.Ver00);
                    s.sendMessage("Art: " + Main.Art02);
                    s.sendMessage("Leitung: " + Main.Own02);
                    s.sendMessage(Main.Des00);
                    s.sendMessage(Main.Des01);
                    s.sendMessage(Main.Des02);
                    s.sendMessage(Main.Des03);
                    s.sendMessage("§8==============§7(§dUtralo§7)§8==============");
                }
            }
        }
        return false;
    }
}
