package ichoco.basicrtp.utils;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import ichoco.basicrtp.BasicRtpMain;

public abstract class MethodUtil{

    private static Random random = new Random();
    private int maxRadius = BasicRtpMain.getConfiguration().getInt("max-radius");;

    public void execute(Player player, int x, int z){
        Location newLoc;
        World world = player.getWorld();
		world.loadChunk(x, z);

        for(short i = 5; i < 255; i++){
            newLoc = new Location(world, x, i , z);
            if (newLoc.getBlock().isEmpty()){
                player.teleport(newLoc);
                MessageUtil.sendMessage(player, newLoc);
                break;
            }
        }
    }

    public void preExecute(Player player){
        int x = random.nextInt(maxRadius);
        int z = random.nextInt(maxRadius);
        execute(player, x, z);
    }

    public static Random Random(){
        return random;
    }
}