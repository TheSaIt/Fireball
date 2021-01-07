package me.fireball;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class Event implements Listener {

    @EventHandler
    public void playerInteractEvent(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK &&
                p.getInventory().getItemInMainHand().getType() == Material.STICK){
            Fireball fb = p.launchProjectile(Fireball.class);
            fb.setVelocity(p.getLocation().getDirection().multiply(5));
        }
    }
    @EventHandler
    public void onJoin (PlayerJoinEvent e){
        Player p = e.getPlayer();
        e.setJoinMessage(ChatColor.GOLD +p.getName()+ChatColor.GRAY+"님이 입장하셨습니다");

    }
    @EventHandler
    public void onQuit (PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage(ChatColor.RED+p.getName()+ChatColor.GRAY+"님이 퇴장하셨습니다");
    }

}
