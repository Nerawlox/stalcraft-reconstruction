/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class iurq
extends zwat {
    public String _a;
    public wnce[] _b;

    public iurq(String string, wnce ... wnceArray) {
        this._a = string;
        this._b = wnceArray;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeInt(this._b.length);
        for (wnce wnce2 : this._b) {
            iurq.writeItemStackData(wnce2, dataOutput);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = new wnce[dataInput.readInt()];
        for (int i = 0; i < this._b.length; ++i) {
            this._b[i] = iurq.readItemStackData(dataInput);
        }
    }

    public iurq() {
    }
}

