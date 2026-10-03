/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;

public class xtcq
extends TileEntity {
    public final MobSpawnerBaseLogic _a = new zzis(this);

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        this._a._a(nBTTagCompound);
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        this._a._b(nBTTagCompound);
    }

    @Override
    public void updateEntity() {
        this._a._g();
        super.updateEntity();
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        this.writeToNBT(nBTTagCompound);
        nBTTagCompound._p("SpawnPotentials");
        return new wpte(this.xCoord, this.yCoord, this.zCoord, 1, nBTTagCompound);
    }

    @Override
    public boolean receiveClientEvent(int n, int n2) {
        if (this._a._b(n)) {
            return true;
        }
        return super.receiveClientEvent(n, n2);
    }

    public MobSpawnerBaseLogic _a() {
        return this._a;
    }
}

