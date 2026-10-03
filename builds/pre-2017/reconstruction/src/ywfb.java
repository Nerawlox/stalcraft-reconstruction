/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class ywfb
implements Callable {
    public final /* synthetic */ int _a;
    public final /* synthetic */ World _b;

    public ywfb(World world, int n) {
        this._b = world;
        this._a = n;
    }

    public String _a() {
        try {
            return String.format("ID #%d (%s // %s)", this._a, Block.blocksList[this._a].getUnlocalizedName(), Block.blocksList[this._a].getClass().getCanonicalName());
        }
        catch (Throwable throwable) {
            return "ID #" + this._a;
        }
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

