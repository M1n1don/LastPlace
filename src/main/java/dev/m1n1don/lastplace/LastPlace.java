package dev.m1n1don.lastplace;

import dev.m1n1don.lastplace.commands.LastTeleport;
import dev.m1n1don.lastplace.listeners.PlayerConnectionListener;
import dev.m1n1don.lastplace.tabs.SavedPlayersComplete;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class LastPlace extends AbstractLastPlace
{
    private static LastPlace plugin;

    private Map<String, Location> last = new HashMap<>();

    @Override
    public void onEnable()
    {
        plugin = this;

        registerListeners(
                new PlayerConnectionListener()
        );

        getCommand("lastteleport").setExecutor(new LastTeleport());
        getCommand("lastteleport").setTabCompleter(new SavedPlayersComplete());
    }

    public static LastPlace getPlugin()
    {
        return plugin;
    }

    public Map<String, Location> getLast()
    {
        return last;
    }
}