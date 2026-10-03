/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.misc.ezfa;
import gloomyfolken.mods.core.misc.kjwj;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ezfc;

public class aofd
extends kjwj
implements ezfa {
    private final int _b;

    public aofd(int n, String string, List<String> list, int n2, int n3) {
        super(n, "Blueprint", string, list, n2);
        this._b = n3;
    }

    public int _a() {
        return this._b;
    }

    @Override
    public String func_77628_j(cvzo cvzo2) {
        hsvw hsvw2 = this._b();
        return "\u0427\u0435\u0440\u0442\u0435\u0436: " + (Object)((Object)ezfc._o) + (hsvw2 != null ? hsvw2._e() : "unknown") + (Object)((Object)ezfc._v);
    }

    public hsvw _b() {
        return hszb._a._a(this._b);
    }

    @Override
    public boolean _a_(cvzo cvzo2) {
        return false;
    }

    @Override
    public boolean _l_(cvzo cvzo2) {
        return true;
    }

    @Override
    public String _d_(cvzo cvzo2) {
        return "\u041d\u0430\u0436\u043c\u0438\u0442\u0435 <\u041f\u041a\u041c> \u0447\u0442\u043e\u0431\u044b \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c";
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public gqjz _a(gqjz gqjz2, EntityPlayer entityPlayer, cvzo cvzo2, int n) {
        return new ejnl(gqjz2, entityPlayer, n);
    }
}

