package de.nerotv.projectsbase.api;
import de.nerotv.projectsbase.primal.Main;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import static org.bukkit.Bukkit.getServer;

public class AutoBroadcast {

    private static Main MAIN;
    public AutoBroadcast(final Main main) {
        this.MAIN = main;
    }

    static File Config = new File("plugins/Utralo/Broadcaster.yml");
    static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(Config);

    private static void saveDefaultConfig() {
        if(!(cfg.contains("Is.True"))) {
            cfg.set("broadcasts-enabled",true);
            cfg.set("broadcasts-interval",3600);
            cfg.set("Is.True","yes");
            try {
                cfg.save(Config);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void start() {
        saveDefaultConfig();
        startBroadcastTimer(getServer().getScheduler());
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("reloadbroadcasts")) {
            API.reloadConfig(Config,cfg);
            sender.sendMessage(ChatColor.GREEN + "Reloaded AutoBroadcast config and broadcasts");
            return true;
        }

        return false;
    }

    private static void startBroadcastTimer(BukkitScheduler scheduler) {
        int scheduleId = scheduler.scheduleSyncDelayedTask(Main.instance, () -> {
            if (cfg.getBoolean("broadcasts-enabled")) {
                Set<String> broadcastsList = cfg.getConfigurationSection("broadcasts").getKeys(false);
                String broadcastId = getRandomElement(broadcastsList);
                ConfigurationSection broadcast = cfg.getConfigurationSection("broadcasts." + broadcastId);
                for (String message : broadcast.getStringList("messages")) {
                    getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
                }
                if (broadcast.getString("sound") != null) {
                    for (Player p : getServer().getOnlinePlayers()) {
                        try {
                            p.playSound(p.getLocation(), Sound.valueOf(broadcast.getString("sound")), 5, 5);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            startBroadcastTimer(scheduler);
        }, cfg.getLong("broadcast-interval"));
    }

    private static String getRandomElement(Set<String> set) {
        int index = new Random().nextInt(set.size());
        Iterator<String> iter = set.iterator();
        for (int i = 0; i < index; i++) {
            iter.next();
        }
        return iter.next();
    }
}