/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.jxtc;

public class ekyk
extends zhqo {
    public ekyk(int n, int n2) {
        super(n, n2, nvsz._e);
        this._a("thorns");
    }

    @Override
    public int _a(int n) {
        return 10 + 20 * (n - 1);
    }

    @Override
    public int _b(int n) {
        return super._a(n) + 50;
    }

    @Override
    public int _c() {
        return 3;
    }

    @Override
    public boolean _a(cvzo cvzo2) {
        if (cvzo2._a() instanceof lpno) {
            return true;
        }
        return super._a(cvzo2);
    }

    public static boolean _a(int n, Random random) {
        if (n <= 0) {
            return false;
        }
        return random.nextFloat() < 0.15f * (float)n;
    }

    public static int _b(int n, Random random) {
        if (n > 10) {
            return n - 10;
        }
        return 1 + random.nextInt(4);
    }

    public static void _a(Entity entity, EntityLivingBase entityLivingBase, Random random) {
        int n = zhty._h(entityLivingBase);
        cvzo cvzo2 = zhty._a(zhqo._j, entityLivingBase);
        if (ekyk._a(n, random)) {
            entity.func_70097_a(jxtc.func_92087_a(entityLivingBase), ekyk._b(n, random));
            entity.func_85030_a("damage.thorns", 0.5f, 1.0f);
            if (cvzo2 != null) {
                cvzo2._a(3, entityLivingBase);
            }
        } else if (cvzo2 != null) {
            cvzo2._a(1, entityLivingBase);
        }
    }
}

