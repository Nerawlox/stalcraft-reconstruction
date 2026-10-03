/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.shop;

import net.minecraft.entity.player.EntityPlayer;

public class zwat
extends tehy {
    public static final String _a = "donateinv";
    private xqsf _b;

    public zwat(ccxr ccxr2) {
        super(ccxr2);
    }

    @Override
    public void resetHandler() {
        if (this._b == null) {
            this._b = new dghc();
        }
    }

    public xqsf _a() {
        return this._b;
    }

    public cvzo _a(cvzo cvzo2) {
        return zwat._a(cvzo2, this.player.field_71092_bJ);
    }

    public static cvzo _a(cvzo cvzo2, String string) {
        if (cvzo2._e == null) {
            cvzo2._e = new qoac();
        }
        cvzo2._e._a("buyer", string);
        return cvzo2;
    }

    public static zwat _a(EntityPlayer entityPlayer) {
        return (zwat)ncwh._a((EntityPlayer)entityPlayer)._h.get(_a);
    }

    public static xqsf _b(EntityPlayer entityPlayer) {
        return ((zwat)ncwh._a((EntityPlayer)entityPlayer)._h.get(_a))._a();
    }
}

