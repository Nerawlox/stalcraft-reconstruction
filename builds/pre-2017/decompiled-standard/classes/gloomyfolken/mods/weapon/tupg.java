/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.util.Objects;
import net.minecraft.entity.player.EntityPlayer;
import org.apache.commons.lang3.ArrayUtils;

public class tupg {
    public final EntityPlayer _a;
    public final cvzo _b;
    public final wolf _c;
    public static final String _d = "default_attachment";

    public tupg(EntityPlayer entityPlayer, int n) {
        this(entityPlayer, entityPlayer.field_71071_by.func_70301_a(n));
    }

    public tupg(EntityPlayer entityPlayer, cvzo cvzo2) {
        this._a = entityPlayer;
        this._b = cvzo2;
        this._c = (wolf)cvzo2._a();
    }

    public void _a(dxwc.pidb pidb2, int n, int n2) {
        if (n < 0 && n2 <= 0) {
            this._a(pidb2);
            return;
        }
        if (n2 > 0) {
            boolean bl = ArrayUtils.contains(this._c._c, n2);
            if (bl) {
                cvzo cvzo2 = new cvzo(n2, 1, 0);
                ncwh._b(cvzo2)._a(_d, true);
                this._a(pidb2, cvzo2);
            }
        } else {
            cvzo cvzo3 = this._a.field_71071_by.func_70301_a(n);
            boolean bl = this._a(pidb2, cvzo3);
            if (bl) {
                InvokeSideOnly.frontend(!this._a.field_70170_p.field_72995_K, () -> {});
            }
        }
    }

    public boolean _a(dxwc.pidb pidb2, cvzo cvzo2) {
        if (Objects.equals(cvzo2, this._c._c(this._b, pidb2))) {
            return false;
        }
        if (this._c._b(this._b, cvzo2, pidb2)) {
            if (this._c._c(this._b, pidb2) != null) {
                this._a(pidb2);
            }
            this._c._a(this._b, cvzo2, pidb2);
            this._a();
            return true;
        }
        return false;
    }

    public void _a(dxwc.pidb pidb2) {
        this._a(pidb2, true);
    }

    public void _a(dxwc.pidb pidb2, boolean bl) {
        cvzo cvzo2 = this._c._b(this._b, pidb2);
        if (cvzo2 != null) {
            this._c._a(this._b, (cvzo)null, pidb2);
            if (bl && !ncwh._c(cvzo2)._o(_d)) {
                InvokeSideOnly.frontend(!this._a.field_70170_p.field_72995_K, () -> {});
            }
            this._a();
        }
    }

    private void _a() {
        for (dxwc.pidb pidb2 : dxwc.pidb._x) {
            cvzo cvzo2;
            if (pidb2._p == null || (cvzo2 = this._c._b(this._b, pidb2)) == null || this._c._b(this._b, cvzo2, pidb2)) continue;
            this._a(pidb2);
        }
    }
}

