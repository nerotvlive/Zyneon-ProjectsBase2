package de.nerotv.projectsbase.api;

import java.io.IOException;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.Sound;
import de.nerotv.projectsbase.primal.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.meta.ItemMeta;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Arrays;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.util.UUID;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Team;
import org.bukkit.scoreboard.Scoreboard;

public class API {

    private static Main MAIN;
    public API(final Main main) {
        this.MAIN = main;
    }

    public static Scoreboard RP;
    public static Team A00RP;
    public static Team B0NRP;
    public static Team CSPEC;
    public static ItemStack P001;
    public static ItemStack P002;
    public static ItemStack P005;
    public static ItemStack P010;
    public static ItemStack P020;
    public static ItemStack P050;
    public static ItemStack M001;
    public static ItemStack M002;
    public static ItemStack M005;
    public static ItemStack M010;
    public static ItemStack M020;
    public static ItemStack M050;
    public static ItemStack M100;
    public static ItemStack M200;
    public static ItemStack M500;
    public static ItemStack GUIP;
    public static ItemStack SPWN;
    public static ItemStack FWHO;
    public static ItemStack FWHV;
    public static ItemStack SHES;
    public static ItemStack SONS;
    public static ItemStack FLKW;
    public static ItemStack SHEV;
    public static ItemStack SHER;
    public static ItemStack FRMW;
    public static ItemStack ARNA;
    public static ItemStack PP001;
    public static ItemStack PP002;
    public static ItemStack GUI2;
    public static ItemStack PP005;
    public static ItemStack PP010;
    public static ItemStack PP020;
    public static ItemStack PP050;
    public static ItemStack PM001;
    public static ItemStack PM002;
    public static ItemStack PM005;
    public static ItemStack PM010;
    public static ItemStack PM020;
    public static ItemStack PM050;
    public static ItemStack PM100;
    public static ItemStack PM200;
    public static ItemStack PM500;

    public static void checkPlayerVersion(Player player) {

    }

    public static String getDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy.HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static String checkPayment(final Player p, final int price) {
        final File List = new File("plugins/Utralo/Players/" + p.getUniqueId().toString() + ".yml");
        final YamlConfiguration UUIDs = YamlConfiguration.loadConfiguration(List);
        reloadConfig(List, UUIDs);
        final int c = Integer.parseInt(UUIDs.getString(p.getUniqueId().toString() + ".AP"));
        final int pay = c - price;
        String Return;
        if (pay < 1) {
            Return = "decline";
        }
        else {
            final int pay2 = pay - 1;
            final String Result = String.valueOf(pay2);
            UUIDs.set(p.getUniqueId().toString() + ".AP", (Object)String.valueOf(pay));
            saveConfig(List, UUIDs);
            p.sendMessage("§9Primal 2 §8| §7Du hast nun §e" + Result + "§7 AP!");
            Return = "accept";
        }
        return Return;
    }

    public static void forceJob(String UUID2, String Job) {
        File file = new File("plugins/Utralo/Players/" + UUID2 + ".yml");
        YamlConfiguration usr = YamlConfiguration.loadConfiguration(file);
        API.reloadConfig(file,usr);
        usr.set("Spieler." + UUID2 + ".Job", Job);
        API.saveConfig(file,usr);
        API.reloadConfig(file,usr);
    }
    
    public static ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore((List)Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }
    
    public static void reloadConfigs() {
        final File file0 = new File("plugins/Utralo/ProjectsBase.yml");
        final YamlConfiguration API = YamlConfiguration.loadConfiguration(file0);
        final File file2 = new File("plugins/Utralo/Locations.yml");
        final YamlConfiguration loc = YamlConfiguration.loadConfiguration(file2);
        saveConfig(file0, API);
        saveConfig(file2, loc);
        reloadConfig(file0, API);
        reloadConfig(file2, loc);
        Bukkit.getConsoleSender().sendMessage(Main.Pro02);
        Bukkit.getConsoleSender().sendMessage(Main.Pro02 + "§8 | §fDie Plugin configs wurden neugeladen!");
        Bukkit.getConsoleSender().sendMessage(Main.Pro02);
    }
    
