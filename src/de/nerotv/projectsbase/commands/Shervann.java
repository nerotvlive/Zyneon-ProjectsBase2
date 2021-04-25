package de.nerotv.projectsbase.commands;

import org.bukkit.World;
import org.bukkit.Sound;
import de.nerotv.projectsbase.primal.Main;
import org.bukkit.Location;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import org.bukkit.command.CommandExecutor;

public class Shervann implements CommandExecutor
{
    File file;
    YamlConfiguration loc;
    
    public Shervann() {
        this.file = new File("plugins/Utralo/Locations/Shervann.yml");
        this.loc = YamlConfiguration.loadConfiguration(this.file);
    }
    
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("shervann")) {
            if (!(s instanceof Player)) {
                s.sendMessage("Diseser Befehl kann nur von einem Spieler ausgeführt werden!");
            }
            else {
                if(args.length == 0) {
                    s.sendMessage("§cArgria§8 | §7Nutze bitte §e/warp§7 um dich zu Wegpunkten zu teleportieren.");
                } else {
                    final Player p = (Player)s;
                    final World w = Bukkit.getWorld(this.loc.getString("sher.world"));
                    final double x = this.loc.getDouble("sher.X");
                    final double y = this.loc.getDouble("sher.Y");
                    final double z = this.loc.getDouble("sher.Z");
                    final float yaw = (float)this.loc.getDouble("sher.Yaw");
                    final float pitch = (float)this.loc.getDouble("sher.Pitch");
                    final Location loc2 = new Location(w, x, y, z, yaw, pitch);
                    p.teleport(loc2);
                    p.sendMessage(Main.Pro02 + " §8| §7Du bist nun in §eShervann§7!");
                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
                }
            }
        }
        return false;
    }
}
