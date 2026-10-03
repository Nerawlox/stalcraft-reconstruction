/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.misc;

import net.minecraft.entity.player.EntityPlayer;

public class ugqx {
    public EntityPlayer _a;
    public String _b;
    public int _c;
    public int _d;
    public xafi _e;

    public ugqx(EntityPlayer entityPlayer) {
        this._a = entityPlayer;
        this._e = new xafi();
    }

    public ugqx(EntityPlayer entityPlayer, String string, int n, int n2, xafi xafi2) {
        this._c = n;
        this._d = n2;
        this._e = xafi2;
        this._a = entityPlayer;
        this._b = string;
    }

    public void _a(qoac qoac2) {
        qoac qoac3 = new qoac();
        this._e._a(qoac3);
        qoac2._a("duration", this._d);
        qoac2._a("properties", (huhy)qoac3);
        qoac2._a("reason", this._b);
    }

    public void _b(qoac qoac2) {
        qoac qoac3 = qoac2._m("properties");
        this._e._b(qoac3);
        this._d = qoac2._f("duration");
        this._b = qoac2._j("reason");
    }
}

