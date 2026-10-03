/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.world.storage.WorldInfo;

public class mtna
implements Callable {
    public final /* synthetic */ WorldInfo _a;

    public mtna(WorldInfo worldInfo) {
        this._a = worldInfo;
    }

    public String _a() {
        return String.valueOf(WorldInfo._i(this._a));
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

