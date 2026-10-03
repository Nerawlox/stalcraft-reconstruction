/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class kjwj
extends pzde {
    private int _d;

    public kjwj(turb turb2) {
        super(turb2);
        this._d = 0;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeInt(this._d);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._d = dataInput.readInt();
    }

    public int _e() {
        if (this._a()) {
            return this._d;
        }
        ++this._d;
        this._c();
        return this._d;
    }

    public int _f() {
        return this._d;
    }

    public int _a(int n) {
        if (this._a()) {
            return this._d;
        }
        this._d += n;
        this._d = Math.min(this._d, ((srok)this._b)._e);
        this._c();
        return this._d;
    }

    public void _b(int n) {
        this._d = Math.min(n, ((srok)this._b)._e);
    }

    public kjwj() {
    }
}

