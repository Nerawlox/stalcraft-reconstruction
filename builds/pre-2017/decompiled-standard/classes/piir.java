/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class piir
extends owha {
    public vjsq _a;

    public piir(String string, vjsq vjsq2) {
        super(string);
        this._a = vjsq2;
    }

    public piir() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._a = vjsq.values()[dataInput.readInt()];
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeInt(this._a.ordinal());
    }
}

