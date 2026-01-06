package sudark2.Sudark.enduranceForge;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class EnduranceForge extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new GrindstoneListenr(), this);
    }
}
