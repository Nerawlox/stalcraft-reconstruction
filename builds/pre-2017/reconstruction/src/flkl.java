/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.IOException;
import java.util.HashMap;

public class flkl
extends zwat {
    public HashMap<String, owak> _a;

    @Override
    @ezey(_a={eidj.CLIENT})
    public void read(DataInput dataInput) throws IOException {
        int n = dataInput.readInt();
        this._a = new HashMap(n);
        for (int i = 0; i < n; ++i) {
            this._a.put(dataInput.readUTF(), owak.values()[dataInput.readByte()]);
        }
    }

    @Override
    public void processClient(boolean bl) {
        yuch._a._a(this._a);
    }
}

