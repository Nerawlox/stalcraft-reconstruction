/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class uiag
extends zwat {
    private List<Integer> _a;

    public uiag(List<Integer> list) {
        this._a = list;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a.size());
        for (Integer n : this._a) {
            dataOutput.writeInt(n);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        int n = dataInput.readInt();
        this._a = new ArrayList<Integer>(n);
        for (int i = 0; i < n; ++i) {
            this._a.add(dataInput.readInt());
        }
    }

    public uiag() {
    }
}

