/*
 * Decompiled with CFR 0.152.
 */
import mods.pda.AchievementHooks;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class dhcu
extends bawa {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/achievement/achievement_background.png");
    public xpzm _b;
    public int _c;
    public int _d;
    public String _e;
    public String _f;
    public nfcl _g;
    public long _h;
    public xsbj _i;
    public boolean _j;

    public dhcu(xpzm xpzm2) {
        this._b = xpzm2;
        this._i = new xsbj();
    }

    public void _a(nfcl nfcl2) {
        this._e = wpcz._a("achievement.get");
        this._f = wpcz._a(nfcl2.func_75970_i());
        this._h = xpzm._M();
        this._g = nfcl2;
        this._j = false;
    }

    public void _b(nfcl nfcl2) {
        this._e = wpcz._a(nfcl2.func_75970_i());
        this._f = nfcl2.func_75989_e();
        this._h = xpzm._M() - 2500L;
        this._g = nfcl2;
        this._j = true;
    }

    public void _a() {
        GL11.glViewport(0, 0, this._b._n, this._b._o);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        this._c = this._b._n;
        this._d = this._b._o;
        htou htou2 = new htou(this._b._M, this._b._n, this._b._o);
        this._c = htou2._a();
        this._d = htou2._b();
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, this._c, this._d, 0.0, 1000.0, 3000.0);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -2000.0f);
    }

    public void _b() {
        AchievementHooks.updateAchievementWindow(this);
    }
}

