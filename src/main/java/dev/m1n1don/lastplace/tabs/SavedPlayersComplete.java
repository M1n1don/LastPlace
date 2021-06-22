package dev.m1n1don.lastplace.tabs;

import dev.m1n1don.lastplace.LastPlace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class SavedPlayersComplete implements TabCompleter
{

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args)
    {
        final List<String> players = new ArrayList<>();

        if (args.length == 1) for (String player : LastPlace.getPlugin().getLast().keySet()) players.add(player);

        return players;
    }
}