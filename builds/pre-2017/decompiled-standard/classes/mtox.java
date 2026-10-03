/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;

@SideOnly(value=Side.CLIENT)
public class mtox
extends thcx {
    protected mtox _b = null;
    protected ArrayList<thcx> _c = new ArrayList();

    public mtox(ywry ywry2, int n) {
        super(ywry2, n);
    }

    public void _a(thcx thcx2) {
        this._c.add(thcx2);
        thcx2._G = this;
        this._F._e(thcx2);
    }

    public void _b(thcx thcx2) {
        this._c.remove(thcx2);
        thcx2._G = null;
    }
}

