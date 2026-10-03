/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;
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
    public void writeEntityToNBT(qoac qoac2) {
        qoac2._a("MercenaryDaysHired", this.daysHired);
        qoac2._a("MercenaryHiredTime", this.hiredTime);
        qoac2._a("MercenaryDialogHired", this.dialogHire);
        qoac2._a("MercenaryDialogFarewell", this.dialogFarewell);
        if (this.owner != null && !this.owner.isEmpty()) {
            qoac2._a("MercenaryOwner", this.owner);
        }
        qoac2._a("MercenaryDayRates", NBTTags.nbtIntegerIntegerMap(this.rates));
        qoac2._a("MercenaryInv", this.inventory.getToNBT());
        qoac2._a("MercenaryIsFollowing", this.isFollowing);
    }

    @Override
    public void readEntityFromNBT(qoac qoac2) {
        this.owner = qoac2._j("MercenaryOwner");
        this.daysHired = qoac2._f("MercenaryDaysHired");
        this.hiredTime = qoac2._g("MercenaryHiredTime");
        this.dialogHire = qoac2._j("MercenaryDialogHired");
        this.dialogFarewell = qoac2._j("MercenaryDialogFarewell");
        this.rates = NBTTags.getIntegerIntegerMap(qoac2._n("MercenaryDayRates"));
        this.inventory.setFromNBT(qoac2._m("MercenaryInv"));
        this.isFollowing = qoac2._o("MercenaryIsFollowing");
    }

    @Override
    public boolean aiShouldExecute() {
        if (this.hasOwner() && this.isFollowing) {
            if (this.getDaysLeft() <= 0) {
                EntityPlayer entityPlayer = this.getOwner();
                if (entityPlayer != null) {
                    entityPlayer.func_71035_c(this.dialogFarewell.replaceAll("\\{player\\}", entityPlayer.field_71092_bJ));
                }
                this.killed();
                return false;
            }
            return this.npc.func_70032_d(this.getOwner()) >= 10.0f;
        }
        return false;
    }

    @Override
    public void aiUpdateTask() {
        ++this.updateTick;
        if (this.updateTick >= 10) {
            EntityPlayer entityPlayer = this.getOwner();
            this.npc.func_70671_ap()._a(entityPlayer, 10.0f, (float)this.npc.func_70646_bf());
            if (!this.npc.func_70661_as()._a(entityPlayer, 1.0) && this.npc.func_70068_e(entityPlayer) >= 144.0) {
                int n = sajh._c(entityPlayer.field_70165_t) - 2;
                int n2 = sajh._c(entityPlayer.field_70161_v) - 2;
                int n3 = sajh._c(entityPlayer.field_70121_D._c);
                for (int i = 0; i <= 4; ++i) {
                    for (int j = 0; j <= 4; ++j) {
                        if (i >= 1 && j >= 1 && i <= 3 && j <= 3 || !this.npc.field_70170_p.func_72797_t(n + i, n3 - 1, n2 + j) || this.npc.field_70170_p.func_72809_s(n + i, n3, n2 + j) || this.npc.field_70170_p.func_72809_s(n + i, n3 + 1, n2 + j)) continue;
                        this.npc.func_70012_b((float)(n + i) + 0.5f, n3, (float)(n2 + j) + 0.5f, this.npc.field_70177_z, this.npc.field_70125_A);
                        this.npc.func_70661_as()._h();
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
        return entityPlayer != null && !this.npc.func_70661_as()._g() && this.npc.func_70032_d(entityPlayer) > 2.0f && this.isFollowing;
    }

    public boolean isFollowing() {
        return !this.isFollowing ? false : this.getOwner() != null;
    }

    public EntityPlayer getOwner() {
        return this.owner != null && !this.owner.isEmpty() ? this.npc.field_70170_p.func_72924_a(this.owner) : null;
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
        int n = (int)((this.npc.field_70170_p.func_72820_D() - this.hiredTime) / 24000L);
        return this.daysHired - n;
    }

    public void addDays(int n) {
        this.daysHired += n + this.getDaysLeft();
        this.hiredTime = this.npc.field_70170_p.func_72820_D();
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

