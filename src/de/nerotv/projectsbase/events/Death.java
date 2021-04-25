package de.nerotv.projectsbase.events;

import de.nerotv.projectsbase.api.API;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = (Player)e.getEntity();
        Location lc = p.getLocation();
        String loc = "§4X"+lc.getBlockX()+" Y"+lc.getBlockY()+" Z"+lc.getBlockZ()+" §7("+lc.getWorld().getName()+")§4";
        API.sendConsole("§4"+p.getName()+"§c starb bei "+loc);
        API.sendPlayerMsg(p,"§cDu bist bei "+loc+"§c gestorben! Deine Items liegen frei herum und §4despawnen §cbald. Beeil dich!");
    }

    /*public static HashMap<Block, Inventory> DeathChest = new HashMap<Block,Inventory>();

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = (Player)e.getEntity();
        Location loc = p.getLocation();
        final String SID = p.getUniqueId().toString();
        final File file = new File("plugins/Utralo/Players/" + SID + ".yml");
        final YamlConfiguration usr = YamlConfiguration.loadConfiguration(file);
        String DESC = API.getDateTime();
        usr.set("Death."+DESC,e.getDrops());
        API.saveConfig(file,usr);
        Block Chest = p.getWorld().getBlockAt(p.getLocation().add(0,0.5,0));
        Chest.setType(Material.CHEST);
        p.playSound(p.getLocation(), Sound.ENTITY_IRON_GOLEM_DEATH,100,100);
        API.sendConsole("§4§l"+p.getName()+" ist bei X"+loc.getBlockX()+" Y"+loc.getBlockY()+" Z"+loc.getBlockZ()+" §7("+loc.getWorld().getName()+"§7) §4gestorben!");
        p.sendMessage("§cDu bist bei X"+loc.getBlockX()+" Y"+loc.getBlockY()+" Z"+loc.getBlockZ()+" §7("+loc.getWorld().getName()+")§c"+" gestorben! §7An deinem §eTodespunkt§7 hat sich eine Todeskiste aufgetan§8!");
        Inventory inv = Bukkit.createInventory(null, 45,"§c§lTodeskiste von §e§l"+p.getName());
        inv.clear(); inv.setContents(e.getDrops().toArray(new ItemStack[0]));
        DeathChest.put(Chest,inv);
        org.bukkit.block.Chest chest1 = (Chest)Chest.getState();
        chest1.getInventory().addItem(e.getDrops().toArray(new ItemStack[0]));
        e.getDrops().clear();
    }

    @EventHandler
    public void onChest(PlayerInteractEvent e) {
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(e.getClickedBlock() != null) {
                if(e.getClickedBlock().getType() == Material.CHEST) {
                    Block block = e.getClickedBlock();
                    for(Block blocks:DeathChest.keySet()) {
                        if(blocks.getLocation().equals(block.getLocation())) {
                            e.setCancelled(true);
                            e.getPlayer().playSound(e.getPlayer().getLocation(),Sound.BLOCK_CHEST_OPEN,100,100);
                            e.getPlayer().openInventory(DeathChest.get(blocks));
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onDestroy(BlockBreakEvent e) {
        if(e.getBlock().getType() == Material.CHEST) {
            Block block = e.getBlock();
            for(Block blocks:DeathChest.keySet()) {
                if(blocks.getLocation().equals(block.getLocation())) {
                    if(!(DeathChest.get(blocks).isEmpty())) {
                        e.setCancelled(true);
                        Player p = e.getPlayer();
                        p.sendMessage("§cDie Todeskiste ist nicht leer! §7Leere sie, damit du sie entfernen kannst§8!");
                    } else {
                        e.setDropItems(false);
                    }
                }
            }
        }
    }*/
}