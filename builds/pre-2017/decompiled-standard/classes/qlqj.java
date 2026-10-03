/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;
import javax.vecmath.Vector3f;

public class qlqj
extends qlgf {
    private int _a;
    private String _b;
    private Vector3f _c;
    private String _d;

    public qlqj() {
    }

    public qlqj(int n, String string, Vector3f vector3f, String string2) {
        this._a = n;
        this._b = string;
        this._c = vector3f;
        this._d = string2;
    }

    public int _a() {
        return this._a;
    }

    public String _b() {
        return this._b;
    }

    public Vector3f _c() {
        return this._c;
    }

    public String _d() {
        return this._d;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeFloat(this._c().x);
        dataOutput.writeFloat(this._c().y);
        dataOutput.writeFloat(this._c().z);
        dataOutput.writeUTF(this._b());
        dataOutput.writeUTF(this._d());
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._c = new Vector3f(dataInput.readFloat(), dataInput.readFloat(), dataInput.readFloat());
        this._b = dataInput.readUTF();
        this._d = dataInput.readUTF();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        qlqj qlqj2 = (qlqj)object;
        return this._a == qlqj2._a && Objects.equals(this._b, qlqj2._b) && Objects.equals(this._c, qlqj2._c) && Objects.equals(this._d, qlqj2._d);
    }

    public int hashCode() {
        return Objects.hash(this._a, this._b, this._c, this._d);
    }
}

