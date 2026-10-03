/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.owak;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.World;

public final class oyto
extends zhrm {
    @Override
    public owak _a(World world, yent yent2) {
        EntityArrow entityArrow = new EntityArrow(world, yent2._b(), yent2._c(), yent2._d());
        entityArrow.canBePickedUp = 1;
        return entityArrow;
    }
}

