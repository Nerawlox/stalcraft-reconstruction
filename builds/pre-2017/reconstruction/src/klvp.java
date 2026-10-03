/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;
import net.minecraft.client.gui.achievement.GuiSlotStatsItem;
import net.minecraft.stats.StatBase;

public class klvp
implements Comparator {
    public final /* synthetic */ uzta _a;
    public final /* synthetic */ GuiSlotStatsItem _b;

    public klvp(GuiSlotStatsItem guiSlotStatsItem, uzta uzta2) {
        this._b = guiSlotStatsItem;
        this._a = uzta2;
    }

    public int _a(huss huss2, huss huss3) {
        int n = huss2._a();
        int n2 = huss3._a();
        StatBase statBase = null;
        StatBase statBase2 = null;
        if (this._b._d == 0) {
            statBase = dzif._F[n];
            statBase2 = dzif._F[n2];
        } else if (this._b._d == 1) {
            statBase = dzif._D[n];
            statBase2 = dzif._D[n2];
        } else if (this._b._d == 2) {
            statBase = dzif._E[n];
            statBase2 = dzif._E[n2];
        }
        if (statBase != null || statBase2 != null) {
            int n3;
            if (statBase == null) {
                return 1;
            }
            if (statBase2 == null) {
                return -1;
            }
            int n4 = uzta._c(this._b._g)._a(statBase);
            if (n4 != (n3 = uzta._c(this._b._g)._a(statBase2))) {
                return (n4 - n3) * this._b._e;
            }
        }
        return n - n2;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this._a((huss)object, (huss)object2);
    }
}

