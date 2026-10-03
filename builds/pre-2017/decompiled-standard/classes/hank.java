/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class hank
extends pzde {
    private boolean _d;

    public hank(turb turb2) {
        super(turb2);
        this._d = false;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeBoolean(this._d);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._d = dataInput.readBoolean();
    }

    public void _e() {
        if (this._a()) {
            return;
        }
        this._d = true;
        this._c();
    }

    public boolean _f() {
        return this._d;
    }

    public hank() {
    }
}

