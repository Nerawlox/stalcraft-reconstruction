/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public class sdgq
extends tgdv {
    public sdgq(int n) {
        super(n);
        this.func_77625_d(1);
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        entityPlayer.func_71048_c(cvzo2);
        return cvzo2;
    }

    @Override
    public boolean func_77651_p() {
        return true;
    }

    public static boolean _a(qoac qoac2) {
        if (qoac2 == null) {
            return false;
        }
        if (!qoac2._c("pages")) {
            return false;
        }
        bsyv bsyv2 = (bsyv)qoac2._b("pages");
        for (int i = 0; i < bsyv2._d(); ++i) {
            xsxy xsxy2 = (xsxy)bsyv2._b(i);
            if (xsxy2._c == null) {
                return false;
            }
            if (xsxy2._c.length() <= 256) continue;
            return false;
        }
        return true;
    }
}

