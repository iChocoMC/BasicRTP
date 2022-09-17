package ichoco.basicrtp.utils;

import net.md_5.bungee.api.ChatColor;

public class MessageUtil {
    
    public String translate(String string){
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}