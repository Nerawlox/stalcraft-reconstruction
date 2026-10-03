/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

public class qozr
extends thcx {
    private int _a;
    private int _b;
    private String _c = "";
    private mcmy _d = yfpk._c;

    public qozr(ywry ywry2, int n) {
        super(ywry2, n);
    }

    public void _a(String string) {
        this._c = string;
    }

    public String _a() {
        return this._c;
    }

    public void _a(mcmy mcmy2) {
        this._d = mcmy2;
    }

    @Override
    public void _b(xpzm xpzm2, int n, int n2) {
        GL11.glScaled(0.5, 0.5, 1.0);
        GL11.glTranslated(this._a / 2, -this._b, 0.0);
        this._d._a(this._a(), this._A - 12, 0.0, -4221836, 1.0f);
    }
}

