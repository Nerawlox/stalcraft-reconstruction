/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import gloomyfolken.bundle.common.core.InvokeWithResult;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;

public class ContainerNPCSetup
extends jjgc {
    protected final boolean access;

    public ContainerNPCSetup(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) {
        this.access = entityNPCInterface.field_70170_p.field_72995_K || InvokeWithResult.frontend(() -> null) != false;
    }

    @Override
    public cvzo func_75144_a(int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (this.access) {
            return super.func_75144_a(n, n2, n3, entityPlayer);
        }
        return null;
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

