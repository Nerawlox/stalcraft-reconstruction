/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import java.time.Instant;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class hbio
extends TileEntityChest {
    private int _m = 27;
    private satl _n;
    private Instant _o = null;
    private boolean _p = false;
    private int _q = 0;

    public hbio() {
    }

    public hbio(uyqj uyqj2) {
        this._n = uyqj2._a();
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        this._p = nBTTagCompound._o("EnableLoot") || nBTTagCompound._c("LootId");
        this._o = nBTTagCompound._c("NextLoot") ? Instant.ofEpochMilli(nBTTagCompound._g("NextLoot")) : null;
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        nBTTagCompound._a("EnableLoot", this._p);
        if (this._o != null) {
            nBTTagCompound._a("NextLoot", this._o.toEpochMilli());
        }
    }

    private String _d() {
        Block block = this.getBlockType();
        if (block instanceof uyqj) {
            return ((uyqj)block)._i;
        }
        return "";
    }

    private String _e() {
        Block block = this.getBlockType();
        if (block instanceof uyqj) {
            return ((uyqj)block)._j;
        }
        return "";
    }

    @Override
    public void updateEntity() {
        InvokeSideOnly.frontend(!this.worldObj.isRemote, () -> {});
    }

    public boolean _a() {
        return this._p;
    }

    public void _a(boolean bl) {
        this._p = bl;
    }

    private void _a(ItemStack itemStack, double d) {
        int n = itemStack._k();
        if (n > 0) {
            int n2 = (int)((double)n * (1.0 - d) * (double)this.worldObj.rand.nextFloat());
            if (itemStack._a() instanceof culm) {
                ((culm)((Object)itemStack._a()))._b(itemStack, n2);
            }
            itemStack._f = n2;
        }
    }

    private satl _f() {
        Block block;
        if (this._n == null && (block = this.getBlockType()) instanceof uyqj) {
            this._n = ((uyqj)block)._a();
        }
        return this._n;
    }

    @Override
    public void openChest() {
        super.openChest();
        if (!this.worldObj.isRemote) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    @Override
    public void closeChest() {
        super.closeChest();
        if (!this.worldObj.isRemote) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    @Override
    public boolean canUpdate() {
        return GloomyCore.side.isServer();
    }

    @Override
    public int getSizeInventory() {
        return this._m;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public AxisAlignedBB getRenderBoundingBox() {
        Block block = this.getBlockType();
        if (block == null) {
            return TileEntity.INFINITE_EXTENT_AABB;
        }
        return AxisAlignedBB._a()._a((double)this.xCoord + block.minX - 4.0, (double)this.yCoord + block.minY - 4.0, (double)this.zCoord + block.minZ - 4.0, (double)this.xCoord + block.maxX + 5.0, (double)this.yCoord + block.maxY + 5.0, (double)this.zCoord + block.maxZ + 5.0);
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        this.writeToNBT(nBTTagCompound);
        return new wpte(this.xCoord, this.yCoord, this.zCoord, 1, nBTTagCompound);
    }

    @Override
    public void onDataPacket(jjpj jjpj2, wpte wpte2) {
        this.readFromNBT(wpte2._e);
    }

    @Override
    public void setWorldObj(World world) {
        super.setWorldObj(world);
        InvokeSideOnly.frontend(!world.isRemote, () -> {});
    }

    @Override
    public void validate() {
        super.validate();
        if (!this.worldObj.isRemote) {
            InvokeSideOnly.frontend(() -> {});
        }
    }
}

