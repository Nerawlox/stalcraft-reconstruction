/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayerMP;

public class suor
extends fojy {
    public final dzfd _g;
    public final Set _h = new HashSet();
    public qojj _i;

    public suor(dzfd dzfd2) {
        this._g = dzfd2;
    }

    @Override
    public void _a(cwdc cwdc2) {
        super._a(cwdc2);
        if (this._h.contains(cwdc2._c())) {
            this._g.__ag()._a(new plcv(cwdc2, 0));
        }
        this._f();
    }

    @Override
    public void _h(String string) {
        super._h(string);
        this._g.__ag()._a(new plcv(string));
        this._f();
    }

    @Override
    public void _a(int n, igri igri2) {
        igri igri3 = this._a(n);
        super._a(n, igri2);
        if (igri3 != igri2 && igri3 != null) {
            if (this._j(igri3) > 0) {
                this._g.__ag()._a(new txou(n, igri2));
            } else {
                this._i(igri3);
            }
        }
        if (igri2 != null) {
            if (this._h.contains(igri2)) {
                this._g.__ag()._a(new txou(n, igri2));
            } else {
                this._g(igri2);
            }
        }
        this._f();
    }

    @Override
    public void _a(String string, dzew dzew2) {
        super._a(string, dzew2);
        this._g.__ag()._a(new lpxb(dzew2, Arrays.asList(string), 3));
        this._f();
    }

    @Override
    public void _b(String string, dzew dzew2) {
        super._b(string, dzew2);
        this._g.__ag()._a(new lpxb(dzew2, Arrays.asList(string), 4));
        this._f();
    }

    @Override
    public void _c(igri igri2) {
        super._c(igri2);
        this._f();
    }

    @Override
    public void _d(igri igri2) {
        super._d(igri2);
        if (this._h.contains(igri2)) {
            this._g.__ag()._a(new sulv(igri2, 2));
        }
        this._f();
    }

    @Override
    public void _e(igri igri2) {
        super._e(igri2);
        if (this._h.contains(igri2)) {
            this._i(igri2);
        }
        this._f();
    }

    @Override
    public void _b(dzew dzew2) {
        super._b(dzew2);
        this._g.__ag()._a(new lpxb(dzew2, 0));
        this._f();
    }

    @Override
    public void _c(dzew dzew2) {
        super._c(dzew2);
        this._g.__ag()._a(new lpxb(dzew2, 2));
        this._f();
    }

    @Override
    public void _d(dzew dzew2) {
        super._d(dzew2);
        this._g.__ag()._a(new lpxb(dzew2, 1));
        this._f();
    }

    public void _a(qojj qojj2) {
        this._i = qojj2;
    }

    public void _f() {
        if (this._i != null) {
            this._i.func_76185_a();
        }
    }

    public List _f(igri igri2) {
        ArrayList<cezg> arrayList = new ArrayList<cezg>();
        arrayList.add(new sulv(igri2, 0));
        for (int i = 0; i < 3; ++i) {
            if (this._a(i) != igri2) continue;
            arrayList.add(new txou(i, igri2));
        }
        for (cwdc cwdc2 : this._a(igri2)) {
            arrayList.add(new plcv(cwdc2, 0));
        }
        return arrayList;
    }

    public void _g(igri igri2) {
        List list2 = this._f(igri2);
        for (EntityPlayerMP entityPlayerMP : this._g.__ag()._e) {
            for (cezg cezg2 : list2) {
                entityPlayerMP.field_71135_a.func_72567_b(cezg2);
            }
        }
        this._h.add(igri2);
    }

    public List _h(igri igri2) {
        ArrayList<cezg> arrayList = new ArrayList<cezg>();
        arrayList.add(new sulv(igri2, 1));
        for (int i = 0; i < 3; ++i) {
            if (this._a(i) != igri2) continue;
            arrayList.add(new txou(i, igri2));
        }
        return arrayList;
    }

    public void _i(igri igri2) {
        List list2 = this._h(igri2);
        for (EntityPlayerMP entityPlayerMP : this._g.__ag()._e) {
            for (cezg cezg2 : list2) {
                entityPlayerMP.field_71135_a.func_72567_b(cezg2);
            }
        }
        this._h.remove(igri2);
    }

    public int _j(igri igri2) {
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (this._a(i) != igri2) continue;
            ++n;
        }
        return n;
    }
}

