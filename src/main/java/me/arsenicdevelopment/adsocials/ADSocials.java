package me.arsenicdevelopment.adsocials;


import lombok.Getter;

import lombok.SneakyThrows;
import me.arsenicdevelopment.adsocials.commands.*;

import me.arsenicdevelopment.adsocials.utils.ConfigFile;
import me.arsenicdevelopment.adsocials.utils.MessagesFile;
import org.bukkit.plugin.java.JavaPlugin;

public final class ADSocials extends JavaPlugin {
    @Getter
    private static ADSocials instance;

    @SneakyThrows
    @Override
    public void onEnable() {
        instance = this;
        MessagesFile.getConfig().save();
        ConfigFile.getConfig().save();
        getCommand("discord").setExecutor(new DiscordCMD(this));
        getCommand("facebook").setExecutor(new FacebookCMD(this));
        getCommand("instagram").setExecutor(new InstagramCMD(this));
        getCommand("teamspeak").setExecutor(new TeamspeakCMD(this));
        getCommand("telegram").setExecutor(new TelegramCMD(this));
        getCommand("adsocials").setExecutor(new ADSocialsCMD(this));
    }
    public static ADSocials getInstance() {
        return instance;
    }
    @Override
    public void onDisable() {
        MessagesFile.getConfig().save();
        ConfigFile.getConfig().save();
    }
}
