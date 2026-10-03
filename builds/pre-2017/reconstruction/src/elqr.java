/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.world.gen.structure.MapGenStructure;

public class elqr
implements Callable {
    public final /* synthetic */ int _a;
    public final /* synthetic */ int _b;
    public final /* synthetic */ MapGenStructure _c;

    public elqr(MapGenStructure mapGenStructure, int n, int n2) {
        this._c = mapGenStructure;
        this._a = n;
        this._b = n2;
    }

    public String _a() {
        return String.valueOf(jjym._a(this._a, this._b));
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

