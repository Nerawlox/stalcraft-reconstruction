/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.roles.JobItemGiver;

public class ContainerNpcItemGiver
extends jjgc {
    private JobItemGiver role;

    public ContainerNpcItemGiver(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) {
        int n;
        this.role = (JobItemGiver)entityNPCInterface.jobInterface;
        for (n = 0; n < 9; ++n) {
            this.func_75146_a(new yeso(this.role.inventory, n, 6 + n * 18, 81));
        }
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.func_75146_a(new yeso(entityPlayer.field_71071_by, i + n * 9 + 9, 6 + i * 18, 107 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.func_75146_a(new yeso(entityPlayer.field_71071_by, n, 6 + n * 18, 165));
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
}

