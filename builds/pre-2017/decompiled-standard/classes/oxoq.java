/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class oxoq
extends oxot {
    private String _c;
    private String _d;
    private cvzo _e;
    private cvzo _f;
    private cvzo _g;

    public oxoq() {
    }

    public oxoq(String string, String string2, cvzo cvzo2, cvzo cvzo3, float f, cvzo cvzo4) {
        super(f);
        this._c = string;
        this._d = string2;
        this._e = cvzo4;
        this._f = cvzo2;
        this._g = cvzo3;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeUTF(this._d);
        oxoq.writeItemStack(this._e, dataOutput);
        oxoq.writeItemStack(this._f, dataOutput);
        oxoq.writeItemStack(this._g, dataOutput);
        dataOutput.writeUTF(this._c);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._d = dataInput.readUTF();
        this._e = oxoq.readItemStack(dataInput);
        this._f = oxoq.readItemStack(dataInput);
        try {
            this._g = oxoq.readItemStack(dataInput);
            this._c = dataInput.readUTF();
        }
        catch (IOException iOException) {
            // empty catch block
        }
        if (this._c == null) {
            this._c = "";
        }
    }

    @Override
    public boolean _b() {
        if (this._e != null && this._e._a() instanceof wolf) {
            return ((wolf)this._e._a())._U((cvzo)this._e)._a;
        }
        return false;
    }

    public String _c() {
        return this._c;
    }

    public String _d() {
        return this._d;
    }

    public cvzo _e() {
        return this._e;
    }

    public cvzo _f() {
        return this._f;
    }

    public cvzo _g() {
        return this._g;
    }
}

