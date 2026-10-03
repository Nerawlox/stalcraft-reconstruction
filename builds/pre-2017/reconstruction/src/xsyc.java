/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.Packet30Entity;

public class xsyc
extends Packet30Entity {
    public xsyc() {
        this._g = true;
    }

    public xsyc(int n, byte by, byte by2, byte by3, byte by4, byte by5) {
        super(n);
        this._b = by;
        this._c = by2;
        this._d = by3;
        this._e = by4;
        this._f = by5;
        this._g = true;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        super.readPacketData(dataInput);
        this._b = dataInput.readByte();
        this._c = dataInput.readByte();
        this._d = dataInput.readByte();
        this._e = dataInput.readByte();
        this._f = dataInput.readByte();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        super.writePacketData(dataOutput);
        dataOutput.writeByte(this._b);
        dataOutput.writeByte(this._c);
        dataOutput.writeByte(this._d);
        dataOutput.writeByte(this._e);
        dataOutput.writeByte(this._f);
    }

    @Override
    public int getPacketSize() {
        return 9;
    }
}

