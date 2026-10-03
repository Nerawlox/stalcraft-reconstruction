/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public class tgfn
extends tgfo {
    public gaqr _a;

    public tgfn() {
        super("container.enderchest", false, 27);
    }

    public void _a(gaqr gaqr2) {
        this._a = gaqr2;
    }

    public void _a(bsyv bsyv2) {
        int n;
        for (n = 0; n < this.func_70302_i_(); ++n) {
            this.func_70299_a(n, null);
        }
        for (n = 0; n < bsyv2._d(); ++n) {
            qoac qoac2 = (qoac)bsyv2._b(n);
            int n2 = qoac2._d("Slot") & 0xFF;
            if (n2 < 0 || n2 >= this.func_70302_i_()) continue;
            this.func_70299_a(n2, cvzo._a(qoac2));
        }
    }

    public bsyv _a() {
        bsyv bsyv2 = new bsyv("EnderItems");
        for (int i = 0; i < this.func_70302_i_(); ++i) {
            cvzo cvzo2 = this.func_70301_a(i);
            if (cvzo2 == null) continue;
            qoac qoac2 = new qoac();
            qoac2._a("Slot", (byte)i);
            cvzo2._b(qoac2);
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    @Override
    public boolean func_70300_a(EntityPlayer entityPlayer) {
        if (this._a != null && !this._a._a(entityPlayer)) {
            return false;
        }
        return super.func_70300_a(entityPlayer);
    }

    @Override
    public void func_70295_k_() {
        if (this._a != null) {
            this._a._a();
        }
        super.func_70295_k_();
    }

    @Override
    public void func_70305_f() {
        if (this._a != null) {
            this._a._b();
        }
        super.func_70305_f();
        this._a = null;
    }

    @Override
    public boolean func_94041_b(int n, cvzo cvzo2) {
        return true;
    }
}

