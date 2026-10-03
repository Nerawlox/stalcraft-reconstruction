/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.world.storage.WorldInfo;

public class ywoq
implements Callable {
    public final /* synthetic */ WorldInfo _a;

    public ywoq(WorldInfo worldInfo) {
        this._a = worldInfo;
    }

    public String _a() {
        return String.format("%d game time, %d day time", WorldInfo._g(this._a), WorldInfo._h(this._a));
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

