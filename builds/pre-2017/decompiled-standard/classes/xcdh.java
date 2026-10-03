/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.passive.EntityWolf;

public class xcdh
extends foqh {
    public xcdh(int n) {
        super(n);
        this._K.add(new yffo(EntityWolf.class, 5, 4, 4));
        this._I.field_76832_z = 10;
        this._I.field_76803_B = 2;
    }

    @Override
    public zzpm _a(Random random) {
        if (random.nextInt(5) == 0) {
            return this._S;
        }
        if (random.nextInt(10) == 0) {
            return this._R;
        }
        return this._Q;
    }
}

