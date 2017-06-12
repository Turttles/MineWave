package mw.swifty.slappy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class Utils
{
  public static HashMap<String, Boolean> ingame = new HashMap();
  public static HashMap<String, Integer> ploc = new HashMap();
  public static List<String> queue_ember = new ArrayList();
  public static List<String> queue_fortress = new ArrayList();
  public static List<String> frozen = new ArrayList();
  
  public static void teleport(Player p, String map)
  {
    if (map == "fortress")
    {
      World w = Bukkit.getWorld("slappy");
      Location loc1 = new Location(w, 2338.5D, 13.0D, -879.5D, 90.0F, 0.0F);
      Location loc2 = new Location(w, 2318.5D, 13.0D, -899.5D, 0.0F, 0.0F);
      Location loc3 = new Location(w, 2298.5D, 13.0D, -879.5D, -90.0F, 0.0F);
      Location loc4 = new Location(w, 2318.5D, 13.0D, -859.5D, 180.0F, 1.0F);
      if (ploc.get(p.getName()) == null) {
        return;
      }
      if (((Integer)ploc.get(p.getName())).intValue() == 1) {
        p.teleport(loc1);
      }
      if (((Integer)ploc.get(p.getName())).intValue() == 2) {
        p.teleport(loc2);
      }
      if (((Integer)ploc.get(p.getName())).intValue() == 3) {
        p.teleport(loc3);
      }
      if (((Integer)ploc.get(p.getName())).intValue() == 4) {
        p.teleport(loc4);
      }
    }
  }
  
  public static String no_args = "§cInvalid args, try /slappy help to view a list of command!";
  
  public static Boolean removefromQueue(Player p, String map)
  {
    Boolean r = null;
    if (map == "ember") {
      if (!queue_ember.contains(p.getName()))
      {
        r = Boolean.valueOf(false);
      }
      else
      {
        r = Boolean.valueOf(true);
        queue_ember.remove(p.getName());
      }
    }
    if (map == "fortress") {
      if (!queue_fortress.contains(p.getName()))
      {
        r = Boolean.valueOf(false);
      }
      else
      {
        r = Boolean.valueOf(true);
        queue_fortress.remove(p.getName());
      }
    }
    return r;
  }
  
  public static Boolean addtoQueue(Player p, String map)
  {
    Boolean r = null;
    p.getInventory().clear();
    if (map == "ember") {
      if (queue_ember.contains(p.getName()))
      {
        r = Boolean.valueOf(false);
      }
      else
      {
        r = Boolean.valueOf(true);
        teleport(p, map);
        queue_ember.add(p.getName());
      }
    }
    if (map == "fortress") {
      if (queue_fortress.contains(p.getName()))
      {
        r = Boolean.valueOf(false);
      }
      else
      {
        r = Boolean.valueOf(true);
        teleport(p, map);
        queue_fortress.add(p.getName());
      }
    }
    return r;
  }
  
  public static void giveItems(Player p)
  {
    ItemStack i = new ItemStack(Material.RAW_FISH, 1);
    ItemMeta m = i.getItemMeta();
    m.addEnchant(Enchantment.KNOCKBACK, 7, true);
    m.setDisplayName("§aSlappy Fish");
    m.setLore(Arrays.asList(new String[] { "§aSlap your opponents with this fish to make them fly away!" }));
    i.setItemMeta(m);
    p.getInventory().setItem(0, i);
  }
  
  public static Boolean isinQueue(Player p)
  {
    Boolean r = Boolean.valueOf(false);
    if (queue_ember.contains(p.getName())) {
      r = Boolean.valueOf(true);
    }
    if (queue_fortress.contains(p.getName())) {
      r = Boolean.valueOf(true);
    }
    return r;
  }
  
  public static String ListQueue(String map)
  {
    String r = "";
    if (map == "ember") {
      if (queue_ember.size() == 0)
      {
        r = "§cThe queue is empty for the map Ember!";
      }
      else
      {
        String q = "";
        if (queue_ember.size() == 1)
        {
          q = queue_ember.toString();
        }
        else
        {
          StringBuilder sb = new StringBuilder();
          for (int i = 0; i < queue_ember.size() - 1; i++) {
            sb.append((String)queue_ember.get(i) + ", ");
          }
          sb.append((String)queue_ember.get(queue_ember.size()));
        }
        r = "§aThe queue for the map Ember is " + q.replace("[", "").replace("]", "") + ".";
      }
    }
    if (map == "fortress") {
      if (queue_fortress.size() == 0)
      {
        r = "§cThe queue is empty for the map Fortress!";
      }
      else
      {
        String q = "";
        if (queue_fortress.size() == 1)
        {
          q = queue_fortress.toString();
        }
        else
        {
          StringBuilder sb = new StringBuilder();
          for (int i = 0; i < queue_fortress.size() - 1; i++) {
            sb.append((String)queue_fortress.get(i) + ", ");
          }
          sb.append((String)queue_fortress.get(queue_fortress.size()));
        }
        r = "§aThe queue for the map Fortress is " + q.replace("[", "").replace("]", "") + ".";
      }
    }
    return r;
  }
  
  public static void Maps(Player p)
  {
    p.sendMessage("§a----=> Slappy Maps <=----");
    p.sendMessage("§aEmber");
    p.sendMessage("§aFortress");
    p.sendMessage("§a----=>  Page: 1/1  <=----");
  }
  
  public static void Help(Player p)
  {
    p.sendMessage("§a----=> Slappy Help <=----");
    p.sendMessage("§a/Slappy help - Brings up this message!");
    p.sendMessage("§a/Slappy leave - Leave a slappy game!");
    p.sendMessage("§a/Slappy maps - shows the list of maps available!");
    p.sendMessage("§a/Slappy join <map> - Join a slappy game!");
    p.sendMessage("§a/Slappy queue <map> - shows the queue for a map!");
    p.sendMessage("§a----=>  Page: 1/1  <=----");
  }
}
