/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;

public class yvgb
implements Comparator {
    public double _a;
    public double _b;
    public double _c;

    public yvgb(Entity entity) {
        this._a = -entity.posX;
        this._b = -entity.posY;
        this._c = -entity.posZ;
    }

    public int _a(WorldRenderer worldRenderer, WorldRenderer worldRenderer2) {
        double d = (double)worldRenderer.posXPlus + this._a;
        double d2 = (double)worldRenderer.posYPlus + this._b;
        double d3 = (double)worldRenderer.posZPlus + this._c;
        double d4 = (double)worldRenderer2.posXPlus + this._a;
        double d5 = (double)worldRenderer2.posYPlus + this._b;
        double d6 = (double)worldRenderer2.posZPlus + this._c;
        return (int)((d * d + d2 * d2 + d3 * d3 - (d4 * d4 + d5 * d5 + d6 * d6)) * 1024.0);
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this._a((WorldRenderer)object, (WorldRenderer)object2);
    }
}

