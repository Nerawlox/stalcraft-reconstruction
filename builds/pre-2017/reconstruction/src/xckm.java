/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.world.storage.WorldInfo;

public class xckm
implements Callable {
    public final /* synthetic */ WorldInfo _a;

    public xckm(WorldInfo worldInfo) {
        this._a = worldInfo;
    }

    public String _a() {
        String string = "Unknown?";
        try {
            switch (WorldInfo._j(this._a)) {
                case 19133: {
                    string = "Anvil";
                    break;
                }
                case 19132: {
                    string = "McRegion";
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return String.format("0x%05X - %s", WorldInfo._j(this._a), string);
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

