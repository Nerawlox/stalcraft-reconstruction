/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.xpzm;

public class necw {
    public final xpzm _a;
    public final List _b = new ArrayList();

    public necw(xpzm xpzm2) {
        this._a = xpzm2;
        this._a();
    }

    public void _a() {
        try {
            this._b.clear();
            qoac qoac2 = bsvf._a(new File(this._a._P, "servers.dat"));
            if (qoac2 == null) {
                return;
            }
            bsyv bsyv2 = qoac2._n("servers");
            for (int i = 0; i < bsyv2._d(); ++i) {
                this._b.add(htsm._a((qoac)bsyv2._b(i)));
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void _b() {
        try {
            bsyv bsyv2 = new bsyv();
            for (htsm htsm2 : this._b) {
                bsyv2._a(htsm2._a());
            }
            qoac qoac2 = new qoac();
            qoac2._a("servers", bsyv2);
            bsvf._a(qoac2, new File(this._a._P, "servers.dat"));
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public htsm _a(int n) {
        return (htsm)this._b.get(n);
    }

    public void _b(int n) {
        this._b.remove(n);
    }

    public void _a(htsm htsm2) {
        this._b.add(htsm2);
    }

    public int _c() {
        return this._b.size();
    }

    public void _a(int n, int n2) {
        htsm htsm2 = this._a(n);
        this._b.set(n, this._a(n2));
        this._b.set(n2, htsm2);
        this._b();
    }
}

