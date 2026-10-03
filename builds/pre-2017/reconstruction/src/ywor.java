/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.world.storage.WorldInfo;

public class ywor
implements Callable {
    public final /* synthetic */ WorldInfo _a;

    public ywor(WorldInfo worldInfo) {
        this._a = worldInfo;
    }

    public String _a() {
        return String.format("Rain time: %d (now: %b), thunder time: %d (now: %b)", WorldInfo._k(this._a), WorldInfo._l(this._a), WorldInfo._m(this._a), WorldInfo._n(this._a));
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

