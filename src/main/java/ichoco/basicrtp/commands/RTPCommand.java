package ichoco.basicrtp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ichoco.basicrtp.methods.Features;

public class RTPCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage("Only players can execute this command");
			return true;
		}
		Player player = (Player)sender;
		Features.teleport(player);
		return false;
	}
}
