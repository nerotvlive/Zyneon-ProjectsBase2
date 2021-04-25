package de.nerotv.projectsbase.api;

import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;

public class LastLoc {

    public static String getWorldName(String SID) {
        File file = new File("plugins/Utralo/Players/"+SID+".yml");
        YamlConfiguration usr = YamlConfiguration.loadConfiguration(file);
        API.reloadConfig(file,usr);
        if(usr.contains("LastLoc.World")) {
            return usr.getString("LastLoc.World");
        } else {
            return "§c?";
        }
    }

    public static String getXString(String SID) {
        File file = new File("plugins/Utralo/Players/"+SID+".yml");
        YamlConfiguration usr = YamlConfiguration.loadConfiguration(file);
        API.reloadConfig(file,usr);
        if(usr.contains("LastLoc.X")) {
            return usr.getString("LastLoc.X");
        } else {
            return "§c?";
        }
    }

    public static String getYString(String SID) {
        File file = new File("plugins/Utralo/Players/"+SID+".yml");
        YamlConfiguration usr = YamlConfiguration.loadConfiguration(file);
        API.reloadConfig(file,usr);
        if(usr.contains("LastLoc.Y")) {
            return usr.getString("LastLoc.Y");
        } else {
            return "§c?";
        }
    }

    public static String getZString(String SID) {
        File file = new File("plugins/Utralo/Players/"+SID+".yml");
        YamlConfiguration usr = YamlConfiguration.loadConfiguration(file);
        API.reloadConfig(file,usr);
        if(usr.contains("LastLoc.Z")) {
            return usr.getString("LastLoc.Z");
        } else {
            return "§c?";
        }
    }
}