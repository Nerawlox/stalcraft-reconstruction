/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.Slot;
import org.lwjgl.opengl.GL11;

public class wqlh
implements cfqs {
    private ywry _f;
    public Slot _a;
    public int _b;
    public double _c;
    public int _d;
    public int _e;

    public wqlh(ywry ywry2, Slot slot, int n) {
        this._f = ywry2;
        this._a = slot;
        this._b = n;
        this._e = 16;
        this._d = 16;
        this._c = 1.0;
    }

    @Override
    public double _e() {
        return this._c;
    }

    @Override
    public void _a(double d) {
        this._c = d;
    }

    @Override
    public boolean _j() {
        return true;
    }

    @Override
    public void _c(Minecraft minecraft, int n, int n2) {
        if (this._a == null || this._f == null) {
            return;
        }
        GL11.glEnable(32826);
        qnon._c();
        GL11.glTranslated(this._f.__ag, this._f.__ah, 0.0);
        this._f._a(this._a);
        if (this._f.getSlotAtPosition(n, n2) == this._a && this._a.getHasStack() && this._a.func_111238_b() && this._f.__aF) {
            this._f.__ai = this._a;
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            int n3 = this._a.xDisplayPosition;
            int n4 = this._a.yDisplayPosition;
            GL11.glColorMask(true, true, true, false);
            this._f.drawGradientRect(n3, n4, n3 + 16, n4 + 16, -2130706433, -2130706433);
            GL11.glColorMask(true, true, true, true);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
        }
        GL11.glTranslated(-this._f.__ag, -this._f.__ah, 0.0);
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        qnon._a();
    }

    @Override
    public boolean _g(int n, int n2) {
        return n >= this._a.xDisplayPosition && n <= this._a.xDisplayPosition + this._d && n2 >= this._a.yDisplayPosition && n2 <= this._a.yDisplayPosition + this._e;
    }
}

