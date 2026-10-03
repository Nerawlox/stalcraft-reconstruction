/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.world.storage.WorldInfo;

public class bcmf
implements Callable {
    public final /* synthetic */ WorldInfo _a;

    public bcmf(WorldInfo worldInfo) {
        this._a = worldInfo;
    }

    public String _a() {
        return CrashReportCategory._a(WorldInfo._d(this._a), WorldInfo._e(this._a), WorldInfo._f(this._a));
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

