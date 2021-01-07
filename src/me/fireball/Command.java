package me.fireball;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (command.getName().equals("fireball")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "명령어 사용법: /fireball [on/off]");
            } else if (args[0].equals("on")) {
                sender.sendMessage(ChatColor.GOLD + "파이어볼" + ChatColor.GRAY + "이 켜졌습니다");
            } else if (args[0].equals("off")) {
                sender.sendMessage(ChatColor.GOLD + "파이어볼" + ChatColor.GRAY + "이 꺼졌습니다");
            } else {
                sender.sendMessage(ChatColor.RED + "명령어 사용법: /fireball [on/off]");
            }
        }
        return false;
    }
}

