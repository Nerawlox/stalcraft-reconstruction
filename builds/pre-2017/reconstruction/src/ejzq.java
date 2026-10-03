/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.BlockDispenser;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.owak;
import net.minecraft.world.World;

public class ejzq
extends BlockDispenser {
    public final vmgb _f = new bbmo();

    public ejzq(int n) {
        super(n);
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b("furnace_side");
        this._c = iconRegister._b("furnace_top");
        this._d = iconRegister._b(this.getTextureName() + "_front_horizontal");
        this._e = iconRegister._b(this.getTextureName() + "_front_vertical");
    }

    @Override
    public vmgb _a(ItemStack itemStack) {
        return this._f;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new hdtl();
    }

    @Override
    public void _b(World world, int n, int n2, int n3) {
        rqep rqep2 = new rqep(world, n, n2, n3);
        TileEntityDispenser tileEntityDispenser = (TileEntityDispenser)rqep2._i();
        if (tileEntityDispenser == null) {
            return;
        }
        int n4 = tileEntityDispenser._a();
        if (n4 < 0) {
            world.playAuxSFX(1001, n, n2, n3, 0);
        } else {
            ItemStack itemStack;
            ItemStack itemStack2 = tileEntityDispenser.getStackInSlot(n4);
            int n5 = world.getBlockMetadata(n, n2, n3) & 7;
            IInventory iInventory = TileEntityHopper._b(world, n + owak._b[n5], (double)(n2 + owak._c[n5]), (double)(n3 + owak._d[n5]));
            if (iInventory != null) {
                itemStack = TileEntityHopper._a(iInventory, itemStack2._l()._a(1), owak._a[n5]);
                if (itemStack == null) {
                    itemStack = itemStack2._l();
                    if (--itemStack._b == 0) {
                        itemStack = null;
                    }
                } else {
                    itemStack = itemStack2._l();
                }
            } else {
                itemStack = this._f._a(rqep2, itemStack2);
                if (itemStack != null && itemStack._b == 0) {
                    itemStack = null;
                }
            }
            tileEntityDispenser.setInventorySlotContents(n4, itemStack);
        }
    }
}

