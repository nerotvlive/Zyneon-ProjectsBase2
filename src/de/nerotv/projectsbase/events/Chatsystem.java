package de.nerotv.projectsbase.events;

import de.nerotv.projectsbase.api.API;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import java.util.UUID;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.Listener;

public class Chatsystem implements Listener
{
    @EventHandler
    public void onChat(final AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();
        final UUID PID = p.getUniqueId();
        final String SID = PID.toString();
        final File file = new File("plugins/Utralo/Players/" + SID + ".yml");
        YamlConfiguration usr = YamlConfiguration.loadConfiguration(file);
        usr = YamlConfiguration.loadConfiguration(file);
        final String PR = usr.getString("Spieler." + SID + ".Roleplay");
        String PJ;
        if (usr.getString("Spieler." + SID + ".Job") != null) {
            PJ = usr.getString("Spieler." + SID + ".Job");
        }
        else {
            PJ = "Arbeitslos";
        }
        String RP = "";
        String m = "";
        String RN = "";
        if (usr.contains("Spieler." + SID + ".Roleplayname")) {
            RN = usr.getString("Spieler." + SID + ".Roleplayname");
        }
        else {
            RN = p.getName();
        }
        if (p.hasPermission("pb.color")) {
            m = e.getMessage().replace("%", "%%").replace("&", "§");
        }
        else {
            m = e.getMessage().replace("%", "%%");
        }
        if (PR.equalsIgnoreCase("false")) {
            RP = "§7no-RP §8|";
            RN = p.getName();
        }
        else if (PR.equalsIgnoreCase("true")) {
            RP = "§6RP §8|";
        }
        else {
            RP = "§o§7Spectating §8|";
        }
        String RNN;
        if (usr.getString("Spieler." + SID + ".INF").equalsIgnoreCase("true")) {
            RNN = "§6§l" + RN;
        }
        else {
            RNN = RN;
        }
        String Format;
        e.setCancelled(true);
        if (PR.equalsIgnoreCase("true")) {
            String MSG2 = "%rp%%job%%player%&8: &f%msg%".replace("&", "§").replace("%rp%", RP).replace("%job%", " §7" + PJ + " §8| §e").replace("%player%", RNN.replace("beurlaubt", "nerotvlive")).replace("%msg%", m);
            for (Player p2 : Bukkit.getOnlinePlayers()) {
                if (p.getLocation().getWorld().getName().equals(p2.getLocation().getWorld().getName()) && p.getLocation().distance(p2.getLocation()) <= 29) {
                    p2.sendMessage(MSG2);
                }
            }
            Bukkit.getConsoleSender().sendMessage(MSG2);
            Format = "%rp%%job%%player%&8: &f%msg%".replace("&", "§").replace("%rp%", RP).replace("%job%", " §7" + PJ + " §8| §e");
        } else if(PR.contains("SPEC")) {
            for(Player all:Bukkit.getOnlinePlayers()) {
                if(API.isRP(all)) {
                    all.sendMessage("§8SPEC §8| §8"+p.getName()+"§8: §8"+API.removeFormat(e.getMessage()));
                } else {
                    all.sendMessage("§7SPEC §8| §7"+p.getName()+"§8: §7"+m);
                }
            }
            Bukkit.getConsoleSender().sendMessage("§7no-RP §8| §e"+RNN+"§8: §f"+m);
        } else {
            for(Player all:Bukkit.getOnlinePlayers()) {
                if(API.isRP(all)) {
                    all.sendMessage("§8no-RP §8| §8"+p.getName()+"§8: §8"+API.removeFormat(e.getMessage()));
                } else {
                    all.sendMessage("§7no-RP §8| §e"+RNN+"§8: §f"+m);
                }
            }
            Bukkit.getConsoleSender().sendMessage("§7no-RP §8| §e"+RNN+"§8: §f"+m);
        }
    }
}
