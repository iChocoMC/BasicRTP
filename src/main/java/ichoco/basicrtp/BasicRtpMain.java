package ichoco.basicrtp;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import ichoco.basicrtp.commands.*;
import ichoco.basicrtp.methods.Features;
import ichoco.basicrtp.utils.MessageUtil;

public class BasicRtpMain extends JavaPlugin{
    private static FileConfiguration config;
    private static BasicRtpMain main;

    public static void setConfig(FileConfiguration file){
        config = file;
    }

    @Override
    public void onEnable() {
        main = this;
        this.saveDefaultConfig();
        setConfig(this.getConfig());
        
        Features.getFeatures().startMethod();
        MessageUtil.startUtil();

        this.getCommand("rtp").setExecutor(new RTPCommand());
    }

    public static FileConfiguration getConfiguration(){
        return config;
    }

    public static BasicRtpMain getInstance(){
        return main;
    }
} 