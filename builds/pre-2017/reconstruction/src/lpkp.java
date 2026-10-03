/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.BlockDispenser;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ezfa;

public final class lpkp
extends bbmo {
    @Override
    public ItemStack _b(ekuw ekuw2, ItemStack itemStack) {
        ezfa ezfa2 = BlockDispenser._a(ekuw2._h());
        double d = ekuw2._b() + (double)ezfa2._a();
        double d2 = (float)ekuw2._f() + 0.2f;
        double d3 = ekuw2._d() + (double)ezfa2._c();
        EntityFireworkRocket entityFireworkRocket = new EntityFireworkRocket(ekuw2._a(), d, d2, d3, itemStack);
        ekuw2._a().spawnEntityInWorld(entityFireworkRocket);
        itemStack._a(1);
        return itemStack;
    }

    @Override
    public void _a(ekuw ekuw2) {
        ekuw2._a().playAuxSFX(1002, ekuw2._e(), ekuw2._f(), ekuw2._g(), 0);
    }
}

