package de.nerotv.projectsbase.primal;

import de.nerotv.projectsbase.api.API;
import de.nerotv.projectsbase.api.AutoBroadcast;
import de.nerotv.projectsbase.commands.*;
import de.nerotv.projectsbase.events.*;
import de.nerotv.projectsbase.api.RewardAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import java.io.IOException;
import java.io.File;

public class Main extends JavaPlugin {

    public static Main instance;
    public static Main get() { return instance; }

    public static Scoreboard RP;
    static File file;
    static YamlConfiguration API;
    public static String Pro00;
    public static String Pro01;
    public static String Pro02;
    public static String Ver00;
    public static String Art00;
    public static String Art01;
    public static String Art02;
    public static String Own00;
    public static String Own01;
    public static String Own02;
    public static String Pre00;
    public static String Des00;
    public static String Des01;
    public static String Des02;
    public static String Des03;
    public static String Rul00;
    
    public void checkAPIconfig() {
        final File file = new File("plugins/Utralo/ProjectsBase.yml");
        final YamlConfiguration API = YamlConfiguration.loadConfiguration(file);
        if (file.exists()) {
            sendCon("Die API-config wurde gefunden!");
            sendCon("Die API-config wurde erfolgreich geladen!");
            sendCon("Daten zum Projekt werden abgerufen:");
            sendCon("Projekt: " + Main.Pro01 + ", " + Main.Ver00 + " von " + Main.Own01);
        }
        else {
            sendCon("Die API-config wurde nicht gefunden...");
            sendCon("generiere neue API-config...");
            API.set("Init.BigFont1", (Object)"§5UTRALO01");
            API.set("Init.BigFont2", (Object)"§5UTRALO02");
            API.set("Init.BigFont3", (Object)"§5UTRALO03");
            API.set("Init.BigFont4", (Object)"§5UTRALO04");
            API.set("Init.BigFont5", (Object)"§5UTRALO05");
            API.set("Init.BigFont6", (Object)"§5UTRALO06");
            API.set("Init.BigFontL", (Object)"UTRALO PROJECTSBASE - DEFAULT-PROJEKT - STANDARD - BY NIEMAND");
            API.set("Projekt.Name", (Object)"Standard");
            API.set("Projekt.Regellink", (Object)"https://info.utralo.de/rules-???.html");
            API.set("Projekt.Farbe", (Object)"§f");
            API.set("Projekt.Version", (Object)"0.1 ALPHA");
            API.set("Projektart.Name", (Object)"Default");
            API.set("Projektart.Farbe", (Object)"§f");
            API.set("Projektleitung.Name", (Object)"Niemand");
            API.set("Projektleitung.Farbe", (Object)"§f");
            API.set("Projektbeschreibung.Zeile01", (Object)" -- ZEILE01 --");
            API.set("Projektbeschreibung.Zeile02", (Object)" -- ZEILE02 --");
            API.set("Projektbeschreibung.Zeile03", (Object)" -- ZEILE03 --");
            API.set("Projektbeschreibung.Zeile04", (Object)" -- ZEILE04 --");
            try {
                API.save(file);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            sendCon("Die API-config wurde erfolgreich generiert!");
            sendCon("Die API-config wurde gefunden!");
            sendCon("Die API-config wurde erfolgreich geladen!");
            sendCon("Daten zum Projekt werden abgerufen:");
            sendCon("Projekt: " + Main.Pro01 + ", " + Main.Ver00 + " von " + Main.Own01);
        }
    }
    
    public void onLoad() {
        sendDir("ProjectsBase wird geladen...");
        sendDir("by nerotvlive");
    }
    
    public void onEnable() {
        instance = this;
        sendInit();
        sendCon("Das Plugin wird aktiviert...");
        sendCon("  lade Basis...");
        (Main.RP = Bukkit.getScoreboardManager().getNewScoreboard()).registerNewTeam("001NORP");
        Main.RP.registerNewTeam("00000RP");
        Main.RP.registerNewTeam("002SPEC");
        Main.RP.getTeam("001NORP").setPrefix("§8[§7no-RP§8] §e");
        Main.RP.getTeam("00000RP").setPrefix("§8[§6RP§8] §e");
        Main.RP.getTeam("002SPEC").setPrefix("§8[§fSPEC§8] §7");
        Main.RP.getTeam("002SPEC").setNameTagVisibility(NameTagVisibility.NEVER);
        Main.RP.getTeam("00000RP").setNameTagVisibility(NameTagVisibility.NEVER);
        Main.RP.getTeam("001NORP").setNameTagVisibility(NameTagVisibility.NEVER);
        Main.RP.getTeam("001NORP").setCanSeeFriendlyInvisibles(false);
        Main.RP.getTeam("00000RP").setCanSeeFriendlyInvisibles(false);
        Main.RP.getTeam("002SPEC").setCanSeeFriendlyInvisibles(false);
        sendCon("  Basis geladen!");
        this.checkAPIconfig();
        sendCon("Das Plugin wird aktiviert...");
        sendCon("  lade Befehle...");
        this.registerCommands();
        sendCon("  Befehle geladen!");
        sendCon("  lade Events/Listener...");
        sendCon("    -> " + ChatColor.BOLD + "JoinLeave" + ChatColor.RESET + "...");
        this.getServer().getPluginManager().registerEvents((Listener) new JoinLeave(), (Plugin)this);
        sendCon("    -> " + ChatColor.BOLD + "RewardsSystem" + ChatColor.RESET + "...");
        this.getServer().getPluginManager().registerEvents((Listener)new RewardAPI(), (Plugin)this);
        sendCon("    -> " + ChatColor.BOLD + "ChatSystem" + ChatColor.RESET + "...");
        this.getServer().getPluginManager().registerEvents((Listener)new Chatsystem(), (Plugin)this);
        sendCon("    -> " + ChatColor.BOLD + "DeathSystem" + ChatColor.RESET + "...");
        this.getServer().getPluginManager().registerEvents((Listener)new Death(), (Plugin)this);
        sendCon("    -> " + ChatColor.BOLD + "GameModeCheck" + ChatColor.RESET + "...");
        this.getServer().getPluginManager().registerEvents((Listener)new SpecCheck(), (Plugin)this);
        sendCon("    -> " + ChatColor.BOLD + "RegionEnterLeave" + ChatColor.RESET + "...");
        this.getServer().getPluginManager().registerEvents((Listener)new RegionEnter(), (Plugin)this);
        sendCon("  Listener geladen!");
        sendCon("§aDas Plugin wurde aktiviert!");
        sendInit();
        AutoBroadcast.start();
        if(de.nerotv.projectsbase.api.API.isMaintenance()) {
            de.nerotv.projectsbase.api.API.sendConsole("§cDER SERVER IST IM WARTUNGSMODUS!");
        }
    }
    
    public void registerCommands() {
        sendCon("    -> " + ChatColor.BOLD + "/help" + ChatColor.RESET + "...");
        this.getCommand("?").setExecutor((CommandExecutor)new Help(this));
        sendCon("    -> " + ChatColor.BOLD + "/fix" + ChatColor.RESET + "...");
        this.getCommand("fix").setExecutor((CommandExecutor)new Fix());
        sendCon("    -> " + ChatColor.BOLD + "/gamemode" + ChatColor.RESET + "...");
        this.getCommand("gamemode").setExecutor((CommandExecutor)new Gamemode());
        sendCon("    -> " + ChatColor.BOLD + "/srl" + ChatColor.RESET + "...");
        this.getCommand("srl").setExecutor((CommandExecutor)new SRL());
        sendCon("    -> " + ChatColor.BOLD + "/difficulty" + ChatColor.RESET + "...");
        this.getCommand("difficulty").setExecutor((CommandExecutor)new Difficulty());
        sendCon("    -> " + ChatColor.BOLD + "/setspawn" + ChatColor.RESET + "...");
        this.getCommand("setspawn").setExecutor((CommandExecutor)new SetSpawn());
        sendCon("    -> " + ChatColor.BOLD + "/spawn" + ChatColor.RESET + "...");
        this.getCommand("spawn").setExecutor((CommandExecutor)new Spawn());
        sendCon("    -> " + ChatColor.BOLD + "/pbq" + ChatColor.RESET + "...");
        this.getCommand("pbq").setExecutor((CommandExecutor)new PBQ());
        sendCon("    -> " + ChatColor.BOLD + "/job" + ChatColor.RESET + "...");
        this.getCommand("job").setExecutor((CommandExecutor)new Job());
        sendCon("    -> " + ChatColor.BOLD + "/buch" + ChatColor.RESET + "...");
        this.getCommand("buch").setExecutor((CommandExecutor)new Buch());
        sendCon("    -> " + ChatColor.BOLD + "/forcejob" + ChatColor.RESET + "...");
        this.getCommand("forcejob").setExecutor((CommandExecutor)new ForceJob());
        sendCon("    -> " + ChatColor.BOLD + "/rp" + ChatColor.RESET + "...");
        this.getCommand("rp").setExecutor((CommandExecutor)new RP());
        sendCon("    -> " + ChatColor.BOLD + "/setfarmwelt" + ChatColor.RESET + "...");
        this.getCommand("setfarmwelt").setExecutor((CommandExecutor)new SetFarmwelt());
        sendCon("    -> " + ChatColor.BOLD + "/farmwelt" + ChatColor.RESET + "...");
        this.getCommand("Farmwelt").setExecutor((CommandExecutor)new Farmwelt());
        sendCon("    -> " + ChatColor.BOLD + "/chatclear" + ChatColor.RESET + "...");
        this.getCommand("Chatclear").setExecutor((CommandExecutor)new Chatclear());
        sendCon("    -> " + ChatColor.BOLD + "/name" + ChatColor.RESET + "...");
        this.getCommand("name").setExecutor((CommandExecutor)new Name());
        sendCon("    -> " + ChatColor.BOLD + "/forcename" + ChatColor.RESET + "...");
        this.getCommand("forcename").setExecutor((CommandExecutor)new ForceName());
        sendCon("    -> " + ChatColor.BOLD + "/kill" + ChatColor.RESET + "...");
        this.getCommand("kill").setExecutor((CommandExecutor)new Kill());
        sendCon("    -> " + ChatColor.BOLD + "/heal" + ChatColor.RESET + "...");
        this.getCommand("heal").setExecutor((CommandExecutor)new Heal());
        sendCon("    -> " + ChatColor.BOLD + "/support" + ChatColor.RESET + "...");
        this.getCommand("support").setExecutor((CommandExecutor)new Support());
        sendCon("    -> " + ChatColor.BOLD + "/rules" + ChatColor.RESET + "...");
        this.getCommand("rules").setExecutor((CommandExecutor)new Rules());
        sendCon("    -> " + ChatColor.BOLD + "/projectsbase" + ChatColor.RESET + "...");
        this.getCommand("projectsbase").setExecutor((CommandExecutor)new Projectsbase(this));
        sendCon("    -> " + ChatColor.BOLD + "/feed" + ChatColor.RESET + "...");
        this.getCommand("feed").setExecutor((CommandExecutor)new Feed());
        sendCon("    -> " + ChatColor.BOLD + "/rewards" + ChatColor.RESET + "...");
        this.getCommand("rewards").setExecutor((CommandExecutor)new Rewards());
        sendCon("    -> " + ChatColor.BOLD + "/event" + ChatColor.RESET + "...");
        this.getCommand("event").setExecutor((CommandExecutor)new Event());
        sendCon("    -> " + ChatColor.BOLD + "/setarena" + ChatColor.RESET + "...");
        this.getCommand("setArena").setExecutor((CommandExecutor)new SetArena());
        sendCon("    -> " + ChatColor.BOLD + "/arena" + ChatColor.RESET + "...");
        this.getCommand("arena").setExecutor((CommandExecutor)new Arena());
        sendCon("    -> " + ChatColor.BOLD + "/warp" + ChatColor.RESET + "...");
        this.getCommand("warp").setExecutor((CommandExecutor)new Warp());
        sendCon("    -> " + ChatColor.BOLD + "/money" + ChatColor.RESET + "...");
        this.getCommand("money").setExecutor((CommandExecutor)new Money());
        sendCon("    -> " + ChatColor.BOLD + "/shervann" + ChatColor.RESET + "...");
        this.getCommand("shervann").setExecutor(new Shervann());
        sendCon("    -> " + ChatColor.BOLD + "/setshervann" + ChatColor.RESET + "...");
        this.getCommand("setshervann").setExecutor(new SetShervann());
        sendCon("    -> " + ChatColor.BOLD + "/check" + ChatColor.RESET + "...");
        this.getCommand("check").setExecutor(new Check());
        sendCon("    -> " + ChatColor.BOLD + "/falkenwacht" + ChatColor.RESET + "...");
        this.getCommand("falkenwacht").setExecutor(new Falkenwacht());
        sendCon("    -> " + ChatColor.BOLD + "/setfalkenwacht" + ChatColor.RESET + "...");
        this.getCommand("setfalkenwacht").setExecutor(new SetFalkenwacht());
        sendCon("    -> " + ChatColor.BOLD + "/gommemode" + ChatColor.RESET + "...");
        this.getCommand("gommemode").setExecutor(new Gommemode());
        sendCon("    -> " + ChatColor.BOLD + "/teleport" + ChatColor.RESET + "...");
        this.getCommand("teleport").setExecutor(new Teleport());
        sendCon("    -> " + ChatColor.BOLD + "/time" + ChatColor.RESET + "...");
        this.getCommand("time").setExecutor(new Time());
        sendCon("    -> " + ChatColor.BOLD + "/day" + ChatColor.RESET + "...");
        this.getCommand("day").setExecutor(new Day());
        sendCon("    -> " + ChatColor.BOLD + "/night" + ChatColor.RESET + "...");
        this.getCommand("night").setExecutor(new Night());
        sendCon("    -> " + ChatColor.BOLD + "/argria" + ChatColor.RESET + "...");
        this.getCommand("argria").setExecutor(new Argria());
        sendCon("    -> " + ChatColor.BOLD + "/weather" + ChatColor.RESET + "...");
        this.getCommand("weather").setExecutor(new Weather());
        sendCon("    -> " + ChatColor.BOLD + "/sun" + ChatColor.RESET + "...");
        this.getCommand("sun").setExecutor(new Sun());
        sendCon("    -> " + ChatColor.BOLD + "/rain" + ChatColor.RESET + "...");
        this.getCommand("rain").setExecutor(new Rain());
        sendCon("    -> " + ChatColor.BOLD + "/thunder" + ChatColor.RESET + "...");
        this.getCommand("thunder").setExecutor(new Thunder());
        sendCon("    -> " + ChatColor.BOLD + "/broadcast" + ChatColor.RESET + "...");
        this.getCommand("broadcast").setExecutor(new Broadcast());
        sendCon("    -> " + ChatColor.BOLD + "/inventory" + ChatColor.RESET + "...");
        this.getCommand("inventory").setExecutor(new Inventory());
        sendCon("    -> " + ChatColor.BOLD + "/me" + ChatColor.RESET + "...");
        this.getCommand("me").setExecutor(new Me());
        sendCon("    -> " + ChatColor.BOLD + "/say" + ChatColor.RESET + "...");
        this.getCommand("say").setExecutor(new Say());
        sendCon("    -> " + ChatColor.BOLD + "/msg" + ChatColor.RESET + "...");
        this.getCommand("msg").setExecutor(new Msg());
        sendCon("    -> " + ChatColor.BOLD + "/team" + ChatColor.RESET + "...");
        this.getCommand("team").setExecutor(new Team());
        sendCon("    -> " + ChatColor.BOLD + "/chat" + ChatColor.RESET + "...");
        this.getCommand("chat").setExecutor(new Chat());
        sendCon("    -> " + ChatColor.BOLD + "/sudo" + ChatColor.RESET + "...");
        this.getCommand("sudo").setExecutor(new Sudo());
        sendCon("    -> " + ChatColor.BOLD + "/rucksack" + ChatColor.RESET + "...");
        this.getCommand("rucksack").setExecutor(new Rucksack());
        sendCon("    -> " + ChatColor.BOLD + "/author" + ChatColor.RESET + "...");
        this.getCommand("author").setExecutor(new Author(this));
        sendCon("    -> " + ChatColor.BOLD + "/disconnect" + ChatColor.RESET + "...");
        this.getCommand("disconnect").setExecutor(new Disconnect());
        sendCon("    -> " + ChatColor.BOLD + "/kick" + ChatColor.RESET + "...");
        this.getCommand("kick").setExecutor(new Kick());
        sendCon("    -> " + ChatColor.BOLD + "/maintenance" + ChatColor.RESET + "...");
        this.getCommand("maintenance").setExecutor(new Maintenance());
        sendCon("    -> " + ChatColor.BOLD + "/changemotd" + ChatColor.RESET + "...");
        this.getCommand("changemotd").setExecutor(new ServerMOTD());
        sendCon("    -> " + ChatColor.BOLD + "/novus" + ChatColor.RESET + "...");
        this.getCommand("novus").setExecutor(new Novus());
    }
    
    public void onDisable() {
        sendInit();
        sendCon("Das Plugin wird deaktiviert...");
        sendCon("  entlade Systeme...");
        sendCon("  Systeme entladen!");
        sendCon("  entlade API's...");
        sendCon("  API's entladen!");
        sendCon("  entlade Befehle...");
        sendCon("  Befehle entladen!");
        sendCon("  entlade Events/Listener...");
        sendCon("  Listener entladen!");
        sendCon("§cDas Plugin wurde deaktiviert!");
        sendInit();
        instance = null;
    }
    
    public static void sendInit() {
        sendCon(Main.API.getString("Init.BigFontL"));
        sendCon(Main.API.getString("Init.BigFont1"));
        sendCon(Main.API.getString("Init.BigFont2"));
        sendCon(Main.API.getString("Init.BigFont3"));
        sendCon(Main.API.getString("Init.BigFont4"));
        sendCon(Main.API.getString("Init.BigFont5"));
        sendCon(Main.API.getString("Init.BigFont6"));
        sendCon(Main.API.getString("Init.BigFontL"));
        sendCon("§fPlugin: §9ProjectsBase §cArgria-Edition §7v§a"+instance.getDescription().getVersion()+" §7von §cnerotvlive§7.");
    }
    
    public static void changeDifficulty(final String world, final String Difficulty) {
        String dif = "";
        if (Difficulty.equalsIgnoreCase("1")) {
            dif = "EASY";
        }
        else if (Difficulty.equalsIgnoreCase("2")) {
            dif = "NORMAL";
        }
        else if (Difficulty.equalsIgnoreCase("3")) {
            dif = "HARD";
        }
        else if (Difficulty.equalsIgnoreCase("0")) {
            dif = "PEACEFUL";
        }
        else if (Difficulty.equalsIgnoreCase("EASY")) {
            dif = "EASY";
        }
        else if (Difficulty.equalsIgnoreCase("NORMAL")) {
            dif = "NORMAL";
        }
        else if (Difficulty.equalsIgnoreCase("HARD")) {
            dif = "HARD";
        }
        else if (Difficulty.equalsIgnoreCase("PEACEFUL")) {
            dif = "PEACEFUL";
        }
        else if (Difficulty.equalsIgnoreCase("PEACEFULL")) {
            dif = "PEACEFUL";
        }
        else if (Difficulty.equalsIgnoreCase("PEACE")) {
            dif = "PEACEFUL";
        }
        Bukkit.getServer().getWorld(world).setDifficulty(org.bukkit.Difficulty.valueOf(dif));
    }
    
    public static void changeDifficulty2(final World world, final String Difficulty) {
        String dif = "";
        if (Difficulty.equalsIgnoreCase("1")) {
            dif = "EASY";
        }
        else if (Difficulty.equalsIgnoreCase("2")) {
            dif = "NORMAL";
        }
        else if (Difficulty.equalsIgnoreCase("3")) {
            dif = "HARD";
        }
        else if (Difficulty.equalsIgnoreCase("0")) {
            dif = "PEACEFUL";
        }
        else if (Difficulty.equalsIgnoreCase("EASY")) {
            dif = "EASY";
        }
        else if (Difficulty.equalsIgnoreCase("NORMAL")) {
            dif = "NORMAL";
        }
        else if (Difficulty.equalsIgnoreCase("HARD")) {
            dif = "HARD";
        }
        else if (Difficulty.equalsIgnoreCase("PEACEFUL")) {
            dif = "PEACEFUL";
        }
        else if (Difficulty.equalsIgnoreCase("PEACEFULL")) {
            dif = "PEACEFUL";
        }
        else if (Difficulty.equalsIgnoreCase("PEACE")) {
            dif = "PEACEFUL";
        }
        world.setDifficulty(org.bukkit.Difficulty.valueOf(dif));
    }
    
    public static void sendDir(final String msg) {
        Bukkit.getServer().getConsoleSender().sendMessage(msg);
    }
    
    public static void sendCon(final String message) {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Argria " + ChatColor.DARK_GRAY + "| " + ChatColor.WHITE + message);
    }
    
    public static void setState(final Player p) {
        String State = "";
        final String SID = p.getUniqueId().toString();
        final File file = new File("plugins/Utralo/Players/" + SID + ".yml");
        final YamlConfiguration usr = YamlConfiguration.loadConfiguration(file);
        if (usr.getString("Spieler." + SID + ".Roleplay").equalsIgnoreCase("false")) {
            State = "001NORP";
        }
        else if (usr.getString("Spieler." + SID + ".Roleplay").equalsIgnoreCase("true")) {
            State = "00000RP";
        }
        else {
            State = "002SPEC";
        }
        Main.RP.getTeam(State).addPlayer(p);
        if(p.getName().equalsIgnoreCase("ideaIIauch")) {
            p.setPlayerListName(Main.RP.getTeam(State).getPrefix()+"§fnerotvlive");
        } else {
            p.setDisplayName(Main.RP.getTeam(State).getPrefix() + p.getName().replace("ideaIIauch","§cnerotvlive"));
        }
        for (final Player all : Bukkit.getOnlinePlayers()) {
            all.setScoreboard(Main.RP);
        }
    }
    
    static {
        Main.file = new File("plugins/Utralo/ProjectsBase.yml");
        Main.API = YamlConfiguration.loadConfiguration(Main.file);
        Main.Pro00 = Main.API.getString("Projekt.Farbe");
        Main.Pro01 = Main.API.getString("Projekt.Name");
        Main.Pro02 = Main.Pro00 + Main.Pro01;
        Main.Ver00 = Main.API.getString("Projekt.Version");
        Main.Art00 = Main.API.getString("Projektart.Farbe");
        Main.Art01 = Main.API.getString("Projektart.Name");
        Main.Art02 = Main.Art00 + Main.Art01;
        Main.Own00 = Main.API.getString("Projektleitung.Farbe");
        Main.Own01 = Main.API.getString("Projektleitung.Name");
        Main.Own02 = Main.Own00 + Main.Own01;
        Main.Pre00 = Main.Pro02;
        Main.Des00 = Main.API.getString("Projektbeschreibung.Zeile01");
        Main.Des01 = Main.API.getString("Projektbeschreibung.Zeile02");
        Main.Des02 = Main.API.getString("Projektbeschreibung.Zeile03");
        Main.Des03 = Main.API.getString("Projektbeschreibung.Zeile04");
        Main.Rul00 = Main.API.getString("Projekt.Regellink");
    }
}
