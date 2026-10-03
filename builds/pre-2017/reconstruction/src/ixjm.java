/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ixjm
extends Item {
    public ixjm(int n) {
        super(n);
        this.setCreativeTab(CreativeTabs.tabTransport);
        this.setMaxStackSize(1);
        this.setMaxDamage(25);
    }

    @Override
    public boolean isFull3D() {
        return true;
    }

    @Override
    public boolean shouldRotateAroundWhenRendering() {
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        EntityPig entityPig;
        if (entityPlayer.isRiding() && entityPlayer.ridingEntity instanceof EntityPig && (entityPig = (EntityPig)entityPlayer.ridingEntity).getAIControlledByPlayer()._c() && itemStack._k() - itemStack._j() >= 7) {
            entityPig.getAIControlledByPlayer()._b();
            itemStack._a(7, (EntityLivingBase)entityPlayer);
            if (itemStack._b == 0) {
                ItemStack itemStack2 = new ItemStack(Item.fishingRod);
                itemStack2._d(itemStack._e);
                return itemStack2;
            }
        }
        return itemStack;
    }
}

