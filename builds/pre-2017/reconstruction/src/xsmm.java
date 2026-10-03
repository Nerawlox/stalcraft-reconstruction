/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.owak;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.world.World;

public final class xsmm
extends zhrm {
    @Override
    public owak _a(World world, yent yent2) {
        return new EntitySnowball(world, yent2._b(), yent2._c(), yent2._d());
    }
}

