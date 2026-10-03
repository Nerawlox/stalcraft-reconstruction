/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.weapon.ugqx;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ezfc;

public class xrox
extends dxwc {
    public static final String _h = "grenade";
    public final int[] _i;
    public final int _j;
    public final int _k;
    public final String _l;
    public final String _m;
    public final String _n;
    public final String _o;

    public xrox(int n, String string, String string2, List<String> list2, String string3, String string4, String string5, String string6, int[] nArray, int n2, int n3) {
        super(n, string, string2, list2, dxwc.eidj._c);
        this._i = nArray;
        this._l = string3;
        this._m = string4;
        this._n = string5;
        this._o = string6;
        this._j = n2;
        this._k = n3 * 50;
    }

    @ezey(_a={eidj.CLIENT})
    public static void _a(EntityPlayer entityPlayer) {
        cvzo cvzo2 = entityPlayer.func_70694_bm();
        wolf wolf2 = (wolf)cvzo2._a();
        xrox xrox2 = wolf2._a(cvzo2, dxwc.pidb._b, xrox.class);
        ugqx ugqx2 = ugqx._a(entityPlayer);
        if (ugqx2._c(cvzo2) == ugqx.pidb._a) {
            new kljg().sendToServer();
            ugqx2._a(xrox2);
        }
    }

    public boolean _a(int n) {
        for (int n2 : this._i) {
            if (n2 != n) continue;
            return true;
        }
        return false;
    }

    @Override
    public void _a(cvzo cvzo2, EntityPlayer entityPlayer, List<String> list2) {
        if (ncwh._c(cvzo2)._f(_h) != 0) {
            this._a(list2, "\u0417\u0430\u0440\u044f\u0436\u0435\u043d");
        }
        super._a(cvzo2, entityPlayer, list2);
    }

    @Override
    public void _b(cvzo cvzo2, EntityPlayer entityPlayer, List<String> list2) {
        list2.add((Object)((Object)ezfc._r) + "\u041f\u043e\u0434\u0445\u043e\u0434\u044f\u0449\u0438\u0435 \u0431\u043e\u0435\u043f\u0440\u0438\u043f\u0430\u0441\u044b:");
        for (int n : this._i) {
            tgdv tgdv2 = tgdv.field_77698_e[n];
            if (!(tgdv2 instanceof yurw)) continue;
            list2.add(tgdv2.func_77628_j(null));
        }
    }
}

