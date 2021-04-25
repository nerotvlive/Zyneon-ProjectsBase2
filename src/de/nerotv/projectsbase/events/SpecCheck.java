package de.nerotv.projectsbase.events;

import de.nerotv.projectsbase.api.API;
import de.nerotv.projectsbase.primal.Main;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import java.io.File;
import java.util.UUID;

public class SpecCheck implements Listener {

    @EventHandler
    public void onGM(PlayerGameModeChangeEvent e) {
        Player p = e.getPlayer();
        UUID PID = p.getUniqueId();
        File file = new File("plugins/Utralo/Players/"+PID+".yml");
        YamlConfiguration usr = YamlConfiguration.loadConfiguration(file);
        API.reloadConfig(file,usr);
        if(e.getNewGameMode().equals(GameMode.SPECTATOR)) {
            if(API.isRP(p)) {
                usr.set("Spieler."+PID+".Roleplay","trueSPEC");
            } else {
                usr.set("Spieler."+PID+".Roleplay","falseSPEC");
            }
            API.saveConfig(file,usr);
            Main.setState(p);
        } else {
            if (usr.getString("Spieler."+PID+".Roleplay").contains("SPEC")) {
                String RPL = usr.getString("Spieler."+PID+".Roleplay");
                usr.set("Spieler."+PID+".Roleplay",RPL.replace("SPEC",""));
            }
            API.saveConfig(file,usr);
            Main.setState(p);
        }
    }
}