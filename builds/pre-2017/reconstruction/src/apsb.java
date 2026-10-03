/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class apsb
extends Item {
    public apsb(int n) {
        super(n);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (world.isRemote) {
            return true;
        }
        if (n4 == 0) {
            --n2;
        }
        if (n4 == 1) {
            ++n2;
        }
        if (n4 == 2) {
            --n3;
        }
        if (n4 == 3) {
            ++n3;
        }
        if (n4 == 4) {
            --n;
        }
        if (n4 == 5) {
            ++n;
        }
        if (!entityPlayer.canPlayerEdit(n, n2, n3, n4, itemStack)) {
            return false;
        }
        int n5 = world.getBlockId(n, n2, n3);
        if (n5 == 0) {
            world.playSoundEffect((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "fire.ignite", 1.0f, itemRand.nextFloat() * 0.4f + 0.8f);
            world.setBlock(n, n2, n3, Block.fire.blockID);
        }
        if (!entityPlayer.capabilities._d) {
            --itemStack._b;
        }
        return true;
    }
}

