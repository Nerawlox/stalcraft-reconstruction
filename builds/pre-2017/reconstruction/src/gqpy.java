/*
 * Decompiled with CFR 0.152.
 */
import java.io.OutputStream;
import net.minecraft.client.mco.Request;

public class gqpy
extends Request {
    public byte[] _d;

    public gqpy(String string, byte[] byArray, int n, int n2) {
        super(string, n, n2);
        this._d = byArray;
    }

    public gqpy _h() {
        try {
            this._a.setDoInput(true);
            this._a.setDoOutput(true);
            this._a.setUseCaches(false);
            this._a.setRequestMethod("POST");
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
    public /* synthetic */ Request _f() {
        return this._h();
    }
}

