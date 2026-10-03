/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.util.dwan;

public class oxzc
extends twgu {
    public dwan _a;

    public oxzc(int n) {
        super(n, tflj._B);
        this.func_71849_a(tgbl.field_78030_b);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n == 1 || n == 0) {
            return this._a;
        }
        return this.field_94336_cN;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return tgdv.field_77738_bf.field_77779_bT;
    }

    @Override
    public int func_71925_a(Random random) {
        return 3 + random.nextInt(5);
    }

    @Override
    public int func_71910_a(int n, Random random) {
        int n2 = this.func_71925_a(random) + random.nextInt(1 + n);
        if (n2 > 9) {
            n2 = 9;
        }
        return n2;
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b(this.func_111023_E() + "_side");
        this._a = nege2._b(this.func_111023_E() + "_top");
    }
}

