package FlintironNewEra.Entity.Projectile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.world.World;

public abstract class CartridgeEntity extends ProjectileEntity {
    public CartridgeEntity(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }
}
