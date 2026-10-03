/*
 * Decompiled with CFR 0.152.
 */
import java.io.OutputStream;

public class yvee
extends klxf {
    public byte[] _d;

    public yvee(String string, byte[] byArray, int n, int n2) {
        super(string, n, n2);
        this._d = byArray;
    }

    public yvee _h() {
        try {
            this._a.setDoOutput(true);
            this._a.setDoInput(true);
            this._a.setRequestMethod("PUT");
            OutputStream outputStream = this._a.getOutputStream();
            outputStream.write(this._d);
            outputStream.flush();
            return this;
        }
        catch (Exception exception) {
            throw new htpz("Failed URL: " + this._c, exception);
        }
    }

    @Override
    public /* synthetic */ klxf _f() {
        return this._h();
    }
}

