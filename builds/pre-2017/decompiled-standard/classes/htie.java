/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.util.dwan;

public class htie
extends twgu {
    public static final String[] _a = new String[]{"stone", "cobble", "brick"};

    public htie(int n) {
        super(n, tflj._A);
        this.func_71848_c(0.0f);
        this.func_71849_a(tgbl.field_78031_c);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n2 == 1) {
            return twgu.field_71978_w.func_71851_a(n);
        }
        if (n2 == 2) {
            return twgu.field_72007_bm.func_71851_a(n);
        }
        return twgu.field_71981_t.func_71851_a(n);
    }

    @Override
    public void func_94332_a(nege nege2) {
    }

    @Override
    public void func_71898_d(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (!ozlu2.field_72995_K) {
            EntitySilverfish entitySilverfish = new EntitySilverfish(ozlu2);
            entitySilverfish.func_70012_b((double)n + 0.5, n2, (double)n3 + 0.5, 0.0f, 0.0f);
            ozlu2.func_72838_d(entitySilverfish);
            entitySilverfish.func_70656_aK();
        }
        super.func_71898_d(ozlu2, n, n2, n3, n4);
    }

    @Override
    public int func_71925_a(Random random) {
        return 0;
    }

    public static boolean _a(int n) {
        return n == twgu.field_71981_t.field_71990_ca || n == twgu.field_71978_w.field_71990_ca || n == twgu.field_72007_bm.field_71990_ca;
    }

    public static int _b(int n) {
        if (n == twgu.field_71978_w.field_71990_ca) {
            return 1;
        }
        if (n == twgu.field_72007_bm.field_71990_ca) {
            return 2;
        }
        return 0;
    }

    @Override
    public cvzo func_71880_c_(int n) {
        twgu twgu2 = twgu.field_71981_t;
        if (n == 1) {
            twgu2 = twgu.field_71978_w;
        }
        if (n == 2) {
            twgu2 = twgu.field_72007_bm;
        }
        return new cvzo(twgu2);
    }

    @Override
    public int func_71873_h(ozlu ozlu2, int n, int n2, int n3) {
        return ozlu2.func_72805_g(n, n2, n3);
    }

    @Override
    public void func_71879_a(int n, tgbl tgbl2, List list2) {
        for (int i = 0; i < 3; ++i) {
            list2.add(new cvzo(n, 1, i));
        }
    }
}

