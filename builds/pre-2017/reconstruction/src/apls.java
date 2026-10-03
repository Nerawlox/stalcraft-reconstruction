/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.BlockDispenser;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ezfa;

public final class apls
extends bbmo {
    @Override
    public ItemStack _b(ekuw ekuw2, ItemStack itemStack) {
        ezfa ezfa2 = BlockDispenser._a(ekuw2._h());
        double d = ekuw2._b() + (double)ezfa2._a();
        double d2 = (float)ekuw2._f() + 0.2f;
        double d3 = ekuw2._d() + (double)ezfa2._c();
        Entity entity = ItemMonsterPlacer._a(ekuw2._a(), itemStack._j(), d, d2, d3);
        if (entity instanceof EntityLivingBase && itemStack._u()) {
            ((EntityLiving)entity).setCustomNameTag(itemStack._s());
        }
        itemStack._a(1);
        return itemStack;
    }
}

