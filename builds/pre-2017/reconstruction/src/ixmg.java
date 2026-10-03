/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.Packet10Flying;

public class ixmg
extends Packet10Flying {
    public ixmg() {
        this._i = true;
    }

    public ixmg(float f, float f2, boolean bl) {
        this._e = f;
        this._f = f2;
        this._g = bl;
        this._i = true;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._e = dataInput.readFloat();
        this._f = dataInput.readFloat();
        super.readPacketData(dataInput);
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeFloat(this._e);
        dataOutput.writeFloat(this._f);
        super.writePacketData(dataOutput);
    }

    @Override
    public int getPacketSize() {
        return 9;
    }
}

