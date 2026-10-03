/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class cvvn
extends Slot {
    public final /* synthetic */ World _a;
    public final /* synthetic */ int _b;
    public final /* synthetic */ int _c;
    public final /* synthetic */ int _d;
    public final /* synthetic */ ContainerRepair _e;

    public cvvn(ContainerRepair containerRepair, IInventory iInventory, int n, int n2, int n3, World world, int n4, int n5, int n6) {
        this._e = containerRepair;
        this._a = world;
        this._b = n4;
        this._c = n5;
        this._d = n6;
        super(iInventory, n, n2, n3);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return false;
    }

    @Override
    public boolean canTakeStack(EntityPlayer entityPlayer) {
        return (entityPlayer.capabilities._d || entityPlayer.experienceLevel >= this._e._g) && this._e._g > 0 && this.getHasStack();
    }

    @Override
    public void onPickupFromSlot(EntityPlayer entityPlayer, ItemStack itemStack) {
        if (!entityPlayer.capabilities._d) {
            entityPlayer.addExperienceLevel(-this._e._g);
        }
        ContainerRepair._a(this._e).setInventorySlotContents(0, null);
        if (ContainerRepair._b(this._e) > 0) {
            ItemStack itemStack2 = ContainerRepair._a(this._e).getStackInSlot(1);
            if (itemStack2 != null && itemStack2._b > ContainerRepair._b(this._e)) {
                itemStack2._b -= ContainerRepair._b(this._e);
                ContainerRepair._a(this._e).setInventorySlotContents(1, itemStack2);
            } else {
                ContainerRepair._a(this._e).setInventorySlotContents(1, null);
            }
        } else {
            ContainerRepair._a(this._e).setInventorySlotContents(1, null);
        }
        this._e._g = 0;
        if (!entityPlayer.capabilities._d && !this._a.isRemote && this._a.getBlockId(this._b, this._c, this._d) == Block.anvil.blockID && entityPlayer.getRNG().nextFloat() < 0.12f) {
            int n = this._a.getBlockMetadata(this._b, this._c, this._d);
            int n2 = n & 3;
            int n3 = n >> 2;
            if (++n3 > 2) {
                this._a.setBlockToAir(this._b, this._c, this._d);
                this._a.playAuxSFX(1020, this._b, this._c, this._d, 0);
            } else {
                this._a.func_72921_c(this._b, this._c, this._d, n2 | n3 << 2, 2);
                this._a.playAuxSFX(1021, this._b, this._c, this._d, 0);
            }
        } else if (!this._a.isRemote) {
            this._a.playAuxSFX(1021, this._b, this._c, this._d, 0);
        }
    }
}

