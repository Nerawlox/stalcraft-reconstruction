/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

public class tdpf
extends zwat {
    public String _a;
    public byte[] _b;

    public tdpf(String string, byte[] byArray) {
        this._a = string;
        this._b = byArray;
    }

    public tdpf(String string, zwat zwat2) {
        this._a = string;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            sryv._a(zwat2, new DataOutputStream(byteArrayOutputStream));
        }
        catch (IOException iOException) {
            // empty catch block
        }
        this._b = byteArrayOutputStream.toByteArray();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeInt(this._b.length);
        dataOutput.write(this._b);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = new byte[dataInput.readInt()];
        dataInput.readFully(this._b);
    }

    public tdpf() {
    }
}

