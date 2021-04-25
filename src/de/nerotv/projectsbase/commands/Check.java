package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.API;
import de.nerotv.projectsbase.api.LastLoc;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class Check implements CommandExecutor {

    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("check")) {
            if(s.hasPermission("pb.check")) {
                if(args.length == 0) {
                    s.sendMessage("/check [spieler]");
                } else {
                    Player pq = Bukkit.getPlayer(args[0]);
                    if(pq == null) {
                        File ULIST = new File("plugins/Utralo/UUIDList.yml");
                        YamlConfiguration UL = YamlConfiguration.loadConfiguration(ULIST);
                        API.reloadConfig(ULIST,UL);
                        if(UL.contains("UUID."+args[0])) {
                            String PID = UL.getString("UUID."+args[0]);
                            File List = new File("plugins/Utralo/Players/"+PID+".yml");
                            YamlConfiguration UUIDs = YamlConfiguration.loadConfiguration(List);
                            API.reloadConfig(List,UUIDs);
                            String PLN = UUIDs.getString(PID+".Name");
                            String RPN = UUIDs.getString("Spieler."+PID+".Roleplayname");
                            String RPJ = UUIDs.getString("Spieler."+PID+".Job");
                            String PAP = UUIDs.getString(PID+".AP");
                            Integer PP2 = Integer.parseInt(PAP)-1;
                            s.sendMessage("§8===========================================");
                            s.sendMessage("§eUUID: §6"+PID);
                            s.sendMessage("§eSpieler: §6"+PLN);
                            s.sendMessage("§eSpielmodus: §6Überlebensmodus");
                            s.sendMessage("§eIP-Adresse: §cNicht gespeichert");
                            s.sendMessage("§eRoleplay-Job: §6"+RPJ);
                            s.sendMessage("§eRoleplay-Name: §6"+RPN);
                            s.sendMessage("§eAchievement-Punkte: §6"+PP2+" AP");
                            s.sendMessage("§eBefindet sich in der Welt §6"+LastLoc.getWorldName(PID)+"§e bei §eX§6"+LastLoc.getXString(PID)+" §eY§6"+LastLoc.getYString(PID)+" §eZ§6"+LastLoc.getZString(PID));
                            s.sendMessage("§8===========================================");
                        } else {
                            s.sendMessage("§cDieser Spieler ist nicht online!");
                        }
                    } else {
                        File List = new File("plugins/Utralo/Players/" + pq.getUniqueId().toString() + ".yml");
                        YamlConfiguration UUIDs = YamlConfiguration.loadConfiguration(List);
                        API.reloadConfig(List, UUIDs);
                        String PLN = pq.getName();
                        String PID = pq.getUniqueId().toString();
                        String RPN = UUIDs.getString("Spieler."+PID+".Roleplayname");
                        String RPJ = UUIDs.getString("Spieler."+PID+".Job");
                        String PAP = UUIDs.getString(PID+".AP");
                        Integer PP2 = Integer.parseInt(PAP)-1;
                        s.sendMessage("§8===========================================");
                        s.sendMessage("§eUUID: §6"+PID);
                        s.sendMessage("§eSpieler: §6"+PLN);
                        s.sendMessage("§eSpielmodus: §6"+API.getGameMode(pq));
                        s.sendMessage("§eIP-Adresse: §cNicht gespeichert");
                        s.sendMessage("§eRoleplay-Job: §6"+RPJ);
                        s.sendMessage("§eRoleplay-Name: §6"+RPN);
                        s.sendMessage("§eAchievement-Punkte: §6"+PP2+" AP");
                        s.sendMessage("§eBefindet sich in der Welt \"§6"+pq.getLocation().getWorld().getName()+"§e\" bei X§6"+pq.getLocation().getBlockX()+" §eY§6"+pq.getLocation().getBlockY()+" §eZ§6"+pq.getLocation().getBlockZ());
                        s.sendMessage("§8===========================================");
                    }
                }
            } else {
                s.sendMessage("§cDies darfst du nicht tun!");
            }
        }
        return false;
    }

}
