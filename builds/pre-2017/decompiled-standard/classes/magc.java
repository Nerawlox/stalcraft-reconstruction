/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;

public class magc
extends tehy {
    public static final String _a = "Recipes";
    private Set<Integer> _b = new HashSet<Integer>();

    public magc(ccxr ccxr2) {
        super(ccxr2);
    }

    public boolean _a(hsvw hsvw2) {
        return hsvw2._c() || this._b.contains(hsvw2._d());
    }

    public Set<Integer> _a() {
        return this._b;
    }

    public void _a(Set<Integer> set) {
        this._b = set;
    }

    @ezey(_a={eidj.CLIENT})
    public static magc _b() {
        return magc._a(xpzm._E()._t);
    }

    public static magc _a(EntityPlayer entityPlayer) {
        return magc._a(ncwh._a(entityPlayer));
    }

    public static magc _a(ccxr ccxr2) {
        return (magc)ccxr2._h.get(_a);
    }
}

