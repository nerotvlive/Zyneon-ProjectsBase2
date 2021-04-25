package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.api.API;
import de.nerotv.projectsbase.primal.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SetFalkenwacht implements CommandExecutor {

    File file;
    YamlConfiguration loc;

    public SetFalkenwacht() {
        this.file = new File("plugins/Utralo/Locations/Falkenwacht.yml");
        this.loc = YamlConfiguration.loadConfiguration(this.file);
    }

    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("setfalkenwacht")) {
            if (!(s instanceof Player)) {
                s.sendMessage("Diseser Befehl kann nur von einem Spieler ausgeführt werden!");
            }
            else {
                final Player p = (Player)s;
                if (p.hasPermission("pb.setspawn")) {
                    this.loc.set("Falkenwacht.world", (Object)p.getLocation().getWorld().getName());
                    this.loc.set("Falkenwacht.X", (Object)p.getLocation().getX());
                    this.loc.set("Falkenwacht.Y", (Object)p.getLocation().getY());
                    this.loc.set("Falkenwacht.Z", (Object)p.getLocation().getZ());
                    this.loc.set("Falkenwacht.Yaw", (Object)p.getLocation().getYaw());
                    this.loc.set("Falkenwacht.Pitch", (Object)p.getLocation().getPitch());
                    try {
                        this.loc.save(this.file);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    API.reloadConfig(this.file, this.loc);
                    p.sendMessage(Main.Pre00 + " §8| §7Du hast §aerfolgreich§7 den §eSpawnpunkt§7 gesetzt!");
                }
                else {
                    p.sendMessage("§cDies darfst du nicht tun!");
                }
            }
        }
        return false;
    }
}