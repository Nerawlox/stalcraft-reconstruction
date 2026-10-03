/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.mco.Request;

public class ifuh
extends Request {
    public ifuh(String string, int n, int n2) {
        super(string, n, n2);
    }

    public ifuh _h() {
        try {
            this._a.setDoInput(true);
            this._a.setDoOutput(true);
            this._a.setUseCaches(false);
            this._a.setRequestMethod("GET");
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

