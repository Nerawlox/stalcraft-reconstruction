/*
 * Decompiled with CFR 0.152.
 */
package mods.regions;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;

public class RegionsPlayerHandler
extends tehy {
    public static final String ID = "SelectionHandler";
    public einh selectionA;
    public einh selectionB;
    public String selectedRegion;
    public Map<String, Boolean> regionsState = new HashMap<String, Boolean>();

    public RegionsPlayerHandler(ccxr ccxr2) {
        super(ccxr2);
    }

    public static RegionsPlayerHandler getSelection(EntityPlayer entityPlayer) {
        return (RegionsPlayerHandler)ncwh._a((EntityPlayer)entityPlayer)._h.get(ID);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.player.field_70170_p.field_72995_K) {
            return;
        }
        InvokeSideOnly.frontend(() -> {});
    }

    public void showSize() {
        if (this.selectionA == null || this.selectionB == null) {
            return;
        }
        einh einh2 = this.selectionA;
        einh einh3 = this.selectionB;
        int n = (int)((Math.max(einh3._c, einh2._c) - Math.min(einh3._c, einh2._c) + 1.0) * (Math.max(einh3._d, einh2._d) - Math.min(einh3._d, einh2._d) + 1.0) * (Math.max(einh3._e, einh2._e) - Math.min(einh3._e, einh2._e) + 1.0));
        this.player.func_71035_c("\u041e\u0431\u044a\u0435\u043c \u0432\u044b\u0434\u0435\u043b\u0435\u043d\u0438\u044f: " + n + " \u0431\u043b.");
    }

    public void showSelection(int n) {
        einh einh2 = null;
        if (n == 0) {
            einh2 = this.selectionA;
        } else if (n == 1) {
            einh2 = this.selectionB;
        }
        if (einh2 != null) {
            String string = String.format("\u0412\u044b\u0434\u0435\u043b\u0435\u043d\u0438\u0435 %d: %.2f, %.2f, %.2f (\u043c\u0438\u0440 %d)", n + 1, einh2._c, einh2._d, einh2._e, einh2._b);
            this.player.func_71035_c(string);
        }
    }
}

