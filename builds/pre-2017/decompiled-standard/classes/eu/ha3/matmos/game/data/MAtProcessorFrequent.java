/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.data;

import eu.ha3.matmos.engine.implem.IntegerData;
import eu.ha3.matmos.game.data.MAtAccessors;
import eu.ha3.matmos.game.data.MAtProcessorModel;
import eu.ha3.matmos.game.system.MAtMod;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityMinecartEmpty;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.util.amww;

public class MAtProcessorFrequent
extends MAtProcessorModel {
    public MAtProcessorFrequent(MAtMod mAtMod, IntegerData integerData, String string, String string2) {
        super(mAtMod, integerData, string, string2);
    }

    @Override
    protected void doProcess() {
        xpzm xpzm2 = xpzm._E();
        pkix pkix2 = xpzm2._r;
        iyev iyev2 = MAtAccessors.getWorldInfoOf(pkix2);
        EntityClientPlayerMP entityClientPlayerMP = xpzm2._t;
        int n = (int)Math.floor(entityClientPlayerMP.field_70165_t);
        int n2 = (int)Math.floor(entityClientPlayerMP.field_70163_u);
        int n3 = (int)Math.floor(entityClientPlayerMP.field_70161_v);
        boolean bl = xpzm2._L != null && xpzm2._L._c == amww._a;
        for (Integer n4 : this.getRequired()) {
            switch (n4) {
                case 0: {
                    this.setValue(0, pkix2.func_72972_b(rrqi._a, n, n2, n3));
                    break;
                }
                case 1: {
                    this.setValue(1, pkix2.func_72972_b(rrqi._b, n, n2, n3));
                    break;
                }
                case 2: {
                    this.setValue(2, pkix2.func_72957_l(n, n2, n3));
                    break;
                }
                case 3: {
                    this.setValue(3, (int)(iyev2._g() % 160000L));
                    break;
                }
                case 4: {
                    this.setValue(4, n2);
                    break;
                }
                case 6: {
                    this.setValue(6, entityClientPlayerMP.func_70090_H() ? 1 : 0);
                    break;
                }
                case 7: {
                    this.setValue(7, iyev2._p() ? 1 : 0);
                    break;
                }
                case 8: {
                    this.setValue(8, iyev2._n() ? 1 : 0);
                    break;
                }
                case 9: {
                    this.setValue(9, pkix2.func_72937_j(n, n2, n3) ? 1 : 0);
                    break;
                }
                case 10: {
                    this.setValue(10, entityClientPlayerMP.field_71093_bK == -1 ? 1 : 0);
                    break;
                }
                case 11: {
                    this.setValue(11, pkix2.field_73008_k);
                    break;
                }
                case 19: {
                    this.setValue(19, entityClientPlayerMP.func_70026_G() ? 1 : 0);
                    break;
                }
                case 20: {
                    this.setValue(20, n);
                    break;
                }
                case 21: {
                    this.setValue(21, n3);
                    break;
                }
                case 22: {
                    this.setValue(22, entityClientPlayerMP.field_70122_E ? 1 : 0);
                    break;
                }
                case 23: {
                    this.setValue(23, entityClientPlayerMP.func_70086_ai());
                    break;
                }
                case 24: {
                    this.setValue(24, (int)Math.ceil(entityClientPlayerMP.func_110143_aJ()));
                    break;
                }
                case 25: {
                    this.setValue(25, entityClientPlayerMP.field_71093_bK);
                    break;
                }
                case 26: {
                    this.setValue(26, pkix2.func_72937_j(n, n2, n3) && pkix2.func_72825_h(n, n3) <= n2 ? 1 : 0);
                    break;
                }
                case 27: {
                    this.setValue(27, pkix2.func_72825_h(n, n3));
                    break;
                }
                case 28: {
                    this.setValue(28, pkix2.func_72825_h(n, n3) - n2);
                    break;
                }
                case 32: {
                    this.setValue(32, entityClientPlayerMP.field_71071_by._a() != null ? entityClientPlayerMP.field_71071_by._a()._d : -1);
                    break;
                }
                case 33: {
                    this.setValue(33, (int)Math.round(entityClientPlayerMP.field_70159_w * 1000.0));
                    break;
                }
                case 34: {
                    this.setValue(34, (int)Math.round(entityClientPlayerMP.field_70181_x * 1000.0));
                    break;
                }
                case 35: {
                    this.setValue(35, (int)Math.round(entityClientPlayerMP.field_70179_y * 1000.0));
                    break;
                }
                case 36: {
                    this.setValue(36, n2 >= 1 && n2 < this.mod().util().getWorldHeight() ? this.getTranslatedBlockId(xpzm2._r.func_72798_a(n, n2 - 1, n3)) : -1);
                    break;
                }
                case 37: {
                    this.setValue(37, n2 >= 2 && n2 < this.mod().util().getWorldHeight() ? this.getTranslatedBlockId(xpzm2._r.func_72798_a(n, n2 - 2, n3)) : -1);
                    break;
                }
                case 38: {
                    this.setValue(38, (int)this.mod().util().getClientTick());
                    break;
                }
                case 39: {
                    this.setValue(39, entityClientPlayerMP.func_70027_ad() ? 1 : 0);
                    break;
                }
                case 40: {
                    this.setValue(40, (int)Math.floor(entityClientPlayerMP.field_70733_aJ * 16.0f));
                    break;
                }
                case 41: {
                    this.setValue(41, entityClientPlayerMP.field_70733_aJ != 0.0f ? 1 : 0);
                    break;
                }
                case 42: {
                    this.setValue(42, MAtAccessors.getIsJumpingOf(this.mod().util(), entityClientPlayerMP) ? 1 : 0);
                    break;
                }
                case 43: {
                    this.setValue(43, (int)(entityClientPlayerMP.field_70143_R * 1000.0f));
                    break;
                }
                case 44: {
                    this.setValue(44, MAtAccessors.getIsInWebOf(this.mod().util(), entityClientPlayerMP) ? 1 : 0);
                    break;
                }
                case 45: {
                    int n5 = (int)Math.round(entityClientPlayerMP.field_70159_w * 1000.0);
                    int n6 = (int)Math.round(entityClientPlayerMP.field_70179_y * 1000.0);
                    this.setValue(45, (int)Math.floor(Math.sqrt(n5 * n5 + n6 * n6)));
                    break;
                }
                case 46: {
                    this.setValue(46, entityClientPlayerMP.field_71071_by._c);
                    break;
                }
                case 47: {
                    this.setValue(47, xpzm2._L != null ? 1 : 0);
                    break;
                }
                case 48: {
                    this.setValue(48, xpzm2._L != null ? xpzm2._L._c.ordinal() : -1);
                    break;
                }
                case 49: {
                    this.setValue(49, entityClientPlayerMP.func_70027_ad() ? 1 : 0);
                    break;
                }
                case 50: {
                    this.setValue(50, entityClientPlayerMP.func_70658_aO());
                    break;
                }
                case 51: {
                    this.setValue(51, MAtAccessors.getFoodStatsOf(entityClientPlayerMP)._a());
                    break;
                }
                case 52: {
                    this.setValue(52, (int)(MAtAccessors.getFoodStatsOf(entityClientPlayerMP)._d() * 1000.0f));
                    break;
                }
                case 53: {
                    this.setValue(53, 0);
                    break;
                }
                case 54: {
                    this.setValue(54, (int)(entityClientPlayerMP.field_71106_cc * 1000.0f));
                    break;
                }
                case 55: {
                    this.setValue(55, entityClientPlayerMP.field_71068_ca);
                    break;
                }
                case 56: {
                    this.setValue(56, entityClientPlayerMP.field_71067_cb);
                    break;
                }
                case 57: {
                    this.setValue(57, entityClientPlayerMP.func_70617_f_() ? 1 : 0);
                    break;
                }
                case 58: {
                    this.setValue(58, entityClientPlayerMP.func_71057_bx());
                    break;
                }
                case 59: {
                    this.setValue(59, 0);
                    break;
                }
                case 60: {
                    this.setValue(60, entityClientPlayerMP.func_70632_aY() ? 1 : 0);
                    break;
                }
                case 61: {
                    this.setValue(61, 72000 - entityClientPlayerMP.func_71057_bx());
                    break;
                }
                case 62: {
                    this.setValue(62, entityClientPlayerMP.field_71071_by._a() == null ? -1 : entityClientPlayerMP.field_71071_by._a()._j());
                    break;
                }
                case 63: {
                    this.setValue(63, entityClientPlayerMP.func_70051_ag() ? 1 : 0);
                    break;
                }
                case 64: {
                    this.setValue(64, entityClientPlayerMP.func_70093_af() ? 1 : 0);
                    break;
                }
                case 65: {
                    this.setValue(65, entityClientPlayerMP.field_70160_al ? 1 : 0);
                    break;
                }
                case 66: {
                    this.setValue(66, entityClientPlayerMP.func_71039_bw() ? 1 : 0);
                    break;
                }
                case 67: {
                    this.setValue(67, entityClientPlayerMP.func_70115_ae() ? 1 : 0);
                    break;
                }
                case 68: {
                    this.setValue(68, entityClientPlayerMP.field_70154_o != null && entityClientPlayerMP.field_70154_o.getClass() == EntityMinecartEmpty.class ? 1 : 0);
                    break;
                }
                case 69: {
                    this.setValue(69, entityClientPlayerMP.field_70154_o != null && entityClientPlayerMP.field_70154_o.getClass() == EntityBoat.class ? 1 : 0);
                    break;
                }
                case 70: {
                    this.setValue(70, xpzm2._j != null && xpzm2._j._i() ? 1 : 0);
                    break;
                }
                case 71: {
                    int n7 = entityClientPlayerMP.field_70154_o != null ? (int)Math.round(entityClientPlayerMP.field_70154_o.field_70159_w * 1000.0) : 0;
                    this.setValue(71, n7);
                    break;
                }
                case 72: {
                    int n8 = entityClientPlayerMP.field_70154_o != null ? (int)Math.round(entityClientPlayerMP.field_70154_o.field_70181_x * 1000.0) : 0;
                    this.setValue(72, n8);
                    break;
                }
                case 73: {
                    int n9 = entityClientPlayerMP.field_70154_o != null ? (int)Math.round(entityClientPlayerMP.field_70154_o.field_70179_y * 1000.0) : 0;
                    this.setValue(73, n9);
                    break;
                }
                case 74: {
                    int n10 = entityClientPlayerMP.field_70154_o != null ? (int)Math.round(entityClientPlayerMP.field_70154_o.field_70159_w * 1000.0) : 0;
                    int n11 = entityClientPlayerMP.field_70154_o != null ? (int)Math.round(entityClientPlayerMP.field_70154_o.field_70179_y * 1000.0) : 0;
                    this.setValue(74, entityClientPlayerMP.field_70154_o != null ? (int)Math.floor(Math.sqrt(n10 * n10 + n11 * n11)) : 0);
                    break;
                }
                case 86: {
                    this.setValue(86, bl ? pkix2.func_72798_a(xpzm2._L._d, xpzm2._L._e, xpzm2._L._f) : 0);
                    break;
                }
                case 87: {
                    this.setValue(87, bl ? pkix2.func_72805_g(xpzm2._L._d, xpzm2._L._e, xpzm2._L._f) : 0);
                    break;
                }
                case 89: {
                    this.setValue(89, entityClientPlayerMP.field_71071_by._b[0] != null ? entityClientPlayerMP.field_71071_by._b[0]._d : -1);
                    break;
                }
                case 90: {
                    this.setValue(90, entityClientPlayerMP.field_71071_by._b[1] != null ? entityClientPlayerMP.field_71071_by._b[1]._d : -1);
                    break;
                }
                case 91: {
                    this.setValue(91, entityClientPlayerMP.field_71071_by._b[2] != null ? entityClientPlayerMP.field_71071_by._b[2]._d : -1);
                    break;
                }
                case 92: {
                    this.setValue(92, entityClientPlayerMP.field_71071_by._b[3] != null ? entityClientPlayerMP.field_71071_by._b[3]._d : -1);
                    break;
                }
                case 94: {
                    this.setValue(94, n2 >= 0 && n2 < this.mod().util().getWorldHeight() ? this.getTranslatedBlockId(xpzm2._r.func_72798_a(n, n2, n3)) : -1);
                    break;
                }
                case 95: {
                    this.setValue(95, n2 >= 0 && n2 < this.mod().util().getWorldHeight() - 1 ? this.getTranslatedBlockId(xpzm2._r.func_72798_a(n, n2 + 1, n3)) : -1);
                    break;
                }
                case 96: {
                    cvzo cvzo2 = entityClientPlayerMP.field_71071_by._a();
                    this.setValue(96, cvzo2 != null ? cvzo2._d : -1);
                    break;
                }
                case 97: {
                    this.setValue(97, xpzm2._B != null && xpzm2._B instanceof zybc ? 1 : 0);
                    break;
                }
                case 100: {
                    this.setValue(100, entityClientPlayerMP.field_70154_o != null && entityClientPlayerMP.field_70154_o instanceof EntityHorse ? 1 : 0);
                    break;
                }
            }
        }
    }

    private int getTranslatedBlockId(int n) {
        if (n < 0) {
            return 0;
        }
        if (n >= 4096) {
            return 0;
        }
        return n;
    }
}

