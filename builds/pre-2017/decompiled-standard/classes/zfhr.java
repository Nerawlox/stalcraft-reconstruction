/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class zfhr
extends zwat {
    private List<qlqj> _a;

    public zfhr(Collection<qlqj> collection) {
        this._a = new ArrayList<qlqj>(collection);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a.size());
        for (qlqj qlqj2 : this._a) {
            qlqj2.write(dataOutput);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = new ArrayList<qlqj>();
        int n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            qlqj qlqj2 = new qlqj();
            qlqj2.read(dataInput);
            this._a.add(qlqj2);
        }
    }

    @Override
    public void processClient(boolean bl) {
        gloomyfolken.mods.party.zwat._a._a(this._a);
    }

    public zfhr() {
    }
}

