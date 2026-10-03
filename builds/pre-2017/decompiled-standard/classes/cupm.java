/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class cupm
extends vlfg {
    public String _e;
    public oxoq _f;

    public cupm() {
    }

    public cupm(ndni ndni2, rpzz rpzz2, int n, String string, oxoq oxoq2) {
        super(ndni2, rpzz2, n);
        this._e = string;
        this._f = oxoq2;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeUTF(this._e);
        if (this._f != null) {
            dataOutput.writeBoolean(true);
            this._a(this._f, dataOutput);
        } else {
            dataOutput.writeBoolean(false);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._e = dataInput.readUTF();
        if (dataInput.readBoolean()) {
            this._f = (oxoq)this._a(dataInput);
        }
    }
}

