/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.world.storage.WorldInfo;

public class dism
implements Callable {
    public final /* synthetic */ WorldInfo _a;

    public dism(WorldInfo worldInfo) {
        this._a = worldInfo;
    }

    public String _a() {
        return WorldInfo._c(this._a);
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

