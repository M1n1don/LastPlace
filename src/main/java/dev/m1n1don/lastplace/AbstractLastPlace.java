package dev.m1n1don.lastplace;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class AbstractLastPlace extends JavaPlugin
{
    protected void registerListeners(Listener... listeners)
    {
        for (Listener listener : listeners) getServer().getPluginManager().registerEvents(listener, this);
    }
}