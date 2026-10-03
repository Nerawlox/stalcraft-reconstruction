/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.mcsa;

import gloomyfolken.mods.effects.client.mcsa.ugqx;
import gloomyfolken.mods.effects.client.mcsa.zwat;
import java.util.function.Predicate;

class vjta
implements zwat {
    protected ugqx.kjui[] _a;
    protected final boolean _b;
    protected final boolean _c;

    public vjta(boolean bl, boolean bl2, ugqx.kjui[] kjuiArray) {
        this._a = kjuiArray;
        this._b = bl;
        this._c = bl2;
    }

    @Override
    public void renderAll(cucv cucv2) {
        for (ugqx.kjui kjui2 : this._a) {
            this._a(kjui2, cucv2);
        }
    }

    @Override
    public void renderOnly(Predicate<String> predicate, cucv cucv2) {
        for (ugqx.kjui kjui2 : this._a) {
            if (!predicate.test(kjui2._c._l)) continue;
            this._a(kjui2, cucv2);
        }
    }

    @Override
    public void renderPart(String string, cucv cucv2) {
        for (ugqx.kjui kjui2 : this._a) {
            if (!string.equals(kjui2._c._l)) continue;
            this._a(kjui2, cucv2);
        }
    }

    @Override
    public void renderPart(int n, cucv cucv2) {
        if (n < this._a.length) {
            ugqx.kjui kjui2 = this._a[n];
            this._a(kjui2, cucv2);
        }
    }

    protected void _a(ugqx.kjui kjui2, cucv cucv2) {
        if (kjui2 == null) {
            return;
        }
        kjui2._a(this._b, this._c, cucv2);
    }
}

