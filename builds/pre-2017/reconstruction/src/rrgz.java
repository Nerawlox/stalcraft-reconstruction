/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.NetworkListenThread;

public class rrgz
implements Callable {
    public final /* synthetic */ NetServerHandler _a;
    public final /* synthetic */ NetworkListenThread _b;

    public rrgz(NetworkListenThread networkListenThread, NetServerHandler netServerHandler) {
        this._b = networkListenThread;
        this._a = netServerHandler;
    }

    public String _a() {
        return this._a.toString();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

