package FlintironNewEra.Item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public abstract class MusketItem extends RangedWeaponItem {
    private boolean priming = false;
    private boolean primed = false;
    private static final float DEFAULT_PRIMING_TIME = 3.0f;


    public MusketItem(Item.Settings settings) {
        super(settings);
    }

    public static final Predicate<ItemStack> MUSKET_PROJECTILES =
            stack -> stack.isOf(ModItems.CARTRIDGE);





    @Override
    public int getRange() {
        return 0;
    }

    @Override
    protected void shoot(LivingEntity shooter, ProjectileEntity projectile, int index, float speed, float divergence, float yaw, @Nullable LivingEntity target) {

    }




    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        //need some way for timer to begin for 3 seconds, detecting if the hand goes off the item

    }
}
