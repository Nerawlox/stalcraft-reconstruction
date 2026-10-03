/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.client.Minecraft;

public class hbzg
extends zwat {
    private Set<Integer> _a;

    public hbzg(magc magc2) {
        this._a = magc2._a();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a.size());
        for (int n : this._a) {
            dataOutput.writeInt(n);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        int n = dataInput.readInt();
        this._a = new HashSet<Integer>(n);
        for (int i = 0; i < n; ++i) {
            this._a.add(dataInput.readInt());
        }
    }

    @Override
    public void processClient(boolean bl) {
        magc._a(Minecraft._E()._t)._a(this._a);
    }

    public hbzg() {
    }
}

