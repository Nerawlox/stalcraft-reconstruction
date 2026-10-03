/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.tileentity;

import carpentersblocks.tileentity.CompatibilityHelper;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TECarpentersBlock
extends TileEntity {
    public short[] cover = new short[7];
    public byte[] pattern = new byte[7];
    public byte[] color = new byte[7];
    public byte[] overlay = new byte[7];
    public short data = 0;

    @Override
    public boolean canUpdate() {
        return false;
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        if (!nBTTagCompound._c("color")) {
            CompatibilityHelper.convertData(this, nBTTagCompound);
        } else {
            for (int i = 0; i < 7; ++i) {
                this.cover[i] = nBTTagCompound._e("cover_" + i);
            }
            this.pattern = nBTTagCompound._k("pattern");
            this.color = nBTTagCompound._k("color");
            this.overlay = nBTTagCompound._k("overlay");
            this.data = nBTTagCompound._e("data");
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        for (int i = 0; i < 7; ++i) {
            nBTTagCompound._a("cover_" + i, this.cover[i]);
        }
        nBTTagCompound._a("pattern", this.pattern);
        nBTTagCompound._a("color", this.color);
        nBTTagCompound._a("overlay", this.overlay);
        nBTTagCompound._a("data", this.data);
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        this.writeToNBT(nBTTagCompound);
        return new wpte(this.xCoord, this.yCoord, this.zCoord, 1, nBTTagCompound);
    }

    public void writeToBytes(DataOutput dataOutput) throws IOException {
        boolean bl = this.hasCover();
        boolean bl2 = this.hasNonZeroByte(this.pattern);
        boolean bl3 = this.hasNonZeroByte(this.color);
        boolean bl4 = this.hasNonZeroByte(this.overlay);
        dataOutput.writeByte((bl ? 1 : 0) << 3 | (bl2 ? 1 : 0) << 2 | (bl3 ? 1 : 0) << 1 | (bl4 ? 1 : 0));
        if (bl) {
            for (short s : this.cover) {
                dataOutput.writeShort(s);
            }
        } else {
            dataOutput.writeShort(this.cover[this.cover.length - 1]);
        }
        if (bl2) {
            dataOutput.write(this.pattern);
        }
        if (bl3) {
            dataOutput.write(this.color);
        }
        if (bl4) {
            dataOutput.write(this.overlay);
        }
        dataOutput.writeShort(this.data);
    }

    public void readFromBytes(DataInput dataInput) throws IOException {
        boolean bl;
        byte by = dataInput.readByte();
        boolean bl2 = (by & 8) != 0;
        boolean bl3 = (by & 4) != 0;
        boolean bl4 = (by & 2) != 0;
        boolean bl5 = bl = (by & 1) != 0;
        if (bl2) {
            for (int i = 0; i < this.cover.length; ++i) {
                this.cover[i] = dataInput.readShort();
            }
        } else {
            this.cover[this.cover.length - 1] = dataInput.readShort();
        }
        if (bl3) {
            dataInput.readFully(this.pattern);
        }
        if (bl4) {
            dataInput.readFully(this.color);
        }
        if (bl) {
            dataInput.readFully(this.overlay);
        }
        this.data = dataInput.readShort();
    }

    private boolean hasNonZeroByte(byte[] byArray) {
        boolean bl = false;
        for (byte by : byArray) {
            if (by == 0) continue;
            bl = true;
        }
        return bl;
    }

    private boolean hasCover() {
        boolean bl = false;
        for (int i = 0; i < 6; ++i) {
            if (this.cover[i] == 0) continue;
            bl = true;
        }
        return bl;
    }

    @Override
    public void onDataPacket(jjpj jjpj2, wpte wpte2) {
        this.readFromNBT(wpte2._e);
        if (this.worldObj.isRemote) {
            Minecraft._E()._s._c(this.xCoord, this.yCoord, this.zCoord);
            this.worldObj.updateAllLightTypes(this.xCoord, this.yCoord, this.zCoord);
        }
    }

    public static TECarpentersBlock get(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        if (iBlockAccess instanceof zzie) {
            return TECarpentersBlock.get(((zzie)iBlockAccess)._e, n, n2, n3);
        }
        return TECarpentersBlock.get((World)iBlockAccess, n, n2, n3);
    }

    public static TECarpentersBlock get(World world, int n, int n2, int n3) {
        TileEntity tileEntity = world.getBlockTileEntity(n, n2, n3);
        if (tileEntity instanceof TECarpentersBlock) {
            return (TECarpentersBlock)tileEntity;
        }
        return null;
    }
}

