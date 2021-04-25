package de.nerotv.projectsbase.api;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class WorldAPI {

    public static String NoWorld = "§cDiese Welt wurde nicht gefunden.";

    public static World getWorld(String worldname) {
        if(Bukkit.getWorld(worldname) == null) { return null; } else {
            return Bukkit.getWorld(worldname);
        }
    }

    public static World playerWorld(Player player) {
        World Return;
        Return = player.getWorld();
        return Return;
    }

    public static void setTime(Integer time, World world) {
        if(world == null) { API.doNothing(); } else {
            long t = time.longValue();
            world.setTime(t);
            API.sendConsole("§7Die Zeit von Welt §e"+world.getName()+"§7 wurde auf §e"+time+" §7gesetzt.");
        }
    }

    public static void setTime(Integer time, String worldname) {
        if(Bukkit.getWorld(worldname) == null) { API.doNothing(); } else {
            World world = Bukkit.getWorld(worldname);
            long t = time.longValue();
            world.setTime(t);
            API.sendConsole("§7Die Zeit von Welt §e"+world.getName()+"§7 wurde auf §e"+time+" §7gesetzt.");
        }
    }

    public static void addTime(Integer time, World world) {
        if(world == null) { API.doNothing(); } else {
            long t = world.getTime()+time.longValue();
            world.setTime(t);
            API.sendConsole("§7Die Zeit von Welt §e"+world.getName()+"§7 wurde auf §e"+t+" §7gesetzt.");
        }
    }

    public static void addTime(Integer time, String worldname) {
        if(Bukkit.getWorld(worldname) == null) { API.doNothing(); } else {
            World world = Bukkit.getWorld(worldname);
            long t = world.getTime()+time.longValue();
            world.setTime(t);
            API.sendConsole("§7Die Zeit von Welt §e"+world.getName()+"§7 wurde auf §e"+t+" §7gesetzt.");
        }
    }

    public static void removeTime(Integer time, World world) {
        if(world == null) { API.doNothing(); } else {
            long t = world.getTime()-time.longValue();
            world.setTime(t);
            API.sendConsole("§7Die Zeit von Welt §e"+world.getName()+"§7 wurde auf §e"+t+" §7gesetzt.");
        }
    }

    public static void removeTime(Integer time, String worldname) {
        if(Bukkit.getWorld(worldname) == null) { API.doNothing(); } else {
            World world = Bukkit.getWorld(worldname);
            long t = world.getTime()-time.longValue();
            world.setTime(t);
            API.sendConsole("§7Die Zeit von Welt §e"+world.getName()+"§7 wurde auf §e"+t+" §7gesetzt.");
        }
    }

    public static void setSun(World world) {
        if(world == null) { API.doNothing(); } else {
            world.setThundering(false);
            world.setStorm(false);
            API.sendConsole("§7Das Wetter von Welt §e"+world.getName()+"§7 wurde auf §eSonne §7gesetzt.");
        }
    }

    public static void setSun(String worldname) {
        if(Bukkit.getWorld(worldname) == null) { API.doNothing(); } else {
            World world = Bukkit.getWorld(worldname);
            world.setThundering(false);
            world.setStorm(true);
            API.sendConsole("§7Das Wetter von Welt §e"+world.getName()+"§7 wurde auf §eSonne §7gesetzt.");
        }
    }

    public static void setRain(World world) {
        if(world == null) { API.doNothing(); } else {
            world.setThundering(false);
            world.setStorm(true);
            API.sendConsole("§7Das Wetter von Welt §e"+world.getName()+"§7 wurde auf §eRegen §7gesetzt.");
        }
    }

    public static void setRain(String worldname) {
        if(Bukkit.getWorld(worldname) == null) { API.doNothing(); } else {
            World world = Bukkit.getWorld(worldname);
            world.setThundering(false);
            world.setStorm(true);
            API.sendConsole("§7Das Wetter von Welt §e"+world.getName()+"§7 wurde auf §eRegen §7gesetzt.");
        }
    }

    public static void setStorm(World world) {
        if(world == null) { API.doNothing(); } else {
            world.setStorm(true);
            world.setThundering(true);
            API.sendConsole("§7Das Wetter von Welt §e"+world.getName()+"§7 wurde auf §eSturm §7gesetzt.");
        }
    }

    public static void setStorm(String worldname) {
        if(Bukkit.getWorld(worldname) == null) { API.doNothing(); } else {
            World world = Bukkit.getWorld(worldname);
            world.setStorm(true);
            world.setThundering(true);
            API.sendConsole("§7Das Wetter von Welt §e"+world.getName()+"§7 wurde auf §eSturm §7gesetzt.");
        }
    }

    public static void setDifficulty(World world, Difficulty difficulty) {
        if(world == null) { API.doNothing(); } else {
            world.setDifficulty(difficulty);
            API.sendConsole("§7Die Schwierigkeit von Welt §e"+world.getName()+"§7 wurde auf §e"+difficulty.name()+" §7gesetzt.");
        }
    }

    public static void setDifficulty(World world, String difficulty) {
        if(API.resolveDifficulty(difficulty)==null) { API.doNothing(); } else {
            if(world == null) { API.doNothing(); } else {
                world.setDifficulty(API.resolveDifficulty(difficulty));
                API.sendConsole("§7Die Schwierigkeit von Welt §e"+world.getName()+"§7 wurde auf §e"+world.getDifficulty().name()+" §7gesetzt.");
            }
        }
    }
}