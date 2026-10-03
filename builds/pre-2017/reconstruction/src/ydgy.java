/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.Point;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ydgy
extends Gui {
    public final int _a;
    public bafe _b;
    private final Point _d;
    private final Dimension _e;
    private final Point _f;
    private final Point _g;
    public ResourceLocation _c;
    private boolean _h = true;
    private int _i = 15;

    public ydgy(int n, bafe bafe2, Point point, Dimension dimension, Point point2, Point point3, ResourceLocation resourceLocation) {
        this._a = n;
        this._b = bafe2;
        this._d = point;
        this._e = dimension;
        this._f = point2;
        this._g = point3;
        this._c = resourceLocation;
    }

    public void _a(int n, int n2, int n3) {
        if (n3 == 0 && this._b(n, n2)) {
            this._b._a(this);
        }
    }

    public void _a(int n, int n2) {
        Minecraft._E()._h._a(this._c);
        boolean bl = this._b(n, n2);
        if (this._h == bl) {
            boolean bl2 = this._h = !this._h;
            if (!this._h) {
                Minecraft._E()._N._a("stalker:hover", 1.0f, 1.0f);
            }
            this._i = 0;
        }
        ++this._i;
        float f = (float)this._i / 15.0f;
        Point point = this._h ? this._g : this._f;
        Point point2 = this._h ? this._f : this._g;
        this._a(point, 1.0f - f);
        this._a(point2, f);
    }

    private float _a() {
        return this._b.height > 400 ? 0.5f : 0.25f;
    }

    public void _a(Point point, float f) {
        double d = 9.765625E-4;
        double d2 = 9.765625E-4;
        double d3 = this._a();
        int n = this._e.width;
        int n2 = this._e.height;
        int n3 = point.x;
        int n4 = point.y;
        double d4 = (double)this._b.width - (double)this._e.width * d3;
        double d5 = (double)this._d.y * d3;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, f);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(d4, d5 + (double)n2 * d3, this.zLevel, (double)n3 * d, (double)(n4 + n2) * d2);
        tessellator.addVertexWithUV(d4 + (double)n * d3, d5 + (double)n2 * d3, this.zLevel, (double)(n3 + n) * d, (double)(n4 + n2) * d2);
        tessellator.addVertexWithUV(d4 + (double)n * d3, d5, this.zLevel, (double)(n3 + n) * d, (double)n4 * d2);
        tessellator.addVertexWithUV(d4, d5, this.zLevel, (double)n3 * d, (double)n4 * d2);
        tessellator.draw();
    }

    private boolean _b(int n, int n2) {
        double d = this._a();
        double d2 = (double)this._b.width - (double)(20 + this._e.width) * d;
        double d3 = (double)this._d.y * d;
        return (double)n >= d2 && (double)n < d2 + (double)this._e.width * d && (double)n2 >= d3 && (double)n2 < d3 + (double)this._e.height * d;
    }
}

