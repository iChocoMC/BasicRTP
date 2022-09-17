package ichoco.basicrtp;

import org.bukkit.plugin.java.JavaPlugin;

import ichoco.basicrtp.commands.*;

public class BasicRtpMain extends JavaPlugin{

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        
        if (this.getConfig().getBoolean("activate-negative-cords")){
            this.getCommand("rtp").setExecutor(new RTPCommandNegative());
            return;
        }
        this.getCommand("rtp").setExecutor(new RTPCommand());
    }

    public static BasicRtpMain getInstance(){
        return BasicRtpMain.getPlugin(BasicRtpMain.class);
    }
} 