package org.alchemy.mobconvert;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class MobConvert extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new EventsHandler(), this);
        Logger logger = Bukkit.getLogger();
        logger.log(Level.FINE, String.format("[%s] Enabled Version %s", Bukkit.getName(), Bukkit.getVersion()));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
