/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.world.storage.WorldInfo;

public class gazc
implements Callable {
    public final /* synthetic */ WorldInfo _a;

    public gazc(WorldInfo worldInfo) {
        this._a = worldInfo;
    }

    public String _a() {
        return String.valueOf(this._a._b());
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

