/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.world.gen.structure.MapGenStructure;

public class gavt
implements Callable {
    public final /* synthetic */ MapGenStructure _a;

    public gavt(MapGenStructure mapGenStructure) {
        this._a = mapGenStructure;
    }

    public String _a() {
        return this._a.getClass().getCanonicalName();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

