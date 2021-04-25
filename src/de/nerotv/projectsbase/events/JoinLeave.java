package de.nerotv.projectsbase.events;

import net.raidstone.wgevents.WorldGuardEvents;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.EventHandler;
import java.util.UUID;
import org.bukkit.entity.Player;
import org.bukkit.Sound;
import de.nerotv.projectsbase.primal.Main;
import de.nerotv.projectsbase.api.API;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;

public class JoinLeave implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        if(API.isBanned(e.getPlayer())) {
            e.setJoinMessage("");
        } else {
            if (API.isMaintenance()) {
                Player p = e.getPlayer();
                if (p.hasPermission("ProjectMaintenance.Join")) {
                    e.setJoinMessage("§8[§a+§8]§a " + p.getName());
                } else {
                    e.setJoinMessage("");
                    p.kickPlayer("§cArgria befindet sich zurzeit im §4Wartungs-/Updatemodus§c!");
                }
            } else {
                final Player p = e.getPlayer();
                final UUID PID = p.getUniqueId();
                final String SID = PID.toString();
                File ULIST = new File("plugins/Utralo/UUIDList.yml");
                YamlConfiguration UL = YamlConfiguration.loadConfiguration(ULIST);
                API.reloadConfig(ULIST, UL);
                UL.set("UUID." + p.getName(), SID);
                UL.set("UUID." + SID, SID);
                API.saveConfig(ULIST, UL);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " remove lwc.*");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " remove LWC.*");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " remove trust.*");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " remove lwctrust.*");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex reload");
                final File file = new File("plugins/Utralo/Players/" + SID + ".yml");
                final YamlConfiguration usr = YamlConfiguration.loadConfiguration(file);
                final File List = file;
                final YamlConfiguration UUIDs = usr;
                API.reloadConfig(List, UUIDs);
                UUIDs.set(SID + ".Name", (Object) p.getName());
                API.saveConfig(List, UUIDs);
                if (UUIDs.contains(SID + ".isBanned")) {
                    if (UUIDs.getString(SID + ".isBanned").equalsIgnoreCase("true")) {
                        if (UUIDs.contains(SID + ".BanReason")) {
                            String BR = UUIDs.getString(SID + ".BanReason");
                            p.kickPlayer("§4Du bist gebannt. Grund: §c" + BR);
                            e.setJoinMessage("");
                        } else {
                            p.kickPlayer("§4Du bist gebannt.");
                            e.setJoinMessage("");
                        }
                    } else {
                        if (UUIDs.contains(SID + ".AP")) {
                            if (Integer.parseInt(UUIDs.getString(SID + ".AP")) < 1) {
                                UUIDs.set(SID + ".AP", (Object) "1");
                                API.saveConfig(List, UUIDs);
                            }
                        } else {
                            UUIDs.set(SID + ".AP", (Object) "1");
                            API.saveConfig(List, UUIDs);
                        }
                        if (UUIDs.contains(SID + "isBanned")) {
                            if (UUIDs.getString(SID + "isBanned").equalsIgnoreCase("true")) {
                                p.kickPlayer("§4Du wurdest von §c" + Main.Pro01 + "§4 ausgeschlossen!");
                            } else if (file.exists()) {
                                usr.set("Spieler." + SID + ".Name", (Object) p.getName());
                                API.saveConfig(file, usr);
                                if (!usr.contains("Spieler." + SID + ".Name")) {
                                    usr.set("Spieler." + SID + ".Job", (Object) "Arbeitslos");
                                    API.saveConfig(file, usr);
                                }
                                usr.set("Spieler." + SID + ".Roleplay", (Object) "false");
                                API.saveConfig(file, usr);
                                Main.setState(p);
                                if (usr.contains("Spieler." + SID + ".isKnown")) {
                                    if (usr.getString("Spieler." + SID + ".isKnown").equalsIgnoreCase("true")) {
                                        Bukkit.getServer().broadcastMessage("§8[§2+§8] §a" + p.getName().replace("beurlaubt", "nerotvlive"));
                                        p.sendMessage("§0 ");
                                    } else {
                                        Bukkit.getServer().broadcastMessage("§8[§2+§8] §a" + p.getName().replace("beurlaubt", "nerotvlive"));
                                        usr.set("Spieler." + SID + ".isKnown", (Object) "true");
                                        API.saveConfig(file, usr);
                                        Bukkit.getServer().broadcastMessage("§e" + p.getName().replace("beurlaubt", "nerotvlive") + "§7 betritt den Server zum ersten Mal§8!");
                                        p.sendMessage("§0 ");
                                        p.sendMessage("§aWillkommen auf dem Server! Wir wünschen dir viel Spaß!");
                                        p.sendMessage("§0 ");
                                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100.0f, 100.0f);
                                        Main.setState(p);
                                    }
                                } else {
                                    Bukkit.getServer().broadcastMessage("§8[§2+§8] §a" + p.getName().replace("beurlaubt", "nerotvlive"));
                                    usr.set("Spieler." + SID + ".isKnown", (Object) "true");
                                    API.saveConfig(file, usr);
                                    Bukkit.getServer().broadcastMessage("§e" + p.getName().replace("beurlaubt", "nerotvlive") + "§7 betritt den Server zum ersten Mal§8!");
                                    p.sendMessage("§0 ");
                                    p.sendMessage("§aWillkommen auf dem Server! Wir wünschen dir viel Spaß!");
                                    p.sendMessage("§0 ");
                                    p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100.0f, 100.0f);
                                    Main.setState(p);
                                }
                            } else {
                                usr.set("Spieler." + SID + ".Name", (Object) p.getName());
                                usr.set("Spieler." + SID + ".Job", (Object) "Arbeitslos");
                                usr.set("Spieler." + SID + ".Roleplay", (Object) "false");
                                usr.set("Spieler." + SID + ".isKnown", (Object) "true");
                                API.saveConfig(file, usr);
                                Bukkit.getServer().broadcastMessage("§8[§2+§8] §a" + p.getName().replace("beurlaubt", "nerotvlive"));
                                Bukkit.getServer().broadcastMessage("§e" + p.getName().replace("beurlaubt", "nerotvlive") + "§7 betritt den Server zum ersten Mal§8!");
                                p.sendMessage("§0 ");
                                p.sendMessage("§aWillkommen auf dem Server! Wir wünschen dir viel Spaß!");
                                p.sendMessage("§0 ");
                                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100.0f, 100.0f);
                                Main.setState(p);
                            }
                        } else {
                            UUIDs.set(SID + ".isBanned", (Object) "false");
                            API.saveConfig(List, UUIDs);
                            if (file.exists()) {
                                usr.set("Spieler." + SID + ".Name", (Object) p.getName());
                                API.saveConfig(file, usr);
                                if (!usr.contains("Spieler." + SID + ".Name")) {
                                    usr.set("Spieler." + SID + ".Job", (Object) "Arbeitslos");
                                    API.saveConfig(file, usr);
                                }
                                usr.set("Spieler." + SID + ".Roleplay", (Object) "false");
                                API.saveConfig(file, usr);
                                Main.setState(p);
                                if (usr.contains("Spieler." + SID + ".isKnown")) {
                                    if (usr.getString("Spieler." + SID + ".isKnown").equalsIgnoreCase("true")) {
                                        Bukkit.getServer().broadcastMessage("§8[§2+§8] §a" + p.getName().replace("beurlaubt", "nerotvlive"));
                                        p.sendMessage("§0 ");
                                    } else {
                                        Bukkit.getServer().broadcastMessage("§8[§2+§8] §a" + p.getName().replace("beurlaubt", "nerotvlive"));
                                        usr.set("Spieler." + SID + ".isKnown", (Object) "true");
                                        API.saveConfig(file, usr);
                                        Bukkit.getServer().broadcastMessage("§e" + p.getName().replace("beurlaubt", "nerotvlive") + "§7 betritt den Server zum ersten Mal§8!");
                                        p.sendMessage("§0 ");
                                        p.sendMessage("§aWillkommen auf dem Server! Wir wünschen dir viel Spaß!");
                                        p.sendMessage("§0 ");
                                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100.0f, 100.0f);
                                        Main.setState(p);
                                    }
                                } else {
                                    Bukkit.getServer().broadcastMessage("§8[§2+§8] §a" + p.getName().replace("beurlaubt", "nerotvlive"));
                                    usr.set("Spieler." + SID + ".isKnown", (Object) "true");
                                    API.saveConfig(file, usr);
                                    Bukkit.getServer().broadcastMessage("§e" + p.getName().replace("beurlaubt", "nerotvlive") + "§7 betritt den Server zum ersten Mal§8!");
                                    p.sendMessage("§0 ");
                                    p.sendMessage("§aWillkommen auf dem Server! Wir wünschen dir viel Spaß!");
                                    p.sendMessage("§0 ");
                                    p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100.0f, 100.0f);
                                    Main.setState(p);
                                }
                            } else {
                                usr.set("Spieler." + SID + ".Name", (Object) p.getName());
                                usr.set("Spieler." + SID + ".Job", (Object) "Arbeitslos");
                                usr.set("Spieler." + SID + ".Roleplay", (Object) "false");
                                usr.set("Spieler." + SID + ".isKnown", (Object) "true");
                                API.saveConfig(file, usr);
                                Bukkit.getServer().broadcastMessage("§8[§2+§8] §a" + p.getName().replace("beurlaubt", "nerotvlive"));
                                Bukkit.getServer().broadcastMessage("§e" + p.getName().replace("beurlaubt", "nerotvlive") + "§7 betritt den Server zum ersten Mal§8!");
                                p.sendMessage("§0 ");
                                p.sendMessage("§aWillkommen auf dem Server! Wir wünschen dir viel Spaß!");
                                p.sendMessage("§0 ");
                                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100.0f, 100.0f);
                                Main.setState(p);
                            }
                        }
                        if (!usr.contains("Spieler." + SID + ".INF")) {
                            usr.set("Spieler." + SID + ".INF", (Object) "false");
                        }
                        API.saveConfig(file, usr);
                        API.saveConfig(List, UUIDs);
                        API.reloadConfig(file, usr);
                        Main.setState(p);
                        e.setJoinMessage("");
                    }
                } else {
                    UUIDs.set(SID + ".isBanned", "false");
                    if (UUIDs.contains(SID + ".AP")) {
                        if (Integer.parseInt(UUIDs.getString(SID + ".AP")) < 1) {
                            UUIDs.set(SID + ".AP", (Object) "1");
                            API.saveConfig(List, UUIDs);
                        }
                    } else {
                        UUIDs.set(SID + ".AP", (Object) "1");
                        API.saveConfig(List, UUIDs);
                    }
                    if (UUIDs.contains(SID + "isBanned")) {
                        if (UUIDs.getString(SID + "isBanned").equalsIgnoreCase("true")) {
                            p.kickPlayer("§4Du wurdest von §c" + Main.Pro01 + "§4 ausgeschlossen!");
                        } else if (file.exists()) {
                            usr.set("Spieler." + SID + ".Name", (Object) p.getName());
                            API.saveConfig(file, usr);
                            if (!usr.contains("Spieler." + SID + ".Name")) {
                                usr.set("Spieler." + SID + ".Job", (Object) "Arbeitslos");
                                API.saveConfig(file, usr);
                            }
                            usr.set("Spieler." + SID + ".Roleplay", (Object) "false");
                            API.saveConfig(file, usr);
                            Main.setState(p);
                            if (usr.contains("Spieler." + SID + ".isKnown")) {
                                if (usr.getString("Spieler." + SID + ".isKnown").equalsIgnoreCase("true")) {
                                    Bukkit.getServer().broadcastMessage("§8[§2+§8] §a" + p.getName().replace("beurlaubt", "nerotvlive"));
                                    p.sendMessage("§0 ");
                                } else {
                                    Bukkit.getServer().broadcastMessage("§8[§2+§8] §a" + p.getName().replace("beurlaubt", "nerotvlive"));
                                    usr.set("Spieler." + SID + ".isKnown", (Object) "true");
                                    API.saveConfig(file, usr);
                                    Bukkit.getServer().broadcastMessage("§e" + p.getName().replace("beurlaubt", "nerotvlive") + "§7 betritt den Server zum ersten Mal§8!");
                                    p.sendMessage("§0 ");
                                    p.sendMessage("§aWillkommen auf dem Server! Wir wünschen dir viel Spaß!");
                                    p.sendMessage("§0 ");
                                    p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100.0f, 100.0f);
                                    Main.setState(p);
                                }
                            } else {
                                Bukkit.getServer().broadcastMessage("§8[§2+§8] §a" + p.getName().replace("beurlaubt", "nerotvlive"));
                                usr.set("Spieler." + SID + ".isKnown", (Object) "true");
                                API.saveConfig(file, usr);
                                Bukkit.getServer().broadcastMessage("§e" + p.getName().replace("beurlaubt", "nerotvlive") + "§7 betritt den Server zum ersten Mal§8!");
                                p.sendMessage("§0 ");
                                p.sendMessage("§aWillkommen auf dem Server! Wir wünschen dir viel Spaß!");
                                p.sendMessage("§0 ");
                                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100.0f, 100.0f);
                                Main.setState(p);
                            }
                        } else {
                            usr.set("Spieler." + SID + ".Name", (Object) p.getName());
                            usr.set("Spieler." + SID + ".Job", (Object) "Arbeitslos");
                            usr.set("Spieler." + SID + ".Roleplay", (Object) "false");
                            usr.set("Spieler." + SID + ".isKnown", (Object) "true");
                            API.saveConfig(file, usr);
                            Bukkit.getServer().broadcastMessage("§8[§2+§8] §a" + p.getName().replace("beurlaubt", "nerotvlive"));
                            Bukkit.getServer().broadcastMessage("§e" + p.getName().replace("beurlaubt", "nerotvlive") + "§7 betritt den Server zum ersten Mal§8!");
                            p.sendMessage("§0 ");
                            p.sendMessage("§aWillkommen auf dem Server! Wir wünschen dir viel Spaß!");
                            p.sendMessage("§0 ");
                            p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100.0f, 100.0f);
                            Main.setState(p);
                        }
                    } else {
                        UUIDs.set(SID + ".isBanned", (Object) "false");
                        API.saveConfig(List, UUIDs);
                        if (file.exists()) {
                            usr.set("Spieler." + SID + ".Name", (Object) p.getName());
                            API.saveConfig(file, usr);
                            if (!usr.contains("Spieler." + SID + ".Name")) {
                                usr.set("Spieler." + SID + ".Job", (Object) "Arbeitslos");
                                API.saveConfig(file, usr);
                            }
                            usr.set("Spieler." + SID + ".Roleplay", (Object) "false");
                            API.saveConfig(file, usr);
                            Main.setState(p);
                            if (usr.contains("Spieler." + SID + ".isKnown")) {
                                if (usr.getString("Spieler." + SID + ".isKnown").equalsIgnoreCase("true")) {
                                    Bukkit.getServer().broadcastMessage("§8[§2+§8] §a" + p.getName().replace("beurlaubt", "nerotvlive"));
                                    p.sendMessage("§0 ");
                                } else {
                                    Bukkit.getServer().broadcastMessage("§8[§2+§8] §a" + p.getName().replace("beurlaubt", "nerotvlive"));
                                    usr.set("Spieler." + SID + ".isKnown", (Object) "true");
                                    API.saveConfig(file, usr);
                                    Bukkit.getServer().broadcastMessage("§e" + p.getName().replace("beurlaubt", "nerotvlive") + "§7 betritt den Server zum ersten Mal§8!");
                                    p.sendMessage("§0 ");
                                    p.sendMessage("§aWillkommen auf dem Server! Wir wünschen dir viel Spaß!");
                                    p.sendMessage("§0 ");
                                    p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100.0f, 100.0f);
                                    Main.setState(p);
                                }
                            } else {
                                Bukkit.getServer().broadcastMessage("§8[§2+§8] §a" + p.getName().replace("beurlaubt", "nerotvlive"));
                                usr.set("Spieler." + SID + ".isKnown", (Object) "true");
                                API.saveConfig(file, usr);
                                Bukkit.getServer().broadcastMessage("§e" + p.getName().replace("beurlaubt", "nerotvlive") + "§7 betritt den Server zum ersten Mal§8!");
                                p.sendMessage("§0 ");
                                p.sendMessage("§aWillkommen auf dem Server! Wir wünschen dir viel Spaß!");
                                p.sendMessage("§0 ");
                                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100.0f, 100.0f);
                                Main.setState(p);
                            }
                        } else {
                            usr.set("Spieler." + SID + ".Name", (Object) p.getName());
                            usr.set("Spieler." + SID + ".Job", (Object) "Arbeitslos");
                            usr.set("Spieler." + SID + ".Roleplay", (Object) "false");
                            usr.set("Spieler." + SID + ".isKnown", (Object) "true");
                            API.saveConfig(file, usr);
                            Bukkit.getServer().broadcastMessage("§8[§2+§8] §a" + p.getName().replace("beurlaubt", "nerotvlive"));
                            Bukkit.getServer().broadcastMessage("§e" + p.getName().replace("beurlaubt", "nerotvlive") + "§7 betritt den Server zum ersten Mal§8!");
                            p.sendMessage("§0 ");
                            p.sendMessage("§aWillkommen auf dem Server! Wir wünschen dir viel Spaß!");
                            p.sendMessage("§0 ");
                            p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100.0f, 100.0f);
                            Main.setState(p);
                        }
                    }
                    if (!usr.contains("Spieler." + SID + ".INF")) {
                        usr.set("Spieler." + SID + ".INF", (Object) "false");
                    }
                    API.saveConfig(file, usr);
                    API.saveConfig(List, UUIDs);
                    API.reloadConfig(file, usr);
                    Main.setState(p);
                    e.setJoinMessage("");
                }
                e.setJoinMessage("");
            }
        }
        if(API.isDorffest()) {
            if (WorldGuardEvents.isPlayerInAnyRegion(e.getPlayer().getUniqueId(), "dorfplatz")) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "amusic play " + e.getPlayer().getName() + " 1");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "amusic shuffle " + e.getPlayer().getName());
            } else {
                API.doNothing();
            }
            for (Player all : Bukkit.getOnlinePlayers()) {
                if (WorldGuardEvents.isPlayerInAnyRegion(all.getUniqueId(), "dorfplatz")) {
                    API.doNothing();
                } else {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "amusic stop" + all.getName());
                }
            }
        }
    }
    
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if(API.isBanned(e.getPlayer())) {
            e.setQuitMessage("");
        } else {
            if (API.isMaintenance()) {
                Player p = e.getPlayer();
                if (p.hasPermission("ProjectMaintenance.Join")) {
                    e.setQuitMessage("§8[§4-§8] §c" + p.getName());
                } else {
                    e.setQuitMessage("");
                }
            } else {
                Player p = e.getPlayer();
                String SID = p.getUniqueId().toString();
                final File file = new File("plugins/Utralo/Players/" + SID + ".yml");
                final YamlConfiguration usr = YamlConfiguration.loadConfiguration(file);
                final File List = file;
                final YamlConfiguration UUIDs = usr;
                Location LastLoc = p.getLocation();
                API.reloadConfig(file, usr);
                usr.set("LastLoc.World", LastLoc.getWorld().getName());
                usr.set("LastLoc.X", LastLoc.getBlockX());
                usr.set("LastLoc.Y", LastLoc.getBlockY());
                usr.set("LastLoc.Z", LastLoc.getBlockZ());
                API.saveConfig(file, usr);
                e.setQuitMessage("");
                if (UUIDs.contains(SID + ".isBanned")) {
                    if (UUIDs.getString(SID + ".isBanned").equalsIgnoreCase("true")) {
                    } else {
                        Bukkit.getServer().broadcastMessage("§8[§4-§8] §c" + p.getName());
                    }
                } else {
                    Bukkit.getServer().broadcastMessage("§8[§4-§8] §c" + p.getName());
                }
            }
        }
    }
}
