package de.nerotv.projectsbase.commands;

import java.util.UUID;
import java.io.IOException;
import de.nerotv.projectsbase.primal.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class RP implements CommandExecutor
{
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("RP")) {
            final Player p = (Player)s;
            final UUID PID = p.getUniqueId();
            final String SID = PID.toString();
            final File file = new File("plugins/Utralo/Players/" + SID + ".yml");
            final YamlConfiguration usr = YamlConfiguration.loadConfiguration(file);
            if (usr.getString("Spieler." + SID + ".Roleplay").equalsIgnoreCase("true")) {
                usr.set("Spieler." + SID + ".Roleplay", (Object)"false");
                p.sendMessage(Main.Pre00 + " §8| §7Du hast den §eRoleplaymodus §7verlassen.");
                try {
                    usr.save(file);
                }
                catch (IOException ef) {
                    ef.printStackTrace();
                }
                Main.setState(p);
            }
            else {
                usr.set("Spieler." + SID + ".Roleplay", (Object)"true");
                p.sendMessage(Main.Pre00 + " §8| §7Du hast den §eRoleplaymodus §7betreten.");
                try {
                    usr.save(file);
                }
                catch (IOException ef) {
                    ef.printStackTrace();
                }
                Main.setState(p);
            }
            try {
                usr.save(file);
            }
            catch (IOException ef) {
                ef.printStackTrace();
            }
            Main.setState(p);
        }
        return false;
    }
}
