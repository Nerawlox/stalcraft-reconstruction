/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.world.World;

public class rrqg
implements Callable {
    public final /* synthetic */ World _a;

    public rrqg(World world) {
        this._a = world;
    }

    public String _a() {
        return this._a.chunkProvider._d();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

