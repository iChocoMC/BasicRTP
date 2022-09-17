package ichoco.basicrtp.utils;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import ichoco.basicrtp.BasicRtpMain;

public class TeleportUtil {
    
    static Random random = new Random();
    static int maxRadius = BasicRtpMain.getInstance().getConfig().getInt("max-radius");
    
    public static void teleportPlayer(Player player){
        Location
            loc = player.getLocation(),
            newloc;

        int 
            x = random.nextInt(maxRadius),
            z = random.nextInt(maxRadius),
            y = 5;


        while(y > 0){
            newloc = new Location(loc.getWorld(), x, y , z);
            if (newloc.getBlock().getType() == Material.AIR){
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
        Location
            loc = player.getLocation(),
            newloc;

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
            newloc = new Location(loc.getWorld(), x, y , z);
            if (newloc.getBlock().getType() == Material.AIR){
                player.teleport(newloc);
                break;
            }
            y++;
        }
    }
}