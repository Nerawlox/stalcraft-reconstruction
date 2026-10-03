/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class pzms
extends zwat {
    public List<dfiq> _a;

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a.size());
        for (dfiq dfiq2 : this._a) {
            dfiq2.write(dataOutput);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        int n = dataInput.readInt();
        this._a = new ArrayList<dfiq>(n);
        for (int i = 0; i < n; ++i) {
            dfiq dfiq2 = new dfiq();
            dfiq2.read(dataInput);
            this._a.add(dfiq2);
        }
    }
}

