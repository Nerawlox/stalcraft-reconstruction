/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.passive.EntityWolf;

public class hdur
extends foqh {
    public hdur(int n) {
        super(n);
        this._K.add(new yffo(EntityWolf.class, 8, 4, 4));
        this._I.field_76832_z = 10;
        this._I.field_76803_B = 1;
    }

    @Override
    public zzpm _a(Random random) {
        if (random.nextInt(3) == 0) {
            return new bthg();
        }
        return new nwmw(false);
    }
}

