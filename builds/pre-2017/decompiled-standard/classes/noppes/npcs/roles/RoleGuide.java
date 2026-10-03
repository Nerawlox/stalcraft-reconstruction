/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.util.concurrent.TimeUnit;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.roles.RoleInterface;

public class RoleGuide
extends RoleInterface {
    private static final long DISCOUNT_TIME_SPAN = TimeUnit.DAYS.toMillis(7L);
    public String currentSavezone = "";

    public RoleGuide(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
    }

    @Override
    public void writeEntityToNBT(qoac qoac2) {
        qoac2._a("Location", this.currentSavezone);
    }

    @Override
    public void readEntityFromNBT(qoac qoac2) {
        this.currentSavezone = qoac2._j("Location");
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        if (!this.currentSavezone.isEmpty()) {
            InvokeSideOnly.frontend(!this.npc.field_70170_p.field_72995_K, () -> {});
            return true;
        }
        return false;
    }
}

