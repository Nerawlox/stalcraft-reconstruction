/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.Packet10Flying;

public class xszx
extends Packet10Flying {
    public xszx() {
        this._i = true;
        this._h = true;
    }

    public xszx(double d, double d2, double d3, double d4, float f, float f2, boolean bl) {
        this._a = d;
        this._b = d2;
        this._d = d3;
        this._c = d4;
        this._e = f;
        this._f = f2;
        this._g = bl;
        this._i = true;
        this._h = true;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readDouble();
        this._b = dataInput.readDouble();
        this._d = dataInput.readDouble();
        this._c = dataInput.readDouble();
        this._e = dataInput.readFloat();
        this._f = dataInput.readFloat();
        super.readPacketData(dataInput);
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeDouble(this._a);
        dataOutput.writeDouble(this._b);
        dataOutput.writeDouble(this._d);
        dataOutput.writeDouble(this._c);
        dataOutput.writeFloat(this._e);
        dataOutput.writeFloat(this._f);
        super.writePacketData(dataOutput);
    }

    @Override
    public int getPacketSize() {
        return 41;
    }
}

