/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class dyzi
extends Item {
    public dyzi(int n) {
        super(n);
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer entityPlayer, EntityLivingBase entityLivingBase) {
        if (!itemStack._u()) {
            return false;
        }
        if (entityLivingBase instanceof EntityLiving) {
            EntityLiving entityLiving = (EntityLiving)entityLivingBase;
            entityLiving.setCustomNameTag(itemStack._s());
            entityLiving.func_110163_bv();
            --itemStack._b;
            return true;
        }
        return super.itemInteractionForEntity(itemStack, entityPlayer, entityLivingBase);
    }
}

