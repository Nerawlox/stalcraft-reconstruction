/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.xpzm;

@SideOnly(value=Side.CLIENT)
public class twyn
extends dhji {
    public double _a;
    public double _b;

    public twyn(String string) {
        super(string);
    }

    public void _a() {
        xpzm xpzm2 = xpzm._E();
        if (xpzm2._r != null && xpzm2._t != null) {
            this._a(xpzm2._r, xpzm2._t.field_70165_t, xpzm2._t.field_70161_v, xpzm2._t.field_70177_z, false, false);
        } else {
            this._a(null, 0.0, 0.0, 0.0, true, false);
        }
    }

    public void _a(ozlu ozlu2, double d, double d2, double d3, boolean bl, boolean bl2) {
    }
}

