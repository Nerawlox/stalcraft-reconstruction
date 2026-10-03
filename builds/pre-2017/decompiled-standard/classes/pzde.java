/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.qlgf;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public abstract class pzde
extends qlgf {
    public String _a;
    public turb _b;
    protected boolean _c;

    public pzde(turb turb2) {
        this._c = false;
        this._b = turb2;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeBoolean(this._c);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._c = dataInput.readBoolean();
    }

    public boolean _a() {
        return this._c;
    }

    public boolean _b() {
        return this._b._a(this);
    }

    protected void _c() {
        if (!this._c && this._b()) {
            this._d();
        }
    }

    public void _d() {
        this._c = true;
        InvokeSideOnly.frontend(() -> {});
    }

    public pzde() {
    }
}

