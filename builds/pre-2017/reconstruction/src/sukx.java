/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.Packet30Entity;

public class sukx
extends Packet30Entity {
    public sukx() {
    }

    public sukx(int n, byte by, byte by2, byte by3) {
        super(n);
        this._b = by;
        this._c = by2;
        this._d = by3;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        super.readPacketData(dataInput);
        this._b = dataInput.readByte();
        this._c = dataInput.readByte();
        this._d = dataInput.readByte();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        super.writePacketData(dataOutput);
        dataOutput.writeByte(this._b);
        dataOutput.writeByte(this._c);
        dataOutput.writeByte(this._d);
    }

    @Override
    public int getPacketSize() {
        return 7;
    }
}

