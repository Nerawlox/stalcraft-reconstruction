/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.pidb;
import gloomyfolken.mods.asm.Logger;
import java.io.IOException;
import net.minecraft.client.xpzm;

public class pzvp
extends pzrd {
    xpzm _b = xpzm._E();
    ivbz _c;
    boolean _d;

    public pzvp(ivbz ivbz2, String string, int n) throws IOException {
        super(string, n, pidb._a);
        this._c = ivbz2;
    }

    public void _a(zfeq zfeq2) {
        Logger.info("Reconnecting to frontend server " + zfeq2._a + ":" + zfeq2._b, new Object[0]);
        this._b._a(new fnnc(new fngq(), this._b, new htsm("BundleFrontend", zfeq2._a + ":" + zfeq2._b)));
        this._d = true;
    }

    public void _a(haqh haqh2) {
        if (this._c != null) {
            this._c._b = haqh2._a;
        }
    }

    @Override
    public void _a(String string) {
        if (!this._d) {
            this._b._a(new xrwl(new gqju(new fngq()), "disconnect.lost", string == null ? "No reason" : string, null));
        }
    }

    @Override
    public void _c(ctih ctih2) {
        int n = sryv._a(ctih2);
        if (n == sryv._a(zfeq.class)) {
            this._a((zfeq)ctih2);
        }
        if (n == sryv._a(haqh.class)) {
            this._a((haqh)ctih2);
        }
    }

    @Override
    public String _c() {
        return "backend";
    }
}

