package de.nerotv.projectsbase.events;

import de.nerotv.projectsbase.api.API;
import net.raidstone.wgevents.events.RegionEnteredEvent;
import net.raidstone.wgevents.events.RegionLeftEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class RegionEnter implements Listener {

    @EventHandler
    public void onRegion(RegionEnteredEvent e) {
        Player p = e.getPlayer();
        String RegionName = e.getRegionName();
        if(API.isDorffest()) {
            if (RegionName.equals("dorfplatz")) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "amusic random " + p.getName());
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "amusic shuffle " + p.getName());
            }
        }
    }

    @EventHandler
    public void onRegion2(RegionLeftEvent e) {
        Player p = e.getPlayer();
        String RegionName = e.getRegionName();
        if(RegionName.equals("dorfplatz")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"amusic stop "+p.getName());
        }
    }
}

