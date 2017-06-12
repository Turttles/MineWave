package mw.swifty.slappy;

import java.util.HashMap;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Slappy
  implements CommandExecutor
{
  String nargs = Utils.no_args;
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if ((sender instanceof Player))
    {
      Player p = (Player)sender;
      if (cmd.getName().equalsIgnoreCase("slappy"))
      {
        if (args.length == 0)
        {
          Utils.Help(p);
          return false;
        }
        if (args.length == 1)
        {
          if (args[0].equalsIgnoreCase("help"))
          {
            Utils.Help(p);
            return false;
          }
          if (args[0].equalsIgnoreCase("maps"))
          {
            Utils.Maps(p);
            return false;
          }
          if (args[0].equalsIgnoreCase("leave"))
          {
            if (Utils.queue_ember.contains(p.getName()))
            {
              Utils.removefromQueue(p, "ember");
              p.sendMessage("§cYou are no longer in queue to play the map Ember!");
              return false;
            }
            if (Utils.queue_fortress.contains(p.getName()))
            {
              Utils.removefromQueue(p, "fortress");
              p.sendMessage("§cYou are no longer in queue to play the map Fortress!");
              return false;
            }
            p.sendMessage("§cYou are not queued to play any maps!");
            return false;
          }
        }
        if (args.length == 2)
        {
          if (args[0].equalsIgnoreCase("forcestart"))
          {
            if (args[1].equalsIgnoreCase("ember"))
            {
              pregame("ember");
              return false;
            }
            if (args[1].equalsIgnoreCase("fortress"))
            {
              pregame("fortress");
              return false;
            }
            return false;
          }
          if (args[0].equalsIgnoreCase("join"))
          {
            if (Utils.isinQueue(p).booleanValue())
            {
              p.sendMessage("§cYou are already in a queue!");
            }
            else
            {
              if (args[1].equalsIgnoreCase("ember"))
              {
                if ((Utils.ingame.get("ember") != null) && (((Boolean)Utils.ingame.get("ember")).booleanValue()))
                {
                  p.sendMessage(
                    "§cThe map Ember is already in its game phase, please check back later for an open slot!");
                }
                else if (Utils.queue_ember.contains(p.getName()))
                {
                  p.sendMessage("§cYou are already in queue to play the map Ember!");
                }
                else if ((Utils.queue_ember.size() < 4) && (Utils.queue_ember.size() > 2))
                {
                  Utils.addtoQueue(p, "ember");
                  pregame("ember");
                  p.sendMessage("§aYou are now in queue to play the map Ember!");
                }
                else if (Utils.queue_ember.size() == 4)
                {
                  p.sendMessage("§cThe map Ember currently has a full lobby!");
                }
                else
                {
                  Utils.addtoQueue(p, "ember");
                  p.sendMessage("§aYou are now in queue to play the map Ember!");
                }
                return false;
              }
              if (args[1].equalsIgnoreCase("fortress"))
              {
                if ((Utils.ingame.get("fortress") != null) && (((Boolean)Utils.ingame.get("fortress")).booleanValue()))
                {
                  p.sendMessage(
                    "§cThe map Fortress is already in its game phase, please check back later for an open slot!");
                }
                else if (Utils.queue_ember.contains(p.getName()))
                {
                  p.sendMessage("§cYou are already in queue to play the map Fortress!");
                }
                else if ((Utils.queue_fortress.size() < 4) && (Utils.queue_fortress.size() > 2))
                {
                  Utils.addtoQueue(p, "fortress");
                  pregame("fortress");
                  Utils.ploc.put(p.getName(), Integer.valueOf(Utils.queue_fortress.size()));
                  Utils.teleport(p, "fortress");
                  p.sendMessage("§aYou are now in queue to play the map Fortress!");
                }
                else if (Utils.queue_fortress.size() == 4)
                {
                  p.sendMessage("§cThe map Fortress currently has a full lobby!");
                }
                else
                {
                  Utils.addtoQueue(p, "fortress");
                  Utils.ploc.put(p.getName(), Integer.valueOf(Utils.queue_fortress.size()));
                  Utils.teleport(p, "fortress");
                  p.sendMessage("§aYou are now in queue to play the map Fortress!");
                }
                return false;
              }
              p.sendMessage("§cThe map '" + args[1] + 
                "' is not a valid map, use /slappy maps to view a list of maps!");
              return false;
            }
            return false;
          }
          if (args[0].equalsIgnoreCase("queue"))
          {
            if (args[1].equalsIgnoreCase("ember"))
            {
              p.sendMessage(Utils.ListQueue("ember"));
              return false;
            }
            if (args[1].equalsIgnoreCase("fortress"))
            {
              p.sendMessage(Utils.ListQueue("fortress"));
              return false;
            }
            p.sendMessage("§cThe map '" + args[1] + 
              "' is not a valid map, use /slappy maps to view a list of maps!");
            return false;
          }
        }
        p.sendMessage(this.nargs);
      }
    }
    else
    {
      sender.sendMessage("You must be a player to use this command!");
    }
    return false;
  }
  
  private void pregame(String map)
  {
    if (map == "ember")
    {
      for (String a : Utils.queue_ember)
      {
        Player p = Bukkit.getPlayer(a);
        if (a != null)
        {
          Utils.teleport(p, "ember");
          Utils.frozen.add(p.getName());
          p.sendMessage("§aMatch is starting in 5 seconds!");
        }
      }
      new BukkitRunnable()
      {
        public void run()
        {
          for (String a : Utils.queue_ember)
          {
            Player p = Bukkit.getPlayer(a);
            if (a != null) {
              p.sendMessage("§aMatch is starting in 4 seconds!");
            }
          }
        }
      }.runTaskLater(Main.getPlugin(Main.class), 20L);
      new BukkitRunnable()
      {
        public void run()
        {
          for (String a : Utils.queue_ember)
          {
            Player p = Bukkit.getPlayer(a);
            if (a != null) {
              p.sendMessage("§aMatch is starting in 3 seconds!");
            }
          }
        }
      }.runTaskLater(Main.getPlugin(Main.class), 40L);
      new BukkitRunnable()
      {
        public void run()
        {
          for (String a : Utils.queue_ember)
          {
            Player p = Bukkit.getPlayer(a);
            if (a != null) {
              p.sendMessage("§aMatch is starting in 2 seconds!");
            }
          }
        }
      }.runTaskLater(Main.getPlugin(Main.class), 60L);
      new BukkitRunnable()
      {
        public void run()
        {
          for (String a : Utils.queue_ember)
          {
            Player p = Bukkit.getPlayer(a);
            if (a != null) {
              p.sendMessage("§aMatch is starting in 1 seconds!");
            }
          }
        }
      }.runTaskLater(Main.getPlugin(Main.class), 80L);
      new BukkitRunnable()
      {
        public void run()
        {
          for (String a : Utils.queue_ember)
          {
            Player p = Bukkit.getPlayer(a);
            if (a != null)
            {
              Utils.frozen.remove(p.getName());
              p.sendMessage("§aMatch has been started!");
            }
          }
        }
      }.runTaskLater(Main.getPlugin(Main.class), 100L);
    }
    if (map == "fortress")
    {
      for (String a : Utils.queue_fortress)
      {
        Player p = Bukkit.getPlayer(a);
        if (a != null)
        {
          Utils.giveItems(p);
          p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 1));
          p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, Integer.MAX_VALUE, 1));
          p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
          Utils.teleport(p, "fortress");
          p.setGameMode(GameMode.SURVIVAL);
          Utils.frozen.add(p.getName());
          p.sendMessage("§aMatch is starting in 5 seconds!");
        }
      }
      new BukkitRunnable()
      {
        public void run()
        {
          for (String a : Utils.queue_fortress)
          {
            Player p = Bukkit.getPlayer(a);
            if (a != null) {
              p.sendMessage("§aMatch is starting in 4 seconds!");
            }
          }
        }
      }.runTaskLater(Main.getPlugin(Main.class), 20L);
      new BukkitRunnable()
      {
        public void run()
        {
          for (String a : Utils.queue_fortress)
          {
            Player p = Bukkit.getPlayer(a);
            if (a != null) {
              p.sendMessage("§aMatch is starting in 3 seconds!");
            }
          }
        }
      }.runTaskLater(Main.getPlugin(Main.class), 40L);
      new BukkitRunnable()
      {
        public void run()
        {
          for (String a : Utils.queue_fortress)
          {
            Player p = Bukkit.getPlayer(a);
            if (a != null) {
              p.sendMessage("§aMatch is starting in 2 seconds!");
            }
          }
        }
      }.runTaskLater(Main.getPlugin(Main.class), 60L);
      new BukkitRunnable()
      {
        public void run()
        {
          for (String a : Utils.queue_fortress)
          {
            Player p = Bukkit.getPlayer(a);
            if (a != null) {
              p.sendMessage("§aMatch is starting in 1 seconds!");
            }
          }
        }
      }.runTaskLater(Main.getPlugin(Main.class), 80L);
      new BukkitRunnable()
      {
        public void run()
        {
          for (String a : Utils.queue_fortress)
          {
            Player p = Bukkit.getPlayer(a);
            if (a != null)
            {
              p.setGameMode(GameMode.SURVIVAL);
              Utils.frozen.remove(p.getName());
              p.sendMessage("§aMatch has been started!");
            }
          }
        }
      }.runTaskLater(Main.getPlugin(Main.class), 100L);
    }
  }
}
