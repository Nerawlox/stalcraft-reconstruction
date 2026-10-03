/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.util.dwan;

public class uzmt
extends ndvn {
    public static final String[] _b = new String[]{"oak", "spruce", "birch", "jungle"};

    public uzmt(int n, boolean bl) {
        super(n, bl, tflj._d);
        this.func_71849_a(tgbl.field_78030_b);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        return twgu.field_71988_x.func_71858_a(n, n2 & 7);
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return twgu.field_72092_bO.field_71990_ca;
    }

    @Override
    public cvzo func_71880_c_(int n) {
        return new cvzo(twgu.field_72092_bO.field_71990_ca, 2, n & 7);
    }

    @Override
    public String _b(int n) {
        if (n < 0 || n >= _b.length) {
            n = 0;
        }
        return super.func_71917_a() + "." + _b[n];
    }

    @Override
    public void func_71879_a(int n, tgbl tgbl2, List list) {
        if (n == twgu.field_72090_bN.field_71990_ca) {
            return;
        }
        for (int i = 0; i < 4; ++i) {
            list.add(new cvzo(n, 1, i));
        }
    }

    @Override
    public void func_94332_a(nege nege2) {
    }
}

