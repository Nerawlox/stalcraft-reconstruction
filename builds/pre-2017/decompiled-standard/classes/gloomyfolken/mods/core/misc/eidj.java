/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.jxsn;
import net.minecraft.util.sajz;

public class eidj
implements mccn {
    private ozlu _a;

    public eidj(ozlu ozlu2) {
        this._a = ozlu2;
    }

    @Override
    public ixzi _a(int n, int n2) {
        return this._b(n, n2);
    }

    @Override
    public ixzi _b(int n, int n2) {
        ixzi ixzi2 = new ixzi(this._a, n, n2);
        byte[] byArray = ixzi2._l();
        for (int i = 0; i < byArray.length; ++i) {
            byArray[i] = (byte)foqh._h._P;
        }
        ixzi2._d();
        return ixzi2;
    }

    @Override
    public boolean _c(int n, int n2) {
        return true;
    }

    @Override
    public void _a(mccn mccn2, int n, int n2) {
    }

    @Override
    public boolean _a(boolean bl, sajz sajz2) {
        return true;
    }

    @Override
    public void _a() {
    }

    @Override
    public boolean _b() {
        return false;
    }

    @Override
    public boolean _c() {
        return true;
    }

    @Override
    public String _d() {
        return "DummyRandomLevelSource";
    }

    @Override
    public List _a(jxsn jxsn2, int n, int n2, int n3) {
        return new ArrayList(0);
    }

    @Override
    public xtcd _a(ozlu ozlu2, String string, int n, int n2, int n3) {
        return null;
    }

    @Override
    public int _e() {
        return 0;
    }

    @Override
    public void _d(int n, int n2) {
    }
}

