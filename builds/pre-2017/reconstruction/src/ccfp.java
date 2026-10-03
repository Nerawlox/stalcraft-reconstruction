/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.core.main.ClientProxy;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ccfp
extends zwat {
    public String _a;
    public int _b;
    public int _c;

    public ccfp(String string, int n, int n2) {
        this._a = string;
        this._c = n2;
        this._b = n;
    }

    @Override
    public void processClient(boolean bl) {
        ClientProxy.publishScreenCenterMessage(new ntsy(this._a, this._b, this._c));
    }

    public ccfp() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
    }
}

