/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import gloomyfolken.bundle.common.core.InvokeWithResult;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.roles.RoleExchanger;

public class ContainerNpcExchanger
extends jjgc {
    public RoleExchanger role;

    public ContainerNpcExchanger(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) {
        int n;
        int n2;
        this.role = (RoleExchanger)entityNPCInterface.roleInterface;
        for (n2 = 0; n2 < 18; ++n2) {
            n = 35 + n2 % 3 * 45;
            int n3 = 9 + n2 / 3 * 22;
            this.func_75146_a(new yeso(this.role.invSold, n2, n, n3));
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.func_75146_a(new yeso(entityPlayer.field_71071_by, n + n2 * 9 + 9, 8 + n * 18, 144 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.func_75146_a(new yeso(entityPlayer.field_71071_by, n2, 8 + n2 * 18, 202));
        }
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        return null;
    }

    @Override
    public cvzo func_75144_a(int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (n3 == 6) {
            n3 = 0;
        }
        if (n >= 0 && n < 18) {
            if (n2 == 1) {
                return null;
            }
            return this.buy(n, entityPlayer);
        }
        return super.func_75144_a(n, n2, n3, entityPlayer);
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return true;
    }

    private cvzo buy(int n, EntityPlayer entityPlayer) {
        if (!entityPlayer.field_70170_p.field_72995_K) {
            return InvokeWithResult.frontend(() -> null);
        }
        return null;
    }

    private boolean canBuy(int n, EntityPlayer entityPlayer) {
        cvzo cvzo2 = this.role.invCurrency.func_70301_a(n);
        if (cvzo2 == null) {
            return true;
        }
        int n2 = this.role.checkNbt ? ncwh._a(entityPlayer, cvzo2._d, cvzo2._q()) : ncwh._b(entityPlayer, cvzo2._d);
        return n2 >= cvzo2._b;
    }
}

