/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import javax.vecmath.Vector3f;

public class pzmv
extends zwat {
    private String _a;
    private Vector3f _b;

    public pzmv(String string, Vector3f vector3f) {
        this._a = string;
        this._b = vector3f;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeFloat(this._b.x);
        dataOutput.writeFloat(this._b.y);
        dataOutput.writeFloat(this._b.z);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = new Vector3f(dataInput.readFloat(), dataInput.readFloat(), dataInput.readFloat());
    }

    public pzmv() {
    }
}

