/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;

public class grmg
implements Callable {
    public final /* synthetic */ MinecraftServer _a;

    public grmg(MinecraftServer minecraftServer) {
        this._a = minecraftServer;
    }

    public String _a() {
        return MinecraftServer._a(this._a)._q() + " / " + MinecraftServer._a(this._a)._r() + "; " + MinecraftServer._a((MinecraftServer)this._a)._e;
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

