package me.arsenicdevelopment.adsocials.commands;

import lombok.SneakyThrows;
import me.arsenicdevelopment.adsocials.ADSocials;
import me.arsenicdevelopment.adsocials.utils.ChatUtil;
import me.arsenicdevelopment.adsocials.utils.ConfigFile;
import me.arsenicdevelopment.adsocials.utils.MessagesFile;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ADSocialsCMD implements CommandExecutor {

    private ADSocials adsocials;

    public ADSocialsCMD(ADSocials adsocials){
        this.adsocials = adsocials;
    }
    @SneakyThrows
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        if (player.hasPermission("adsocials.help")) {
            if (command.getName().equalsIgnoreCase("adsocials")) {
                if (args.length == 0) {
                    player.sendMessage(ChatUtil.CC(""));
                    player.sendMessage(ChatUtil.CC("&6&lADSocials Help"));
                    player.sendMessage(ChatUtil.CC(""));
                    player.sendMessage(ChatUtil.CC("&7/adsocials help - for to get the help list"));
                    player.sendMessage(ChatUtil.CC("&7/adsocials reload - for the reload of the fils"));
                    player.sendMessage(ChatUtil.CC("&7/adsocials info - for information about the plugin"));
                    player.sendMessage(ChatUtil.CC(""));
                    return false;
                }
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("help")) {
                        if (player.hasPermission("adsocials.help")) {
                            player.sendMessage(ChatUtil.CC(""));
                            player.sendMessage(ChatUtil.CC("&6&lADSocials Help"));
                            player.sendMessage(ChatUtil.CC(""));
                            player.sendMessage(ChatUtil.CC("&7/adsocials help - for to get the help list"));
                            player.sendMessage(ChatUtil.CC("&7/adsocials reload - for the reload of the fils"));
                            player.sendMessage(ChatUtil.CC("&7/adsocials info - for information about the plugin"));
                            player.sendMessage(ChatUtil.CC(""));
                        }
                        return false;
                    }
                    if (args[0].equalsIgnoreCase("reload")) {
                        if (sender.hasPermission("adsocials.reload")) {
                            MessagesFile.getConfig().reload();
                            ConfigFile.getConfig().reload();
                            player.sendMessage(ChatUtil.CC(""));
                            player.sendMessage(ChatUtil.CC("&c&lReload"));
                            player.sendMessage(ChatUtil.CC("&6All files has been successfully reloaded."));
                            player.sendMessage(ChatUtil.CC(""));
                        }
                        return false;
                    }
                    if (args[0].equalsIgnoreCase("info")) {
                        if (player.hasPermission("adsocials.info")) {
                            player.sendMessage(ChatUtil.CC(""));
                            player.sendMessage(ChatUtil.CC("&6ADSocials Info"));
                            player.sendMessage(ChatUtil.CC(""));
                            player.sendMessage(ChatUtil.CC("Version: 1.0"));
                            player.sendMessage(ChatUtil.CC("Author: TryHardKoala"));
                            player.sendMessage(ChatUtil.CC("Discord: https://discord.gg/bs5MneFZeq"));
                            player.sendMessage(ChatUtil.CC(""));
                        }
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
