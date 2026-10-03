/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

public class sdfp
implements Callable {
    public final /* synthetic */ String _a;
    public final /* synthetic */ NBTTagCompound _b;

    public sdfp(NBTTagCompound nBTTagCompound, String string) {
        this._b = nBTTagCompound;
        this._a = string;
    }

    public String _a() {
        return NBTBase._a[((NBTBase)NBTTagCompound._a(this._b).get(this._a))._a()];
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

