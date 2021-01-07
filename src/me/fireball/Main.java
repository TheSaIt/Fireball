package me.fireball;

import com.sk89q.worldedit.IncompleteRegionException;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.bukkit.BukkitPlayer;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.regions.Region;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public class Main extends JavaPlugin{


    Logger logger = getServer().getLogger();

    public Main() throws IncompleteRegionException {
    }


    @Override
    public void onEnable() {
        logger.info(ChatColor.GREEN +"플러그인 활성화");
        getCommand("FireBall").setExecutor(new Command());
        Bukkit.getPluginManager().registerEvents(new Event(), (Plugin) this);
        Bukkit.getPluginManager().getPlugin("WorldEdit");
    }

    @Override
    public void onDisable() {
        logger.info("플러그인 비활성화");
    }
    public WorldEditPlugin getWorldEdit() {
       Plugin p = (Plugin) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");

        if (p instanceof WorldEditPlugin) return (WorldEditPlugin) p;
        else return  null;
    }

    private Player player;
    BukkitPlayer bPlayer = BukkitAdapter.adapt(player);
    Region region = WorldEdit.getInstance().getSessionManager().get(bPlayer).getSelection(bPlayer.getWorld());



}

