/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.stalker.misc.tupg;
import net.minecraft.client.xpzm;
import net.minecraft.entity.EntityLivingBase;

public class loee
implements yctv<jzak> {
    public jzak _b(EntityLivingBase entityLivingBase, mssh ... msshArray) {
        return new jzak(entityLivingBase, msshArray);
    }

    public jzak _b(ccxr ccxr2) {
        return new jzak(ccxr2._a, ccxr2._a.field_71071_by, tupg._a((ccxr)ccxr2)._c);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public zybc _a(jzak jzak2) {
        if (jzak2.owner == xpzm._E()._t) {
            return new nuis(jzak2.player);
        }
        return new hsxd(jzak2);
    }

    @Override
    public int _a() {
        return 61;
    }

    @Override
    public int _b() {
        return 4;
    }

    @Override
    public /* synthetic */ zwyn _a(ccxr ccxr2) {
        return this._b(ccxr2);
    }

    @Override
    public /* synthetic */ zwyn _a(EntityLivingBase entityLivingBase, mssh[] msshArray) {
        return this._b(entityLivingBase, msshArray);
    }
}

