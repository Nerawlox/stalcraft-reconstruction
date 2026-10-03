/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.ForgeSubscribe;
import org.lwjgl.opengl.GL11;

public abstract class ntvb {
    private static final long _d = 500L;
    private qlzo _e = new ycpw()._a(new ivew(zftb._g, 500L, false))._a(new ivew(zftb._a, 1500L, true))._a(new ivew(zftb._f, 300L, true));
    private long _f = 0L;
    private long _g = 0L;
    protected int _a = 0;
    protected int _b = 0;
    protected final int _c;

    public ntvb(int n) {
        this._c = n;
    }

    @ForgeSubscribe
    public void _a(RenderGameOverlayEvent.Post post) {
        if (post.type != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        Minecraft minecraft = Minecraft._E();
        long l = System.currentTimeMillis();
        long l2 = l - this._f;
        if (l2 > this._e._d() - 10L) {
            return;
        }
        long l3 = l - this._g;
        int n = (int)zftb._b._a(Math.min(l3, 500L), this._a, this._b, 500.0f);
        float f = zftb._h._a(l3, 0.0f, 0.1f, 1000.0f) + 0.9f;
        String string = this._a() + (n < 0 ? "" : "+") + this._b(n);
        double d = minecraft._n / 4;
        double d2 = (int)((float)minecraft._o * 4.0f / 5.0f) / 2 + this._c;
        int n2 = this._a(n) + ((int)(this._e._a(l2) * 255.0f) << 24);
        if ((n2 >> 24 & 0xFE) == 0) {
            return;
        }
        GL11.glTranslated(d, d2, 0.0);
        GL11.glScalef(f, f, 1.0f);
        ExternalFont.tahoma16.drawString(string, (double)(-ExternalFont.tahoma16.getStringWidth(string) / 2), 0.0, n2, true);
        GL11.glScalef(1.0f / f, 1.0f / f, 1.0f);
        GL11.glTranslated(-d, -d2, 0.0);
    }

    public abstract int _a(int var1);

    public abstract String _a();

    public String _b(int n) {
        return String.valueOf(n);
    }

    public void _c(int n) {
        long l = System.currentTimeMillis();
        if (l - this._f < this._e._d()) {
            this._g = l;
            this._f = l - 500L;
            this._a += this._b;
            this._b = n;
        } else {
            this._f = l;
            this._g = l;
            this._a = 0;
            this._b = n;
        }
    }
}

