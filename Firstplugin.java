package me.firstplugin.macksmic.firstplugin;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;



public final class Firstplugin extends JavaPlugin {
    public class PlayerMovementListener implements Listener {

        @EventHandler
        public void onPlayerMove(PlayerMoveEvent event){
            // Get the player that just moved
            Player p = event.getPlayer();

            // Get the Block right below the player
            Block b = p.getLocation().getBlock().getRelative(BlockFace.DOWN);

            if (b.getType() == Material.GRASS_BLOCK){

                World w = p.getWorld();
                w.createExplosion(p.getLocation(), 5);

            }

        }

    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PlayerMovementListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
