/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

public class lpsl
implements Callable {
    public final /* synthetic */ int _a;
    public final /* synthetic */ NBTTagCompound _b;

    public lpsl(NBTTagCompound nBTTagCompound, int n) {
        this._b = nBTTagCompound;
        this._a = n;
    }

    public String _a() {
        return NBTBase._a[this._a];
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

