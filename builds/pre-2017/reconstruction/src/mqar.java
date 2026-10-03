/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.UUID;

public class mqar
implements ctih {
    public UUID _a;
    public String _b;
    public UUID _c;
    public String _d;
    public String _e;
    public int _f;
    public int _g;

    public mqar() {
    }

    public mqar(UUID uUID, String string, UUID uUID2, String string2, String string3, int n, int n2) {
        this._a = uUID;
        this._b = string;
        this._c = uUID2;
        this._d = string2;
        this._e = string3;
        this._f = n;
        this._g = n2;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this._a.getMostSignificantBits());
        dataOutput.writeLong(this._a.getLeastSignificantBits());
        dataOutput.writeUTF(this._b);
        dataOutput.writeLong(this._c.getMostSignificantBits());
        dataOutput.writeLong(this._c.getLeastSignificantBits());
        dataOutput.writeUTF(this._d);
        dataOutput.writeUTF(this._e);
        dataOutput.writeInt(this._f);
        dataOutput.writeInt(this._g);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = new UUID(dataInput.readLong(), dataInput.readLong());
        this._b = dataInput.readUTF();
        this._c = new UUID(dataInput.readLong(), dataInput.readLong());
        this._d = dataInput.readUTF();
        this._e = dataInput.readUTF();
        this._f = dataInput.readInt();
        this._g = dataInput.readInt();
    }
}

