/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.bundle;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

public class zwat
extends gloomyfolken.bundle.common.core.zwat {
    public byte[] _a;

    public zwat(gloomyfolken.bundle.common.core.zwat zwat2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            sryv._a(zwat2, new DataOutputStream(byteArrayOutputStream));
        }
        catch (IOException iOException) {
            // empty catch block
        }
        this._a = byteArrayOutputStream.toByteArray();
    }

    public zwat(byte[] byArray) {
        this._a = byArray;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a.length);
        dataOutput.write(this._a);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = new byte[dataInput.readInt()];
        dataInput.readFully(this._a);
    }

    @Override
    public void processClient(boolean bl) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this._a);
        try {
            gloomyfolken.bundle.common.core.zwat zwat2 = (gloomyfolken.bundle.common.core.zwat)sryv._a(new DataInputStream(byteArrayInputStream));
            zwat2.processClient(true);
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    public zwat() {
    }
}

