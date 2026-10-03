/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.world.World;

public class sutf
implements Callable {
    public final /* synthetic */ World _a;

    public sutf(World world) {
        this._a = world;
    }

    public String _a() {
        return this._a.playerEntities.size() + " total; " + this._a.playerEntities.toString();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

