/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.world.storage.WorldInfo;

public class mckx
implements Callable {
    public final /* synthetic */ WorldInfo _a;

    public mckx(WorldInfo worldInfo) {
        this._a = worldInfo;
    }

    public String _a() {
        return String.format("ID %02d - %s, ver %d. Features enabled: %b", WorldInfo._a(this._a)._g(), WorldInfo._a(this._a)._a(), WorldInfo._a(this._a)._c(), WorldInfo._b(this._a));
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

