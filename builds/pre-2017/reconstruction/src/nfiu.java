/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ForgeDirection;

public class nfiu
extends WorldGenerator {
    public static final byte[] _a = new byte[]{2, 0, 0, 1, 2, 1};
    public Random _b = new Random();
    public World _c;
    public int[] _d = new int[]{0, 0, 0};
    public int _e;
    public int _f;
    public double _g = 0.618;
    public double _h = 1.0;
    public double _i = 0.381;
    public double _j = 1.0;
    public double _k = 1.0;
    public int _l = 1;
    public int _m = 12;
    public int _n = 4;
    public int[][] _o;

    public nfiu(boolean bl) {
        super(bl);
    }

    public void _a() {
        int n;
        this._f = (int)((double)this._e * this._g);
        if (this._f >= this._e) {
            this._f = this._e - 1;
        }
        if ((n = (int)(1.382 + Math.pow(this._k * (double)this._e / 13.0, 2.0))) < 1) {
            n = 1;
        }
        int[][] nArray = new int[n * this._e][4];
        int n2 = this._d[1] + this._e - this._n;
        int n3 = 1;
        int n4 = this._d[1] + this._f;
        int n5 = n2 - this._d[1];
        nArray[0][0] = this._d[0];
        nArray[0][1] = n2--;
        nArray[0][2] = this._d[2];
        nArray[0][3] = n4;
        while (n5 >= 0) {
            float f = this._a(n5);
            if (f < 0.0f) {
                --n2;
                --n5;
                continue;
            }
            double d = 0.5;
            for (int i = 0; i < n; ++i) {
                int[] nArray2;
                int n6;
                double d2;
                double d3 = this._j * (double)f * ((double)this._b.nextFloat() + 0.328);
                int n7 = sajh._c(d3 * Math.sin(d2 = (double)this._b.nextFloat() * 2.0 * Math.PI) + (double)this._d[0] + d);
                int[] nArray3 = new int[]{n7, n2, n6 = sajh._c(d3 * Math.cos(d2) + (double)this._d[2] + d)};
                if (this._a(nArray3, nArray2 = new int[]{n7, n2 + this._n, n6}) != -1) continue;
                int[] nArray4 = new int[]{this._d[0], this._d[1], this._d[2]};
                double d4 = Math.sqrt(Math.pow(Math.abs(this._d[0] - nArray3[0]), 2.0) + Math.pow(Math.abs(this._d[2] - nArray3[2]), 2.0));
                double d5 = d4 * this._i;
                nArray4[1] = (double)nArray3[1] - d5 > (double)n4 ? n4 : (int)((double)nArray3[1] - d5);
                if (this._a(nArray4, nArray3) != -1) continue;
                nArray[n3][0] = n7;
                nArray[n3][1] = n2;
                nArray[n3][2] = n6;
                nArray[n3][3] = nArray4[1];
                ++n3;
            }
            --n2;
            --n5;
        }
        this._o = new int[n3][4];
        System.arraycopy(nArray, 0, this._o, 0, n3);
    }

    public void _a(int n, int n2, int n3, float f, byte by, int n4) {
        int n5 = (int)((double)f + 0.618);
        byte by2 = _a[by];
        byte by3 = _a[by + 3];
        int[] nArray = new int[]{n, n2, n3};
        int[] nArray2 = new int[]{0, 0, 0};
        int n6 = -n5;
        nArray2[by] = nArray[by];
        for (int i = -n5; i <= n5; ++i) {
            nArray2[by2] = nArray[by2] + i;
            n6 = -n5;
            while (n6 <= n5) {
                double d = Math.pow((double)Math.abs(i) + 0.5, 2.0) + Math.pow((double)Math.abs(n6) + 0.5, 2.0);
                if (d > (double)(f * f)) {
                    ++n6;
                    continue;
                }
                nArray2[by3] = nArray[by3] + n6;
                int n7 = this._c.getBlockId(nArray2[0], nArray2[1], nArray2[2]);
                Block block = Block.blocksList[n7];
                if (block != null && !block.isAirBlock(this._c, nArray2[0], nArray2[1], nArray2[2]) && !block.isLeaves(this._c, nArray2[0], nArray2[1], nArray2[2])) {
                    ++n6;
                    continue;
                }
                this._a(this._c, nArray2[0], nArray2[1], nArray2[2], n4, 0);
                ++n6;
            }
        }
    }

    public float _a(int n) {
        if ((double)n < (double)this._e * 0.3) {
            return -1.618f;
        }
        float f = (float)this._e / 2.0f;
        float f2 = (float)this._e / 2.0f - (float)n;
        float f3 = f2 == 0.0f ? f : (Math.abs(f2) >= f ? 0.0f : (float)Math.sqrt(Math.pow(Math.abs(f), 2.0) - Math.pow(Math.abs(f2), 2.0)));
        return f3 *= 0.5f;
    }

    public float _b(int n) {
        return n >= 0 && n < this._n ? (n != 0 && n != this._n - 1 ? 3.0f : 2.0f) : -1.0f;
    }

    public void _a(int n, int n2, int n3) {
        int n4 = n2 + this._n;
        for (int i = n2; i < n4; ++i) {
            float f = this._b(i - n2);
            this._a(n, i, n3, f, (byte)1, Block.leaves.blockID);
        }
    }

    public void _a(int[] nArray, int[] nArray2, int n) {
        int[] nArray3 = new int[]{0, 0, 0};
        int n2 = 0;
        for (int n3 = 0; n3 < 3; n3 = (int)((byte)(n3 + 1))) {
            nArray3[n3] = nArray2[n3] - nArray[n3];
            if (Math.abs(nArray3[n3]) <= Math.abs(nArray3[n2])) continue;
            n2 = n3;
        }
        if (nArray3[n2] != 0) {
            byte by = _a[n2];
            byte by2 = _a[n2 + 3];
            int n4 = nArray3[n2] > 0 ? 1 : -1;
            double d = (double)nArray3[by] / (double)nArray3[n2];
            double d2 = (double)nArray3[by2] / (double)nArray3[n2];
            int[] nArray4 = new int[]{0, 0, 0};
            int n5 = nArray3[n2] + n4;
            for (int i = 0; i != n5; i += n4) {
                int n6;
                nArray4[n2] = sajh._c((double)(nArray[n2] + i) + 0.5);
                nArray4[by] = sajh._c((double)nArray[by] + (double)i * d + 0.5);
                nArray4[by2] = sajh._c((double)nArray[by2] + (double)i * d2 + 0.5);
                int n7 = 0;
                int n8 = Math.abs(nArray4[0] - nArray[0]);
                int n9 = Math.max(n8, n6 = Math.abs(nArray4[2] - nArray[2]));
                if (n9 > 0) {
                    if (n8 == n9) {
                        n7 = 4;
                    } else if (n6 == n9) {
                        n7 = 8;
                    }
                }
                this._a(this._c, nArray4[0], nArray4[1], nArray4[2], n, n7);
            }
        }
    }

    public void _b() {
        int n = this._o.length;
        for (int i = 0; i < n; ++i) {
            int n2 = this._o[i][0];
            int n3 = this._o[i][1];
            int n4 = this._o[i][2];
            this._a(n2, n3, n4);
        }
    }

    public boolean _c(int n) {
        return (double)n >= (double)this._e * 0.2;
    }

    public void _c() {
        int n = this._d[0];
        int n2 = this._d[1];
        int n3 = this._d[1] + this._f;
        int n4 = this._d[2];
        int[] nArray = new int[]{n, n2, n4};
        int[] nArray2 = new int[]{n, n3, n4};
        this._a(nArray, nArray2, Block.wood.blockID);
        if (this._l == 2) {
            nArray[0] = nArray[0] + 1;
            nArray2[0] = nArray2[0] + 1;
            this._a(nArray, nArray2, Block.wood.blockID);
            nArray[2] = nArray[2] + 1;
            nArray2[2] = nArray2[2] + 1;
            this._a(nArray, nArray2, Block.wood.blockID);
            nArray[0] = nArray[0] + -1;
            nArray2[0] = nArray2[0] + -1;
            this._a(nArray, nArray2, Block.wood.blockID);
        }
    }

    public void _d() {
        int n = this._o.length;
        int[] nArray = new int[]{this._d[0], this._d[1], this._d[2]};
        for (int i = 0; i < n; ++i) {
            int[] nArray2 = this._o[i];
            int[] nArray3 = new int[]{nArray2[0], nArray2[1], nArray2[2]};
            nArray[1] = nArray2[3];
            int n2 = nArray[1] - this._d[1];
            if (!this._c(n2)) continue;
            this._a(nArray, nArray3, (int)((byte)Block.wood.blockID));
        }
    }

    public int _a(int[] nArray, int[] nArray2) {
        int n;
        int[] nArray3 = new int[]{0, 0, 0};
        int n2 = 0;
        for (int n3 = 0; n3 < 3; n3 = (int)((byte)(n3 + 1))) {
            nArray3[n3] = nArray2[n3] - nArray[n3];
            if (Math.abs(nArray3[n3]) <= Math.abs(nArray3[n2])) continue;
            n2 = n3;
        }
        if (nArray3[n2] == 0) {
            return -1;
        }
        byte by = _a[n2];
        byte by2 = _a[n2 + 3];
        int n4 = nArray3[n2] > 0 ? 1 : -1;
        double d = (double)nArray3[by] / (double)nArray3[n2];
        double d2 = (double)nArray3[by2] / (double)nArray3[n2];
        int[] nArray4 = new int[]{0, 0, 0};
        int n5 = nArray3[n2] + n4;
        for (n = 0; n != n5; n += n4) {
            nArray4[n2] = nArray[n2] + n;
            nArray4[by] = sajh._c((double)nArray[by] + (double)n * d);
            nArray4[by2] = sajh._c((double)nArray[by2] + (double)n * d2);
            int n6 = this._c.getBlockId(nArray4[0], nArray4[1], nArray4[2]);
            Block block = Block.blocksList[n6];
            if (block != null && !block.isAirBlock(this._c, nArray4[0], nArray4[1], nArray4[2]) && !block.isLeaves(this._c, nArray4[0], nArray4[1], nArray4[2])) break;
        }
        return n == n5 ? -1 : Math.abs(n);
    }

    public boolean _e() {
        boolean bl;
        int[] nArray = new int[]{this._d[0], this._d[1], this._d[2]};
        int[] nArray2 = new int[]{this._d[0], this._d[1] + this._e - 1, this._d[2]};
        int n = this._c.getBlockId(this._d[0], this._d[1] - 1, this._d[2]);
        Block block = Block.blocksList[n];
        boolean bl2 = bl = block != null && block.canSustainPlant(this._c, this._d[0], this._d[1] - 1, this._d[2], ForgeDirection.UP, (rqeh)Block.sapling);
        if (!bl) {
            return false;
        }
        int n2 = this._a(nArray, nArray2);
        if (n2 == -1) {
            return true;
        }
        if (n2 < 6) {
            return false;
        }
        this._e = n2;
        return true;
    }

    @Override
    public void _a(double d, double d2, double d3) {
        this._m = (int)(d * 12.0);
        if (d > 0.5) {
            this._n = 5;
        }
        this._j = d2;
        this._k = d3;
    }

    @Override
    public boolean _a(World world, Random random, int n, int n2, int n3) {
        this._c = world;
        long l = random.nextLong();
        this._b.setSeed(l);
        this._d[0] = n;
        this._d[1] = n2;
        this._d[2] = n3;
        if (this._e == 0) {
            this._e = 5 + this._b.nextInt(this._m);
        }
        if (!this._e()) {
            return false;
        }
        this._a();
        this._b();
        this._c();
        this._d();
        return true;
    }
}

