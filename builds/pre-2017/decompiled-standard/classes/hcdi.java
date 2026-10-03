/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.util.sajh;

public class hcdi
extends twgu {
    public hcdi(int n) {
        super(n, tflj._e);
        this.func_71849_a(tgbl.field_78030_b);
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return this.field_71990_ca == twgu.field_71950_I.field_71990_ca ? tgdv.field_77705_m.field_77779_bT : (this.field_71990_ca == twgu.field_72073_aw.field_71990_ca ? tgdv.field_77702_n.field_77779_bT : (this.field_71990_ca == twgu.field_71947_N.field_71990_ca ? tgdv.field_77756_aW.field_77779_bT : (this.field_71990_ca == twgu.field_72068_bR.field_71990_ca ? tgdv.field_77817_bH.field_77779_bT : (this.field_71990_ca == twgu.field_94342_cr.field_71990_ca ? tgdv.field_94583_ca.field_77779_bT : this.field_71990_ca))));
    }

    @Override
    public int func_71925_a(Random random) {
        return this.field_71990_ca == twgu.field_71947_N.field_71990_ca ? 4 + random.nextInt(5) : 1;
    }

    @Override
    public int func_71910_a(int n, Random random) {
        if (n > 0 && this.field_71990_ca != this.func_71885_a(0, random, n)) {
            int n2 = random.nextInt(n + 2) - 1;
            if (n2 < 0) {
                n2 = 0;
            }
            return this.func_71925_a(random) * (n2 + 1);
        }
        return this.func_71925_a(random);
    }

    @Override
    public void func_71914_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, int n5) {
        super.func_71914_a(ozlu2, n, n2, n3, n4, f, n5);
    }

    @Override
    public int getExpDrop(ozlu ozlu2, int n, int n2) {
        if (this.func_71885_a(n, ozlu2.field_73012_v, n2) != this.field_71990_ca) {
            int n3 = 0;
            if (this.field_71990_ca == twgu.field_71950_I.field_71990_ca) {
                n3 = sajh._a(ozlu2.field_73012_v, 0, 2);
            } else if (this.field_71990_ca == twgu.field_72073_aw.field_71990_ca) {
                n3 = sajh._a(ozlu2.field_73012_v, 3, 7);
            } else if (this.field_71990_ca == twgu.field_72068_bR.field_71990_ca) {
                n3 = sajh._a(ozlu2.field_73012_v, 3, 7);
            } else if (this.field_71990_ca == twgu.field_71947_N.field_71990_ca) {
                n3 = sajh._a(ozlu2.field_73012_v, 2, 5);
            } else if (this.field_71990_ca == twgu.field_94342_cr.field_71990_ca) {
                n3 = sajh._a(ozlu2.field_73012_v, 2, 5);
            }
            return n3;
        }
        return 0;
    }

    @Override
    public int func_71899_b(int n) {
        return this.field_71990_ca == twgu.field_71947_N.field_71990_ca ? 4 : 0;
    }
}

