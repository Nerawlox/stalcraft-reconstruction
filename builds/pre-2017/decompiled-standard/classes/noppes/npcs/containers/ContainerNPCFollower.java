/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.containers.InventoryNPC;
import noppes.npcs.containers.SlotNpcMercenaryCurrency;
import noppes.npcs.roles.RoleFollower;

public class ContainerNPCFollower
extends jjgc {
    public InventoryNPC currencyMatrix;
    public RoleFollower role;

    public ContainerNPCFollower(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) {
        this.role = (RoleFollower)entityNPCInterface.roleInterface;
        this.currencyMatrix = new InventoryNPC("currency", 1, this);
        this.func_75146_a(new SlotNpcMercenaryCurrency(this.role, this.currencyMatrix, 0, 26, 9));
        for (int i = 0; i < 9; ++i) {
            this.func_75146_a(new yeso(entityPlayer.field_71071_by, i, 8 + i * 18, 142));
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

