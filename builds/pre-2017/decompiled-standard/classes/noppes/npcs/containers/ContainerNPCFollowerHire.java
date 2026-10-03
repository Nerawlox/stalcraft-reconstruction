/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.containers.SlotNpcMercenaryCurrency;
import noppes.npcs.roles.RoleFollower;

public class ContainerNPCFollowerHire
extends jjgc {
    public tgfo currencyMatrix;
    public RoleFollower role;

    public ContainerNPCFollowerHire(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) {
        int n;
        this.role = (RoleFollower)entityNPCInterface.roleInterface;
        this.currencyMatrix = new tgfo("currency", false, 1);
        this.func_75146_a(new SlotNpcMercenaryCurrency(this.role, this.currencyMatrix, 0, 44, 35));
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.func_75146_a(new yeso(entityPlayer.field_71071_by, i + n * 9 + 9, 8 + i * 18, 84 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.func_75146_a(new yeso(entityPlayer.field_71071_by, n, 8 + n * 18, 142));
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
    public void func_75134_a(EntityPlayer entityPlayer) {
        cvzo cvzo2;
        super.func_75134_a(entityPlayer);
        if (!entityPlayer.field_70170_p.field_72995_K && (cvzo2 = this.currencyMatrix.func_70304_b(0)) != null && !entityPlayer.field_70170_p.field_72995_K) {
            entityPlayer.func_70099_a(cvzo2, 0.0f);
        }
    }
}

