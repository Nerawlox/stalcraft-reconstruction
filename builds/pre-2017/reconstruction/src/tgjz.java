/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.Packet10Flying;

public class tgjz
extends Packet10Flying {
    public tgjz() {
        this._h = true;
    }

    public tgjz(double d, double d2, double d3, double d4, boolean bl) {
        this._a = d;
        this._b = d2;
        this._d = d3;
        this._c = d4;
        this._g = bl;
        this._h = true;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readDouble();
        this._b = dataInput.readDouble();
        this._d = dataInput.readDouble();
        this._c = dataInput.readDouble();
        super.readPacketData(dataInput);
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeDouble(this._a);
        dataOutput.writeDouble(this._b);
        dataOutput.writeDouble(this._d);
        dataOutput.writeDouble(this._c);
        super.writePacketData(dataOutput);
    }

    @Override
    public int getPacketSize() {
        return 33;
    }
}

