/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.annotations.SerializedName;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.jetbrains.annotations.Nullable;

public class pzne {
    @SerializedName(value="id")
    private int _a;
    @SerializedName(value="stackSize")
    private int _c;
    @SerializedName(value="itemDamage")
    private int _d;
    @SerializedName(value="tag")
    @Nullable
    private NBTTagCompound _e;
    @SerializedName(value="stackSizeVariance")
    private int _f;
    @SerializedName(value="weight")
    public float _b;
    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    @Nullable
    private transient ItemStack _g;

    public pzne(int n, int n2, int n3, @Nullable NBTTagCompound nBTTagCompound, int n4, float f) {
        this._a = n;
        this._c = n2;
        this._d = n3;
        this._e = nBTTagCompound;
        this._f = n4;
        this._b = f;
    }

    public boolean _a() {
        return this._a <= 0;
    }

    @Nullable
    public wnce _b() {
        if (this._a()) {
            return null;
        }
        return new wnce(this._a, this._c, this._d);
    }

    public int _c() {
        return this._a;
    }

    public int _d() {
        return this._c;
    }

    public int _e() {
        return this._d;
    }

    @Nullable
    public NBTTagCompound _f() {
        return this._e;
    }

    public void _a(@Nullable NBTTagCompound nBTTagCompound) {
        this._e = nBTTagCompound;
    }

    public int _g() {
        return this._f;
    }

    public float _h() {
        return this._b;
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public boolean _i() {
        return this._a <= 0 || this._a >= Item.itemsList.length || Item.itemsList[this._a] == null;
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public boolean _j() {
        return !this._a();
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    @Nullable
    public ItemStack _k() {
        if (this._a()) {
            return null;
        }
        if (this._g == null) {
            this._g = this._a(false)._a();
        }
        return this._g;
    }

    @Nullable
    public wnce _l() {
        if (this._a()) {
            return null;
        }
        return this._a(true);
    }

    public wnce _a(boolean bl) {
        int n = this._c;
        if (bl && this._f > 0) {
            n += ThreadLocalRandom.current().nextInt(this._f);
        }
        return new wnce(this._a, n, this._d, this._e);
    }
}

