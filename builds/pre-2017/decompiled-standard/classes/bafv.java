/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.misc.kjwj;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;

public class bafv
extends kjwj
implements aofo {
    public xafi _b;
    public final float _c;

    public bafv(int n, String string, String string2, List<String> list2, int n2, xafi xafi2, float f) {
        super(n, string, "stalker:" + string2, list2, n2);
        this._b = xafi2;
        this._c = f;
        this.func_77627_a(true);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void func_77633_a(int n, tgbl tgbl2, List list2) {
        for (int i = 0; i < 3; ++i) {
            list2.add(new cvzo(n, 1, i));
        }
    }

    @Override
    public void _a(cvzo cvzo2, EntityPlayer entityPlayer, List<String> list2) {
        if (cvzo2._j() == 0) {
            this._a(list2, "\u041f\u0440\u0438 \u043d\u0435\u0443\u0434\u0430\u0447\u0435 \u0443\u0440\u043e\u0432\u0435\u043d\u044c \u043d\u0435 \u043f\u043e\u043d\u0438\u0436\u0430\u0435\u0442\u0441\u044f");
        } else {
            this._b(list2, "\u041f\u0440\u0438 \u043d\u0435\u0443\u0434\u0430\u0447\u0435 \u0443\u0440\u043e\u0432\u0435\u043d\u044c \u043f\u043e\u043d\u0438\u0436\u0430\u0435\u0442\u0441\u044f \u043d\u0430 " + cvzo2._j());
        }
        list2.addAll(this._b._a());
    }

    @Override
    public xafi _g_(cvzo cvzo2) {
        return this._b;
    }
}

