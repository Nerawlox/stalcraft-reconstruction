/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.anomaly;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.client.xpzm;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ofbx;
import net.smart.moving.SmartMovingFactory;
import net.smart.moving.SmartMovingSelf;

public interface zwat {
    public boolean _a(EntityPlayer var1);

    default public float _a(int n) {
        return 0.0f;
    }

    default public void _a() {
    }

    default public ofbx _a(ofbx ofbx2, ofbx ofbx3, int n) {
        float f = this._a(n);
        royz royz2 = this._s_();
        ofbx ofbx4 = ofbx._a((double)royz2.field_70329_l + 0.5 - ofbx2._c, (double)royz2.field_70330_m + 3.38 - ofbx2._d, (double)royz2.field_70327_n + 0.5 - ofbx2._e)._a();
        return ofbx._a(ofbx3._c + (Math.abs(ofbx4._c * (double)f) > Math.abs((double)royz2.field_70329_l + 0.5 - ofbx2._c) ? (double)royz2.field_70329_l + 0.5 - ofbx2._c : ofbx4._c * (double)f), Math.min(ofbx4._d * (double)f, (double)royz2.field_70330_m + 3.38 - ofbx2._d), ofbx3._e + (Math.abs(ofbx4._e * (double)f) > Math.abs((double)royz2.field_70327_n + 0.5 - ofbx2._e) ? (double)royz2.field_70327_n + 0.5 - ofbx2._e : ofbx4._e * (double)f));
    }

    default public royz _s_() {
        return (royz)((Object)this);
    }

    default public void _a(EntityLivingBase entityLivingBase, int n) {
        ofbx ofbx2 = entityLivingBase.field_70170_p.func_82732_R()._a(entityLivingBase.field_70165_t, entityLivingBase.field_70163_u, entityLivingBase.field_70161_v);
        ofbx ofbx3 = entityLivingBase.field_70170_p.func_82732_R()._a(entityLivingBase.field_70159_w, entityLivingBase.field_70181_x, entityLivingBase.field_70179_y);
        ofbx ofbx4 = this._a(ofbx2, ofbx3, n);
        entityLivingBase.field_70159_w = ofbx4._c;
        entityLivingBase.field_70181_x = ofbx4._d;
        entityLivingBase.field_70179_y = ofbx4._e;
    }

    @ezey(_a={eidj.CLIENT})
    default public void _b(EntityLivingBase entityLivingBase, int n) {
        if (entityLivingBase == xpzm._E()._t) {
            royz royz2 = this._s_();
            SmartMovingSelf smartMovingSelf = (SmartMovingSelf)SmartMovingFactory.getInstance(xpzm._E()._t);
            smartMovingSelf.anticheat._a(this, n);
            new jygo(royz2.field_70329_l, royz2.field_70330_m, royz2.field_70327_n, n).sendToServer();
        }
    }

    default public void _c(EntityLivingBase entityLivingBase, int n) {
        royz royz2 = this._s_();
        if (royz2.field_70331_k.field_72995_K) {
            InvokeSideOnly.client(() -> this._b(entityLivingBase, n));
        } else if (!(entityLivingBase instanceof EntityPlayer)) {
            this._a(entityLivingBase, n);
        }
    }
}

