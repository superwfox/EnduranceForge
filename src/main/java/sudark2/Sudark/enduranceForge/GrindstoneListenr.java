package sudark2.Sudark.enduranceForge;

import org.bukkit.Material;
import org.bukkit.event.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.PrepareGrindstoneEvent;
import org.bukkit.inventory.GrindstoneInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

public class GrindstoneListenr implements Listener {

    @EventHandler
    public void onPrepare(PrepareGrindstoneEvent e) {
        GrindstoneInventory inv = e.getInventory();
        ItemStack base = inv.getItem(0);
        ItemStack fuel = inv.getItem(1);
        if (base == null || fuel == null) return;
        if (!(base.getItemMeta() instanceof Damageable)) return;
        if (!fuel.getType().name().contains("NETHERITE")) return;

        String baseMaterial = base.getType().name();
        String fuelMaterial = fuel.getType().name();
        String baseKey = baseMaterial.substring(baseMaterial.length() - 3);
        String fuelKey = fuelMaterial.substring(fuelMaterial.length() - 3);

        if (!fuelKey.equals(baseKey)) return;

        // 克隆物品并保存原最大耐久
        ItemStack result = base.clone();
        Damageable dm = (Damageable) result.getItemMeta();

        int origMax = (dm.hasMaxDamage()) ? dm.getMaxDamage() : result.getType().getMaxDurability();
        dm.setMaxDamage(origMax + 100);

        result.setItemMeta(dm);
        e.setResult(result);
    }
}

