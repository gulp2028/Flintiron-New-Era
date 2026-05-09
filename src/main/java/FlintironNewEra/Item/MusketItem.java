package FlintironNewEra.Item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ChargedProjectilesComponent;
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

import static org.apache.logging.log4j.ThreadContext.isEmpty;

public class musketItem extends RangedWeaponItem {

    private boolean Primed = false;
    private boolean isLoaded = false;



    public musketItem(Item.Settings settings)
    {super(settings);}

    public Predicate<ItemStack> getProjectiles() {return MUSKET_PROJECTILES;}

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        ChargedProjectilesComponent chargedProjectilesComponent = (ChargedProjectilesComponent)itemStack.get(DataComponentTypes.CHARGED_PROJECTILES);
        if(chargedProjectilesComponent != null && !chargedProjectilesComponent.isEmpty())
            this.shootAll(world, user, hand, itemStack, getSpeed(chargedProjectilesComponent), 4.0F, 0.0F, (LivingEntity) null);
            return TypedActionResult.consume(itemStack);
        else if(!user.getProjectileType(itemStack).isEmpty()) {
            Primed = true;
            isLoaded = true;
            user.setCurrentHand(hand);
            return TypedActionResult.consume(itemStack);
        else {
            TypedActionResult.fail(itemStack);
            }










}


}