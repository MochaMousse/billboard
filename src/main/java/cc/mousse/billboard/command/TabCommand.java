package cc.mousse.billboard.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PhineasZ
 */
public class TabCommand implements TabCompleter {
  @Nullable
  @Override
  public List<String> onTabComplete(
      @NotNull CommandSender sender,
      @NotNull Command command,
      @NotNull String label,
      @NotNull String[] args) {
    List<String> commands = new ArrayList<>();
    if (args.length == 1) {
      commands.add("reload");
      commands.add("enable");
      commands.add("disable");
    }
    return commands;
  }
}
