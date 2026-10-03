/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.TileEntity;

public class oxif
extends TileEntity {
    public int _a;

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        nBTTagCompound._a("cooldown", this._a);
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        this._a = nBTTagCompound._f("cooldown");
    }

    @Override
    public void updateEntity() {
        if (this._a > 0) {
            --this._a;
        }
    }

    @Override
    public boolean canUpdate() {
        return FMLCommonHandler.instance().getEffectiveSide().isServer();
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
}

