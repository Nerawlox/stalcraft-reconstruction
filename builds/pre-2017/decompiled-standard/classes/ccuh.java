/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.font.SdfFont;
import gloomyfolken.mods.effects.client.main.qlgf;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import org.lwjgl.opengl.GL11;

public class ccuh
extends qlgf.kjui {
    public static qlgf<ccuh> _a = new qlgf<ccuh>(ccuh::new);
    public String[] _b = new String[2];
    public int[] _c = new int[2];
    public float _d;

    @Override
    protected void render(float f) {
        GL11.glPushMatrix();
        ezfc._a();
        ezfc._a(this.modelView);
        ezfc._e();
        GL11.glDisable(2896);
        GL11.glDepthMask(true);
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDepthMask(false);
        SdfFont sdfFont = SdfFont.tahoma;
        SdfFont.FontWeight.Normal normal = SdfFont.FontWeight.Normal.INSTANCE;
        double d = -3.0;
        for (int i = 0; i < this._b.length; ++i) {
            String string = this._b[i];
            if (string == null) continue;
            int n = this._c[i];
            float f2 = sdfFont.getStringWidth(string, this._d) + 4.0f;
            sdfFont.renderString(-f2 / 2.0f, (float)(d -= 3.0), string, 0x20FFFFFFL, true, this._d, normal);
            GL11.glEnable(2929);
            sdfFont.renderString(-f2 / 2.0f, (float)d, string, n, true, this._d, normal);
            GL11.glDisable(2929);
            d += 10.0;
        }
        GL11.glDepthMask(true);
        GL11.glEnable(2896);
        GL11.glEnable(2929);
        GL11.glDisable(3042);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        ezfc._b();
        GL11.glPopMatrix();
    }

    @Override
    protected boolean isSolid() {
        return false;
    }
}

