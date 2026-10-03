/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;
import net.minecraft.util.vjvn;

public class lprm
extends tgdv {
    public lprm(int n) {
        super(n);
    }

    @Override
    public boolean func_77636_d(cvzo cvzo2) {
        return true;
    }

    @Override
    public boolean func_77616_k(cvzo cvzo2) {
        return false;
    }

    @Override
    public zywl func_77613_e(cvzo cvzo2) {
        if (this._a(cvzo2)._d() > 0) {
            return zywl._b;
        }
        return super.func_77613_e(cvzo2);
    }

    public bsyv _a(cvzo cvzo2) {
        if (cvzo2._e == null || !cvzo2._e._c("StoredEnchantments")) {
            return new bsyv();
        }
        return (bsyv)cvzo2._e._b("StoredEnchantments");
    }

    @Override
    public void func_77624_a(cvzo cvzo2, EntityPlayer entityPlayer, List list, boolean bl) {
        super.func_77624_a(cvzo2, entityPlayer, list, bl);
        bsyv bsyv2 = this._a(cvzo2);
        if (bsyv2 != null) {
            for (int i = 0; i < bsyv2._d(); ++i) {
                short s = ((qoac)bsyv2._b(i))._e("id");
                short s2 = ((qoac)bsyv2._b(i))._e("lvl");
                if (zhqo._a[s] == null) continue;
                list.add(zhqo._a[s]._c(s2));
            }
        }
    }

    public void _a(cvzo cvzo2, ixcc ixcc2) {
        bsyv bsyv2 = this._a(cvzo2);
        boolean bl = true;
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            if (qoac2._e("id") != ixcc2._a._y) continue;
            if (qoac2._e("lvl") < ixcc2._b) {
                qoac2._a("lvl", (short)ixcc2._b);
            }
            bl = false;
            break;
        }
        if (bl) {
            qoac qoac3 = new qoac();
            qoac3._a("id", (short)ixcc2._a._y);
            qoac3._a("lvl", (short)ixcc2._b);
            bsyv2._a(qoac3);
        }
        if (!cvzo2._p()) {
            cvzo2._d(new qoac());
        }
        cvzo2._q()._a("StoredEnchantments", bsyv2);
    }

    public cvzo _a(ixcc ixcc2) {
        cvzo cvzo2 = new cvzo(this);
        this._a(cvzo2, ixcc2);
        return cvzo2;
    }

    public void _a(zhqo zhqo2, List list) {
        for (int i = zhqo2._b(); i <= zhqo2._c(); ++i) {
            list.add(this._a(new ixcc(zhqo2, i)));
        }
    }

    public vjvn _a(Random random) {
        return this._a(random, 1, 1, 1);
    }

    public vjvn _a(Random random, int n, int n2, int n3) {
        zhqo zhqo2 = zhqo._b[random.nextInt(zhqo._b.length)];
        cvzo cvzo2 = new cvzo(this.field_77779_bT, 1, 0);
        int n4 = sajh._a(random, zhqo2._b(), zhqo2._c());
        this._a(cvzo2, new ixcc(zhqo2, n4));
        return new vjvn(cvzo2, n, n2, n3);
    }
}

