/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityBeacon
extends TileEntity
implements IInventory {
    public static final Potion[][] _a = new Potion[][]{{Potion._c, Potion._e}, {Potion._m, Potion._j}, {Potion._g}, {Potion._l}};
    @SideOnly(value=Side.CLIENT)
    public long _b;
    @SideOnly(value=Side.CLIENT)
    public float _c;
    public boolean _d;
    public int _e = -1;
    public int _f;
    public int _g;
    public ItemStack _h;
    public String _i;

    @Override
    public void updateEntity() {
        if (this.worldObj.getTotalWorldTime() % 80L == 0L) {
            this._b();
            this._a();
        }
    }

    public void _a() {
        if (this._d && this._e > 0 && !this.worldObj.isRemote && this._f > 0) {
            double d = this._e * 10 + 10;
            int n = 0;
            if (this._e >= 4 && this._f == this._g) {
                n = 1;
            }
            AxisAlignedBB axisAlignedBB = AxisAlignedBB._a()._a(this.xCoord, this.yCoord, this.zCoord, this.xCoord + 1, this.yCoord + 1, this.zCoord + 1)._b(d, d, d);
            axisAlignedBB._f = this.worldObj.getHeight();
            List list = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, axisAlignedBB);
            for (EntityPlayer entityPlayer : list) {
                entityPlayer.addPotionEffect(new PotionEffect(this._f, 180, n, true));
            }
            if (this._e >= 4 && this._f != this._g && this._g > 0) {
                for (EntityPlayer entityPlayer : list) {
                    entityPlayer.addPotionEffect(new PotionEffect(this._g, 180, 0, true));
                }
            }
        }
    }

    public void _b() {
        if (!this.worldObj.canBlockSeeTheSky(this.xCoord, this.yCoord + 1, this.zCoord)) {
            this._d = false;
            this._e = 0;
        } else {
            int n;
            this._d = true;
            this._e = 0;
            int n2 = 1;
            while (n2 <= 4 && (n = this.yCoord - n2) >= 0) {
                boolean bl = true;
                block1: for (int i = this.xCoord - n2; i <= this.xCoord + n2 && bl; ++i) {
                    for (int j = this.zCoord - n2; j <= this.zCoord + n2; ++j) {
                        int n3 = this.worldObj.getBlockId(i, n, j);
                        Block block = Block.blocksList[n3];
                        if (block != null && block.isBeaconBase(this.worldObj, i, n, j, this.xCoord, this.yCoord, this.zCoord)) continue;
                        bl = false;
                        continue block1;
                    }
                }
                if (!bl) break;
                this._e = n2++;
            }
            if (this._e == 0) {
                this._d = false;
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public float _c() {
        if (!this._d) {
            return 0.0f;
        }
        int n = (int)(this.worldObj.getTotalWorldTime() - this._b);
        this._b = this.worldObj.getTotalWorldTime();
        if (n > 1) {
            this._c -= (float)n / 40.0f;
            if (this._c < 0.0f) {
                this._c = 0.0f;
            }
        }
        this._c += 0.025f;
        if (this._c > 1.0f) {
            this._c = 1.0f;
        }
        return this._c;
    }

    public int _d() {
        return this._f;
    }

    public int _e() {
        return this._g;
    }

    public int _f() {
        return this._e;
    }

    @SideOnly(value=Side.CLIENT)
    public void _a(int n) {
        this._e = n;
    }

    public void _b(int n) {
        this._f = 0;
        for (int i = 0; i < this._e && i < 3; ++i) {
            for (Potion potion : _a[i]) {
                if (potion._H != n) continue;
                this._f = n;
                return;
            }
        }
    }

    public void _c(int n) {
        this._g = 0;
        if (this._e >= 4) {
            for (int i = 0; i < 4; ++i) {
                for (Potion potion : _a[i]) {
                    if (potion._H != n) continue;
                    this._g = n;
                    return;
                }
            }
        }
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        this.writeToNBT(nBTTagCompound);
        return new wpte(this.xCoord, this.yCoord, this.zCoord, 3, nBTTagCompound);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public double getMaxRenderDistanceSquared() {
        return 65536.0;
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        this._f = nBTTagCompound._f("Primary");
        this._g = nBTTagCompound._f("Secondary");
        this._e = nBTTagCompound._f("Levels");
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        nBTTagCompound._a("Primary", this._f);
        nBTTagCompound._a("Secondary", this._g);
        nBTTagCompound._a("Levels", this._e);
    }

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return n == 0 ? this._h : null;
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        if (n == 0 && this._h != null) {
            if (n2 >= this._h._b) {
                ItemStack itemStack = this._h;
                this._h = null;
                return itemStack;
            }
            this._h._b -= n2;
            return new ItemStack(this._h._d, n2, this._h._j());
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        if (n == 0 && this._h != null) {
            ItemStack itemStack = this._h;
            this._h = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        if (n == 0) {
            this._h = itemStack;
        }
    }

    @Override
    public String getInvName() {
        return this.isInvNameLocalized() ? this._i : "container.beacon";
    }

    @Override
    public boolean isInvNameLocalized() {
        return this._i != null && this._i.length() > 0;
    }

    public void _a(String string) {
        this._i = string;
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityPlayer.getDistanceSq((double)this.xCoord + 0.5, (double)this.yCoord + 0.5, (double)this.zCoord + 0.5) <= 64.0;
    }

    @Override
    public void openChest() {
    }

    @Override
    public void closeChest() {
    }

    @Override
    public boolean isItemValidForSlot(int n, ItemStack itemStack) {
        return itemStack._d == Item.emerald.itemID || itemStack._d == Item.diamond.itemID || itemStack._d == Item.ingotGold.itemID || itemStack._d == Item.ingotIron.itemID;
    }
}

