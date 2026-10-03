/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.EntityLivingBase;

public class jizs
implements Comparator {
    public EntityLivingBase _a;

    public jizs(EntityLivingBase entityLivingBase) {
        this._a = entityLivingBase;
    }

    public int _a(WorldRenderer worldRenderer, WorldRenderer worldRenderer2) {
        double d;
        if (worldRenderer.isInFrustum && !worldRenderer2.isInFrustum) {
            return 1;
        }
        if (worldRenderer2.isInFrustum && !worldRenderer.isInFrustum) {
            return -1;
        }
        double d2 = worldRenderer.distanceToEntitySquared(this._a);
        if (d2 < (d = (double)worldRenderer2.distanceToEntitySquared(this._a))) {
            return 1;
        }
        if (d2 > d) {
            return -1;
        }
        return worldRenderer.chunkIndex < worldRenderer2.chunkIndex ? 1 : -1;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this._a((WorldRenderer)object, (WorldRenderer)object2);
    }
}

