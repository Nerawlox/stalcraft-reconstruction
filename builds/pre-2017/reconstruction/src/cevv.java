/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class cevv
extends nvwc {
    public cevv(int n) {
        super(n);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        ItemStack itemStack2 = new ItemStack(Item.map, 1, world.getUniqueDataId("map"));
        String string = "map_" + itemStack2._j();
        thdd thdd2 = new thdd(string);
        world.setItemData(string, thdd2);
        thdd2._d = 0;
        int n = 128 * (1 << thdd2._d);
        thdd2._a = (int)(Math.round(entityPlayer.posX / (double)n) * (long)n);
        thdd2._b = (int)(Math.round(entityPlayer.posZ / (double)n) * (long)n);
        thdd2._c = (byte)world.provider._i;
        thdd2.markDirty();
        --itemStack._b;
        if (itemStack._b <= 0) {
            return itemStack2;
        }
        if (!entityPlayer.inventory._c(itemStack2._l())) {
            entityPlayer.dropPlayerItem(itemStack2);
        }
        return itemStack;
    }
}

