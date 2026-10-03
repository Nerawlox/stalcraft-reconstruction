/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockRailBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ujjf
extends Item {
    public static final vmgb _a = new ixgp();
    public int _b;

    public ujjf(int n, int n2) {
        super(n);
        this.maxStackSize = 1;
        this._b = n2;
        this.setCreativeTab(CreativeTabs.tabTransport);
        BlockDispenser._a._a(this, _a);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        int n5 = world.getBlockId(n, n2, n3);
        if (BlockRailBase._a(n5)) {
            if (!world.isRemote) {
                EntityMinecart entityMinecart = EntityMinecart.createMinecart(world, (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, this._b);
                if (itemStack._u()) {
                    entityMinecart.setMinecartName(itemStack._s());
                }
                world.spawnEntityInWorld(entityMinecart);
            }
            --itemStack._b;
            return true;
        }
        return false;
    }
}

