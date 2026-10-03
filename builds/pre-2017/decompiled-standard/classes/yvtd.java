/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;

public class yvtd
extends tgha {
    public yvtd(int n, int n2, float f, boolean bl) {
        super(n, n2, f, bl);
        this.func_77627_a(true);
    }

    @Override
    public boolean func_77636_d(cvzo cvzo2) {
        return cvzo2._j() > 0;
    }

    @Override
    public zywl func_77613_e(cvzo cvzo2) {
        if (cvzo2._j() == 0) {
            return zywl._c;
        }
        return zywl._d;
    }

    @Override
    public void func_77849_c(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        if (!ozlu2.field_72995_K) {
            entityPlayer.func_70690_d(new supr(hdpq._x._H, 2400, 0));
        }
        if (cvzo2._j() > 0) {
            if (!ozlu2.field_72995_K) {
                entityPlayer.func_70690_d(new supr(hdpq._l._H, 600, 4));
                entityPlayer.func_70690_d(new supr(hdpq._m._H, 6000, 0));
                entityPlayer.func_70690_d(new supr(hdpq._n._H, 6000, 0));
            }
        } else {
            super.func_77849_c(cvzo2, ozlu2, entityPlayer);
        }
    }

    @Override
    public void func_77633_a(int n, tgbl tgbl2, List list) {
        list.add(new cvzo(n, 1, 0));
        list.add(new cvzo(n, 1, 1));
    }
}

