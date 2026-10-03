/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChunkCoordinates;

public class ozhb
implements Comparator {
    public final ChunkCoordinates _a;

    public ozhb(ChunkCoordinates chunkCoordinates) {
        this._a = chunkCoordinates;
    }

    public int _a(EntityPlayerMP entityPlayerMP, EntityPlayerMP entityPlayerMP2) {
        double d;
        double d2 = entityPlayerMP.getDistanceSq(this._a._a, this._a._b, this._a._c);
        if (d2 < (d = entityPlayerMP2.getDistanceSq(this._a._a, this._a._b, this._a._c))) {
            return -1;
        }
        if (d2 > d) {
            return 1;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this._a((EntityPlayerMP)object, (EntityPlayerMP)object2);
    }
}

