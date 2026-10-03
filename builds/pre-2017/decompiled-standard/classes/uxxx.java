/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class uxxx
extends zwat {
    public String _a;
    public int _b;
    public qoac _c;

    public uxxx(String string, ezfc.kjui kjui2, qoac qoac2) {
        this._a = string;
        this._b = kjui2.ordinal();
        this._c = qoac2;
    }

    public uxxx() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = dataInput.readInt();
        this._c = qlgf.readNBTTagCompound(dataInput);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeInt(this._b);
        qlgf.writeNBTTagCompound(this._c, dataOutput);
    }
}

