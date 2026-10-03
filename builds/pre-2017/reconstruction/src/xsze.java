/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.util.List;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.sajh;

public class xsze
extends Packet {
    public int _a;
    public String _b;
    public int _c;
    public int _d;
    public int _e;
    public byte _f;
    public byte _g;
    public int _h;
    public DataWatcher _i;
    public List _j;

    public xsze() {
    }

    public xsze(EntityPlayer entityPlayer) {
        this._a = entityPlayer.entityId;
        this._b = entityPlayer.getCommandSenderName();
        this._c = sajh._c(entityPlayer.posX * 32.0);
        this._d = sajh._c(entityPlayer.posY * 32.0);
        this._e = sajh._c(entityPlayer.posZ * 32.0);
        this._f = (byte)(entityPlayer.rotationYaw * 256.0f / 360.0f);
        this._g = (byte)(entityPlayer.rotationPitch * 256.0f / 360.0f);
        ItemStack itemStack = entityPlayer.inventory._a();
        this._h = itemStack == null ? 0 : itemStack._d;
        this._i = entityPlayer.getDataWatcher();
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = xsze.readString(dataInput, 16);
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readInt();
        this._f = dataInput.readByte();
        this._g = dataInput.readByte();
        this._h = dataInput.readShort();
        this._j = DataWatcher._a(dataInput);
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        xsze.writeString(this._b, dataOutput);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.writeInt(this._e);
        dataOutput.writeByte(this._f);
        dataOutput.writeByte(this._g);
        dataOutput.writeShort(this._h);
        this._i._a(dataOutput);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleNamedEntitySpawn(this);
    }

    @Override
    public int getPacketSize() {
        return 28;
    }

    public List _a() {
        if (this._j == null) {
            this._j = this._i._c();
        }
        return this._j;
    }
}

