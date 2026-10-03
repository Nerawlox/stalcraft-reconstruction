/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.misc.sajh;
import gloomyfolken.mods.money.zwat;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.roles.RoleTrader;

public class ContainerNPCTrader
extends jjgc {
    public RoleTrader role;

    public ContainerNPCTrader(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) {
        int n;
        int n2;
        this.role = (RoleTrader)entityNPCInterface.roleInterface;
        for (n2 = 0; n2 < 63; ++n2) {
            n = 8;
            int n3 = 14;
            this.func_75146_a(new yeso(this.role.inventorySold, n2, n += n2 % 9 * 18, n3 += n2 / 9 * 18));
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
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public cvzo func_75144_a(int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (n3 == 6) {
            n3 = 0;
        }
        if (n >= 0 && n < 63) {
            if (n2 == 1) {
                return null;
            }
            yeso yeso2 = (yeso)this.field_75151_b.get(n);
            if (yeso2 == null || yeso2.func_75211_c() == null) {
                return null;
            }
            cvzo cvzo2 = yeso2.func_75211_c();
            if (!ncwh._a(cvzo2, entityPlayer)) {
                return null;
            }
            if (!this.canBuy(this.role.sellPrices[n], entityPlayer)) {
                return null;
            }
            cvzo cvzo3 = cvzo2._l();
            sajh._c._a(cvzo3, this.role.npc.func_70023_ak(), false);
            ncwh._b(cvzo3, entityPlayer);
            InvokeSideOnly.frontend(!entityPlayer.field_70170_p.field_72995_K, () -> {});
            return cvzo3;
        }
        if (n2 == 1 && n >= 63) {
            int n4;
            yeso yeso3 = this.func_75139_a(n);
            cvzo cvzo4 = yeso3.func_75211_c();
            if (cvzo4 != null && (n4 = this.role.getBuyPrice(cvzo4)) > 0) {
                yeso3.func_75215_d(null);
                zwat._a(entityPlayer)._b(n4);
                if (!entityPlayer.field_70170_p.field_72995_K) {
                    InvokeSideOnly.frontend(() -> {});
                }
            }
            return null;
        }
        return super.func_75144_a(n, n2, n3, entityPlayer);
    }

    private boolean canBuy(long l, EntityPlayer entityPlayer) {
        if (l <= 0L) {
            return false;
        }
        return zwat._a(entityPlayer)._d(l);
    }
}

