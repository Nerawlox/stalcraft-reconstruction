/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityOcelot;

public class xteo
extends foqh {
    public xteo(int n) {
        super(n);
        this._I.field_76832_z = 50;
        this._I.field_76803_B = 25;
        this._I.field_76802_A = 4;
        this._J.add(new yffo(EntityOcelot.class, 2, 1, 1));
        this._K.add(new yffo(EntityChicken.class, 10, 4, 4));
    }

    @Override
    public zzpm _a(Random random) {
        if (random.nextInt(10) == 0) {
            return this._R;
        }
        if (random.nextInt(2) == 0) {
            return new rasl(3, 0);
        }
        if (random.nextInt(3) == 0) {
            return new mtgt(false, 10 + random.nextInt(20), 3, 3);
        }
        return new dzqi(false, 4 + random.nextInt(7), 3, 3, true);
    }

    @Override
    public zzpm _b(Random random) {
        if (random.nextInt(4) == 0) {
            return new zinw(twgu.field_71962_X.field_71990_ca, 2);
        }
        return new zinw(twgu.field_71962_X.field_71990_ca, 1);
    }

    @Override
    public void _a(ozlu ozlu2, Random random, int n, int n2) {
        super._a(ozlu2, random, n, n2);
        cflv cflv2 = new cflv();
        for (int i = 0; i < 50; ++i) {
            int n3 = n + random.nextInt(16) + 8;
            int n4 = 64;
            int n5 = n2 + random.nextInt(16) + 8;
            cflv2._a(ozlu2, random, n3, n4, n5);
        }
    }
}

