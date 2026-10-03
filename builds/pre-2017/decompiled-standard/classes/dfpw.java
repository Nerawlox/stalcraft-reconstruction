/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class dfpw
extends zwat {
    public int _a;

    public dfpw(int n) {
        this._a = n;
    }

    @Override
    public void processClient(boolean bl) {
        if (!jysc._d("teleport")) {
            jysc._c(new uyar(this._a));
        }
    }

    public dfpw() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
    }
}

