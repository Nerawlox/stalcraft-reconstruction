/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.util.dwan;

public class lopk
extends twgu {
    public lopk(int n) {
        super(n, tflj._d);
        this.func_71849_a(tgbl.field_78030_b);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n == 1 || n == 0) {
            return twgu.field_71988_x.func_71851_a(n);
        }
        return super.func_71858_a(n, n2);
    }

    @Override
    public int func_71925_a(Random random) {
        return 3;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return tgdv.field_77760_aL.field_77779_bT;
    }
}

