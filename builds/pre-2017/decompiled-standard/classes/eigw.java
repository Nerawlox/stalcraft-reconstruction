/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class eigw
extends tuuw {
    public String _a;
    public owak _b;

    public eigw(String string, owak owak2) {
        this._a = string;
        this._b = owak2;
    }

    public eigw() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._a = dataInput.readUTF();
        this._b = owak.values()[dataInput.readInt()];
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeUTF(this._a);
        dataOutput.writeInt(this._b.ordinal());
    }
}