    public static String sendDialog(final String Sender, final String Empfänger, final String Nachricht) {
        final String Output = "§4" + Sender + "§8 -> §c" + Empfänger + "§8: " + Nachricht;
        return Output;
    }
    
    public static void changeGamemode(final Player p, final String GameMode) {
        if (GameMode.equalsIgnoreCase("0")) {
            p.setGameMode(org.bukkit.GameMode.SURVIVAL);
            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
            p.sendMessage(Main.Pro02 + "§8 |§7 Du bist nun im " + getGamemode(p) + "§7!");
        }
        else if (GameMode.equalsIgnoreCase("1")) {
            p.setGameMode(org.bukkit.GameMode.CREATIVE);
            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
            p.sendMessage(Main.Pro02 + "§8 |§7 Du bist nun im " + getGamemode(p) + "§7!");
        }
        else if (GameMode.equalsIgnoreCase("2")) {
            p.setGameMode(org.bukkit.GameMode.ADVENTURE);
            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
            p.sendMessage(Main.Pro02 + "§8 |§7 Du bist nun im " + getGamemode(p) + "§7!");
        }
        else if (GameMode.equalsIgnoreCase("3")) {
            p.setGameMode(org.bukkit.GameMode.SPECTATOR);
            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
            p.sendMessage(Main.Pro02 + "§8 |§7 Du bist nun im " + getGamemode(p) + "§7!");
        }
        else if (GameMode.equalsIgnoreCase("SURVIVAL")) {
            p.setGameMode(org.bukkit.GameMode.SURVIVAL);
            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
            p.sendMessage(Main.Pro02 + "§8 |§7 Du bist nun im " + getGamemode(p) + "§7!");
        }
        else if (GameMode.equalsIgnoreCase("CREATIVE")) {
            p.setGameMode(org.bukkit.GameMode.CREATIVE);
            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
            p.sendMessage(Main.Pro02 + "§8 |§7 Du bist nun im " + getGamemode(p) + "§7!");
        }
        else if (GameMode.equalsIgnoreCase("ADVENTURE")) {
            p.setGameMode(org.bukkit.GameMode.ADVENTURE);
            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
            p.sendMessage(Main.Pro02 + "§8 |§7 Du bist nun im " + getGamemode(p) + "§7!");
        }
        else if (GameMode.equalsIgnoreCase("SPECTATOR")) {
            p.setGameMode(org.bukkit.GameMode.SPECTATOR);
            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
            p.sendMessage(Main.Pro02 + "§8 |§7 Du bist nun im " + getGamemode(p) + "§7!");
        }
    }

    public static boolean isLeading(String Username) {
        boolean Return;
        final File file = new File("plugins/Utralo/ProjectsBase.yml");
        final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        reloadConfig(file,cfg);
        if(Username.equals(cfg.getString("Projektleitung.Name"))) {
            Return = true;
        } else {
            Return = false;
        }
        return Return;
    }

    public static boolean isDorffest() {
        final File file = new File("plugins/Utralo/ProjectsBase.yml");
        final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        reloadConfig(file,cfg);
        if(cfg.contains("System.Events.Dorffest")) {
            if (cfg.getBoolean("System.Events.Dorffest")) {
                return true;
            } else {
                return false;
            }
        } else {
            cfg.set("System.Events.Dorffest", false);
            saveConfig(file,cfg);
            return false;
        }
    }

    public static void setDorffest(boolean State) {
        final File file = new File("plugins/Utralo/ProjectsBase.yml");
        final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        reloadConfig(file,cfg);
        if(State) {
            cfg.set("System.Events.Dorffest", true);
        } else {
            cfg.set("System.Events.Dorffest", false);
        }
        saveConfig(file,cfg);
    }

    public static boolean isMaintenance() {
        final File file = new File("plugins/Utralo/ProjectsBase.yml");
        final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        reloadConfig(file,cfg);
        if(cfg.contains("System.Maintenance")) {
            if(cfg.getBoolean("System.Maintenance")) {
                return true;
            } else {
                return false;
            }
        } else {
            cfg.set("System.Maintenance",false);
            saveConfig(file,cfg);
            return false;
        }
    }

