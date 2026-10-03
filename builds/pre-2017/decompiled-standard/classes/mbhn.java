/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.zwat;

public class mbhn
extends ohnk {
    @Override
    public String func_71517_b() {
        return "effect";
    }

    @Override
    public int func_82362_a() {
        return 2;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.effect.usage";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length < 2) throw new pksd("commands.effect.usage", new Object[0]);
        EntityPlayerMP entityPlayerMP = mbhn.func_82359_c(nemo2, stringArray[0]);
        if (stringArray[1].equals("clear")) {
            if (entityPlayerMP.func_70651_bq().isEmpty()) {
                throw new cekk("commands.effect.failure.notActive.all", entityPlayerMP.func_70023_ak());
            }
            entityPlayerMP.func_70674_bp();
            mbhn.func_71522_a(nemo2, "commands.effect.success.removed.all", entityPlayerMP.func_70023_ak());
            return;
        } else {
            int n = mbhn.func_71528_a(nemo2, stringArray[1], 1);
            int n2 = 600;
            int n3 = 30;
            int n4 = 0;
            if (n < 0 || n >= hdpq._a.length || hdpq._a[n] == null) {
                throw new jjcb("commands.effect.notFound", n);
            }
            if (stringArray.length >= 3) {
                n3 = mbhn.func_71532_a(nemo2, stringArray[2], 0, 1000000);
                n2 = hdpq._a[n]._b() ? n3 : n3 * 20;
            } else if (hdpq._a[n]._b()) {
                n2 = 1;
            }
            if (stringArray.length >= 4) {
                n4 = mbhn.func_71532_a(nemo2, stringArray[3], 0, 255);
            }
            if (n3 == 0) {
                if (!entityPlayerMP.func_82165_m(n)) throw new cekk("commands.effect.failure.notActive", zwat._e(hdpq._a[n]._c()), entityPlayerMP.func_70023_ak());
                entityPlayerMP.func_82170_o(n);
                mbhn.func_71522_a(nemo2, "commands.effect.success.removed", zwat._e(hdpq._a[n]._c()), entityPlayerMP.func_70023_ak());
                return;
            } else {
                supr supr2 = new supr(n, n2, n4);
                entityPlayerMP.func_70690_d(supr2);
                mbhn.func_71522_a(nemo2, "commands.effect.success", zwat._e(supr2._g()), n, n4, entityPlayerMP.func_70023_ak(), n3);
            }
        }
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1) {
            return mbhn.func_71530_a(stringArray, this._a());
        }
        return null;
    }

    public String[] _a() {
        return dzfd._I()._i();
    }

    @Override
    public boolean func_82358_a(String[] stringArray, int n) {
        return n == 0;
    }
}

