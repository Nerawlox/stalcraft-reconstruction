/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class cewa
extends Item {
    public cewa(int n) {
        super(n);
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (!entityPlayer.capabilities._d) {
            --itemStack._b;
        }
        if (!world.isRemote) {
            entityPlayer.curePotionEffects(itemStack);
        }
        return itemStack._b <= 0 ? new ItemStack(Item.bucketEmpty) : itemStack;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemStack) {
        return 32;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemStack) {
        return EnumAction._c;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        return itemStack;
    }
}

