/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class zhpf {
    public double _a;
    public double _b;

    public zhpf() {
    }

    public zhpf(double d, double d2) {
        this._a = d;
        this._b = d2;
    }

    public double _a(zhpf zhpf2) {
        double d = this._a - zhpf2._a;
        double d2 = this._b - zhpf2._b;
        return Math.sqrt(d * d + d2 * d2);
    }

    public void _a() {
        double d = this._b();
        this._a /= d;
        this._b /= d;
    }

    public float _b() {
        return sajh._a(this._a * this._a + this._b * this._b);
    }

    public void _b(zhpf zhpf2) {
        this._a -= zhpf2._a;
        this._b -= zhpf2._b;
    }

    public boolean _a(double d, double d2, double d3, double d4) {
        boolean bl = false;
        if (this._a < d) {
            this._a = d;
            bl = true;
        } else if (this._a > d3) {
            this._a = d3;
            bl = true;
        }
        if (this._b < d2) {
            this._b = d2;
            bl = true;
        } else if (this._b > d4) {
            this._b = d4;
            bl = true;
        }
        return bl;
    }

    public int _a(World world) {
        int n = sajh._c(this._a);
        int n2 = sajh._c(this._b);
        for (int i = 256; i > 0; --i) {
            int n3 = world.getBlockId(n, i, n2);
            if (n3 == 0) continue;
            return i + 1;
        }
        return 257;
    }

    public boolean _b(World world) {
        int n = sajh._c(this._a);
        int n2 = sajh._c(this._b);
        for (int i = 256; i > 0; --i) {
            int n3 = world.getBlockId(n, i, n2);
            if (n3 == 0) continue;
            Material material = Block.blocksList[n3].blockMaterial;
            return !material._d() && material != Material._o;
        }
        return false;
    }

    public void _a(Random random, double d, double d2, double d3, double d4) {
        this._a = sajh._a(random, d, d3);
        this._b = sajh._a(random, d2, d4);
    }
}

