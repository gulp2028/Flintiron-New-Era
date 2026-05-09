package FlintironNewEra.Item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;

import java.util.function.Predicate;

public class MusketItem extends RangedWeaponItem {

    private boolean Primed = false;
    private boolean Loaded = false;

    public MusketItem(Item.Settings settings)
    {super(settings);}

    public Predicate<ItemStack> getProjectiles() {
        return MUSKET_PROJECTILES}
    //going to add musket projectile tag later
    }



}