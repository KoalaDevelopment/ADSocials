package me.arsenicdevelopment.adsocials.commands;

import me.arsenicdevelopment.adsocials.ADSocials;
import me.arsenicdevelopment.adsocials.utils.ChatUtil;
import me.arsenicdevelopment.adsocials.utils.ConfigFile;
import me.arsenicdevelopment.adsocials.utils.MessagesFile;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InstagramCMD implements CommandExecutor {

    private ADSocials adsocials;

    public InstagramCMD(ADSocials adsocials){
        this.adsocials = adsocials;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("instagram")) {
            if (ConfigFile.getConfig().getBoolean("Instagram") == true) {
                for (String string : MessagesFile.getConfig().getStringList("instagram.message")) {
                    player.sendMessage(ChatUtil.CC(string));
                }
            }
        }
        return false;
    }
}
