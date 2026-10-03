/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class mqbb
extends tuuw {
    public int _a;
    public int _b;

    @ezey(_a={eidj.CLIENT})
    public mqbb(int n, int n2) {
        this._a = n;
        this._b = n2;
    }

    public mqbb() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
    }
}

