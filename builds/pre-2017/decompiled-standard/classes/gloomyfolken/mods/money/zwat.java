/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.money;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.money.kjui;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import net.minecraft.entity.player.EntityPlayer;

public class zwat
extends tehy
implements kjui {
    public static final String _a = "money";
    private static final String _b = "money";
    private static HashMap<Integer, Integer> _c = new HashMap();
    private bqwg<Long> _d;

    public zwat(ccxr ccxr2) {
        super(ccxr2);
        this._d = new bqwg.kjui<Long>(ccxr2, "money", 0L)._b()._f();
    }

    public boolean _e(long l) {
        return this._a() >= l;
    }

    @Override
    public long _a() {
        return this._d._b();
    }

    @Override
    public void _a(long l) {
        this._d._a(l);
    }

    @Override
    public void _b(long l) {
        this._d._a(this._d._b() + l);
        InvokeSideOnly.frontend(!this.player.field_70170_p.field_72995_K, () -> {});
    }

    @Override
    public void _c(long l) {
        if (l < 0L) {
            throw new IllegalArgumentException("Withdrawn money can't be negative value! Use 'addMoney' instead");
        }
        this._d._a(this._d._b() - l);
    }

    @Override
    public boolean _d(long l) {
        if (this._d._b() >= l) {
            this._d._a(this._d._b() - l);
            return true;
        }
        return false;
    }

    public static long _a(cvzo cvzo2) {
        if (cvzo2 != null && _c.containsKey(cvzo2._d)) {
            return cvzo2._b * _c.get(cvzo2._d);
        }
        return 0L;
    }

    public static zwat _a(EntityPlayer entityPlayer) {
        return (zwat)ncwh._a((EntityPlayer)entityPlayer)._h.get("money");
    }

    public static int _a(int n) {
        if (_c.containsKey(n)) {
            return _c.get(n);
        }
        return 0;
    }

    @ezey(_a={eidj.CLIENT})
    public String _b() {
        return NumberFormat.getNumberInstance(Locale.ENGLISH).format(this._a()) + " \u0440\u0443\u0431.";
    }

    static {
        _c.put(16000, 5000);
        _c.put(26978, 1000);
        _c.put(26979, 500);
        _c.put(26977, 100);
        _c.put(26976, 50);
        _c.put(26974, 10);
    }
}

