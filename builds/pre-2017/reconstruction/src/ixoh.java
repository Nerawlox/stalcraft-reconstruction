/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.Packet30Entity;

public class ixoh
extends Packet30Entity {
    public ixoh() {
        this._g = true;
    }

    public ixoh(int n, byte by, byte by2) {
        super(n);
        this._e = by;
        this._f = by2;
        this._g = true;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        super.readPacketData(dataInput);
        this._e = dataInput.readByte();
        this._f = dataInput.readByte();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        super.writePacketData(dataOutput);
        dataOutput.writeByte(this._e);
        dataOutput.writeByte(this._f);
    }

    @Override
    public int getPacketSize() {
        return 6;
    }
}