    public static void toggleMaintenance() {
        final File file = new File("plugins/Utralo/ProjectsBase.yml");
        final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        reloadConfig(file,cfg);
        if(isMaintenance()) {
            setMaintenance(false);
        } else {
            setMaintenance(true);
        }
    }

    public static void setMOTD(String Line1, String Line2) {
        setMOTD(Type.LINE1,Line1);
        setMOTD(Type.LINE2,Line2);
    }

    public static void setMOTD(Type Line, String Content) {
        File MOTD = new File("plugins/ServerMOTD/config.yml");
        YamlConfiguration motd = YamlConfiguration.loadConfiguration(MOTD);
        reloadConfig(MOTD,motd);
        if(Line.equals(Type.LINE1)) {
            motd.set("lineOne",Content);
        } else if(Line.equals(Type.LINE2)) {
            motd.set("lineTwo",Content);
        } else {
            sendConsole("§cFehler beim Setzen der MOTD!");
        }
        saveConfig(MOTD,motd);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"servermotd reload");
    }

    public static void setMaintenance(boolean State) {
        final File file = new File("plugins/Utralo/ProjectsBase.yml");
        final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        reloadConfig(file,cfg);
        if(State) {
            cfg.set("System.Maintenance",true);
            setMOTD("&4Utralo.de &8- &cProjekte und mehr! &4[1.16.5]","§4Projekt: §cArgria: Wolfshaven §4| §cWartungsmodus");
            for(Player all : Bukkit.getOnlinePlayers()) {
                if(all.hasPermission("ProjectMaintenance.Join")) {
                    all.sendMessage("§cDer Server ist nun im Wartungsmodus!");
                } else {
                    all.kickPlayer("§cDer Server ist nun im §4Wartungs-/Updatemodus§c!");
                }
            }
        } else {
            final File MOTD = new File("plugins/ServerMOTD/config.yml");
            final YamlConfiguration motd = YamlConfiguration.loadConfiguration(MOTD);
            reloadConfig(MOTD,motd);
            motd.set("lineOne","&dUtralo.de &8- &7Projekte und mehr! &f[1.16.5]");
            motd.set("lineTwo","§fProjekt: §cArgria: Wolfshaven");
            saveConfig(MOTD,motd);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"servermotd reload");
            cfg.set("System.Maintenance",false);
        }
        saveConfig(file,cfg);
    }

    public static boolean isBanned(Player player) {
        boolean Return;
        Player p = player;
        final String SID = p.getUniqueId().toString();
        final File file = new File("plugins/Utralo/Players/"+SID+".yml");
        final YamlConfiguration usr = YamlConfiguration.loadConfiguration(file);
        reloadConfig(file,usr);
        if(usr.contains("System.isBanned")) {
            if(usr.getBoolean("System.isBanned")) {
                kickBanned(player);
                Return = true;
            } else {
                Return = false;
            }
        } else {
            usr.set("System.isBanned", false);
            Return = false;
        }
        return Return;
    }

    public static void kickBanned(Player player) {
        Player p = player;
        final String SID = p.getUniqueId().toString();
        final File file = new File("plugins/Utralo/Players/"+SID+".yml");
        final YamlConfiguration usr = YamlConfiguration.loadConfiguration(file);
        reloadConfig(file,usr);
        String reason;
        if(usr.contains("System.BanReason")) {
            reason = usr.getString("System.BanReason").replace("&","§");
        } else {
            reason = "Regelverstoß";
        }
        p.kickPlayer("§cDu wurdest §4gebannt§c! §8(§fGrund: §7"+reason+"§8)");
    }
    
    public static void saveConfig(final File file, final YamlConfiguration cfg) {
        try {
            cfg.save(file);
        }
        catch (IOException ef) {
            ef.printStackTrace();
        }
        reloadConfig(file, cfg);
    }
    
    public static void reloadConfig(final File file, YamlConfiguration cfg) {
        cfg = YamlConfiguration.loadConfiguration(file);
    }
    
    public static String getGamemode(final Player p) {
        String GameMode = "";
        if (p != null) {
            if (p.getGameMode().toString().equals("SURVIVAL")) {
                GameMode = "§a\u00dcberlebensmodus";
            }
            else if (p.getGameMode().toString().equals("CREATIVE")) {
                GameMode = "§aKreativmodus";
            }
            else if (p.getGameMode().toString().equals("ADVENTURE")) {
                GameMode = "§aAbenteuermodus";
            }
            else if (p.getGameMode().toString().equals("SPECTATOR")) {
                GameMode = "§aZuschauermodus";
            }
            else {
                GameMode = "Nothing";
            }
        }
        else {
            GameMode = "Nothing";
        }
        return GameMode;
    }

    public static String getGameMode(Player p) {
        String GameMode;
        if (p.getGameMode().toString().equalsIgnoreCase("SURVIVAL")) {
            GameMode = "Überlebensmodus";
        } else if (p.getGameMode().toString().equalsIgnoreCase("CREATIVE")) {
            GameMode = "Kreativmodus";
        } else if (p.getGameMode().toString().equalsIgnoreCase("ADVENTURE")) {
            GameMode = "Abenteuermodus";
        } else if (p.getGameMode().toString().equalsIgnoreCase("SPECTATOR")) {
            GameMode = "Zuschauermodus";
        } else {
            GameMode = "null";
        }
        return GameMode;
    }

    @Deprecated
    public static void doNothing() {

    }

    public static Difficulty resolveDifficulty(String fromString) {
        if(fromString.equalsIgnoreCase("0")) {
            return Difficulty.PEACEFUL;
        } else if(fromString.equalsIgnoreCase("1")) {
            return Difficulty.EASY;
        } else if(fromString.equalsIgnoreCase("2")) {
            return Difficulty.NORMAL;
        } else if(fromString.equalsIgnoreCase("3")) {
            return Difficulty.HARD;
        } else if(fromString.equalsIgnoreCase("easy")) {
            return Difficulty.EASY;
        } else if(fromString.equalsIgnoreCase("peaceful")) {
            return Difficulty.PEACEFUL;
        } else if(fromString.equalsIgnoreCase("hard")) {
            return Difficulty.HARD;
        } else if(fromString.equalsIgnoreCase("normal")) {
            return Difficulty.NORMAL;
        } else {
            return null;
        }
    }

    public static CommandSender CS = Bukkit.getConsoleSender();

    public static void doTimer(String command, int seconds, Player player) {
        int time = seconds*20;
        new BukkitRunnable() {
            public void run() {
                player.performCommand(command);
            }
        }.runTaskTimer(MAIN, 0, time);
    }

    public static void playGlobalSound(Sound sound) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.playSound(p.getLocation(), sound, 100, 100);
        }
    }

    public static boolean isRP(Player player) {
        Player p = player;
        String SID = p.getUniqueId().toString();
        File file = new File("plugins/Utralo/Players/"+SID+".yml");
        YamlConfiguration usr = YamlConfiguration.loadConfiguration(file);
        reloadConfig(file,usr);
        if(usr.contains("Spieler."+SID+".Roleplay")) {
            if (usr.getString("Spieler."+SID+".Roleplay").equalsIgnoreCase("true")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static String removeFormat(String message) {
        String s1 = message.replace("&0", "").replace("&1", "").replace("&2", "").replace("&3", "").replace("&4", "").replace("&5", "").replace("&6", "").replace("&7", "").replace("&8", "").replace("&9", "").replace("&e", "").replace("&o", "").replace("&a", "").replace("&d", "").replace("&k", "").replace("&l", "").replace("&c", "").replace("&b", "").replace("&n", "").replace("&m", "");
        String s2 = s1.replace("§0", "").replace("§1", "").replace("§2", "").replace("§3", "").replace("§4", "").replace("§5", "").replace("§6", "").replace("§7", "").replace("§8", "").replace("§9", "").replace("§e", "").replace("§o", "").replace("§a", "").replace("§d", "").replace("§k", "").replace("§l", "").replace("§c", "").replace("§b", "").replace("§n", "").replace("§m", "");
        return s2.replace("§E","").replace("§O","").replace("§A","").replace("§D","").replace("§F","§f").replace("§f","").replace("§L","").replace("§C","").replace("§B","").replace("§N","").replace("§M","").replace("&E","").replace("&O","").replace("&A","").replace("&D","").replace("&F","&f").replace("§f","").replace("&L","").replace("&C","").replace("&B","").replace("&N","").replace("&M","");
    }

    public static void doTimer(String command, int seconds) {
        int time = seconds*20;
        new BukkitRunnable() {
            public void run() {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(),command);
            }
        }.runTaskTimer(MAIN, 0, time);
    }

    public static void sendConsole(String message) {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Argria " + ChatColor.DARK_GRAY + "| " + ChatColor.WHITE + message);
    }

    public static String formatMsg(final String Nachricht) {
        String Final = "";
        Final = Nachricht.replace("&", "§");
        return Final;
    }

    public static String resolveName(Player player) {
        Player p = player;
        UUID SID = p.getUniqueId();
        File file = new File("plugins/Utralo/Players/" + SID + ".yml");
        YamlConfiguration usr = YamlConfiguration.loadConfiguration(file);
        reloadConfig(file,usr);
        String PR = usr.getString("Spieler." + SID + ".Roleplay");
        if(PR.equalsIgnoreCase("true")) {
            if (usr.contains("Spieler." + SID + ".Roleplayname")) {
                return usr.getString("Spieler." + SID + ".Roleplayname");
            }
            else {
                return p.getName();
            }
        } else {
            return p.getName();
        }
    }
    
    public static void sendPlayerMsg(final Player p, final String Nachricht) {
        formatMsg(Nachricht);
        p.sendMessage(Nachricht);
    }
    
    public static void clearPlayerChat(Player p) {
        for(int i= 0; i < 150; i++){
            p.sendMessage("§0");
        }
    }

    public static boolean checkBlocked(String string, String Block) {
        if(string.toLowerCase().contains(Block.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isJobBlocked(String Job) {
        if(checkBlocked(Job, "bürgermeister")) {
            return true;
        } else if(checkBlocked(Job, "buergermeister")) {
            return true;
        } else if(checkBlocked(Job, "lord")) {
            return true;
        } else if(checkBlocked(Job, "lort")) {
            return true;
        } else if(checkBlocked(Job, "lordt")) {
            return true;
        } else if(checkBlocked(Job, "könig")) {
            return true;
        } else if(checkBlocked(Job, "koenig")) {
            return true;
        } else if(checkBlocked(Job, "imperator")) {
            return true;
        } else if(checkBlocked(Job, "kaiser")) {
            return true;
        } else if(checkBlocked(Job, "killer")) {
            return true;
        } else if(checkBlocked(Job, "polizei")) {
            return true;
        } else if(checkBlocked(Job, "polizist")) {
            return true;
        } else if(checkBlocked(Job, "gesetz")) {
            return true;
        } else if(checkBlocked(Job, "?")) {
            return true;
        } else if(checkBlocked(Job, "geheim")) {
            return true;
        } else if(checkBlocked(Job, "sklave")) {
            return true;
        } else if(checkBlocked(Job, "zwang")) {
            return true;
        } else if(checkBlocked(Job, "attentat")) {
            return true;
        } else if(checkBlocked(Job, "attentäter")) {
            return true;
        } else if(checkBlocked(Job, "auftrag")) {
            return true;
        } else if(checkBlocked(Job, "skuse")) {
            return true;
        } else if(checkBlocked(Job, "sir")) {
            return true;
        } else if(checkBlocked(Job, "graf")) {
            return true;
        } else if(checkBlocked(Job, "graph")) {
            return true;
        } else if(checkBlocked(Job, "hure")) {
            return true;
        } else if(checkBlocked(Job, "führer")) {
            return true;
        } else if(checkBlocked(Job, "fuehrer")) {
            return true;
        } else if(checkBlocked(Job, "president")) {
            return true;
        } else if(checkBlocked(Job, "präsident")) {
            return true;
        } else if(checkBlocked(Job, "prasident")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    static {
        API.FLKW = createGuiItem(Material.DIAMOND,"§bWolfshaven (Stadt1)");
        API.FWHO = createGuiItem(Material.IRON_HORSE_ARMOR,"§bStadttor");
        API.FWHV = createGuiItem(Material.OAK_BOAT,"§bWolfshaven (Stadt)");
        API.SHEV = createGuiItem(Material.EMERALD, "§c???");
        API.SHES = createGuiItem(Material.IRON_HORSE_ARMOR, "§aKutsche");
        API.SONS = createGuiItem(Material.QUARTZ, "§fSonstiges");
        API.P001 = createGuiItem(Material.IRON_NUGGET, "§71 Pfennig §8[§f1 AP§8]");
        API.P002 = createGuiItem(Material.IRON_NUGGET, "§72 Pfennig §8[§f1 AP§8]", new String[0]);
        API.P005 = createGuiItem(Material.IRON_NUGGET, "§75 Pfennig §8[§f1 AP§8]", new String[0]);
        API.P010 = createGuiItem(Material.IRON_NUGGET, "§710 Pfennig §8[§f1 AP§8]", new String[0]);
        API.P020 = createGuiItem(Material.IRON_NUGGET, "§720 Pfennig §8[§f1 AP§8]", new String[0]);
        API.P050 = createGuiItem(Material.IRON_NUGGET, "§750 Pfennig §8[§f1 AP§8]", new String[0]);
        API.M001 = createGuiItem(Material.GOLD_NUGGET, "§a1 Mark §8[§f2 AP§8]", new String[0]);
        API.M002 = createGuiItem(Material.GOLD_NUGGET, "§a2 Mark §8[§f4 AP§8]", new String[0]);
        API.M005 = createGuiItem(Material.PAPER, "§a5 Mark §8[§f10 AP§8]", new String[0]);
        API.M010 = createGuiItem(Material.PAPER, "§910 Mark §8[§f20 AP§8]", new String[0]);
        API.M020 = createGuiItem(Material.PAPER, "§e20 Mark §8[§f40 AP§8]", new String[0]);
        API.M050 = createGuiItem(Material.PAPER, "§c50 Mark §8[§f100 AP§8]", new String[0]);
        API.M100 = createGuiItem(Material.PAPER, "§d100 Mark §8[§f200 AP§8]", new String[0]);
        API.M200 = createGuiItem(Material.PAPER, "§2200 Mark §8[§f400 AP§8]", new String[0]);
        API.M500 = createGuiItem(Material.PAPER, "§4500 Mark §8[§f1000 AP§8]", new String[0]);
        API.GUIP = createGuiItem(Material.BLACK_STAINED_GLASS_PANE, "§0", new String[0]);
        API.GUI2 = createGuiItem(Material.BARRIER, "§cKommt bald...", new String[0]);
        API.FRMW = createGuiItem(Material.IRON_PICKAXE, "§fFarmwelt", new String[0]);
        API.ARNA = createGuiItem(Material.NETHERRACK, "§cNether", new String[0]);
        API.PP001 = createGuiItem(Material.IRON_NUGGET, "§7§o1 Pfennig", new String[0]);
        API.PP002 = createGuiItem(Material.IRON_NUGGET, "§7§o2 Pfennig", new String[0]);
        API.PP005 = createGuiItem(Material.IRON_NUGGET, "§7§o5 Pfennig", new String[0]);
        API.PP010 = createGuiItem(Material.IRON_NUGGET, "§7§o10 Pfennig", new String[0]);
        API.PP020 = createGuiItem(Material.IRON_NUGGET, "§7§o20 Pfennig", new String[0]);
        API.PP050 = createGuiItem(Material.IRON_NUGGET, "§7§o50 Pfennig", new String[0]);
        API.PM001 = createGuiItem(Material.GOLD_NUGGET, "§a§o1 Mark", new String[0]);
        API.PM002 = createGuiItem(Material.GOLD_NUGGET, "§a§o2 Mark", new String[0]);
        API.PM005 = createGuiItem(Material.PAPER, "§a§o5 Mark", new String[0]);
        API.PM010 = createGuiItem(Material.PAPER, "§9§o10 Mark", new String[0]);
        API.PM020 = createGuiItem(Material.PAPER, "§e§o20 Mark", new String[0]);
        API.PM050 = createGuiItem(Material.PAPER, "§c§o50 Mark", new String[0]);
        API.PM100 = createGuiItem(Material.PAPER, "§d§o100 Mark", new String[0]);
        API.PM200 = createGuiItem(Material.PAPER, "§2§o200 Mark", new String[0]);
        API.PM500 = createGuiItem(Material.PAPER, "§4§o500 Mark", new String[0]);
    }
}
