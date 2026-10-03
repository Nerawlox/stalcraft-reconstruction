/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.pidb;
import net.minecraft.entity.player.EntityPlayer;

public class cufs
extends tego {
    public cufs(mssh mssh2, xqsf xqsf2) {
        super(mssh2, xqsf2);
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        cvzo cvzo2 = null;
        yeso yeso2 = (yeso)this.field_75151_b.get(n);
        if (yeso2 != null && yeso2.func_75216_d()) {
            cvzo cvzo3 = yeso2.func_75211_c();
            if (!(yeso2 instanceof kkzz) && !pidb._a(cvzo3)) {
                return null;
            }
            cvzo2 = cvzo3._l();
            if (n < 27 ? !this.func_75135_a(cvzo3, 27, this.field_75151_b.size(), true) : !this.func_75135_a(cvzo3, 0, 27, false)) {
                return null;
            }
            if (cvzo3._b == 0) {
                yeso2.func_75215_d(null);
            } else {
                yeso2.func_75218_e();
            }
        }
        return cvzo2;
    }

    @Override
    protected yeso _a(int n, int n2, int n3) {
        return new kkzz(this._a, n, n2, n3);
    }
}

