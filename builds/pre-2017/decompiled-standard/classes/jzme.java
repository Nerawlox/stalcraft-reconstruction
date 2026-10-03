/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.util.sajh;

public class jzme
extends twgu {
    public jzme(int n, tflj tflj2) {
        super(n, tflj2);
        this.func_71849_a(tgbl.field_78030_b);
    }

    @Override
    public int func_71910_a(int n, Random random) {
        return sajh._a(this.func_71925_a(random) + random.nextInt(n + 1), 1, 4);
    }

    @Override
    public int func_71925_a(Random random) {
        return 2 + random.nextInt(3);
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return tgdv.field_77751_aT.field_77779_bT;
    }
}

