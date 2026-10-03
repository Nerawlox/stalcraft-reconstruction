/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.ExtendedCreativeInv;
import codechicken.nei.SlotBlockArmor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;

public class ContainerCreativeInv
extends jjgc {
    public ContainerCreativeInv(EntityPlayer entityPlayer, ExtendedCreativeInv extendedCreativeInv) {
        int n;
        int n2;
        eidj eidj2 = entityPlayer.field_71071_by;
        for (n2 = 0; n2 < 6; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.func_75146_a(new yeso(extendedCreativeInv, n + n2 * 9, 8 + n * 18, 5 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.func_75146_a(new yeso(eidj2, n + n2 * 9 + 9, 8 + n * 18, 118 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.func_75146_a(new yeso(eidj2, n2, 8 + n2 * 18, 176));
        }
        this.func_75146_a(new SlotBlockArmor((ohws)entityPlayer.field_71069_bz, eidj2, eidj2.func_70302_i_() - 1, -15, 23, 0));
        for (n2 = 1; n2 < 4; ++n2) {
            this.func_75146_a(new yesp((ohws)entityPlayer.field_71069_bz, eidj2, eidj2.func_70302_i_() - 1 - n2, -15, 23 + n2 * 18, n2));
        }
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        cvzo cvzo2 = null;
        yeso yeso2 = (yeso)this.field_75151_b.get(n);
        if (yeso2 != null && yeso2.func_75216_d()) {
            cvzo cvzo3 = yeso2.func_75211_c();
            cvzo2 = cvzo3._l();
            if (cvzo3._a() instanceof lpno) {
                lpno lpno2 = (lpno)cvzo3._a();
                if (!this.func_75139_a(90 + lpno2.field_77881_a).func_75216_d()) {
                    this.func_75139_a(90 + lpno2.field_77881_a).func_75215_d(cvzo2);
                    yeso2.func_75215_d(null);
                    return cvzo2;
                }
            }
            if (n < 54 ? !this.func_75135_a(cvzo3, 54, 90, true) : !this.func_75135_a(cvzo3, 0, 54, false)) {
                return null;
            }
            if (cvzo3._b == 0) {
                yeso2.func_75215_d(null);
            } else {
                yeso2.func_75218_e();
            }
        }
        return cvzo2;
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return true;
    }
}

