package ichoco.basicrtp.utils;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import ichoco.basicrtp.BasicRtpMain;

public class TeleportUtil {
    
    static Random random = new Random();
    static FileConfiguration config = BasicRtpMain.getInstance().getConfig();
    
    static int maxRadius = config.getInt("max-radius");
    static boolean blacklist = config.getBoolean("blacklist-worlds.enable");
    static String worldblacklist = config.getString("blacklist-worlds.message");

    //Check if worldname equals to blacklist
    public static boolean WorldBlackList(String world){
        for(String worlds : config.getStringList("blacklist-worlds")){
            if(world.equalsIgnoreCase(worlds)){
                return true;
            }
        }
        return false;
    }

    public static void teleportPlayer(Player player){
        Location newloc;
        World world = player.getWorld();

        if (blacklist){
            if (WorldBlackList(world.getName())){
                player.sendMessage(MessageUtil.translate(worldblacklist));
            }
        }

        int 
            x = random.nextInt(maxRadius),
            z = random.nextInt(maxRadius),
            y = 5;

        while(y < 255){
            newloc = new Location(world, x, y , z);
            if (newloc.getBlock().isEmpty()){
                player.teleport(newloc);
                break;
            }
            y++;
        }
    }
    
    /*
     * if in config.yml the option: activate-negative-cords is true
     * activate this option.
     */
    public static void teleportPlayerNegative(Player player){
        Location newloc;
        World world = player.getWorld();

        if (blacklist){
            if (WorldBlackList(world.getName())){
                player.sendMessage(MessageUtil.translate(worldblacklist));
            }
        }

        int 
            x = random.nextInt(maxRadius),
            z = random.nextInt(maxRadius),
            y = 5,
            negative = random.nextInt(3);

        switch (negative){
            case 1: x = x*-1; break;
            case 2: z = z*-1; break;
            case 3:
                x = x*-1;
                z = z*-1;
            break;
        }

        while(y > 0){
            newloc = new Location(world, x, y , z);
            if (newloc.getBlock().isEmpty()){
                player.teleport(newloc);
                break;
            }
            y++;
        }
    }
}
