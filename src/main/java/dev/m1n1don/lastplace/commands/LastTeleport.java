package dev.m1n1don.lastplace.commands;

import dev.m1n1don.lastplace.LastPlace;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LastTeleport implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (sender.hasPermission("lastplace.teleport"))
        {
            if (args.length >= 1)
            {

                if (!LastPlace.getPlugin().getLast().containsKey(args[0]))
                {
                    sender.sendMessage(ChatColor.RED + "そのプレイヤーのデータは存在しません。");
                    return true;
                }

                ((Player) sender).teleport(LastPlace.getPlugin().getLast().get(args[0]));
            }
            else sender.sendMessage(ChatColor.RED + "引数が足りません。");
        }
        else sender.sendMessage(ChatColor.RED + "権限がありません。");
        return true;
    }
}