package dev.m1n1don.lastplace.listeners;

import dev.m1n1don.lastplace.LastPlace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnectionListener implements Listener
{

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e)
    {
        final Player p = e.getPlayer();

        if (!LastPlace.getPlugin().getLast().containsKey(p.getName())) return;

        LastPlace.getPlugin().getLast().remove(p.getName());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e)
    {
        final Player p = e.getPlayer();

        LastPlace.getPlugin().getLast().put(p.getName(), p.getLocation());
    }
}