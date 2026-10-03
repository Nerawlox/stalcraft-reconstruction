/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import gloomyfolken.mods.weapon.tupg;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;
import org.apache.commons.lang3.ArrayUtils;

public class sbzo
extends majr {
    private final EntityPlayer _l;
    private final eidj _m;
    private final int _n;
    protected int _i;
    protected boolean _j;
    protected int _k = -1;

    public sbzo(gqjz gqjz2, EntityPlayer entityPlayer, int n) {
        super(gqjz2, entityPlayer.field_71071_by.func_70301_a(n));
        this._l = entityPlayer;
        this._m = entityPlayer.field_71071_by;
        this._n = n;
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        cvzo cvzo2 = this._l.field_71071_by.func_70301_a(this._n);
        if (this.getStack() != cvzo2) {
            if (this.getStack() != null && cvzo2 != null && this.getStack()._d == cvzo2._d) {
                this.setStack(cvzo2);
            } else {
                this.closeScreen();
            }
        }
        if (this._j) {
            cvzo cvzo3 = this._e.selectedStack = this._i >= 0 ? this._m.func_70301_a(this._i) : null;
        }
        if (this._k >= 0) {
            this._f.selectedStack = this._m.func_70301_a(this._k);
        }
    }

    @Override
    protected List<cvzo> getAvailableStacks() {
        ArrayList<cvzo> arrayList = Lists.newArrayList(this._m._a);
        for (int n : this._a._c) {
            cvzo cvzo2 = new cvzo(n, 1, 0);
            ncwh._b(cvzo2)._a("default_attachment", true);
            arrayList.add(cvzo2);
        }
        return arrayList;
    }

    @Override
    protected void _b(cvzo cvzo2) {
        cvzo cvzo3 = this._e.selectedStack;
        if (cvzo3 == null) {
            return;
        }
        int n = ncwh._a(this._m, cvzo3);
        if (n >= 0) {
            new ejxc(this._n, n).sendToServer();
        }
    }

    @Override
    protected boolean _a() {
        return true;
    }

    @Override
    protected void _d() {
        new cdqw(this._n).sendToServer();
    }

    @Override
    protected void _a(dxwc.pidb pidb2, cvzo cvzo2) {
        int n = 0;
        int n2 = -1;
        if (cvzo2 != null && ArrayUtils.contains(this._a._c, cvzo2._d)) {
            n = cvzo2._d;
        } else {
            n2 = ncwh._a(this._m, cvzo2);
        }
        new stdy(this._n, n2, n, pidb2).sendToServer();
        new tupg(this._l, this._n)._a(pidb2, n2, n);
    }

    @Override
    protected void _d(cvzo cvzo2) {
        this._i = ncwh._a(this._m, this._e.selectedStack);
        this._j = true;
    }

    @Override
    protected void _a(cvzo cvzo2) {
        super._a(cvzo2);
        this._k = ncwh._a(this._m, cvzo2);
    }

    @Override
    protected void _c(cvzo cvzo2) {
        if (cvzo2 == null) {
            return;
        }
        int n = ncwh._a(this._m, cvzo2);
        if (n >= 0) {
            new ogtn(this._n, n).sendToServer();
            this._h = ((xroo)cvzo2._a())._b();
        }
    }
}

