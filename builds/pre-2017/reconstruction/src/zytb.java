/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.owak;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.world.World;

public final class zytb
extends zhrm {
    @Override
    public owak _a(World world, yent yent2) {
        return new EntityEgg(world, yent2._b(), yent2._c(), yent2._d());
    }
}

