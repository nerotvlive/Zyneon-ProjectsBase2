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

public class SetFarmwelt implements CommandExecutor
{
    File file;
    YamlConfiguration loc;
    
    public SetFarmwelt() {
        this.file = new File("plugins/Utralo/Locations/Farmwelt.yml");
        this.loc = YamlConfiguration.loadConfiguration(this.file);
    }
    
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("setFarmwelt")) {
            if (!(s instanceof Player)) {
                s.sendMessage("Diseser Befehl kann nur von einem Spieler ausgeführt werden!");
            }
            else {
                final Player p = (Player)s;
                if (p.hasPermission("pb.setfarmwelt")) {
                    this.loc.set("Farmwelt.world", (Object)p.getLocation().getWorld().getName());
                    this.loc.set("Farmwelt.X", (Object)p.getLocation().getX());
                    this.loc.set("Farmwelt.Y", (Object)p.getLocation().getY());
                    this.loc.set("Farmwelt.Z", (Object)p.getLocation().getZ());
                    this.loc.set("Farmwelt.Yaw", (Object)p.getLocation().getYaw());
                    this.loc.set("Farmwelt.Pitch", (Object)p.getLocation().getPitch());
                    try {
                        this.loc.save(this.file);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    API.reloadConfig(this.file, this.loc);
                    p.sendMessage(Main.Pre00 + " §8| §7Du hast §aerfolgreich§7 den §eSpawnpunkt für die Farmwelt§7 gesetzt!");
                }
                else {
                    p.sendMessage("§cDies darfst du nicht tun!");
                }
            }
        }
        return false;
    }
}
