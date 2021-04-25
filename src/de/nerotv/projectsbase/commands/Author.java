package de.nerotv.projectsbase.commands;

import de.nerotv.projectsbase.primal.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Author implements CommandExecutor {

    private Main MAIN;
    public Author(final Main main) {
        this.MAIN = main;
    }

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("author")) {
            s.sendMessage("§8=================================================");
            s.sendMessage("");
            s.sendMessage("§dUtralo§8: §7ProjectsBase §7v§9"+MAIN.getDescription().getVersion());
            s.sendMessage("§fPlugin von §cnerotvlive§f.");
            s.sendMessage("");
            s.sendMessage("§8=================================================");
        }
        return false;
    }
}