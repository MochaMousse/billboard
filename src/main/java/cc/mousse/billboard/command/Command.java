package cc.mousse.billboard.command;

import cc.mousse.billboard.config.ConfigLoader;
import lombok.val;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * @author MochaMousse
 */
public class Command implements CommandExecutor {
  @Override
  public boolean onCommand(
      CommandSender sender,
      @NotNull org.bukkit.command.Command command,
      @NotNull String label,
      String[] args) {
    if (!sender.isOp()) {
      return false;
    }
    if (args.length < 1) {
      return false;
    }
    switch (args[0]) {
      case "reload" -> {
        reload(sender);
        return true;
      }
      case "enable" -> {
        enable(sender);
        return true;
      }
      case "disable" -> {
        disable(sender);
        return true;
      }
      default -> {
        sender.sendMessage(ConfigLoader.getPrefix() + "未知命令");
        return false;
      }
    }
  }

  private void reload(CommandSender sender) {
    ConfigLoader.load();
    sender.sendMessage(ConfigLoader.getPrefix() + ChatColor.BLUE + "消息已重载↓");
    val messages = ConfigLoader.getMessage();
    if (!messages.isEmpty()) {
      for (String message : messages) {
        if (!message.isBlank()) {
          sender.sendMessage(ConfigLoader.getPrefix() + message);
        }
      }
    }
  }

  private void enable(CommandSender sender) {
    ConfigLoader.enable();
    sender.sendMessage(ConfigLoader.getPrefix() + ChatColor.GREEN + "消息已启用");
  }

  private void disable(CommandSender sender) {
    ConfigLoader.disable();
    sender.sendMessage(ConfigLoader.getPrefix() + ChatColor.RED + "消息已禁用");
  }
}
