package ichoco.basicrtp.methods;

import java.util.HashSet;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import ichoco.basicrtp.BasicRtpMain;
import ichoco.basicrtp.utils.MethodUtil;

public class Features{

	private static MethodUtil method;
    private static Features features;
 
	public static void teleport(Player player){
		method.preExecute(player);
	}

	private String blacklistWorld;
	private HashSet<String> Worlds;

	public void startMethod(){
		FileConfiguration config = BasicRtpMain.getConfiguration();

		boolean OptionWorld = config.getBoolean("blacklist-worlds.enable"),
				OptionNegativeCords = config.getBoolean("support-negative-cords");
		
		if(OptionWorld){

			Worlds = new HashSet<>();

			blacklistWorld = config.getString("blacklist-worlds.message").replace('&', '§');
			List<String> worlds = config.getStringList("list-blacklist-worlds");
			
			for(String worldName : worlds){
				Worlds.add(worldName);
			}

			if(OptionNegativeCords){
				method = new NegativeCords() {
					@Override
					public void preExecute(Player player) {
						if(!Worlds.contains(player.getWorld().getName())){
							super.preExecute(player);
							return;
						}
						player.sendMessage(blacklistWorld);
					}
				};
			return;
			}
			method = new MethodUtil() {
				@Override
				public void preExecute(Player player) {
					if(!Worlds.contains(player.getWorld().getName())){
						super.preExecute(player);
						return;
					}
					player.sendMessage(blacklistWorld);
				}
			};
			return;
		}

		if(OptionNegativeCords){
			method = new NegativeCords() {};
			return;
		}
		method = new MethodUtil() {};
	}

    public static Features getFeatures(){
        if(features != null){
            return features;
        }
        features = new Features();
        return features;
    }
}
