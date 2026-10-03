/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.tdpx;

public class nevf
extends tgdv {
    public nevf(int n) {
        super(n);
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (!ozlu2.field_72995_K) {
            EntityFireworkRocket entityFireworkRocket = new EntityFireworkRocket(ozlu2, (float)n + f, (float)n2 + f2, (float)n3 + f3, cvzo2);
            ozlu2.func_72838_d(entityFireworkRocket);
            if (!entityPlayer.field_71075_bZ._d) {
                --cvzo2._b;
            }
            return true;
        }
        return false;
    }

    @Override
    public void func_77624_a(cvzo cvzo2, EntityPlayer entityPlayer, List list, boolean bl) {
        bsyv bsyv2;
        if (!cvzo2._p()) {
            return;
        }
        qoac qoac2 = cvzo2._q()._m("Fireworks");
        if (qoac2 == null) {
            return;
        }
        if (qoac2._c("Flight")) {
            list.add(tdpx._a("item.fireworks.flight") + " " + qoac2._d("Flight"));
        }
        if ((bsyv2 = qoac2._n("Explosions")) != null && bsyv2._d() > 0) {
            for (int i = 0; i < bsyv2._d(); ++i) {
                qoac qoac3 = (qoac)bsyv2._b(i);
                ArrayList<String> arrayList = new ArrayList<String>();
                mbse._a(qoac3, arrayList);
                if (arrayList.size() <= 0) continue;
                for (int j = 1; j < arrayList.size(); ++j) {
                    arrayList.set(j, "  " + (String)arrayList.get(j));
                }
                list.addAll(arrayList);
            }
        }
    }
}

