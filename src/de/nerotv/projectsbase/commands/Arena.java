package de.nerotv.projectsbase.commands;

import org.bukkit.World;
import org.bukkit.Sound;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import org.bukkit.command.CommandExecutor;

public class Arena implements CommandExecutor
{
    File file;
    YamlConfiguration loc;
    
    public Arena() {
        this.file = new File("plugins/Utralo/Locations/Arena.yml");
        this.loc = YamlConfiguration.loadConfiguration(this.file);
    }
    
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("arena")) {
            if (!(s instanceof Player)) {
                s.sendMessage("Diseser Befehl kann nur von einem Spieler ausgeführt werden!");
            }
            else {
                if(args.length == 0) {
                    s.sendMessage("§9Primal 2§8 | §7Nutze bitte §e/warp§7 um dich zu Wegpunkten zu teleportieren.");
                } else {
                    final Player p = (Player)s;
                    final World w = Bukkit.getWorld(this.loc.getString("Arena.world"));
                    final double x = this.loc.getDouble("Arena.X");
                    final double y = this.loc.getDouble("Arena.Y");
                    final double z = this.loc.getDouble("Arena.Z");
                    final float yaw = (float)this.loc.getDouble("Arena.Yaw");
                    final float pitch = (float)this.loc.getDouble("Arena.Pitch");
                    final Location loc2 = new Location(w, x, y, z, yaw, pitch);
                    p.teleport(loc2);
                    p.sendMessage(ChatColor.RED + "Argria " + ChatColor.DARK_GRAY + "| " + ChatColor.GRAY + "Du bist nun im " + ChatColor.YELLOW + "Nether" + ChatColor.GRAY + "!");
                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
                }
            }
        }
        return false;
    }
}
