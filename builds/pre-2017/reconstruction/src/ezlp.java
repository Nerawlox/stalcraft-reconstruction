/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ezlp
extends tuuw {
    public int[] _a;

    @ezey(_a={eidj.CLIENT})
    public ezlp(srli srli2) {
        this._a = new int[srli2._a().size()];
        int n = 0;
        for (srli.kjui kjui2 : srli2._a().values()) {
            this._a[n++] = kjui2._b();
        }
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeShort(this._a.length);
        for (int i = 0; i < this._a.length; ++i) {
            dataOutput.writeInt(this._a[i]);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = new int[dataInput.readShort()];
        for (int i = 0; i < this._a.length; ++i) {
            this._a[i] = dataInput.readInt();
        }
    }

    public ezlp() {
    }
}

