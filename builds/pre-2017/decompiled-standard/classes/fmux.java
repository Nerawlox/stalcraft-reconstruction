/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;

public class fmux
extends zwat {
    private String _a;

    public fmux(String string) {
        this._a = string;
    }

    @Override
    public void processClient(boolean bl) {
        xpzm._E()._a(new cdew(this._a));
    }

    public fmux() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
    }
}

