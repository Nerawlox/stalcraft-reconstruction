/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.money;

import gloomyfolken.bundle.common.core.ezey;
import java.text.NumberFormat;
import java.util.Locale;

@ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
public class eidj
extends ntvb {
    private NumberFormat _d = NumberFormat.getNumberInstance(Locale.ENGLISH);

    public eidj() {
        super(0);
    }

    @Override
    public int _a(int n) {
        return 0xFFFFFF;
    }

    @Override
    public String _a() {
        return "\u041f\u043e\u043b\u0443\u0447\u0435\u043d\u043e \u0434\u0435\u043d\u0435\u0433 ";
    }

    @Override
    public String _b(int n) {
        return this._d.format(n) + " \u0440\u0443\u0431.";
    }
}

