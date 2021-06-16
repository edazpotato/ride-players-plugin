package codes.edaz.rideplayers;

import codes.edaz.rideplayers.commands.KickPassengersCommand;
import codes.edaz.rideplayers.listeners.ClickEntityListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class RidePlayers extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new ClickEntityListener(), this);
        this.getCommand("kickpassengers").setExecutor(new KickPassengersCommand());

        System.out.println("RidePlayers was successfully enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
