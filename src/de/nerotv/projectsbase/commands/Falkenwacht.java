package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.primal.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import java.io.File;

public class Falkenwacht implements CommandExecutor {

    File file;
    YamlConfiguration loc;

    public Falkenwacht() {
        this.file = new File("plugins/Utralo/Locations/Falkenwacht.yml");
        this.loc = YamlConfiguration.loadConfiguration(this.file);
    }

    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("falkenwacht")) {
            if (!(s instanceof Player)) {
                s.sendMessage("Diseser Befehl kann nur von einem Spieler ausgeführt werden!");
            }
            else {
                if(args.length == 0) {
                    s.sendMessage("§cArgria§8 | §7Nutze bitte §e/warp§7 um dich zu Wegpunkten zu teleportieren.");
                } else {
                    final Player p = (Player)s;
                    final World w = Bukkit.getWorld(this.loc.getString("Falkenwacht.world"));
                    final double x = this.loc.getDouble("Falkenwacht.X");
                    final double y = this.loc.getDouble("Falkenwacht.Y");
                    final double z = this.loc.getDouble("Falkenwacht.Z");
                    final float yaw = (float)this.loc.getDouble("Falkenwacht.Yaw");
                    final float pitch = (float)this.loc.getDouble("Falkenwacht.Pitch");
                    final Location loc2 = new Location(w, x, y, z, yaw, pitch);
                    p.teleport(loc2);
                    p.sendMessage(Main.Pro02 + " §8| §7Du bist nun am Stadttor von §eWolfshaven§7!");
                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
                }
            }
        }
        return false;
    }
}
