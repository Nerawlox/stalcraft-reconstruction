/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.block.BlockDispenser;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.jxtc;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ezfa;

public final class pkyq
extends bbmo {
    @Override
    public ItemStack _b(ekuw ekuw2, ItemStack itemStack) {
        ezfa ezfa2 = BlockDispenser._a(ekuw2._h());
        int n = ekuw2._e() + ezfa2._a();
        int n2 = ekuw2._f() + ezfa2._b();
        int n3 = ekuw2._g() + ezfa2._c();
        AxisAlignedBB axisAlignedBB = AxisAlignedBB._a()._a(n, n2, n3, n + 1, n2 + 1, n3 + 1);
        List list2 = ekuw2._a().selectEntitiesWithinAABB(EntityLivingBase.class, axisAlignedBB, new jxtc(itemStack));
        if (list2.size() > 0) {
            EntityLivingBase entityLivingBase = (EntityLivingBase)list2.get(0);
            boolean bl = entityLivingBase instanceof EntityPlayer;
            int n4 = EntityLiving.getArmorPosition(itemStack);
            ItemStack itemStack2 = itemStack._l();
            itemStack2._b = 1;
            entityLivingBase.setCurrentItemOrArmor(n4, itemStack2);
            if (entityLivingBase instanceof EntityLiving) {
                ((EntityLiving)entityLivingBase).setEquipmentDropChance(n4, 2.0f);
            }
            --itemStack._b;
            return itemStack;
        }
        return super._b(ekuw2, itemStack);
    }
}

