/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.money;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.mods.money.ezey;
import gloomyfolken.mods.money.zwat;
import net.minecraft.client.xpzm;
import net.minecraftforge.event.ForgeSubscribe;

public class pidb {
    @ForgeSubscribe
    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    public void _a(lnrm.kjui kjui2) {
        if (kjui2._c == lnrm.pidb._b) {
            xpzm xpzm2 = xpzm._E();
            if (xpzm2._t != null && xpzm2._B instanceof cebg) {
                boolean bl = false;
                for (jiok jiok2 : xpzm2._B.field_73887_h) {
                    if (!(jiok2 instanceof ezey)) continue;
                    bl = true;
                    break;
                }
                if (!bl) {
                    String string = "\u0421\u0447\u0435\u0442: " + zwat._a(xpzm2._t)._b();
                    int n = xpzm2._B.field_73880_f - xpzm2._z._b(string) - 2;
                    int n2 = xpzm2._B.field_73881_g - xpzm2._z._c - 2;
                    xpzm2._B.field_73887_h.add(new ezey(n, n2, string));
                }
            }
        }
    }

    @ForgeSubscribe
    public void _a(mquk mquk2) {
        mquk2._a("money", new zwat(mquk2._a));
    }
}

