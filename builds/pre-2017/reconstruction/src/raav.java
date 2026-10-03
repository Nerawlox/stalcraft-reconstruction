/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class raav
extends Item {
    public raav(int n) {
        super(n);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public boolean hasEffect(ItemStack itemStack) {
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (!entityPlayer.capabilities._d) {
            --itemStack._b;
        }
        world.playSoundAtEntity(entityPlayer, "random.bow", 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
        if (!world.isRemote) {
            world.spawnEntityInWorld(new EntityExpBottle(world, entityPlayer));
        }
        return itemStack;
    }
}

