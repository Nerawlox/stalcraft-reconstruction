/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.world.storage.WorldInfo;

public class foyo
implements Callable {
    public final /* synthetic */ WorldInfo _a;

    public foyo(WorldInfo worldInfo) {
        this._a = worldInfo;
    }

    public String _a() {
        return String.format("Game mode: %s (ID %d). Hardcore: %b. Cheats: %b", WorldInfo._o(this._a)._b(), WorldInfo._o(this._a)._a(), WorldInfo._p(this._a), WorldInfo._q(this._a));
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

