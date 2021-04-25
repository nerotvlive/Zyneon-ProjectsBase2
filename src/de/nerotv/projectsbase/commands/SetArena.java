package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.primal.Main;
import de.nerotv.projectsbase.api.API;
import java.io.IOException;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import org.bukkit.command.CommandExecutor;

public class SetArena implements CommandExecutor
{
    File file;
    YamlConfiguration loc;
    
    public SetArena() {
        this.file = new File("plugins/Utralo/Locations/Arena.yml");
        this.loc = YamlConfiguration.loadConfiguration(this.file);
    }
    
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("setArena")) {
            if (!(s instanceof Player)) {
                s.sendMessage("Diseser Befehl kann nur von einem Spieler ausgeführt werden!");
            }
            else {
                final Player p = (Player)s;
                if (p.hasPermission("pb.setarena")) {
                    this.loc.set("Arena.world", (Object)p.getLocation().getWorld().getName());
                    this.loc.set("Arena.X", (Object)p.getLocation().getX());
                    this.loc.set("Arena.Y", (Object)p.getLocation().getY());
                    this.loc.set("Arena.Z", (Object)p.getLocation().getZ());
                    this.loc.set("Arena.Yaw", (Object)p.getLocation().getYaw());
                    this.loc.set("Arena.Pitch", (Object)p.getLocation().getPitch());
                    try {
                        this.loc.save(this.file);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    API.reloadConfig(this.file, this.loc);
                    p.sendMessage(Main.Pre00 + " §8| §7Du hast §aerfolgreich§7 den §eSpawnpunkt für die Arena§7 gesetzt!");
                }
                else {
                    p.sendMessage("§cDies darfst du nicht tun!");
                }
            }
        }
        return false;
    }
}
