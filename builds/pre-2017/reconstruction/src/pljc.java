/*
 * Decompiled with CFR 0.152.
 */
import java.net.InetAddress;
import net.minecraft.network.NetworkListenThread;
import net.minecraft.server.MinecraftServer;

public class pljc
extends NetworkListenThread {
    public final zibx _d;

    public pljc(MinecraftServer minecraftServer, InetAddress inetAddress, int n) {
        super(minecraftServer);
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
    public /* synthetic */ MinecraftServer _c() {
        return this._d();
    }
}

