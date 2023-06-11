package org.alchemy.mobconvert;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Pig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;
import java.util.logging.Logger;

public final class EventsHandler extends JavaPlugin implements Listener {
    Logger logger = Bukkit.getLogger();

    @EventHandler
    public void onSpawnCreatureEntity(CreatureSpawnEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Pig)
        {
            entity.remove();
            double x = entity.getLocation().getX();
            double y = entity.getLocation().getY();
            double z = entity.getLocation().getZ();
            Random seed = new Random();
            Random random = new Random(seed.nextInt());
            int birth = (int) (entity.getEntityId() % 600 * Math.pow(-1, random.nextInt()));
            int gender = Math.abs(random.nextInt() % 2);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), String.format("summon tfc:boartfc %f %f %f {birth: %d, gender: %d}", x, y, z, birth, gender));
        }
    }
}
