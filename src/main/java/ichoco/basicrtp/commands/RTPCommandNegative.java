package ichoco.basicrtp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ichoco.basicrtp.utils.TeleportUtil;

public class RTPCommandNegative implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;
        TeleportUtil.teleportPlayerNegative(player);

        return true;
    }    
}