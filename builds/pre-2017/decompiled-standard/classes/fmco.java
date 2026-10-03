/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.zwat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

public class fmco
extends cezg {
    private byte[] _a;
    private zwat _b;

    public fmco() {
    }

    public fmco(zwat zwat2) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            sryv._a(zwat2, new DataOutputStream(byteArrayOutputStream));
            this._a = byteArrayOutputStream.toByteArray();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            this._a = new byte[0];
        }
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a.length);
        dataOutput.write(this._a);
    }

    @Override
    public void func_73267_a(DataInput dataInput) throws IOException {
        this._a = new byte[dataInput.readInt()];
        dataInput.readFully(this._a);
        this._a();
    }

    private void _a() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this._a);
        this._b = (zwat)sryv._a(new DataInputStream(byteArrayInputStream));
    }

    @Override
    public void func_73279_a(elai elai2) {
        try {
            zwat zwat2 = this._b();
            if (elai2.func_72489_a()) {
                if (elai2.getPlayer().func_110143_aJ() > 0.0f || zwat2.canProcessWhenDead()) {
                    InvokeSideOnly.frontend(() -> {});
                }
            } else {
                InvokeSideOnly.client(() -> zwat2.processClient(false));
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            elai2.func_72509_a(this);
        }
    }

    @Override
    public int func_73284_a() {
        return 4 + this._a.length;
    }

    private zwat _b() throws IOException {
        if (this._b == null) {
            this._a();
        }
        return this._b;
    }

    @Override
    public boolean func_73277_a_() {
        try {
            return this._b()._a();
        }
        catch (IOException iOException) {
            return false;
        }
    }
}

