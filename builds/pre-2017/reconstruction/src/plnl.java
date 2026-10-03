/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.pibk;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;

public class plnl {
    public final WorldChunkManager _a;
    public long _b;
    public pibk _c = new pibk();
    public List _d = new ArrayList();

    public plnl(WorldChunkManager worldChunkManager) {
        this._a = worldChunkManager;
    }

    public dzlw _a(int n, int n2) {
        long l = (long)(n >>= 4) & 0xFFFFFFFFL | ((long)(n2 >>= 4) & 0xFFFFFFFFL) << 32;
        dzlw dzlw2 = (dzlw)this._c._b(l);
        if (dzlw2 == null) {
            dzlw2 = new dzlw(this, n, n2);
            this._c._a(l, dzlw2);
            this._d.add(dzlw2);
        }
        dzlw2._f = MinecraftServer.__aq();
        return dzlw2;
    }

    public BiomeGenBase _b(int n, int n2) {
        return this._a(n, n2)._a(n, n2);
    }

    public void _a() {
        long l = MinecraftServer.__aq();
        long l2 = l - this._b;
        if (l2 > 7500L || l2 < 0L) {
            this._b = l;
            for (int i = 0; i < this._d.size(); ++i) {
                dzlw dzlw2 = (dzlw)this._d.get(i);
                long l3 = l - dzlw2._f;
                if (l3 <= 30000L && l3 >= 0L) continue;
                this._d.remove(i--);
                long l4 = (long)dzlw2._d & 0xFFFFFFFFL | ((long)dzlw2._e & 0xFFFFFFFFL) << 32;
                this._c._e(l4);
            }
        }
    }

    public BiomeGenBase[] _c(int n, int n2) {
        return this._a((int)n, (int)n2)._c;
    }

    public static /* synthetic */ WorldChunkManager _a(plnl plnl2) {
        return plnl2._a;
    }
}

