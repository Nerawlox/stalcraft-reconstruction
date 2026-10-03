/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.util.dwan;

public class ccvh
extends rpbk {
    public final int _c;

    public ccvh(zwyn zwyn2, mssh mssh2, int n, int n2, int n3, int n4) {
        super(zwyn2, mssh2, n, n2, n3);
        this._c = n4;
    }

    @Override
    public int func_75219_a() {
        return 1;
    }

    @Override
    public boolean func_75214_a(cvzo cvzo2) {
        tgdv tgdv2 = cvzo2 == null ? null : cvzo2._a();
        return tgdv2 != null && tgdv2.isValidArmor(cvzo2, this._c, this._b.owner);
    }

    @Override
    public void func_75218_e() {
        super.func_75218_e();
        this._b.onArmorChanged();
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public dwan func_75212_b() {
        return lpno.func_94602_b(this._c);
    }
}

