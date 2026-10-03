/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;

public class bbhn
extends ohnk {
    @Override
    public String func_71517_b() {
        return "enchant";
    }

    @Override
    public int func_82362_a() {
        return 2;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.enchant.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length >= 2) {
            bsyv bsyv2;
            EntityPlayerMP entityPlayerMP = bbhn.func_82359_c(nemo2, stringArray[0]);
            int n = bbhn.func_71532_a(nemo2, stringArray[1], 0, zhqo._a.length - 1);
            int n2 = 1;
            cvzo cvzo2 = entityPlayerMP.func_71045_bC();
            if (cvzo2 == null) {
                throw new cekk("commands.enchant.noItem", new Object[0]);
            }
            zhqo zhqo2 = zhqo._a[n];
            if (zhqo2 == null) {
                throw new jjcb("commands.enchant.notFound", n);
            }
            if (!zhqo2._a(cvzo2)) {
                throw new cekk("commands.enchant.cantEnchant", new Object[0]);
            }
            if (stringArray.length >= 3) {
                n2 = bbhn.func_71532_a(nemo2, stringArray[2], zhqo2._b(), zhqo2._c());
            }
            if (cvzo2._p() && (bsyv2 = cvzo2._r()) != null) {
                for (int i = 0; i < bsyv2._d(); ++i) {
                    zhqo zhqo3;
                    short s = ((qoac)bsyv2._b(i))._e("id");
                    if (zhqo._a[s] == null || (zhqo3 = zhqo._a[s])._a(zhqo2)) continue;
                    throw new cekk("commands.enchant.cantCombine", zhqo2._c(n2), zhqo3._c(((qoac)bsyv2._b(i))._e("lvl")));
                }
            }
            cvzo2._a(zhqo2, n2);
            bbhn.func_71522_a(nemo2, "commands.enchant.success", new Object[0]);
            return;
        }
        throw new pksd("commands.enchant.usage", new Object[0]);
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1) {
            return bbhn.func_71530_a(stringArray, this._a());
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

