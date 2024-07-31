package cc.mousse.billboard.event;

import cc.mousse.billboard.config.ConfigLoader;
import lombok.val;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author MochaMousse
 */
public class JoinEvent implements Listener {
  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    if (ConfigLoader.isEnable()) {
      val messages = ConfigLoader.getMessage();
      val player = event.getPlayer();
      if (!messages.isEmpty()) {
        for (String message : messages) {
          if (!message.isBlank()) {
            player.sendMessage(ConfigLoader.getPrefix() + message);
          }
        }
      }
    }
  }
}
