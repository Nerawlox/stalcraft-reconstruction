/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.BlockDispenser;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ezfa;
import net.minecraft.world.World;

public final class zhra
extends bbmo {
    @Override
    public ItemStack _b(ekuw ekuw2, ItemStack itemStack) {
        ezfa ezfa2 = BlockDispenser._a(ekuw2._h());
        World world = ekuw2._a();
        int n = ekuw2._e() + ezfa2._a();
        int n2 = ekuw2._f() + ezfa2._b();
        int n3 = ekuw2._g() + ezfa2._c();
        EntityTNTPrimed entityTNTPrimed = new EntityTNTPrimed(world, (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, null);
        world.spawnEntityInWorld(entityTNTPrimed);
        --itemStack._b;
        return itemStack;
    }
}

