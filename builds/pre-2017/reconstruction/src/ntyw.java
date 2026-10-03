/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.core.misc.sajz;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class ntyw
extends zwat {
    public NBTTagCompound _a;
    public int _b;
    public int _c;
    public int _d;
    public boolean _e;

    public ntyw() {
    }

    public ntyw(TileEntity tileEntity, boolean bl) {
        this._b = tileEntity.xCoord;
        this._c = tileEntity.yCoord;
        this._d = tileEntity.zCoord;
        this._e = bl;
        if (!bl) {
            this._a = new NBTTagCompound();
            tileEntity.writeToNBT(this._a);
        }
    }

    protected <T extends TileEntity> void _a(T t, EntityPlayer entityPlayer) {
        ((sajz)((Object)t)).applyEdit(this._a, entityPlayer);
        t.onInventoryChanged();
        entityPlayer.worldObj.markBlockForUpdate(this._b, this._c, this._d);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = qlgf.readNBTTagCompound(dataInput);
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readBoolean();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        qlgf.writeNBTTagCompound(this._a, dataOutput);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.writeBoolean(this._e);
    }
}

