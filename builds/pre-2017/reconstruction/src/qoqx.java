/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class qoqx
extends WorldGenerator {
    public int _a;
    public int _b = 0;
    public int _c;
    public int _d;

    public qoqx(int n, int n2) {
        this(n, n2, Block.stone.blockID);
    }

    public qoqx(int n, int n2, int n3) {
        this._a = n;
        this._c = n2;
        this._d = n3;
    }

    public qoqx(int n, int n2, int n3, int n4) {
        this(n, n3, n4);
        this._b = n2;
    }

    @Override
    public boolean _a(World world, Random random, int n, int n2, int n3) {
        float f = random.nextFloat() * (float)Math.PI;
        double d = (float)(n + 8) + sajh._a(f) * (float)this._c / 8.0f;
        double d2 = (float)(n + 8) - sajh._a(f) * (float)this._c / 8.0f;
        double d3 = (float)(n3 + 8) + sajh._b(f) * (float)this._c / 8.0f;
        double d4 = (float)(n3 + 8) - sajh._b(f) * (float)this._c / 8.0f;
        double d5 = n2 + random.nextInt(3) - 2;
        double d6 = n2 + random.nextInt(3) - 2;
        for (int i = 0; i <= this._c; ++i) {
            double d7 = d + (d2 - d) * (double)i / (double)this._c;
            double d8 = d5 + (d6 - d5) * (double)i / (double)this._c;
            double d9 = d3 + (d4 - d3) * (double)i / (double)this._c;
            double d10 = random.nextDouble() * (double)this._c / 16.0;
            double d11 = (double)(sajh._a((float)i * (float)Math.PI / (float)this._c) + 1.0f) * d10 + 1.0;
            double d12 = (double)(sajh._a((float)i * (float)Math.PI / (float)this._c) + 1.0f) * d10 + 1.0;
            int n4 = sajh._c(d7 - d11 / 2.0);
            int n5 = sajh._c(d8 - d12 / 2.0);
            int n6 = sajh._c(d9 - d11 / 2.0);
            int n7 = sajh._c(d7 + d11 / 2.0);
            int n8 = sajh._c(d8 + d12 / 2.0);
            int n9 = sajh._c(d9 + d11 / 2.0);
            for (int j = n4; j <= n7; ++j) {
                double d13 = ((double)j + 0.5 - d7) / (d11 / 2.0);
                if (!(d13 * d13 < 1.0)) continue;
                for (int k = n5; k <= n8; ++k) {
                    double d14 = ((double)k + 0.5 - d8) / (d12 / 2.0);
                    if (!(d13 * d13 + d14 * d14 < 1.0)) continue;
                    for (int i2 = n6; i2 <= n9; ++i2) {
                        double d15 = ((double)i2 + 0.5 - d9) / (d11 / 2.0);
                        Block block = Block.blocksList[world.getBlockId(j, k, i2)];
                        if (!(d13 * d13 + d14 * d14 + d15 * d15 < 1.0) || block == null || !block.isGenMineableReplaceable(world, j, k, i2, this._d)) continue;
                        world.setBlock(j, k, i2, this._a, this._b, 2);
                    }
                }
            }
        }
        return true;
    }
}

