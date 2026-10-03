/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class yfis {
    public int _a = 8;
    public Random _b = new Random();
    public World _c;

    public void _a(IChunkProvider iChunkProvider, World world, int n, int n2, byte[] byArray) {
        int n3 = this._a;
        this._c = world;
        this._b.setSeed(world.getSeed());
        long l = this._b.nextLong();
        long l2 = this._b.nextLong();
        for (int i = n - n3; i <= n + n3; ++i) {
            for (int j = n2 - n3; j <= n2 + n3; ++j) {
                long l3 = (long)i * l;
                long l4 = (long)j * l2;
                this._b.setSeed(l3 ^ l4 ^ world.getSeed());
                this._a(world, i, j, n, n2, byArray);
            }
        }
    }

    public void _a(World world, int n, int n2, int n3, int n4, byte[] byArray) {
    }
}

