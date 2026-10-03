/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class piev
extends zwat {
    private Map<String, Long> _a;
    private List<String> _b;

    public piev(Map<String, Long> map, List<String> list) {
        this._a = new HashMap<String, Long>();
        this._b = new ArrayList<String>();
        this._a = map;
        this._b = list;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        piev.writeStringList(this._b, dataOutput);
        dataOutput.writeInt(this._a.size());
        for (Map.Entry<String, Long> entry : this._a.entrySet()) {
            dataOutput.writeUTF(entry.getKey());
            dataOutput.writeLong(entry.getValue());
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._b = piev.readStringList(dataInput);
        this._a = new HashMap<String, Long>();
        int n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            this._a.put(dataInput.readUTF(), dataInput.readLong());
        }
    }

    public piev() {
    }
}

