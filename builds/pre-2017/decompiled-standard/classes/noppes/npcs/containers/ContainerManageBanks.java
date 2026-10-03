/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.controllers.Bank;

public class ContainerManageBanks
extends jjgc {
    public Bank bank = new Bank();

    public ContainerManageBanks(EntityPlayer entityPlayer) {
        int n;
        int n2;
        int n3;
        int n4;
        for (n4 = 0; n4 < 6; ++n4) {
            n3 = 36;
            n2 = 21;
            n = n2 + n4 * 22;
            this.func_75146_a(new yeso(this.bank.currencyInventory, n4, n3, n));
        }
        for (n4 = 0; n4 < 6; ++n4) {
            n3 = 142;
            n2 = 21;
            n = n2 + n4 * 22;
            this.func_75146_a(new yeso(this.bank.upgradeInventory, n4, n3, n));
        }
        for (n4 = 0; n4 < 9; ++n4) {
            this.func_75146_a(new yeso(entityPlayer.field_71071_by, n4, 8 + n4 * 18, 154));
        }
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        cvzo cvzo2 = null;
        yeso yeso2 = (yeso)this.field_75151_b.get(n);
        if (yeso2 != null && yeso2.func_75216_d()) {
            cvzo cvzo3 = yeso2.func_75211_c();
            cvzo2 = cvzo3._l();
            if (n >= 0 && n < 7 ? !this.func_75135_a(cvzo3, 7, 43, true) : (n >= 20 && n < 47 ? !this.func_75135_a(cvzo3, 36, 43, false) : (n >= 47 && n < 56 ? !this.func_75135_a(cvzo3, 7, 34, false) : !this.func_75135_a(cvzo3, 7, 43, false)))) {
                return null;
            }
            if (cvzo3._b == 0) {
                yeso2.func_75215_d(null);
            } else {
                yeso2.func_75218_e();
            }
            if (cvzo3._b == cvzo2._b) {
                return null;
            }
            yeso2.func_82870_a(entityPlayer, cvzo3);
        }
        return cvzo2;
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return true;
    }

    public void setBank(Bank bank) {
        for (int i = 0; i < 6; ++i) {
            this.bank.currencyInventory.func_70299_a(i, bank.currencyInventory.func_70301_a(i));
            this.bank.upgradeInventory.func_70299_a(i, bank.upgradeInventory.func_70301_a(i));
        }
    }
}

