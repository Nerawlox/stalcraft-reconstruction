/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.Packet;

public class tglw
implements Callable {
    public final /* synthetic */ Packet _a;
    public final /* synthetic */ NetServerHandler _b;

    public tglw(NetServerHandler netServerHandler, Packet packet) {
        this._b = netServerHandler;
        this._a = packet;
    }

    public String _a() {
        return String.valueOf(this._a.getPacketId());
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

