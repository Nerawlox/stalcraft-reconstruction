/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;

public class jjtx
implements Callable {
    public final /* synthetic */ MinecraftServer _a;

    public jjtx(MinecraftServer minecraftServer) {
        this._a = minecraftServer;
    }

    public String _a() {
        return this._a._g._c ? this._a._g._c() : "N/A (disabled)";
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

