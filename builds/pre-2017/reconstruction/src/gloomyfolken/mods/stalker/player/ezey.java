/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.player;

import gloomyfolken.bundle.common.core.eidj;

@gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
public class ezey
extends nuco {
    private int _c = -1;
    private String _d;

    public ezey(int n, String string) {
        super(n);
        this._d = string;
    }

    @Override
    public boolean _a(jywl.kjui kjui2) {
        if (this._c == -1 && this._d.equals(kjui2._d)) {
            this._c = kjui2._c;
        }
        return this._c == kjui2._c;
    }
}

