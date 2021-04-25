package de.nerotv.projectsbase.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import de.nerotv.projectsbase.primal.Main;
import org.bukkit.command.CommandExecutor;

public class Projectsbase implements CommandExecutor
{
    private Main MAIN;
    
    public Projectsbase(final Main main) {
        this.MAIN = main;
    }
    
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("projectsbase")) {
            s.sendMessage("Auf diesem Server läuft die ArgriaBase von NeroTV");
            s.sendMessage("checking Version...");
            s.sendMessage("Version: " + this.MAIN.getDescription().getVersion() + " für " + MAIN.getDescription().getAPIVersion());
        }
        return false;
    }
}
