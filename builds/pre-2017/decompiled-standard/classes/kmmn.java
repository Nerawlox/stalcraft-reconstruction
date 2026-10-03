/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;

public class kmmn
extends tgdv {
    public static final Map _a = new HashMap();
    public final String _b;

    public kmmn(int n, String string) {
        super(n);
        this._b = string;
        this.field_77777_bU = 1;
        this.func_77637_a(tgbl.field_78026_f);
        _a.put(string, this);
    }

    @Override
    public dwan func_77617_a(int n) {
        return this.field_77791_bV;
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (ozlu2.func_72798_a(n, n2, n3) == twgu.field_72032_aY.field_71990_ca && ozlu2.func_72805_g(n, n2, n3) == 0) {
            if (ozlu2.field_72995_K) {
                return true;
            }
            ((hcdz)twgu.field_72032_aY)._a(ozlu2, n, n2, n3, cvzo2);
            ozlu2.func_72889_a(null, 1005, n, n2, n3, this.field_77779_bT);
            --cvzo2._b;
            return true;
        }
        return false;
    }

    @Override
    public void func_77624_a(cvzo cvzo2, EntityPlayer entityPlayer, List list2, boolean bl) {
        list2.add(this._a());
    }

    public String _a() {
        return "C418 - " + this._b;
    }

    @Override
    public zywl func_77613_e(cvzo cvzo2) {
        return zywl._c;
    }

    public static kmmn _a(String string) {
        return (kmmn)_a.get(string);
    }
}

