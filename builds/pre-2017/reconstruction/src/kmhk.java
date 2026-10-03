/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.owak;
import net.minecraft.world.World;

public final class kmhk
extends zhrm {
    @Override
    public owak _a(World world, yent yent2) {
        return new EntityExpBottle(world, yent2._b(), yent2._c(), yent2._d());
    }

    @Override
    public float _a() {
        return super._a() * 0.5f;
    }

    @Override
    public float _b() {
        return super._b() * 1.25f;
    }
}

