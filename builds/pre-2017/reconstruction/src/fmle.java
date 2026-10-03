/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.stalker.respawn.jxtc;
import java.lang.invoke.LambdaMetafactory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;

public class fmle
extends jxtc
implements IInventory {
    @ezey(_a={eidj.CLIENT})
    public String _a;
    @ezey(_a={eidj.CLIENT})
    public String _b;
    @ezey(_a={eidj.CLIENT})
    public int _c;
    @ezey(_a={eidj.CLIENT})
    public int _d;
    @ezey(_a={eidj.CLIENT})
    public int _e;
    @ezey(_a={eidj.CLIENT})
    public int _f;
    @ezey(_a={eidj.CLIENT})
    public int _g;
    @ezey(_a={eidj.CLIENT})
    public int _h;
    @ezey(_a={eidj.CLIENT})
    public boolean _i;
    public final xqsf _j = new xqsf("\u0421\u043a\u043b\u0430\u0434 \u0431\u0430\u0437\u044b", "Items");
    private einh _p;
    private int _q = -1;

    @Override
    public void updateEntity() {
        super.updateEntity();
        if (this.worldObj != null && !this.worldObj.isRemote) {
            InvokeSideOnly.frontend((InvokeSideOnly.InvokeFrontendOnly)LambdaMetafactory.metafactory(null, null, null, ()V, serverUpdate(), ()V)((fmle)this));
        }
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        this._j._a(nBTTagCompound);
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        this._j._b(nBTTagCompound);
    }

    @ezey(_a={eidj.CLIENT})
    public void _a(String string, String string2, int n, int n2, int n3, int n4, int n5, int n6, boolean bl) {
        this._a = string;
        this._b = string2;
        this._c = n;
        this._d = n2;
        this._e = n3;
        this._f = n4;
        this._g = n5;
        this._h = n6;
        this._i = bl;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public AxisAlignedBB getRenderBoundingBox() {
        return AxisAlignedBB._a()._a(this._c - 1, this._d - 1, this._e - 1, this._f + 1, this._g + 50, this._h + 1);
    }

    @Override
    public int getSizeInventory() {
        return this._j.getSizeInventory();
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return this._j.getStackInSlot(n);
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        return this._j.decrStackSize(n, n2);
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        return this._j.getStackInSlotOnClosing(n);
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        this._j.setInventorySlotContents(n, itemStack);
    }

    @Override
    public String getInvName() {
        return this._j.getInvName();
    }

    @Override
    public boolean isInvNameLocalized() {
        return this._j.isInvNameLocalized();
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
    }

    @Override
    public void onInventoryChanged() {
        this._j.onInventoryChanged();
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return this._j.isUseableByPlayer(entityPlayer);
    }

    @Override
    public void openChest() {
        this._j.openChest();
    }

    @Override
    public void closeChest() {
        this._j.closeChest();
    }

    @Override
    public boolean isItemValidForSlot(int n, ItemStack itemStack) {
        return this._j.isItemValidForSlot(n, itemStack);
    }
}

