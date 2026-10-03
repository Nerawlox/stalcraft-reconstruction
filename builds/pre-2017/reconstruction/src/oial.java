/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class oial {
    public ByteArrayOutputStream _a;
    public DataOutputStream _b;

    public oial(int n) {
        this._a = new ByteArrayOutputStream(n);
        this._b = new DataOutputStream(this._a);
    }

    public void _a(byte[] byArray) {
        this._b.write(byArray, 0, byArray.length);
    }

    public void _a(String string) {
        this._b.writeBytes(string);
        this._b.write(0);
    }

    public void _a(int n) {
        this._b.write(n);
    }

    public void _a(short s) {
        this._b.writeShort(Short.reverseBytes(s));
    }

    public byte[] _a() {
        return this._a.toByteArray();
    }

    public void _b() {
        this._a.reset();
    }
}

