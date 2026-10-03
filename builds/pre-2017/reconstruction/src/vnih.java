/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Rectangle;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class vnih
extends mtox {
    private Rectangle _a;
    private mcmy _d = yfpk._b;
    private String _e = "";
    private boolean _f;
    private boolean _g;
    private int _h = 0;
    private int _i = 0;

    public vnih(ywry ywry2, int n) {
        super(ywry2, n);
    }

    public String _a() {
        return this._e;
    }

    public void _a(String string) {
        this._e = string;
    }

    public void _b() {
        this._f = !this._f;
    }

    public void _a(boolean bl) {
        this._g = bl;
    }

    public boolean _c() {
        return this._g && this._k();
    }

    @Override
    public void _a(Minecraft minecraft, int n, int n2) {
        this._a(this._f(n, n2));
        double d = 1.0;
        if (this._c()) {
            d -= 0.15;
        }
        if (this._f) {
            d -= 0.1;
        }
        GL11.glColor4d(d, d, d, 1.0);
        qozx._a(0, 0, this._I);
        GL11.glColor4d(1.0, 1.0, 1.0, 1.0);
    }

    @Override
    public void _b(Minecraft minecraft, int n, int n2) {
        GL11.glTranslated(this._h / 4, -this._i / 4, 0.0);
        this._d._a(this._a(), this._A / 2 - 5, this._B / 4, -1, 1.0f);
    }

    @Override
    public void _a(int n, int n2, int n3) {
        this._b();
    }

    @Override
    public void _o() {
        this._f = false;
    }

    @Override
    protected boolean _h() {
        return this._j() && this._f;
    }

    @Override
    protected boolean _i() {
        return this._j() && this._f;
    }
}

