package me.arsenicdevelopment.adsocials.utils;

import me.arsenicdevelopment.adsocials.ADSocials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatUtil {

    private static final Pattern HEX_PATTERN = Pattern.compile("&#([a-fA-F0-9]{6})");

    public static String CC(String message) {
        if (MinecraftVersion.atLeast(MinecraftVersion.V.v1_16)) {
            Matcher matcher = HEX_PATTERN.matcher(message);
            while (matcher.find()) {
                String replace = message.substring(matcher.start(), matcher.end());
                message = message.replace(replace, ChatColor.valueOf(replace) + "");
                matcher = HEX_PATTERN.matcher(message);
            }
        }
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<String> CC(List<String> list) {
        List<String> returnVal = new ArrayList<>(list.size());
        list.forEach(s -> returnVal.add(CC(s)));
        return returnVal;
    }

    public static void ConsoleMSG(String s) {
        Bukkit.getConsoleSender().sendMessage(s);
    }

    public static void Broadcast(String s) {
        Bukkit.broadcastMessage(s);
    }


}
