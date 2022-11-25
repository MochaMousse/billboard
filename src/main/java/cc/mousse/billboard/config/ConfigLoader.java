package cc.mousse.billboard.config;

import cc.mousse.billboard.Billboard;
import lombok.val;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PhineasZ
 */
public final class ConfigLoader {

  private static final Billboard INSTANCE = Billboard.getInstance();
  private static List<String> messageList;
  private static boolean enable = false;
  private static String prefix;

  private ConfigLoader() {}

  public static void init() {
    // 加载配置文件
    INSTANCE.saveDefaultConfig();
    load();
  }

  public static void load() {
    // 读取配置文件
    INSTANCE.reloadConfig();
    val config = INSTANCE.getConfig();
    enable = config.getBoolean("billboard.enable");
    prefix = config.getString("billboard.prefix");
    if (prefix != null) {
      prefix = pattern(prefix);
    }
    val messages = config.getStringList("billboard.messages");
    val newMessage = new ArrayList<String>();
    for (String message : messages) {
      if (message != null && !message.isBlank()) {
        newMessage.add(pattern(message));
      }
    }
    messageList = newMessage;
  }

  private static String pattern(String message) {
    message = message.replace("$BLACK$", ChatColor.BLACK.toString());
    message = message.replace("$DARK_BLUE$", ChatColor.DARK_BLUE.toString());
    message = message.replace("$DARK_GREEN$", ChatColor.DARK_GREEN.toString());
    message = message.replace("$DARK_AQUA$", ChatColor.DARK_AQUA.toString());
    message = message.replace("$DARK_RED$", ChatColor.DARK_RED.toString());
    message = message.replace("$DARK_PURPLE$", ChatColor.DARK_PURPLE.toString());
    message = message.replace("$GOLD$", ChatColor.GOLD.toString());
    message = message.replace("$GRAY$", ChatColor.GRAY.toString());
    message = message.replace("$DARK_GRAY$", ChatColor.DARK_GRAY.toString());
    message = message.replace("$BLUE$", ChatColor.BLUE.toString());
    message = message.replace("$GREEN$", ChatColor.GREEN.toString());
    message = message.replace("$AQUA$", ChatColor.AQUA.toString());
    message = message.replace("$RED$", ChatColor.RED.toString());
    message = message.replace("$LIGHT_PURPLE$", ChatColor.LIGHT_PURPLE.toString());
    message = message.replace("$YELLOW$", ChatColor.YELLOW.toString());
    message = message.replace("$WHITE$", ChatColor.WHITE.toString());
    message = message.replace("$MAGIC$", ChatColor.MAGIC.toString());
    message = message.replace("$BOLD$", ChatColor.BOLD.toString());
    message = message.replace("$STRIKETHROUGH$", ChatColor.STRIKETHROUGH.toString());
    message = message.replace("$UNDERLINE$", ChatColor.UNDERLINE.toString());
    message = message.replace("$ITALIC$", ChatColor.ITALIC.toString());
    message = message.replace("$RESET$", ChatColor.RESET.toString());
    return message;
  }

  public static List<String> getMessage() {
    return messageList;
  }

  public static String getPrefix() {
    return prefix;
  }

  public static boolean isEnable() {
    return enable;
  }

  public static void enable() {
    enable = true;
    save(true);
  }

  public static void disable() {
    enable = false;
    save(false);
  }

  private static void save(boolean enable) {
    INSTANCE.getConfig().set("billboard.enable", enable);
    INSTANCE.saveConfig();
  }
}
