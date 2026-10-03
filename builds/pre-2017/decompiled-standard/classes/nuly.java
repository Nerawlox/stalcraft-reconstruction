/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class nuly
extends zwat {
    private Map<String, String> _a;

    public nuly(Map<String, String> map) {
        this._a = map;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a.size());
        for (Map.Entry<String, String> entry : this._a.entrySet()) {
            dataOutput.writeUTF(entry.getKey());
            dataOutput.writeUTF(entry.getValue());
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = new HashMap<String, String>();
        int n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            this._a.put(dataInput.readUTF(), dataInput.readUTF());
        }
    }

    @Override
    public void processClient(boolean bl) {
        StalkerMiscMod._W.clear();
        StalkerMiscMod._W.putAll(this._a);
    }

    public nuly() {
    }
}

