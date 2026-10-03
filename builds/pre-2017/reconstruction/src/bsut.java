/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class bsut
extends Item {
    public bsut(int n) {
        super(n);
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        int n5 = world.getBlockId(n, n2, n3);
        if (Block.blocksList[n5] != null && Block.blocksList[n5].getRenderType() == 11) {
            if (world.isRemote) {
                return true;
            }
            bsut._a(entityPlayer, world, n, n2, n3);
            return true;
        }
        return false;
    }

    public static boolean _a(EntityPlayer entityPlayer, World world, int n, int n2, int n3) {
        EntityLeashKnot entityLeashKnot = EntityLeashKnot.getKnotForBlock(world, n, n2, n3);
        boolean bl = false;
        double d = 7.0;
        List list2 = world.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB._a()._a((double)n - d, (double)n2 - d, (double)n3 - d, (double)n + d, (double)n2 + d, (double)n3 + d));
        if (list2 != null) {
            for (EntityLiving entityLiving : list2) {
                if (!entityLiving.getLeashed() || entityLiving.getLeashedToEntity() != entityPlayer) continue;
                if (entityLeashKnot == null) {
                    entityLeashKnot = EntityLeashKnot.func_110129_a(world, n, n2, n3);
                }
                entityLiving.setLeashedToEntity(entityLeashKnot, true);
                bl = true;
            }
        }
        return bl;
    }
}

