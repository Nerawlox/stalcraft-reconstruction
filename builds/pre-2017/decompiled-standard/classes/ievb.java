/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import gloomyfolken.mods.core.misc.vjta;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;

public class ievb
extends gpqn {
    private EntityPlayer _f;
    private int _g;
    private int _h = -1;
    private int _i = -1;

    public ievb(gqjz gqjz2, EntityPlayer entityPlayer, int n) {
        super(gqjz2, entityPlayer.field_71071_by.func_70301_a(n));
        this._f = entityPlayer;
        this._g = n;
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        cvzo cvzo2 = this._f.field_71071_by.func_70301_a(this._g);
        if (this.getStack() != cvzo2) {
            if (this.getStack() != null && cvzo2 != null && cvzo2._d == this.getStack()._d) {
                this.setStack(cvzo2);
                this._e = ((vjta)((Object)this.getStack()._a()))._i_(this.getStack());
            } else {
                this.closeScreen();
            }
        }
        if (this._h >= 0) {
            this._b.selectedStack = this._f.field_71071_by.func_70301_a(this._h);
        }
        if (this._i >= 0) {
            this._c.selectedStack = this._f.field_71071_by.func_70301_a(this._i);
        }
    }

    @Override
    protected boolean _a() {
        return true;
    }

    @Override
    protected void _b(cvzo cvzo2) {
        this._h = ncwh._a(this._f.field_71071_by, cvzo2);
    }

    @Override
    protected void _a(cvzo cvzo2) {
        super._a(cvzo2);
        this._i = ncwh._a(this._f.field_71071_by, cvzo2);
    }

    @Override
    protected List<cvzo> getAvailableStacks() {
        return Lists.newArrayList(this._f.field_71071_by._a);
    }

    @Override
    protected void _c(cvzo cvzo2) {
        if (cvzo2 == null) {
            return;
        }
        int n = ncwh._a(this._f.field_71071_by, cvzo2);
        if (n > 0) {
            new nuna(this._g, n).sendToServer();
        }
    }

    @Override
    protected void _d(cvzo cvzo2) {
        if (cvzo2 == null) {
            return;
        }
        int n = ncwh._a(this._f.field_71071_by, cvzo2);
        if (n > 0) {
            new ogtn(this._g, n).sendToServer();
            this._e = ((xroo)cvzo2._a())._b();
        }
    }
}

