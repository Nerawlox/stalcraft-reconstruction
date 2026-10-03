/*
 * Decompiled with CFR 0.152.
 */
import java.net.InetAddress;

public class pljc
extends vmra {
    public final zibx _d;

    public pljc(dzfd dzfd2, InetAddress inetAddress, int n) {
        super(dzfd2);
        this._d = new zibx(this, inetAddress, n);
        this._d.start();
    }

    @Override
    public void _a() {
        super._a();
        this._d._b();
        this._d.interrupt();
    }

    @Override
    public void _b() {
        this._d._a();
        super._b();
    }

    public ujth _d() {
        return (ujth)super._c();
    }

    public void _a(InetAddress inetAddress) {
        this._d._a(inetAddress);
    }

    @Override
    public /* synthetic */ dzfd _c() {
        return this._d();
    }
}

