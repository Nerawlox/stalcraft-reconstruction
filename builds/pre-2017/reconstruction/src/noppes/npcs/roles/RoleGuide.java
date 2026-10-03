/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.util.concurrent.TimeUnit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
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
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("Location", this.currentSavezone);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.currentSavezone = nBTTagCompound._j("Location");
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        if (!this.currentSavezone.isEmpty()) {
            InvokeSideOnly.frontend(!this.npc.worldObj.isRemote, () -> {});
            return true;
        }
        return false;
    }
}

