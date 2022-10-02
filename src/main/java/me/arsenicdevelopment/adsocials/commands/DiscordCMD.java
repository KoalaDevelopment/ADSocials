package me.arsenicdevelopment.adsocials.commands;

import me.arsenicdevelopment.adsocials.ADSocials;
import me.arsenicdevelopment.adsocials.utils.ChatUtil;
import me.arsenicdevelopment.adsocials.utils.ConfigFile;
import me.arsenicdevelopment.adsocials.utils.MessagesFile;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordCMD implements CommandExecutor {

    private ADSocials adsocials;

    public DiscordCMD(ADSocials adsocials){
        this.adsocials = adsocials;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("discord")) {
            if (ConfigFile.getConfig().getBoolean("Discord") == true) {
                for (String string : MessagesFile.getConfig().getStringList("discord.message")) {
                    player.sendMessage(ChatUtil.CC(string));
                }
            }
        }
        return false;
    }
}