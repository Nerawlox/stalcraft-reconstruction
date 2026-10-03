/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.tileentity.TileEntity;

public class nwdw
implements Callable {
    public final /* synthetic */ TileEntity _a;

    public nwdw(TileEntity tileEntity) {
        this._a = tileEntity;
    }

    public String _a() {
        return (String)TileEntity.getClassToNameMap().get(this._a.getClass()) + " // " + this._a.getClass().getCanonicalName();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

