package ichoco.basicrtp.utils;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import ichoco.basicrtp.BasicRtpMain;

public class MessageUtil {
	
	private static String teleportMessage;
	private static boolean placeholder;

	public static void startUtil(){
		placeholder = false;
		teleportMessage = transformToString(BasicRtpMain.getConfiguration().getStringList("teleport-message"));

		if(teleportMessage.contains("%location%")){
			placeholder = true;
		}
	}

	private static String transformToString(List<String> lStrings){
		String newTeleportMessage = "";
		for(String line : lStrings){
			newTeleportMessage += line + "\n";
		}
		return newTeleportMessage.replace('&', '§');
	}

	public static void sendMessage(Player player, Location location){
		if(placeholder){
			String locString = "§c  X: §6" + location.getBlockX() + "\n§c   Y: §6" + location.getBlockY() + "\n§c   Z: §6" + location.getBlockZ();
			player.sendMessage(teleportMessage.replace("%location%", locString));
			return;
		}
		player.sendMessage(teleportMessage);
	}
}
