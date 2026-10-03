/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Set;
import net.minecraft.item.ItemStack;

public class hsvw {
    private int _a;
    private String _b;
    private String _c;
    private String _d;
    private ItemStack _e;
    private List<ItemStack> _f;
    private long _g;
    private boolean _h;
    private float _i = 1.0f;
    private Set<String> _j;

    public hsvw(int n, String string, String string2, String string3, ItemStack itemStack, List<ItemStack> list2, long l, boolean bl, Set<String> set, float f) {
        this._a = n;
        this._b = string;
        this._c = string2;
        this._d = string3;
        this._e = itemStack;
        this._f = list2;
        this._g = l;
        this._h = bl;
        this._j = set;
        this._i = f;
    }

    public float _a() {
        return this._i;
    }

    public long _b() {
        return this._g;
    }

    public boolean _c() {
        return this._h;
    }

    public int _d() {
        return this._a;
    }

    public String _e() {
        return this._b;
    }

    public String _f() {
        return this._c;
    }

    public String _g() {
        return this._d;
    }

    public ItemStack _h() {
        return this._e;
    }

    public List<ItemStack> _i() {
        return this._f;
    }

    public Set<String> _j() {
        return this._j;
    }
}

