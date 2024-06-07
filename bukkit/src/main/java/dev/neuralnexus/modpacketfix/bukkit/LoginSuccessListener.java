package dev.neuralnexus.modpacketfix.bukkit;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class LoginSuccessListener implements Listener {
    private final BukkitModPacketFixPlugin plugin;

    public LoginSuccessListener(BukkitModPacketFixPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        // 不再检查客户端品牌，直接将玩家加入Forge用户列表
        plugin.addForgeUser(player);
        plugin.getLogger().info("Registered " + player.getName() + " as a forge user");
    }
}
