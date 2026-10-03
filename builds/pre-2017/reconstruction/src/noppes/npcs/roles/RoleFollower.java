/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.sajh;
import net.minecraft.util.tdpx;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NBTTags;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.NpcMiscInventory;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.roles.RoleInterface;

public class RoleFollower
extends RoleInterface {
    public boolean isFollowing = true;
    public HashMap rates = new HashMap();
    public NpcMiscInventory inventory = new NpcMiscInventory(3);
    public String dialogHire = tdpx._a("follower.hireText") + " {days} " + tdpx._a("follower.days");
    public String dialogFarewell = tdpx._a("follower.farewellText") + " {player}";
    public int daysHired;
    public long hiredTime;
    public int updateTick = 0;
    private String owner;

    public RoleFollower(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("MercenaryDaysHired", this.daysHired);
        nBTTagCompound._a("MercenaryHiredTime", this.hiredTime);
        nBTTagCompound._a("MercenaryDialogHired", this.dialogHire);
        nBTTagCompound._a("MercenaryDialogFarewell", this.dialogFarewell);
        if (this.owner != null && !this.owner.isEmpty()) {
            nBTTagCompound._a("MercenaryOwner", this.owner);
        }
        nBTTagCompound._a("MercenaryDayRates", NBTTags.nbtIntegerIntegerMap(this.rates));
        nBTTagCompound._a("MercenaryInv", this.inventory.getToNBT());
        nBTTagCompound._a("MercenaryIsFollowing", this.isFollowing);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.owner = nBTTagCompound._j("MercenaryOwner");
        this.daysHired = nBTTagCompound._f("MercenaryDaysHired");
        this.hiredTime = nBTTagCompound._g("MercenaryHiredTime");
        this.dialogHire = nBTTagCompound._j("MercenaryDialogHired");
        this.dialogFarewell = nBTTagCompound._j("MercenaryDialogFarewell");
        this.rates = NBTTags.getIntegerIntegerMap(nBTTagCompound._n("MercenaryDayRates"));
        this.inventory.setFromNBT(nBTTagCompound._m("MercenaryInv"));
        this.isFollowing = nBTTagCompound._o("MercenaryIsFollowing");
    }

    @Override
    public boolean aiShouldExecute() {
        if (this.hasOwner() && this.isFollowing) {
            if (this.getDaysLeft() <= 0) {
                EntityPlayer entityPlayer = this.getOwner();
                if (entityPlayer != null) {
                    entityPlayer.addChatMessage(this.dialogFarewell.replaceAll("\\{player\\}", entityPlayer.username));
                }
                this.killed();
                return false;
            }
            return this.npc.getDistanceToEntity(this.getOwner()) >= 10.0f;
        }
        return false;
    }

    @Override
    public void aiUpdateTask() {
        ++this.updateTick;
        if (this.updateTick >= 10) {
            EntityPlayer entityPlayer = this.getOwner();
            this.npc.getLookHelper()._a(entityPlayer, 10.0f, (float)this.npc.getVerticalFaceSpeed());
            if (!this.npc.getNavigator()._a(entityPlayer, 1.0) && this.npc.getDistanceSqToEntity(entityPlayer) >= 144.0) {
                int n = sajh._c(entityPlayer.posX) - 2;
                int n2 = sajh._c(entityPlayer.posZ) - 2;
                int n3 = sajh._c(entityPlayer.boundingBox._c);
                for (int i = 0; i <= 4; ++i) {
                    for (int j = 0; j <= 4; ++j) {
                        if (i >= 1 && j >= 1 && i <= 3 && j <= 3 || !this.npc.worldObj.doesBlockHaveSolidTopSurface(n + i, n3 - 1, n2 + j) || this.npc.worldObj.isBlockNormalCube(n + i, n3, n2 + j) || this.npc.worldObj.isBlockNormalCube(n + i, n3 + 1, n2 + j)) continue;
                        this.npc.setLocationAndAngles((float)(n + i) + 0.5f, n3, (float)(n2 + j) + 0.5f, this.npc.rotationYaw, this.npc.rotationPitch);
                        this.npc.getNavigator()._h();
                        return;
                    }
                }
            }
            this.updateTick = 0;
        }
    }

    @Override
    public void aiStartExecuting() {
        this.updateTick = 10;
    }

    @Override
    public boolean aiContinueExecute() {
        EntityPlayer entityPlayer = this.getOwner();
        return entityPlayer != null && !this.npc.getNavigator()._g() && this.npc.getDistanceToEntity(entityPlayer) > 2.0f && this.isFollowing;
    }

    public boolean isFollowing() {
        return !this.isFollowing ? false : this.getOwner() != null;
    }

    public EntityPlayer getOwner() {
        return this.owner != null && !this.owner.isEmpty() ? this.npc.worldObj.getPlayerEntityByName(this.owner) : null;
    }

    public void setOwner(String string) {
        if (this.owner == null || !this.owner.equals(string)) {
            this.killed();
        }
        this.owner = string;
    }

    public boolean hasOwner() {
        return this.daysHired <= 0 ? false : this.getOwner() != null;
    }

    @Override
    public void killed() {
        this.owner = null;
        this.daysHired = 0;
        this.hiredTime = 0L;
    }

    public int getDaysLeft() {
        if (this.daysHired <= 0) {
            return 0;
        }
        int n = (int)((this.npc.worldObj.getWorldTime() - this.hiredTime) / 24000L);
        return this.daysHired - n;
    }

    public void addDays(int n) {
        this.daysHired += n + this.getDaysLeft();
        this.hiredTime = this.npc.worldObj.getWorldTime();
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        if (this.owner != null && !this.owner.isEmpty()) {
            if (entityPlayer == this.getOwner()) {
                NoppesUtilServer.sendOpenGui(entityPlayer, EnumGuiType.PlayerFollower, this.npc);
            }
        } else {
            this.npc.performInteractReplica(entityPlayer);
            NoppesUtilServer.sendOpenGui(entityPlayer, EnumGuiType.PlayerFollowerHire, this.npc);
        }
        return false;
    }

    @Override
    public void delete() {
    }
}

